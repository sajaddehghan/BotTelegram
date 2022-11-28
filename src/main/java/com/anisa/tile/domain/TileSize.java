package com.anisa.tile.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTileSizes", query = "select myTileSize from TileSize myTileSize"),
        @NamedQuery(name = "findTileSizeById", query = "select myTileSize from TileSize myTileSize where myTileSize.id = ?1"),
        @NamedQuery(name = "findTileSizeByPrimaryKey", query = "select myTileSize from TileSize myTileSize where myTileSize.id = ?1"),
        @NamedQuery(name = "findTileSizeByProductId", query = "select myTileSize from TileSize myTileSize where myTileSize.tileProduct.id = ?1")})
@Table(schema = "public", name = "tile_size")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tile2/com/anisa/tile/domain", name = "TileSize")
public class TileSize implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     */

    @TableGenerator(name = "TABLE_GEN", table = "SEQUENCES", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_NUMBER", pkColumnValue = "tile_size_seq")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    @Column(name = "id", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    @Id
    @XmlElement
    Integer id;
    /**
     */

    @Column(name = "bdt_product_size")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer bdtProductSize;

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
    public Integer getBdtProductSize() {
        return bdtProductSize;
    }

    public void setBdtProductSize(Integer bdtProductSize) {
        this.bdtProductSize = bdtProductSize;
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
    public TileSize() {
    }

    /**
     * Copies the contents of the specified bean into this bean.
     *
     */
    public void copy(TileSize that) {
        setId(that.getId());
        setBdtProductSize(that.getBdtProductSize());
        setTileProduct(that.getTileProduct());
    }

    /**
     * Returns a textual representation of a bean.
     *
     */
    public String toString() {

        StringBuilder buffer = new StringBuilder();

        buffer.append("id=[").append(id).append("] ");

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
        if (!(obj instanceof TileSize))
            return false;
        TileSize equalCheck = (TileSize) obj;
        if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
            return false;
        if (id != null && !id.equals(equalCheck.id))
            return false;
        return true;
    }
}