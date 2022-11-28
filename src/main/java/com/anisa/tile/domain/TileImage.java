package com.anisa.tile.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by sajad on 7/19/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTileImages", query = "select myTileImage from TileImage myTileImage"),
        @NamedQuery(name = "findTileImageById", query = "select myTileImage from TileImage myTileImage where myTileImage.id = ?1"),
        @NamedQuery(name = "findTileImageByPrimaryKey", query = "select myTileImage from TileImage myTileImage where myTileImage.id = ?1"),
        @NamedQuery(name = "findTileImageByProductId", query = "select myTileImage from TileImage myTileImage where myTileImage.tileProduct.id = ?1")})
@Table(schema = "public", name = "tile_image")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tile2/com/anisa/tile/domain", name = "TileImage")
public class TileImage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     */
    @TableGenerator(name = "TABLE_GEN", table = "SEQUENCES", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_NUMBER", pkColumnValue = "tile_image_seq")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    @Column(name = "id", nullable = false)
    @Basic(fetch = FetchType.EAGER)
    @Id
    @XmlElement
    Integer id;
    /**
     */

    @Column(name = "description", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String description;
    /**
     */

    @Column(name = "bdt_image_type")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer bdtImageType;

    /**
     */
    @Column(name = "path", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String path;

    /**
     */
    @Column(name = "name", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String name;

    /**
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({@JoinColumn(name = "product_id", referencedColumnName = "id")})
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getBdtImageType() {
        return bdtImageType;
    }

    public void setBdtImageType(Integer bdtImageType) {
        this.bdtImageType = bdtImageType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     */
    public TileImage() {
    }

    /**
     * Copies the contents of the specified bean into this bean.
     */
    public void copy(TileImage that) {
        setId(that.getId());
        setTileProduct(that.getTileProduct());
    }

    /**
     * Returns a textual representation of a bean.
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
        if (!(obj instanceof TileImage))
            return false;
        TileImage equalCheck = (TileImage) obj;
        if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
            return false;
        if (id != null && !id.equals(equalCheck.id))
            return false;
        return true;
    }
}
