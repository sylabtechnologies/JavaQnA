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
public class TblBookingPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "bookingId")
    private int bookingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flightId")
    private int flightId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bookerId")
    private int bookerId;

    public TblBookingPK() {
    }

    public TblBookingPK(int bookingId, int flightId, int bookerId) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.bookerId = bookerId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getBookerId() {
        return bookerId;
    }

    public void setBookerId(int bookerId) {
        this.bookerId = bookerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) bookingId;
        hash += (int) flightId;
        hash += (int) bookerId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBookingPK)) {
            return false;
        }
        TblBookingPK other = (TblBookingPK) object;
        if (this.bookingId != other.bookingId) {
            return false;
        }
        if (this.flightId != other.flightId) {
            return false;
        }
        if (this.bookerId != other.bookerId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblBookingPK[ bookingId=" + bookingId + ", flightId=" + flightId + ", bookerId=" + bookerId + " ]";
    }
    
}
