/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv3;

import cv3.models.Osoba;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author vsa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv3PU");
         EntityManager em = emf.createEntityManager();
         
         em.getTransaction().begin();
         
         em.persist(new Osoba("Peter",new Date(), (float) 10.0));
         em.persist(new Osoba("Peter",new Date(), (float) 10.0));
         
         em.getTransaction().commit();
         
         Query q = em.createNativeQuery("SELECT id from T_OSOBA", Osoba.class); 
         List<Osoba> osoby = q.getResultList();
         osoby.stream().forEach((osoba) -> {
             
             System.out.println(osoba);
             
        });
         
         
           
    }
}
