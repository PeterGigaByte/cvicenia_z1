/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv2_sorry_part2;

import cv2_sorry_part2.models.Person;
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
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv2_sorry_part2PU");
         EntityManager em = emf.createEntityManager();
         
         showAllPeople(em);
         
    }
    public static void showAllPeople(EntityManager em){
        Query q = em.createNativeQuery("SELECT * from T_OSOBA", Person.class); 
         List<Person> osoby = q.getResultList();
         osoby.stream().forEach((person) -> {
             System.out.println(person);         
        });
    }
}
