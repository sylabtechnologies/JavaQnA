/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Dennis
 */
@Embeddable
public class TblFlightUploadDetailsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "flightUploadDetailsId")
    private int flightUploadDetailsId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flightUploadId")
    private int flightUploadId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departCityId")
    private int departCityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arriveCityId")
    private int arriveCityId;

    public TblFlightUploadDetailsPK() {
    }

    public TblFlightUploadDetailsPK(int flightUploadDetailsId, int flightUploadId, int departCityId, int arriveCityId) {
        this.flightUploadDetailsId = flightUploadDetailsId;
        this.flightUploadId = flightUploadId;
        this.departCityId = departCityId;
        this.arriveCityId = arriveCityId;
    }

    public int getFlightUploadDetailsId() {
        return flightUploadDetailsId;
    }

    public void setFlightUploadDetailsId(int flightUploadDetailsId) {
        this.flightUploadDetailsId = flightUploadDetailsId;
    }

    public int getFlightUploadId() {
        return flightUploadId;
    }

    public void setFlightUploadId(int flightUploadId) {
        this.flightUploadId = flightUploadId;
    }

    public int getDepartCityId() {
        return departCityId;
    }

    public void setDepartCityId(int departCityId) {
        this.departCityId = departCityId;
    }

    public int getArriveCityId() {
        return arriveCityId;
    }

    public void setArriveCityId(int arriveCityId) {
        this.arriveCityId = arriveCityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) flightUploadDetailsId;
        hash += (int) flightUploadId;
        hash += (int) departCityId;
        hash += (int) arriveCityId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFlightUploadDetailsPK)) {
            return false;
        }
        TblFlightUploadDetailsPK other = (TblFlightUploadDetailsPK) object;
        if (this.flightUploadDetailsId != other.flightUploadDetailsId) {
            return false;
        }
        if (this.flightUploadId != other.flightUploadId) {
            return false;
        }
        if (this.departCityId != other.departCityId) {
            return false;
        }
        if (this.arriveCityId != other.arriveCityId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblFlightUploadDetailsPK[ flightUploadDetailsId=" + flightUploadDetailsId + ", flightUploadId=" + flightUploadId + ", departCityId=" + departCityId + ", arriveCityId=" + arriveCityId + " ]";
    }
    
}
