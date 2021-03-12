/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv2_part2;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import models.Person;

/**
 *
 * @author vsa
 */
public class Cv2_part2 {
    
    private static EntityManager em;

    public Cv2_part2() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv2_part2PU");
        Cv2_part2.em = emf.createEntityManager();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Cv2_part2 cv2_part2 = new Cv2_part2();
         start();
         showAllPeople();
         System.out.println(addPerson("Jano"));
         System.out.println(findPersonById(2L));
         System.out.println("count all = " + countAll());
         System.out.println("countNoNames = " + countNoNamed());
         System.out.println("personTheBig = " + personTheBig());
                 
                 
        // TODO code application logic here
    }
    public static void start(){
         em.getTransaction().begin();
         
         em.persist(new Person("Peter",new Date(), (float) 10.0,15));
         em.persist(new Person("Tereza",new Date(), (float) 10.0,15));
        
         
         em.getTransaction().commit();
    }
    public static void showAllPeople() {
        Query q = em.createNativeQuery("SELECT * from T_OSOBA", Person.class);
        List<Person> osoby = q.getResultList();

        osoby.stream().forEach((person) -> {
            System.out.println(person);
            System.out.println(person.getAge());
        });

    }
    public static Long addPerson(String name){
        em.getTransaction().begin();
        Person person = new Person(name);
        em.persist(person);
        em.getTransaction().commit();
        return person.getId();
    } 
    public static Person findPersonById(Long id){
        Query q = em.createNativeQuery("SELECT * from T_OSOBA", Person.class);
        List<Person> people = q.getResultList();
        for (Person person: people){
            if(person.getId().equals(id)){
                return person;
            }
        }
        return null;
    }
    public static int countAll(){
        Query q = em.createNativeQuery("SELECT * from T_OSOBA", Person.class);
        List<Person> people = q.getResultList();
        return people.size();
    }
    public static int countNoNamed(){
        Query q = em.createNativeQuery("SELECT * from T_OSOBA", Person.class);
        List<Person> people = q.getResultList();
        int counter = 0;
        counter = people.stream().filter((person) -> (person.getName() == null || 
        "".equals(person.getName()))).map((_item) -> 1).reduce(counter, Integer::sum);
        return counter;
    }
    public static Person personTheBig() {
        Query q = em.createNativeQuery("SELECT * from T_OSOBA", Person.class);
        List<Person> people = q.getResultList();
        Person personTheBig = null;
        Float weight = 0.0F;
        for (Person person : people) {
            if ((person.getWeight() != null) && (person.getWeight() > weight)) {
                personTheBig = person;
                weight = person.getWeight();
            }
        }
        return personTheBig;
    }  
}
