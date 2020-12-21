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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "tbl_flight")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFlight.findAll", query = "SELECT t FROM TblFlight t")
    , @NamedQuery(name = "TblFlight.findByFlightId", query = "SELECT t FROM TblFlight t WHERE t.tblFlightPK.flightId = :flightId")
    , @NamedQuery(name = "TblFlight.findByDepartTime", query = "SELECT t FROM TblFlight t WHERE t.tblFlightPK.departTime = :departTime")
    , @NamedQuery(name = "TblFlight.findBySeatsAvailable", query = "SELECT t FROM TblFlight t WHERE t.seatsAvailable = :seatsAvailable")
    , @NamedQuery(name = "TblFlight.findByPrice", query = "SELECT t FROM TblFlight t WHERE t.price = :price")
    , @NamedQuery(name = "TblFlight.findByDepartCityId", query = "SELECT t FROM TblFlight t WHERE t.tblFlightPK.departCityId = :departCityId")
    , @NamedQuery(name = "TblFlight.findByArriveCityId", query = "SELECT t FROM TblFlight t WHERE t.tblFlightPK.arriveCityId = :arriveCityId")})
public class TblFlight implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblFlightPK tblFlightPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seatsAvailable")
    private int seatsAvailable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;
    @ManyToMany(mappedBy = "tblFlightCollection")
    private Collection<TblBooking> tblBookingCollection;
    @JoinColumn(name = "departCityId", referencedColumnName = "airportId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblAirport tblAirport;
    @JoinColumn(name = "arriveCityId", referencedColumnName = "airportId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblAirport tblAirport1;

    public TblFlight() {
    }

    public TblFlight(TblFlightPK tblFlightPK) {
        this.tblFlightPK = tblFlightPK;
    }

    public TblFlight(TblFlightPK tblFlightPK, int seatsAvailable, float price) {
        this.tblFlightPK = tblFlightPK;
        this.seatsAvailable = seatsAvailable;
        this.price = price;
    }

    public TblFlight(int flightId, Date departTime, int departCityId, int arriveCityId) {
        this.tblFlightPK = new TblFlightPK(flightId, departTime, departCityId, arriveCityId);
    }

    public TblFlightPK getTblFlightPK() {
        return tblFlightPK;
    }

    public void setTblFlightPK(TblFlightPK tblFlightPK) {
        this.tblFlightPK = tblFlightPK;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<TblBooking> getTblBookingCollection() {
        return tblBookingCollection;
    }

    public void setTblBookingCollection(Collection<TblBooking> tblBookingCollection) {
        this.tblBookingCollection = tblBookingCollection;
    }

    public TblAirport getTblAirport() {
        return tblAirport;
    }

    public void setTblAirport(TblAirport tblAirport) {
        this.tblAirport = tblAirport;
    }

    public TblAirport getTblAirport1() {
        return tblAirport1;
    }

    public void setTblAirport1(TblAirport tblAirport1) {
        this.tblAirport1 = tblAirport1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblFlightPK != null ? tblFlightPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFlight)) {
            return false;
        }
        TblFlight other = (TblFlight) object;
        if ((this.tblFlightPK == null && other.tblFlightPK != null) || (this.tblFlightPK != null && !this.tblFlightPK.equals(other.tblFlightPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblFlight[ tblFlightPK=" + tblFlightPK + " ]";
    }
    
}
