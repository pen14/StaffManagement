/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author penpen
 */
@Entity
@Table(name = "STAFFLEAVE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staffleave.findAll", query = "SELECT s FROM Staffleave s"),
    @NamedQuery(name = "Staffleave.findByEmployeeid", query = "SELECT s FROM Staffleave s WHERE s.employeeid = :employeeid"),
    @NamedQuery(name = "Staffleave.findByFirstname", query = "SELECT s FROM Staffleave s WHERE s.firstname = :firstname"),
    @NamedQuery(name = "Staffleave.findByLastname", query = "SELECT s FROM Staffleave s WHERE s.lastname = :lastname")})
public class Staffleave implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLOYEEID")
    private Integer employeeid;
    @Size(max = 64)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 64)
    @Column(name = "LASTNAME")
    private String lastname;

    public Staffleave() {
    }

    public Staffleave(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staffleave)) {
            return false;
        }
        Staffleave other = (Staffleave) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "staffmanagement.Staffleave[ employeeid=" + employeeid + " ]";
    }
    
}
