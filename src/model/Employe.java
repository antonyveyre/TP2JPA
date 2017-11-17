/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author user
 */
@Entity
public class Employe implements Serializable {

  
  
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
    
  private double sal;
  
  
  private Employe sup;
  
  private String nom;
  
  @ManyToOne
  private Departament departament;
  
  @OneToMany
  private Collection<Projet> projets ;

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public Departament getDepartament() {
    return departament;
  }

  public void setDepartament(Departament departament) {
    this.departament = departament;
  }

  public Collection<Projet> getProjets() {
    return projets;
  }

  public void setProjets(Collection<Projet> projets) {
    this.projets = projets;
  }

  
  
  public Employe() {
  }

  public Employe(double sal, Employe sup, Departament dep) {
    this.sal = sal;
    this.sup = sup;
    this.departament = dep;
  }

  public Employe(double sal, Departament dep) {
    this.sal = sal;
    this.departament = dep;
  }

  public Employe(double sal, Employe sup, String nom, Departament dep, Map<Projet, String> fonctionProjet) {
    this.sal = sal;
    this.sup = sup;
    this.nom = nom;
    this.departament = dep;
//    this.fonctionProjet = fonctionProjet;
  }

  public Employe(String nom,Employe sup ) {
    this.sup = sup;
    this.nom = nom;
  //  this.fonctionProjet = new HashMap<>();
  }
  
  public Employe(String nom) {
    this.nom = nom;
   // this.fonctionProjet = new HashMap<>();
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getSal() {
    return sal;
  }

  public void setSal(double sal) {
    this.sal = sal;
  }

  public Employe getSup() {
    return sup;
  }

  public void setSup(Employe sup) {
    this.sup = sup;
  }

  public Departament getDep() {
    return departament;
  }

  public void setDep(Departament dep) {
    this.departament = dep;
  }

  public void addProjet(Projet p, String function){
    if(this.projets==null){
      this.projets = new ArrayList<>();
      this.projets.add(p);
    }else
      this.projets.add(p);
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
    if (!(object instanceof Employe)) {
      return false;
    }
    Employe other = (Employe) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other    .id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "model.Employe[ id=" + id + " ]";
  }
  
}
