package com.anisa.tile.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTileAgencyGroups", query = "select myTileAgencyGroup from TileAgencyGroup myTileAgencyGroup"),
        @NamedQuery(name = "findTileAgencyGroupByCode", query = "select myTileAgencyGroup from TileAgencyGroup myTileAgencyGroup where myTileAgencyGroup.code = ?1"),
        @NamedQuery(name = "findTileAgencyGroupByDescription", query = "select myTileAgencyGroup from TileAgencyGroup myTileAgencyGroup where myTileAgencyGroup.description = ?1"),
        @NamedQuery(name = "findTileAgencyGroupByDescriptionContaining", query = "select myTileAgencyGroup from TileAgencyGroup myTileAgencyGroup where myTileAgencyGroup.description like ?1"),
        @NamedQuery(name = "findTileAgencyGroupById", query = "select myTileAgencyGroup from TileAgencyGroup myTileAgencyGroup where myTileAgencyGroup.id = ?1"),
        @NamedQuery(name = "findTileAgencyGroupByName", query = "select myTileAgencyGroup from TileAgencyGroup myTileAgencyGroup where myTileAgencyGroup.name = ?1"),
        @NamedQuery(name = "findTileAgencyGroupByNameContaining", query = "select myTileAgencyGroup from TileAgencyGroup myTileAgencyGroup where myTileAgencyGroup.name like ?1"),
        @NamedQuery(name = "findTileAgencyGroupByPrimaryKey", query = "select myTileAgencyGroup from TileAgencyGroup myTileAgencyGroup where myTileAgencyGroup.id = ?1") })
@Table(schema = "public", name = "tile_agency_group")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tile2/com/anisa/tile/domain", name = "TileAgencyGroup")
@XmlRootElement(namespace = "tile2/com/anisa/tile/domain")
public class TileAgencyGroup implements Serializable {
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

    @Column(name = "name", length = 200)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String name;
    /**
     */

    @Column(name = "code")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer code;
    /**
     */

    @Column(name = "description", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String description;

    /**
     */
    @OneToMany(mappedBy = "tileAgencyGroup", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
    @XmlElement(name = "", namespace = "")
    java.util.Set<com.anisa.tile.domain.TileAgency> tileAgencies;
    /**
     */
    @OneToMany(mappedBy = "tileAgencyGroup", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
    @XmlElement(name = "", namespace = "")
    java.util.Set<com.anisa.tile.domain.TileProductGroupProductCost> tileProductGroupProductCosts;

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
    public void setName(String name) {
        this.name = name;
    }

    /**
     */
    public String getName() {
        return this.name;
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
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     */
    public String getDescription() {
        return this.description;
    }

    /**
     */
    public void setTileAgencies(Set<TileAgency> tileAgencies) {
        this.tileAgencies = tileAgencies;
    }

    /**
     */
    public Set<TileAgency> getTileAgencies() {
        if (tileAgencies == null) {
            tileAgencies = new java.util.LinkedHashSet<com.anisa.tile.domain.TileAgency>();
        }
        return tileAgencies;
    }

    /**
     */
    public void setTileProductGroupProductCosts(Set<TileProductGroupProductCost> tileProductGroupProductCosts) {
        this.tileProductGroupProductCosts = tileProductGroupProductCosts;
    }

    /**
     */
    public Set<TileProductGroupProductCost> getTileProductGroupProductCosts() {
        if (tileProductGroupProductCosts == null) {
            tileProductGroupProductCosts = new java.util.LinkedHashSet<com.anisa.tile.domain.TileProductGroupProductCost>();
        }
        return tileProductGroupProductCosts;
    }

    /**
     */
    public TileAgencyGroup() {
    }

    /**
     * Copies the contents of the specified bean into this bean.
     *
     */
    public void copy(TileAgencyGroup that) {
        setId(that.getId());
        setName(that.getName());
        setCode(that.getCode());
        setDescription(that.getDescription());
        setTileAgencies(new java.util.LinkedHashSet<com.anisa.tile.domain.TileAgency>(that.getTileAgencies()));
        setTileProductGroupProductCosts(new java.util.LinkedHashSet<com.anisa.tile.domain.TileProductGroupProductCost>(that.getTileProductGroupProductCosts()));
    }

    /**
     * Returns a textual representation of a bean.
     *
     */
    public String toString() {

        StringBuilder buffer = new StringBuilder();

        buffer.append("id=[").append(id).append("] ");
        buffer.append("name=[").append(name).append("] ");
        buffer.append("code=[").append(code).append("] ");
        buffer.append("description=[").append(description).append("] ");

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
        if (!(obj instanceof TileAgencyGroup))
            return false;
        TileAgencyGroup equalCheck = (TileAgencyGroup) obj;
        if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
            return false;
        if (id != null && !id.equals(equalCheck.id))
            return false;
        return true;
    }
}
