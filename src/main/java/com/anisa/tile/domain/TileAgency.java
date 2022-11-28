package com.anisa.tile.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTileAgencys", query = "select myTileAgency from TileAgency myTileAgency"),
        @NamedQuery(name = "findTileAgencyByAddress", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.address = ?1"),
        @NamedQuery(name = "findTileAgencyByAddressContaining", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.address like ?1"),
        @NamedQuery(name = "findTileAgencyByCode", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.code = ?1"),
        @NamedQuery(name = "findTileAgencyByEconomicId", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.economicId = ?1"),
        @NamedQuery(name = "findTileAgencyByEconomicIdContaining", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.economicId like ?1"),
        @NamedQuery(name = "findTileAgencyByEmail", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.email = ?1"),
        @NamedQuery(name = "findTileAgencyByEmailContaining", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.email like ?1"),
        @NamedQuery(name = "findTileAgencyById", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.id = ?1"),
        @NamedQuery(name = "findTileAgencyByMaxAccountBalance", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.maxAccountBalance = ?1"),
        @NamedQuery(name = "findTileAgencyByMobile", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.mobile = ?1"),
        @NamedQuery(name = "findTileAgencyByMobileContaining", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.mobile like ?1"),
        @NamedQuery(name = "findTileAgencyByNationalId", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.nationalId = ?1"),
        @NamedQuery(name = "findTileAgencyByNationalIdContaining", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.nationalId like ?1"),
        @NamedQuery(name = "findTileAgencyByPhone", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.phone = ?1"),
        @NamedQuery(name = "findTileAgencyByPhoneContaining", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.phone like ?1"),
        @NamedQuery(name = "findTileAgencyByPrimaryKey", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.id = ?1"),
        @NamedQuery(name = "findTileAgencyByTitle", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.title = ?1"),
        @NamedQuery(name = "findTileAgencyByTitleContaining", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.title like ?1"),
        @NamedQuery(name = "findTileAgencyByZipCode", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.zipCode = ?1"),
        @NamedQuery(name = "findTileAgencyByZipCodeContaining", query = "select myTileAgency from TileAgency myTileAgency where myTileAgency.zipCode like ?1") })
@Table(schema = "public", name = "tile_agency")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tile2/com/anisa/tile/domain", name = "TileAgency")
public class TileAgency implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     */

    @Column(name = "id", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    @Id
    @XmlElement
    Integer id;
    /**
     */

    @Column(name = "code")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer code;
    /**
     */

    @Column(name = "title", length = 200)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String title;
    /**
     */

    @Column(name = "max_account_balance", scale = 17, precision = 17)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    BigDecimal maxAccountBalance;
    /**
     */

    @Column(name = "economic_id", length = 20)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String economicId;
    /**
     */

    @Column(name = "national_id", length = 20)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String nationalId;
    /**
     */

    @Column(name = "address", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String address;
    /**
     */

    @Column(name = "phone", length = 50)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String phone;
    /**
     */

    @Column(name = "mobile", length = 50)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String mobile;
    /**
     */

    @Column(name = "email", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String email;
    /**
     */

    @Column(name = "zip_code", length = 20)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String zipCode;

    /**
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "agency_group_id", referencedColumnName = "id") })
    @XmlTransient
    TileAgencyGroup tileAgencyGroup;

    /**
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     */
    public Integer getId() {
        return this.id;
    }

    /**
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     */
    public Integer getCode() {
        return this.code;
    }

    /**
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     */
    public String getTitle() {
        return this.title;
    }

    /**
     */
    public void setMaxAccountBalance(BigDecimal maxAccountBalance) {
        this.maxAccountBalance = maxAccountBalance;
    }

    /**
     */
    public BigDecimal getMaxAccountBalance() {
        return this.maxAccountBalance;
    }

    /**
     */
    public void setEconomicId(String economicId) {
        this.economicId = economicId;
    }

    /**
     */
    public String getEconomicId() {
        return this.economicId;
    }

    /**
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    /**
     */
    public String getNationalId() {
        return this.nationalId;
    }

    /**
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     */
    public String getAddress() {
        return this.address;
    }

    /**
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     */
    public String getEmail() {
        return this.email;
    }

    /**
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     */
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     */
    public void setTileAgencyGroup(TileAgencyGroup tileAgencyGroup) {
        this.tileAgencyGroup = tileAgencyGroup;
    }

    /**
     */
    public TileAgencyGroup getTileAgencyGroup() {
        return tileAgencyGroup;
    }

    /**
     */
    public TileAgency() {
    }

    /**
     * Copies the contents of the specified bean into this bean.
     *
     */
    public void copy(TileAgency that) {
        setId(that.getId());
        setCode(that.getCode());
        setTitle(that.getTitle());
        setMaxAccountBalance(that.getMaxAccountBalance());
        setEconomicId(that.getEconomicId());
        setNationalId(that.getNationalId());
        setAddress(that.getAddress());
        setPhone(that.getPhone());
        setMobile(that.getMobile());
        setEmail(that.getEmail());
        setZipCode(that.getZipCode());
        setTileAgencyGroup(that.getTileAgencyGroup());
    }

    /**
     * Returns a textual representation of a bean.
     *
     */
    public String toString() {

        StringBuilder buffer = new StringBuilder();

        buffer.append("id=[").append(id).append("] ");
        buffer.append("code=[").append(code).append("] ");
        buffer.append("title=[").append(title).append("] ");
        buffer.append("maxAccountBalance=[").append(maxAccountBalance).append("] ");
        buffer.append("economicId=[").append(economicId).append("] ");
        buffer.append("nationalId=[").append(nationalId).append("] ");
        buffer.append("address=[").append(address).append("] ");
        buffer.append("phone=[").append(phone).append("] ");
        buffer.append("mobile=[").append(mobile).append("] ");
        buffer.append("email=[").append(email).append("] ");
        buffer.append("zipCode=[").append(zipCode).append("] ");

        return buffer.toString();
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
        return result;
    }

    /**
     */
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof TileAgency))
            return false;
        TileAgency equalCheck = (TileAgency) obj;
        if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
            return false;
        if (id != null && !id.equals(equalCheck.id))
            return false;
        return true;
    }
}
