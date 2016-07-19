/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author penpen
 */
@Entity
@Table(name = "STAFFBOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staffbooking.findAll", query = "SELECT s FROM Staffbooking s"),
    @NamedQuery(name = "Staffbooking.findByBookingid", query = "SELECT s FROM Staffbooking s WHERE s.bookingid = :bookingid"),
    @NamedQuery(name = "Staffbooking.findByEmployeeid", query = "SELECT s FROM Staffbooking s WHERE s.employeeid = :employeeid"),
    @NamedQuery(name = "Staffbooking.findByShiftreference", query = "SELECT s FROM Staffbooking s WHERE s.shiftreference = :shiftreference"),
    @NamedQuery(name = "Staffbooking.findByFirstname", query = "SELECT s FROM Staffbooking s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Staffbooking.findByLastname", query = "SELECT s FROM Staffbooking s WHERE s.lastname = :lastname")})
public class Staffbooking implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BOOKINGID")
    private Integer bookingid;
    @Column(name = "EMPLOYEEID")
    private Integer employeeid;
    @Column(name = "SHIFTREFERENCE")
    private Integer shiftreference;
    @Size(max = 32)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 32)
    @Column(name = "LASTNAME")
    private String lastname;

    public Staffbooking() {
    }

    public Staffbooking(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        Integer oldBookingid = this.bookingid;
        this.bookingid = bookingid;
        changeSupport.firePropertyChange("bookingid", oldBookingid, bookingid);
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        Integer oldEmployeeid = this.employeeid;
        this.employeeid = employeeid;
        changeSupport.firePropertyChange("employeeid", oldEmployeeid, employeeid);
    }

    public Integer getShiftreference() {
        return shiftreference;
    }

    public void setShiftreference(Integer shiftreference) {
        Integer oldShiftreference = this.shiftreference;
        this.shiftreference = shiftreference;
        changeSupport.firePropertyChange("shiftreference", oldShiftreference, shiftreference);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        changeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        changeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingid != null ? bookingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staffbooking)) {
            return false;
        }
        Staffbooking other = (Staffbooking) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "staffmanagement.Staffbooking[ bookingid=" + bookingid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
