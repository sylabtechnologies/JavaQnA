/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "tbl_traveler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTraveler.findAll", query = "SELECT t FROM TblTraveler t")
    , @NamedQuery(name = "TblTraveler.findByTravelerId", query = "SELECT t FROM TblTraveler t WHERE t.travelerId = :travelerId")
    , @NamedQuery(name = "TblTraveler.findByName", query = "SELECT t FROM TblTraveler t WHERE t.name = :name")
    , @NamedQuery(name = "TblTraveler.findByAddress", query = "SELECT t FROM TblTraveler t WHERE t.address = :address")
    , @NamedQuery(name = "TblTraveler.findByPhone", query = "SELECT t FROM TblTraveler t WHERE t.phone = :phone")
    , @NamedQuery(name = "TblTraveler.findByEmail", query = "SELECT t FROM TblTraveler t WHERE t.email = :email")
    , @NamedQuery(name = "TblTraveler.findByDob", query = "SELECT t FROM TblTraveler t WHERE t.dob = :dob")})
public class TblTraveler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "travelerId")
    private Integer travelerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "address")
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @ManyToMany(mappedBy = "tblTravelerCollection")
    private Collection<TblBooking> tblBookingCollection;

    public TblTraveler() {
    }

    public TblTraveler(Integer travelerId) {
        this.travelerId = travelerId;
    }

    public TblTraveler(Integer travelerId, String name, String address, String phone, String email, Date dob) {
        this.travelerId = travelerId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
    }

    public Integer getTravelerId() {
        return travelerId;
    }

    public void setTravelerId(Integer travelerId) {
        this.travelerId = travelerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @XmlTransient
    public Collection<TblBooking> getTblBookingCollection() {
        return tblBookingCollection;
    }

    public void setTblBookingCollection(Collection<TblBooking> tblBookingCollection) {
        this.tblBookingCollection = tblBookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (travelerId != null ? travelerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTraveler)) {
            return false;
        }
        TblTraveler other = (TblTraveler) object;
        if ((this.travelerId == null && other.travelerId != null) || (this.travelerId != null && !this.travelerId.equals(other.travelerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblTraveler[ travelerId=" + travelerId + " ]";
    }
    
}
