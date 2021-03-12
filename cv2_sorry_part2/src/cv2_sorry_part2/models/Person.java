/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv2_sorry_part2.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;


/**
 *
 * @author vsa
 */
@Entity
@Table(name = "T_OSOBA")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "meno")
    private String name;
    @Column(name = "vaha")
    private Float weight;
    @Column(name = "datum_narodenia")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date born;

    public Person() {
    }
    
    public Person(String name, Date born, Float weight) {
        this.name = name;
        this.born = born;
        this.weight = weight;
    }
    
    /**
     * Get the value of weight
     *
     * @return the value of weight
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * Set the value of weight
     *
     * @param weight new value of weight
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    /**
     * Get the value of born
     *
     * @return the value of born
     */
    public Date getBorn() {
        return born;
    }

    /**
     * Set the value of born
     *
     * @param born new value of born
     */
    public void setBorn(Date born) {
        this.born = born;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

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
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", born=" + born + ", weight=" + weight + '}';
    }


    
}
