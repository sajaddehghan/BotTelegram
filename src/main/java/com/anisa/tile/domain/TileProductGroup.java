package com.anisa.tile.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTileProductGroups", query = "select myTileProductGroup from TileProductGroup myTileProductGroup"),
        @NamedQuery(name = "findTileProductGroupByCode", query = "select myTileProductGroup from TileProductGroup myTileProductGroup where myTileProductGroup.code = ?1"),
        @NamedQuery(name = "findTileProductGroupByDescription", query = "select myTileProductGroup from TileProductGroup myTileProductGroup where myTileProductGroup.description = ?1"),
        @NamedQuery(name = "findTileProductGroupByDescriptionContaining", query = "select myTileProductGroup from TileProductGroup myTileProductGroup where myTileProductGroup.description like ?1"),
        @NamedQuery(name = "findTileProductGroupById", query = "select myTileProductGroup from TileProductGroup myTileProductGroup where myTileProductGroup.id = ?1"),
        @NamedQuery(name = "findTileProductGroupByPrimaryKey", query = "select myTileProductGroup from TileProductGroup myTileProductGroup where myTileProductGroup.id = ?1"),
        @NamedQuery(name = "findTileProductGroupByTitle", query = "select myTileProductGroup from TileProductGroup myTileProductGroup where myTileProductGroup.title = ?1"),
        @NamedQuery(name = "findTileProductGroupByTitleContaining", query = "select myTileProductGroup from TileProductGroup myTileProductGroup where myTileProductGroup.title like ?1")})
@Table(schema = "public", name = "tile_product_group")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tile2/com/anisa/tile/domain", name = "TileProductGroup")
@XmlRootElement(namespace = "tile2/com/anisa/tile/domain")
public class TileProductGroup implements Serializable {
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

    @Column(name = "title", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String title;
    /**
     */

    @Column(name = "description", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String description;

    /**
     */
    @OneToMany(mappedBy = "tileProductGroup", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @XmlElement(name = "", namespace = "")
    java.util.Set<com.anisa.tile.domain.TileProduct> tileProducts;
    /**
     */
    @OneToMany(mappedBy = "tileProductGroup", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
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
    public void setTileProducts(Set<TileProduct> tileProducts) {
        this.tileProducts = tileProducts;
    }

    /**
     */
    public Set<TileProduct> getTileProducts() {
        if (tileProducts == null) {
            tileProducts = new java.util.LinkedHashSet<com.anisa.tile.domain.TileProduct>();
        }
        return tileProducts;
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
    public TileProductGroup() {
    }

    /**
     * Copies the contents of the specified bean into this bean.
     */
    public void copy(TileProductGroup that) {
        setId(that.getId());
        setCode(that.getCode());
        setTitle(that.getTitle());
        setDescription(that.getDescription());
        setTileProducts(new java.util.LinkedHashSet<com.anisa.tile.domain.TileProduct>(that.getTileProducts()));
        setTileProductGroupProductCosts(new java.util.LinkedHashSet<com.anisa.tile.domain.TileProductGroupProductCost>(that.getTileProductGroupProductCosts()));
    }

    /**
     * Returns a textual representation of a bean.
     */
    public String toString() {

        StringBuilder buffer = new StringBuilder();

        buffer.append("id=[").append(id).append("] ");
        buffer.append("code=[").append(code).append("] ");
        buffer.append("title=[").append(title).append("] ");
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
        if (!(obj instanceof TileProductGroup))
            return false;
        TileProductGroup equalCheck = (TileProductGroup) obj;
        if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
            return false;
        if (id != null && !id.equals(equalCheck.id))
            return false;
        return true;
    }
}
