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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Dennis
 */
@Embeddable
public class TblFlightPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "flightId")
    private int flightId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "departCityId")
    private int departCityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arriveCityId")
    private int arriveCityId;

    public TblFlightPK() {
    }

    public TblFlightPK(int flightId, Date departTime, int departCityId, int arriveCityId) {
        this.flightId = flightId;
        this.departTime = departTime;
        this.departCityId = departCityId;
        this.arriveCityId = arriveCityId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
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
        hash += (int) flightId;
        hash += (departTime != null ? departTime.hashCode() : 0);
        hash += (int) departCityId;
        hash += (int) arriveCityId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFlightPK)) {
            return false;
        }
        TblFlightPK other = (TblFlightPK) object;
        if (this.flightId != other.flightId) {
            return false;
        }
        if ((this.departTime == null && other.departTime != null) || (this.departTime != null && !this.departTime.equals(other.departTime))) {
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
        return "Entity.TblFlightPK[ flightId=" + flightId + ", departTime=" + departTime + ", departCityId=" + departCityId + ", arriveCityId=" + arriveCityId + " ]";
    }
    
}
