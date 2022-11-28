package com.anisa.tile.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTileProductGroupProductCosts", query = "select myTileProductGroupProductCost from TileProductGroupProductCost myTileProductGroupProductCost"),
        @NamedQuery(name = "findTileProductGroupProductCostById", query = "select myTileProductGroupProductCost from TileProductGroupProductCost myTileProductGroupProductCost where myTileProductGroupProductCost.id = ?1"),
        @NamedQuery(name = "findTileProductGroupProductCostByMaxCost", query = "select myTileProductGroupProductCost from TileProductGroupProductCost myTileProductGroupProductCost where myTileProductGroupProductCost.maxCost = ?1"),
        @NamedQuery(name = "findTileProductGroupProductCostByMinCost", query = "select myTileProductGroupProductCost from TileProductGroupProductCost myTileProductGroupProductCost where myTileProductGroupProductCost.minCost = ?1"),
        @NamedQuery(name = "findTileProductGroupProductCostByPrimaryKey", query = "select myTileProductGroupProductCost from TileProductGroupProductCost myTileProductGroupProductCost where myTileProductGroupProductCost.id = ?1") })
@Table(schema = "public", name = "tile_product_group_product_cost")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tile2/com/anisa/tile/domain", name = "TileProductGroupProductCost")
public class TileProductGroupProductCost implements Serializable {
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

    @Column(name = "min_cost", scale = 17, precision = 17)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    BigDecimal minCost;
    /**
     */

    @Column(name = "max_cost", scale = 17, precision = 17)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    BigDecimal maxCost;

    /**
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "agency_group_id", referencedColumnName = "id") })
    @XmlTransient
    TileAgencyGroup tileAgencyGroup;
    /**
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "product_group_id", referencedColumnName = "id") })
    @XmlTransient
    TileProductGroup tileProductGroup;

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
    public void setMinCost(BigDecimal minCost) {
        this.minCost = minCost;
    }

    /**
     */
    public BigDecimal getMinCost() {
        return this.minCost;
    }

    /**
     */
    public void setMaxCost(BigDecimal maxCost) {
        this.maxCost = maxCost;
    }

    /**
     */
    public BigDecimal getMaxCost() {
        return this.maxCost;
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
    public void setTileProductGroup(TileProductGroup tileProductGroup) {
        this.tileProductGroup = tileProductGroup;
    }

    /**
     */
    public TileProductGroup getTileProductGroup() {
        return tileProductGroup;
    }

    /**
     */
    public TileProductGroupProductCost() {
    }

    /**
     * Copies the contents of the specified bean into this bean.
     *
     */
    public void copy(TileProductGroupProductCost that) {
        setId(that.getId());
        setMinCost(that.getMinCost());
        setMaxCost(that.getMaxCost());
        setTileAgencyGroup(that.getTileAgencyGroup());
        setTileProductGroup(that.getTileProductGroup());
    }

    /**
     * Returns a textual representation of a bean.
     *
     */
    public String toString() {

        StringBuilder buffer = new StringBuilder();

        buffer.append("id=[").append(id).append("] ");
        buffer.append("minCost=[").append(minCost).append("] ");
        buffer.append("maxCost=[").append(maxCost).append("] ");

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
        if (!(obj instanceof TileProductGroupProductCost))
            return false;
        TileProductGroupProductCost equalCheck = (TileProductGroupProductCost) obj;
        if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
            return false;
        if (id != null && !id.equals(equalCheck.id))
            return false;
        return true;
    }
}
