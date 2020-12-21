/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "tbl_booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBooking.findAll", query = "SELECT t FROM TblBooking t")
    , @NamedQuery(name = "TblBooking.findByBookingId", query = "SELECT t FROM TblBooking t WHERE t.tblBookingPK.bookingId = :bookingId")
    , @NamedQuery(name = "TblBooking.findByFlightId", query = "SELECT t FROM TblBooking t WHERE t.tblBookingPK.flightId = :flightId")
    , @NamedQuery(name = "TblBooking.findByIsActive", query = "SELECT t FROM TblBooking t WHERE t.isActive = :isActive")
    , @NamedQuery(name = "TblBooking.findByStripeId", query = "SELECT t FROM TblBooking t WHERE t.stripeId = :stripeId")
    , @NamedQuery(name = "TblBooking.findByBookerId", query = "SELECT t FROM TblBooking t WHERE t.tblBookingPK.bookerId = :bookerId")})
public class TblBooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblBookingPK tblBookingPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive")
    private short isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "stripeId")
    private String stripeId;
    @JoinTable(name = "tbl_flight_has_bookings", joinColumns = {
        @JoinColumn(name = "bookings_bookingId", referencedColumnName = "bookingId")
        , @JoinColumn(name = "bookings_flightId", referencedColumnName = "flightId")}, inverseJoinColumns = {
        @JoinColumn(name = "flights_flightId", referencedColumnName = "flightId")
        , @JoinColumn(name = "flights_departTime", referencedColumnName = "departTime")
        , @JoinColumn(name = "flights_departCityId", referencedColumnName = "departCityId")
        , @JoinColumn(name = "flights_arriveCityId", referencedColumnName = "arriveCityId")})
    @ManyToMany
    private Collection<TblFlight> tblFlightCollection;
    @JoinTable(name = "tbl_bookings_has_travelers", joinColumns = {
        @JoinColumn(name = "bookings_bookingId", referencedColumnName = "bookingId")
        , @JoinColumn(name = "bookings_flightId", referencedColumnName = "flightId")}, inverseJoinColumns = {
        @JoinColumn(name = "traveler_travelerId", referencedColumnName = "travelerId")})
    @ManyToMany
    private Collection<TblTraveler> tblTravelerCollection;
    @JoinColumn(name = "bookerId", referencedColumnName = "userId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblUsers tblUsers;

    public TblBooking() {
    }

    public TblBooking(TblBookingPK tblBookingPK) {
        this.tblBookingPK = tblBookingPK;
    }

    public TblBooking(TblBookingPK tblBookingPK, short isActive, String stripeId) {
        this.tblBookingPK = tblBookingPK;
        this.isActive = isActive;
        this.stripeId = stripeId;
    }

    public TblBooking(int bookingId, int flightId, int bookerId) {
        this.tblBookingPK = new TblBookingPK(bookingId, flightId, bookerId);
    }

    public TblBookingPK getTblBookingPK() {
        return tblBookingPK;
    }

    public void setTblBookingPK(TblBookingPK tblBookingPK) {
        this.tblBookingPK = tblBookingPK;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    @XmlTransient
    public Collection<TblFlight> getTblFlightCollection() {
        return tblFlightCollection;
    }

    public void setTblFlightCollection(Collection<TblFlight> tblFlightCollection) {
        this.tblFlightCollection = tblFlightCollection;
    }

    @XmlTransient
    public Collection<TblTraveler> getTblTravelerCollection() {
        return tblTravelerCollection;
    }

    public void setTblTravelerCollection(Collection<TblTraveler> tblTravelerCollection) {
        this.tblTravelerCollection = tblTravelerCollection;
    }

    public TblUsers getTblUsers() {
        return tblUsers;
    }

    public void setTblUsers(TblUsers tblUsers) {
        this.tblUsers = tblUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblBookingPK != null ? tblBookingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBooking)) {
            return false;
        }
        TblBooking other = (TblBooking) object;
        if ((this.tblBookingPK == null && other.tblBookingPK != null) || (this.tblBookingPK != null && !this.tblBookingPK.equals(other.tblBookingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblBooking[ tblBookingPK=" + tblBookingPK + " ]";
    }
    
}
