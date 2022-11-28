package com.anisa.tile.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sajad on 7/19/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTileProducts", query = "select myTileProduct from TileProduct myTileProduct"),
        @NamedQuery(name = "findTileProductByBdtProductBrand", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.bdtProductBrand = ?1"),
        @NamedQuery(name = "findTileProductByBdtProductDegree", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.bdtProductDegree = ?1"),
        @NamedQuery(name = "findTileProductByBdtProductFace", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.bdtProductFace = ?1"),
        @NamedQuery(name = "findTileProductByBdtProductGlaze", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.bdtProductGlaze = ?1"),
        @NamedQuery(name = "findTileProductByBdtProductName", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.bdtProductName = ?1"),
        @NamedQuery(name = "findTileProductByBdtProductType", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.bdtProductType = ?1"),
        @NamedQuery(name = "findTileProductByColorSpectrum", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.colorSpectrum = ?1"),
        @NamedQuery(name = "findTileProductByColorSpectrumContaining", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.colorSpectrum like ?1"),
        @NamedQuery(name = "findTileProductByDesignerId", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.designerId = ?1"),
        @NamedQuery(name = "findTileProductById", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.id = ?1"),
        @NamedQuery(name = "findTileProductByIsArchive", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.isArchive = ?1"),
        @NamedQuery(name = "findTileProductByIsBestSeller", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.isBestSeller = ?1"),
        @NamedQuery(name = "findTileProductByIsNew", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.isNew = ?1"),
        @NamedQuery(name = "findTileProductByPrimaryKey", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.id = ?1"),
        @NamedQuery(name = "findTileProductByRayvarzCode", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.rayvarzCode = ?1"),
        @NamedQuery(name = "findTileProductByScore", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.score = ?1"),
        @NamedQuery(name = "findTileProductByVisitNumber", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.visitNumber = ?1"),
        @NamedQuery(name = "findAllNewTileProductsOrderBySaveDate", query = "select myTileProduct from TileProduct myTileProduct where myTileProduct.isNew = true order by myTileProduct.saveDate DESC")})

@Table(schema = "public", name = "tile_product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "Tile/com/anisa/tile/domain", name = "TileProduct")
@XmlRootElement(namespace = "Tile/com/anisa/tile/domain")
public class TileProduct implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     */
    @TableGenerator(name = "TABLE_GEN", table = "SEQUENCES", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_NUMBER", pkColumnValue = "tile_product_seq")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
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

    @Column(name = "bdt_product_name")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer bdtProductName;
    /**
     */

    @Column(name = "bdt_product_brand")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer bdtProductBrand;
    /**
     */

    @Column(name = "bdt_product_design_type")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer bdtProductDesignType;
    /**
     */

    @Column(name = "bdt_product_face")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer bdtProductFace;
    /**
     */

    @Column(name = "bdt_product_glaze")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer bdtProductGlaze;
    /**
     */

    @Column(name = "bdt_product_type")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer bdtProductType;
    /**
     */

    @Column(name = "score")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer score;
    /**
     */

    @Column(name = "visit_number")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer visitNumber;
    /**
     */

    @Column(name = "bdt_product_degree")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer bdtProductDegree;
    /**
     */

    @Column(name = "is_best_seller")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Boolean isBestSeller;
    /**
     */

    @Column(name = "is_new")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Boolean isNew;
    /**
     */

    @Column(name = "is_archive")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Boolean isArchive;
    /**
     */

    @Column(name = "designer_id")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer designerId;
    /**
     */

    @Column(name = "color_spectrum", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String colorSpectrum;
    /**
     */

    @Column(name = "rayvarz_code")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer rayvarzCode;
    /**
     */

    @Column(name = "design_code")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer designCode;

    @Column(name = "title", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String title;
    /**
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({ @JoinColumn(name = "product_group_id", referencedColumnName = "id") })
    @XmlTransient
    TileProductGroup tileProductGroup;
    /**
     */
    @OneToMany(mappedBy = "tileProduct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
    @XmlElement(name = "", namespace = "")
    Set<TileImage> tileImages;
    /**
     */
    @OneToMany(mappedBy = "tileProduct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
    @XmlElement(name = "", namespace = "")
    Set<TileUsage> tileUsages;
    /**
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = "public", name = "tile_related_product", joinColumns = { @JoinColumn(name = "related_product", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "main_product", referencedColumnName = "id", nullable = false, updatable = false) })
    @XmlElement(name = "", namespace = "")
    Set<TileProduct> tileProductsForMainProduct;
    /**
     */
    @ManyToMany(mappedBy = "tileProductsForMainProduct", fetch = FetchType.LAZY)
    @XmlElement(name = "", namespace = "")
    Set<TileProduct> tileProductsForRelatedProduct;

    /**
     */
    @OneToMany(mappedBy = "tileProduct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
    @XmlElement(name = "", namespace = "")
    Set<TileProduction> tileProductions;
    /**
     */
    @OneToMany(mappedBy = "tileProduct", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
    @XmlElement(name = "", namespace = "")
    Set<TileSize> tileSizes;
    /**
     */
    @Column(name = "save_date", length = 50)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String saveDate;
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
    public void setBdtProductName(Integer bdtProductName) {
        this.bdtProductName = bdtProductName;
    }

    /**
     */
    public Integer getBdtProductName() {
        return this.bdtProductName;
    }

    /**
     */
    public void setBdtProductBrand(Integer bdtProductBrand) {
        this.bdtProductBrand = bdtProductBrand;
    }

    /**
     */
    public Integer getBdtProductBrand() {
        return this.bdtProductBrand;
    }

    /**
     */
    public void setBdtProductDesignType(Integer bdtProductDesignType) {
        this.bdtProductDesignType = bdtProductDesignType;
    }

    /**
     */
    public Integer getBdtProductDesignType() {
        return this.bdtProductDesignType;
    }

    /**
     */
    public void setBdtProductFace(Integer bdtProductFace) {
        this.bdtProductFace = bdtProductFace;
    }

    /**
     */
    public Integer getBdtProductFace() {
        return this.bdtProductFace;
    }

    /**
     */
    public void setBdtProductGlaze(Integer bdtProductGlaze) {
        this.bdtProductGlaze = bdtProductGlaze;
    }

    /**
     */
    public Integer getBdtProductGlaze() {
        return this.bdtProductGlaze;
    }

    /**
     */
    public void setBdtProductType(Integer bdtProductType) {
        this.bdtProductType = bdtProductType;
    }

    /**
     */
    public Integer getBdtProductType() {
        return this.bdtProductType;
    }

    /**
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     */
    public Integer getScore() {
        return this.score;
    }

    /**
     */
    public void setVisitNumber(Integer visitNumber) {
        this.visitNumber = visitNumber;
    }

    /**
     */
    public Integer getVisitNumber() {
        return this.visitNumber;
    }

    /**
     */
    public void setBdtProductDegree(Integer bdtProductDegree) {
        this.bdtProductDegree = bdtProductDegree;
    }

    /**
     */
    public Integer getBdtProductDegree() {
        return this.bdtProductDegree;
    }

    /**
     */
    public void setIsBestSeller(Boolean isBestSeller) {
        this.isBestSeller = isBestSeller;
    }

    /**
     */
    public Boolean getIsBestSeller() {
        return this.isBestSeller;
    }

    /**
     */
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    /**
     */
    public Boolean getIsNew() {
        return this.isNew;
    }

    /**
     */
    public void setIsArchive(Boolean isArchive) {
        this.isArchive = isArchive;
    }

    /**
     */
    public Boolean getIsArchive() {
        return this.isArchive;
    }

    /**
     */
    public void setDesignerId(Integer designerId) {
        this.designerId = designerId;
    }

    /**
     */
    public Integer getDesignerId() {
        return this.designerId;
    }

    /**
     */
    public void setColorSpectrum(String colorSpectrum) {
        this.colorSpectrum = colorSpectrum;
    }

    /**
     */
    public String getColorSpectrum() {
        return this.colorSpectrum;
    }

    /**
     */
    public void setRayvarzCode(Integer rayvarzCode) {
        this.rayvarzCode = rayvarzCode;
    }

    /**
     */
    public Integer getRayvarzCode() {
        return this.rayvarzCode;
    }

    /**
     */
    public void setDesignCode(Integer designCode) {
        this.designCode = designCode;
    }

    /**
     */
    public Integer getDesignCode() {
        return this.designCode;
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
    public void setTileImages(Set<TileImage> tileImages) {
        this.tileImages = tileImages;
    }

    /**
     */
    public Set<TileImage> getTileImages() {
        if (tileImages == null) {
            tileImages = new LinkedHashSet<TileImage>();
        }
        return tileImages;
    }

    /**
     */
    public void setTileUsages(Set<TileUsage> tileUsages) {
        this.tileUsages = tileUsages;
    }

    /**
     */
    public Set<TileUsage> getTileUsages() {
        if (tileUsages == null) {
            tileUsages = new LinkedHashSet<TileUsage>();
        }
        return tileUsages;
    }

    /**
     */
    public void setTileProductsForMainProduct(Set<TileProduct> tileProductsForMainProduct) {
        this.tileProductsForMainProduct = tileProductsForMainProduct;
    }

    /**
     */
    public Set<TileProduct> getTileProductsForMainProduct() {
        if (tileProductsForMainProduct == null) {
            tileProductsForMainProduct = new LinkedHashSet<TileProduct>();
        }
        return tileProductsForMainProduct;
    }

    /**
     */
    public void setTileProductsForRelatedProduct(Set<TileProduct> tileProductsForRelatedProduct) {
        this.tileProductsForRelatedProduct = tileProductsForRelatedProduct;
    }

    /**
     */
    public Set<TileProduct> getTileProductsForRelatedProduct() {
        if (tileProductsForRelatedProduct == null) {
            tileProductsForRelatedProduct = new LinkedHashSet<TileProduct>();
        }
        return tileProductsForRelatedProduct;
    }

    /**
     */
    public void setTileProductions(Set<TileProduction> tileProductions) {
        this.tileProductions = tileProductions;
    }

    /**
     */
    public Set<TileProduction> getTileProductions() {
        if (tileProductions == null) {
            tileProductions = new LinkedHashSet<TileProduction>();
        }
        return tileProductions;
    }

    /**
     */
    public void setTileSizes(Set<TileSize> tileSizes) {
        this.tileSizes = tileSizes;
    }

    /**
     */
    public Set<TileSize> getTileSizes() {
        if (tileSizes == null) {
            tileSizes = new LinkedHashSet<TileSize>();
        }
        return tileSizes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(String saveDate) {
        this.saveDate = saveDate;
    }

    /**
     */
    public TileProduct() {
    }

    /**
     * Copies the contents of the specified bean into this bean.
     *
     */
    public void copy(TileProduct that) {
        setId(that.getId());
        setBdtProductName(that.getBdtProductName());
        setBdtProductBrand(that.getBdtProductBrand());
        setBdtProductDesignType(that.getBdtProductDesignType());
        setBdtProductFace(that.getBdtProductFace());
        setBdtProductGlaze(that.getBdtProductGlaze());
        setBdtProductType(that.getBdtProductType());
        setScore(that.getScore());
        setVisitNumber(that.getVisitNumber());
        setBdtProductDegree(that.getBdtProductDegree());
        setIsBestSeller(that.getIsBestSeller());
        setIsNew(that.getIsNew());
        setIsArchive(that.getIsArchive());
        setDesignerId(that.getDesignerId());
        setColorSpectrum(that.getColorSpectrum());
        setRayvarzCode(that.getRayvarzCode());
        setDesignCode(that.getDesignCode());
        setTileProductGroup(that.getTileProductGroup());
        setTileImages(new LinkedHashSet<TileImage>(that.getTileImages()));
        setTileUsages(new LinkedHashSet<TileUsage>(that.getTileUsages()));
        setTileProductsForMainProduct(new LinkedHashSet<TileProduct>(that.getTileProductsForMainProduct()));
        setTileProductsForRelatedProduct(new LinkedHashSet<TileProduct>(that.getTileProductsForRelatedProduct()));
        setTileProductions(new LinkedHashSet<TileProduction>(that.getTileProductions()));
        setTileSizes(new LinkedHashSet<TileSize>(that.getTileSizes()));
    }

    /**
     * Returns a textual representation of a bean.
     *
     */
    public String toString() {

        StringBuilder buffer = new StringBuilder();

        buffer.append("id=[").append(id).append("] ");
        buffer.append("bdtProductName=[").append(bdtProductName).append("] ");
        buffer.append("bdtProductBrand=[").append(bdtProductBrand).append("] ");
        buffer.append("bdtProductDesignType=[").append(bdtProductDesignType).append("] ");
        buffer.append("bdtProductFace=[").append(bdtProductFace).append("] ");
        buffer.append("bdtProductGlaze=[").append(bdtProductGlaze).append("] ");
        buffer.append("bdtProductType=[").append(bdtProductType).append("] ");
        buffer.append("score=[").append(score).append("] ");
        buffer.append("visitNumber=[").append(visitNumber).append("] ");
        buffer.append("bdtProductDegree=[").append(bdtProductDegree).append("] ");
        buffer.append("isBestSeller=[").append(isBestSeller).append("] ");
        buffer.append("isNew=[").append(isNew).append("] ");
        buffer.append("isArchive=[").append(isArchive).append("] ");
        buffer.append("designerId=[").append(designerId).append("] ");
        buffer.append("colorSpectrum=[").append(colorSpectrum).append("] ");
        buffer.append("rayvarzCode=[").append(rayvarzCode).append("] ");
        buffer.append("bdtProductDesign=[").append(designCode).append("] ");

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
        if (!(obj instanceof TileProduct))
            return false;
        TileProduct equalCheck = (TileProduct) obj;
        if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
            return false;
        if (id != null && !id.equals(equalCheck.id))
            return false;
        return true;
    }
}