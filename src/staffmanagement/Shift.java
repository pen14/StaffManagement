/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author penpen
 */
@Entity
@Table(name = "SHIFT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shift.findAll", query = "SELECT s FROM Shift s"),
    @NamedQuery(name = "Shift.findByShiftreference", query = "SELECT s FROM Shift s WHERE s.shiftreference = :shiftreference"),
    @NamedQuery(name = "Shift.findByStarttime", query = "SELECT s FROM Shift s WHERE s.starttime = :starttime"),
    @NamedQuery(name = "Shift.findByEndtime", query = "SELECT s FROM Shift s WHERE s.endtime = :endtime"),
    @NamedQuery(name = "Shift.findByWard", query = "SELECT s FROM Shift s WHERE s.ward = :ward"),
    @NamedQuery(name = "Shift.findByShiftdate", query = "SELECT s FROM Shift s WHERE s.shiftdate = :shiftdate"),
    @NamedQuery(name = "Shift.findByShifttype", query = "SELECT s FROM Shift s WHERE s.shifttype = :shifttype")})
public class Shift implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SHIFTREFERENCE")
    private Integer shiftreference;
    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIME)
    private Date starttime;
    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIME)
    private Date endtime;
    @Size(max = 32)
    @Column(name = "WARD")
    private String ward;
    @Column(name = "SHIFTDATE")
    @Temporal(TemporalType.DATE)
    private Date shiftdate;
    @Size(max = 32)
    @Column(name = "SHIFTTYPE")
    private String shifttype;

    public Shift() {
    }

    public Shift(Integer shiftreference) {
        this.shiftreference = shiftreference;
    }

    public Integer getShiftreference() {
        return shiftreference;
    }

    public void setShiftreference(Integer shiftreference) {
        this.shiftreference = shiftreference;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Date getShiftdate() {
        return shiftdate;
    }

    public void setShiftdate(Date shiftdate) {
        this.shiftdate = shiftdate;
    }

    public String getShifttype() {
        return shifttype;
    }

    public void setShifttype(String shifttype) {
        this.shifttype = shifttype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shiftreference != null ? shiftreference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shift)) {
            return false;
        }
        Shift other = (Shift) object;
        if ((this.shiftreference == null && other.shiftreference != null) || (this.shiftreference != null && !this.shiftreference.equals(other.shiftreference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "staffmanagement.Shift[ shiftreference=" + shiftreference + " ]";
    }
    
}
