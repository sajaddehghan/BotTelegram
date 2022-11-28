package com.anisa.tile.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTileUsages", query = "select myTileUsage from TileUsage myTileUsage"),
        @NamedQuery(name = "findTileUsageByBdtProductUsage", query = "select myTileUsage from TileUsage myTileUsage where myTileUsage.bdtProductUsage = ?1"),
        @NamedQuery(name = "findTileUsageById", query = "select myTileUsage from TileUsage myTileUsage where myTileUsage.id = ?1"),
        @NamedQuery(name = "findTileUsageByPrimaryKey", query = "select myTileUsage from TileUsage myTileUsage where myTileUsage.id = ?1") })
@Table(schema = "public", name = "tile_usage")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tile2/com/anisa/tile/domain", name = "TileUsage")
public class TileUsage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     */
    @TableGenerator(name = "TABLE_GEN", table = "SEQUENCES", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_NUMBER", pkColumnValue = "tile_usage_seq")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    @Column(name = "id", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    @Id
    @XmlElement
    Integer id;
    /**
     */

    @Column(name = "bdt_product_usage")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer bdtProductUsage;

    /**
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "product_id", referencedColumnName = "id") })
    @XmlTransient
    TileProduct tileProduct;

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
    public void setBdtProductUsage(Integer bdtProductUsage) {
        this.bdtProductUsage = bdtProductUsage;
    }

    /**
     */
    public Integer getBdtProductUsage() {
        return this.bdtProductUsage;
    }

    /**
     */
    public void setTileProduct(TileProduct tileProduct) {
        this.tileProduct = tileProduct;
    }

    /**
     */
    public TileProduct getTileProduct() {
        return tileProduct;
    }

    /**
     */
    public TileUsage() {
    }

    /**
     * Copies the contents of the specified bean into this bean.
     *
     */
    public void copy(TileUsage that) {
        setId(that.getId());
        setBdtProductUsage(that.getBdtProductUsage());
        setTileProduct(that.getTileProduct());
    }

    /**
     * Returns a textual representation of a bean.
     *
     */
    public String toString() {

        StringBuilder buffer = new StringBuilder();

        buffer.append("id=[").append(id).append("] ");
        buffer.append("bdtProductUsage=[").append(bdtProductUsage).append("] ");

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
        if (!(obj instanceof TileUsage))
            return false;
        TileUsage equalCheck = (TileUsage) obj;
        if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
            return false;
        if (id != null && !id.equals(equalCheck.id))
            return false;
        return true;
    }
}
