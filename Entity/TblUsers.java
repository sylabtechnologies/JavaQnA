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
@Table(name = "tbl_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsers.findAll", query = "SELECT t FROM TblUsers t")
    , @NamedQuery(name = "TblUsers.findByUserId", query = "SELECT t FROM TblUsers t WHERE t.userId = :userId")
    , @NamedQuery(name = "TblUsers.findByName", query = "SELECT t FROM TblUsers t WHERE t.name = :name")
    , @NamedQuery(name = "TblUsers.findByUsername", query = "SELECT t FROM TblUsers t WHERE t.username = :username")
    , @NamedQuery(name = "TblUsers.findByPassword", query = "SELECT t FROM TblUsers t WHERE t.password = :password")
    , @NamedQuery(name = "TblUsers.findByRole", query = "SELECT t FROM TblUsers t WHERE t.role = :role")})
public class TblUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role")
    private int role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblUsers")
    private Collection<TblBooking> tblBookingCollection;

    public TblUsers() {
    }

    public TblUsers(Integer userId) {
        this.userId = userId;
    }

    public TblUsers(Integer userId, String name, String username, String password, int role) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsers)) {
            return false;
        }
        TblUsers other = (TblUsers) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblUsers[ userId=" + userId + " ]";
    }
    
}
