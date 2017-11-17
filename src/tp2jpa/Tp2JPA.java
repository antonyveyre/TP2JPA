/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Departament;
import model.Employe;
import model.Projet;

/**
 *
 * @author user
 */
public class Tp2JPA {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    EntityManagerFactory emf = null;
    EntityManager em = null;
    EntityTransaction tx = null;

 

      emf = Persistence.createEntityManagerFactory("Tp2JPAPU");
      em = emf.createEntityManager();
      tx = em.getTransaction();
      tx.begin();
      System.out.println("debut transaction");

      Departament dep = new Departament("Informatique", "Sophia Antipolis");
      Employe e = new Employe("BigBoss");
      System.out.println("big boss created");
      Employe e1 = new Employe("Enginer", e);

      System.out.println("enginer created");
      
      System.out.println("departament created");
      
      Projet p = new Projet("J2E");
      
      System.out.println("project created");
      dep.addEmploye(e);
      System.out.println("employe added");
      e1.addProjet(p, "enginer");
      
      System.out.println("project added");

      dep.addEmploye(e1);
      System.out.println("employe added to department ");
      
      
      System.out.println("debut persist");
      
      em.persist(e1);
      em.persist(e);
      em.persist(dep);
      em.persist(p);

      tx.commit();





        em.close();
        emf.close();




      }

    }

  


