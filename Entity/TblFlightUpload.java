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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "tbl_flight_upload")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFlightUpload.findAll", query = "SELECT t FROM TblFlightUpload t")
    , @NamedQuery(name = "TblFlightUpload.findByFlightUploadId", query = "SELECT t FROM TblFlightUpload t WHERE t.flightUploadId = :flightUploadId")
    , @NamedQuery(name = "TblFlightUpload.findByUploadedDate", query = "SELECT t FROM TblFlightUpload t WHERE t.uploadedDate = :uploadedDate")
    , @NamedQuery(name = "TblFlightUpload.findByNumberOfRecords", query = "SELECT t FROM TblFlightUpload t WHERE t.numberOfRecords = :numberOfRecords")})
public class TblFlightUpload implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "flightUploadId")
    private Integer flightUploadId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uploadedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberOfRecords")
    private int numberOfRecords;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblFlightUpload")
    private Collection<TblFlightUploadDetails> tblFlightUploadDetailsCollection;

    public TblFlightUpload() {
    }

    public TblFlightUpload(Integer flightUploadId) {
        this.flightUploadId = flightUploadId;
    }

    public TblFlightUpload(Integer flightUploadId, Date uploadedDate, int numberOfRecords) {
        this.flightUploadId = flightUploadId;
        this.uploadedDate = uploadedDate;
        this.numberOfRecords = numberOfRecords;
    }

    public Integer getFlightUploadId() {
        return flightUploadId;
    }

    public void setFlightUploadId(Integer flightUploadId) {
        this.flightUploadId = flightUploadId;
    }

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    public void setNumberOfRecords(int numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    @XmlTransient
    public Collection<TblFlightUploadDetails> getTblFlightUploadDetailsCollection() {
        return tblFlightUploadDetailsCollection;
    }

    public void setTblFlightUploadDetailsCollection(Collection<TblFlightUploadDetails> tblFlightUploadDetailsCollection) {
        this.tblFlightUploadDetailsCollection = tblFlightUploadDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightUploadId != null ? flightUploadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFlightUpload)) {
            return false;
        }
        TblFlightUpload other = (TblFlightUpload) object;
        if ((this.flightUploadId == null && other.flightUploadId != null) || (this.flightUploadId != null && !this.flightUploadId.equals(other.flightUploadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblFlightUpload[ flightUploadId=" + flightUploadId + " ]";
    }
    
}
