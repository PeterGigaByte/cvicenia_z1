/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv3.models;

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
public class Osoba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String meno;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datum_narodenia;
    
    @Column(nullable = false)
    private Float vaha;

    public Osoba() {
    }

    public Osoba(String meno, Date datum_narodenia, Float vaha) {
        this.meno = meno;
        this.datum_narodenia = datum_narodenia;
        this.vaha = vaha;
    }
    
    /**
     * Get the value of vaha
     *
     * @return the value of vaha
     */
    public float getVaha() {
        return vaha;
    }

    /**
     * Set the value of vaha
     *
     * @param vaha new value of vaha
     */
    public void setVaha(Float vaha) {
        this.vaha = vaha;
    }

    /**
     * Get the value of datum_narodenia
     *
     * @return the value of datum_narodenia
     */
    public Date getDatum_narodenia() {
        return datum_narodenia;
    }

    /**
     * Set the value of datum_narodenia
     *
     * @param datum_narodenia new value of datum_narodenia
     */
    public void setDatum_narodenia(Date datum_narodenia) {
        this.datum_narodenia = datum_narodenia;
    }

    /**
     * Get the value of meno
     *
     * @return the value of meno
     */
    public String getMeno() {
        return meno;
    }

    /**
     * Set the value of meno
     *
     * @param meno new value of meno
     */
    public void setMeno(String meno) {
        this.meno = meno;
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
        if (!(object instanceof Osoba)) {
            return false;
        }
        Osoba other = (Osoba) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv3.models.Osoba[ id=" + id + " ]";
    }
    
}
