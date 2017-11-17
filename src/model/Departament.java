/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author user
 */
@Entity
public class Departament implements Serializable {

  private String nom;
  private String lieu;
  @OneToMany(mappedBy = "departament")
  private List<Employe> employes;

  public Departament() {
  }

  public Departament(String nom, String lieu) {
    this.nom = nom;
    this.lieu = lieu;
    this.employes = new ArrayList();
  }

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Departament)) {
      return false;
    }
    Departament other = (Departament) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "model.Departament[ id=" + nom + " ]";
  }

  public void addEmploye(Employe e) {
    Departament d = e.getDep();
    if (d != null) {
      d.employes.remove(e);
    }
    this.employes.add(e);
    e.setDep(this);
  }

}
