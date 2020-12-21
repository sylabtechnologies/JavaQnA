/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tbl_airport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblAirport.findAll", query = "SELECT t FROM TblAirport t")
    , @NamedQuery(name = "TblAirport.findByAirportId", query = "SELECT t FROM TblAirport t WHERE t.airportId = :airportId")
    , @NamedQuery(name = "TblAirport.findByCity", query = "SELECT t FROM TblAirport t WHERE t.city = :city")})
public class TblAirport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "airportId")
    private Integer airportId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblAirport")
    private Collection<TblFlight> tblFlightCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblAirport1")
    private Collection<TblFlight> tblFlightCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblAirport")
    private Collection<TblFlightUploadDetails> tblFlightUploadDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblAirport1")
    private Collection<TblFlightUploadDetails> tblFlightUploadDetailsCollection1;

    public TblAirport() {
    }

    public TblAirport(Integer airportId) {
        this.airportId = airportId;
    }

    public TblAirport(Integer airportId, String city) {
        this.airportId = airportId;
        this.city = city;
    }

    public Integer getAirportId() {
        return airportId;
    }

    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<TblFlight> getTblFlightCollection() {
        return tblFlightCollection;
    }

    public void setTblFlightCollection(Collection<TblFlight> tblFlightCollection) {
        this.tblFlightCollection = tblFlightCollection;
    }

    @XmlTransient
    public Collection<TblFlight> getTblFlightCollection1() {
        return tblFlightCollection1;
    }

    public void setTblFlightCollection1(Collection<TblFlight> tblFlightCollection1) {
        this.tblFlightCollection1 = tblFlightCollection1;
    }

    @XmlTransient
    public Collection<TblFlightUploadDetails> getTblFlightUploadDetailsCollection() {
        return tblFlightUploadDetailsCollection;
    }

    public void setTblFlightUploadDetailsCollection(Collection<TblFlightUploadDetails> tblFlightUploadDetailsCollection) {
        this.tblFlightUploadDetailsCollection = tblFlightUploadDetailsCollection;
    }

    @XmlTransient
    public Collection<TblFlightUploadDetails> getTblFlightUploadDetailsCollection1() {
        return tblFlightUploadDetailsCollection1;
    }

    public void setTblFlightUploadDetailsCollection1(Collection<TblFlightUploadDetails> tblFlightUploadDetailsCollection1) {
        this.tblFlightUploadDetailsCollection1 = tblFlightUploadDetailsCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (airportId != null ? airportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAirport)) {
            return false;
        }
        TblAirport other = (TblAirport) object;
        if ((this.airportId == null && other.airportId != null) || (this.airportId != null && !this.airportId.equals(other.airportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblAirport[ airportId=" + airportId + " ]";
    }
    
}
