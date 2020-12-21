/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "tbl_flight_upload_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFlightUploadDetails.findAll", query = "SELECT t FROM TblFlightUploadDetails t")
    , @NamedQuery(name = "TblFlightUploadDetails.findByFlightUploadDetailsId", query = "SELECT t FROM TblFlightUploadDetails t WHERE t.tblFlightUploadDetailsPK.flightUploadDetailsId = :flightUploadDetailsId")
    , @NamedQuery(name = "TblFlightUploadDetails.findByFlightUploadId", query = "SELECT t FROM TblFlightUploadDetails t WHERE t.tblFlightUploadDetailsPK.flightUploadId = :flightUploadId")
    , @NamedQuery(name = "TblFlightUploadDetails.findByDepartTime", query = "SELECT t FROM TblFlightUploadDetails t WHERE t.departTime = :departTime")
    , @NamedQuery(name = "TblFlightUploadDetails.findByDepartCityId", query = "SELECT t FROM TblFlightUploadDetails t WHERE t.tblFlightUploadDetailsPK.departCityId = :departCityId")
    , @NamedQuery(name = "TblFlightUploadDetails.findByArriveCityId", query = "SELECT t FROM TblFlightUploadDetails t WHERE t.tblFlightUploadDetailsPK.arriveCityId = :arriveCityId")})
public class TblFlightUploadDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblFlightUploadDetailsPK tblFlightUploadDetailsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departTime;
    @JoinColumn(name = "departCityId", referencedColumnName = "airportId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblAirport tblAirport;
    @JoinColumn(name = "arriveCityId", referencedColumnName = "airportId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblAirport tblAirport1;
    @JoinColumn(name = "flightUploadId", referencedColumnName = "flightUploadId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblFlightUpload tblFlightUpload;

    public TblFlightUploadDetails() {
    }

    public TblFlightUploadDetails(TblFlightUploadDetailsPK tblFlightUploadDetailsPK) {
        this.tblFlightUploadDetailsPK = tblFlightUploadDetailsPK;
    }

    public TblFlightUploadDetails(TblFlightUploadDetailsPK tblFlightUploadDetailsPK, Date departTime) {
        this.tblFlightUploadDetailsPK = tblFlightUploadDetailsPK;
        this.departTime = departTime;
    }

    public TblFlightUploadDetails(int flightUploadDetailsId, int flightUploadId, int departCityId, int arriveCityId) {
        this.tblFlightUploadDetailsPK = new TblFlightUploadDetailsPK(flightUploadDetailsId, flightUploadId, departCityId, arriveCityId);
    }

    public TblFlightUploadDetailsPK getTblFlightUploadDetailsPK() {
        return tblFlightUploadDetailsPK;
    }

    public void setTblFlightUploadDetailsPK(TblFlightUploadDetailsPK tblFlightUploadDetailsPK) {
        this.tblFlightUploadDetailsPK = tblFlightUploadDetailsPK;
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
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

    public TblFlightUpload getTblFlightUpload() {
        return tblFlightUpload;
    }

    public void setTblFlightUpload(TblFlightUpload tblFlightUpload) {
        this.tblFlightUpload = tblFlightUpload;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblFlightUploadDetailsPK != null ? tblFlightUploadDetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFlightUploadDetails)) {
            return false;
        }
        TblFlightUploadDetails other = (TblFlightUploadDetails) object;
        if ((this.tblFlightUploadDetailsPK == null && other.tblFlightUploadDetailsPK != null) || (this.tblFlightUploadDetailsPK != null && !this.tblFlightUploadDetailsPK.equals(other.tblFlightUploadDetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblFlightUploadDetails[ tblFlightUploadDetailsPK=" + tblFlightUploadDetailsPK + " ]";
    }
    
}
