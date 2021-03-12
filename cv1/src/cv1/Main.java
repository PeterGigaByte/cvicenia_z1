/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv1;

import cv1.models.Book;
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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cv1PU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createNativeQuery("select * from BOOK", Book.class);
        List<Book> books = q.getResultList();
        em.getTransaction().begin();
        Book narnia = new Book("Narnia","Peter Mategir",25.25);
        em.persist(narnia);
        books.add(narnia);
        for(Book book: books){
            System.out.println(book.toString());
        }
        
        em.getTransaction().commit();
    }
    
}
