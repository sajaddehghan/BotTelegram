package com.anisa.tile.domain;

import com.anisa.DateHandle;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllTileProductions", query = "select myTileProduction from TileProduction myTileProduction"),
        @NamedQuery(name = "findTileProductionByBoxArea", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.boxArea = ?1"),
        @NamedQuery(name = "findTileProductionByBoxWeight", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.boxWeight = ?1"),
        @NamedQuery(name = "findTileProductionByBskvyytWeight", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.bskvyytWeight = ?1"),
        @NamedQuery(name = "findTileProductionByFormula", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.formula = ?1"),
        @NamedQuery(name = "findTileProductionByFormulaContaining", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.formula like ?1"),
        @NamedQuery(name = "findTileProductionById", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.id = ?1"),
        @NamedQuery(name = "findTileProductionByNumberInPallet", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.numberInPallet = ?1"),
        @NamedQuery(name = "findTileProductionByPalletArea", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.palletArea = ?1"),
        @NamedQuery(name = "findTileProductionByPalletWeight", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.palletWeight = ?1"),
        @NamedQuery(name = "findTileProductionByPrimaryKey", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.id = ?1"),
        @NamedQuery(name = "findTileProductionByProductionRate", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.productionRate = ?1"),
        @NamedQuery(name = "findTileProductionByProductionDate", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.productionDate = ?1"),
        @NamedQuery(name = "findTileProductionByProductionDateContaining", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.productionDate like ?1"),
        @NamedQuery(name = "findTileProductionByProductId", query = "select myTileProduction from TileProduction myTileProduction where myTileProduction.tileProduct.id = ?1")})
@Table(schema = "public", name = "tile_production")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "tile2/com/anisa/tile/domain", name = "TileProduction")
public class TileProduction implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     */
    @TableGenerator(name = "TABLE_GEN", table = "SEQUENCES", pkColumnName = "SEQ_NAME",
            valueColumnName = "SEQ_NUMBER", pkColumnValue = "tile_production_seq")
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

    @Column(name = "production_date", length = 50)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String productionDate;

    @Transient
    Date productionDateToDate;
    /**
     */

    @Column(name = "production_rate", scale = 17, precision = 17)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Double productionRate;
    /**
     */

    @Column(name = "bskvyyt_weight", scale = 17, precision = 17)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Double bskvyytWeight;
    /**
     */

    @Column(name = "formula", length = 300)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    String formula;
    /**
     */

    @Column(name = "number_in_pallet")
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Integer numberInPallet;
    /**
     */

    @Column(name = "pallet_weight", scale = 17, precision = 17)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Double palletWeight;
    /**
     */

    @Column(name = "box_weight", scale = 17, precision = 17)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Double boxWeight;
    /**
     */

    @Column(name = "box_area", scale = 17, precision = 17)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Double boxArea;
    /**
     */

    @Column(name = "pallet_area", scale = 17, precision = 17)
    @Basic(fetch = FetchType.EAGER)
    @XmlElement
    Double palletArea;

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
    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    /**
     */
    public String getProductionDate() {
        return this.productionDate;
    }

    /**
     */
    public void setProductionRate(Double productionRate) {
        this.productionRate = productionRate;
    }

    /**
     */
    public Double getProductionRate() {
        return this.productionRate;
    }

    /**
     */
    public void setBskvyytWeight(Double bskvyytWeight) {
        this.bskvyytWeight = bskvyytWeight;
    }

    /**
     */
    public Double getBskvyytWeight() {
        return this.bskvyytWeight;
    }

    /**
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     */
    public String getFormula() {
        return this.formula;
    }

    /**
     */
    public void setNumberInPallet(Integer numberInPallet) {
        this.numberInPallet = numberInPallet;
    }

    /**
     */
    public Integer getNumberInPallet() {
        return this.numberInPallet;
    }

    /**
     */
    public void setPalletWeight(Double palletWeight) {
        this.palletWeight = palletWeight;
    }

    /**
     */
    public Double getPalletWeight() {
        return this.palletWeight;
    }

    /**
     */
    public void setBoxWeight(Double boxWeight) {
        this.boxWeight = boxWeight;
    }

    /**
     */
    public Double getBoxWeight() {
        return this.boxWeight;
    }

    /**
     */
    public void setBoxArea(Double boxArea) {
        this.boxArea = boxArea;
    }

    /**
     */
    public Double getBoxArea() {
        return this.boxArea;
    }

    /**
     */
    public void setPalletArea(Double palletArea) {
        this.palletArea = palletArea;
    }

    /**
     */
    public Double getPalletArea() {
        return this.palletArea;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getProductionDateToDate() {
        DateHandle datehandle = new DateHandle();
        return productionDateToDate = datehandle.StringToDate(this.productionDate);
    }

    public void setProductionDateToDate(Date productionDateToDate) {
        this.productionDateToDate = productionDateToDate;
        DateHandle datehandle = new DateHandle();
        this.productionDate = datehandle.DateToString(productionDateToDate);
    }

    /**
     */
    public TileProduction() {
    }

    /**
     * Copies the contents of the specified bean into this bean.
     */
    public void copy(TileProduction that) {
        setId(that.getId());
        setProductionDate(that.getProductionDate());
        setProductionRate(that.getProductionRate());
        setBskvyytWeight(that.getBskvyytWeight());
        setFormula(that.getFormula());
        setNumberInPallet(that.getNumberInPallet());
        setPalletWeight(that.getPalletWeight());
        setBoxWeight(that.getBoxWeight());
        setBoxArea(that.getBoxArea());
        setPalletArea(that.getPalletArea());
        setTileProduct(that.getTileProduct());
    }

    /**
     * Returns a textual representation of a bean.
     */
    public String toString() {

        StringBuilder buffer = new StringBuilder();

        buffer.append("id=[").append(id).append("] ");
        buffer.append("productionDate=[").append(productionDate).append("] ");
        buffer.append("productionRate=[").append(productionRate).append("] ");
        buffer.append("bskvyytWeight=[").append(bskvyytWeight).append("] ");
        buffer.append("formula=[").append(formula).append("] ");
        buffer.append("numberInPallet=[").append(numberInPallet).append("] ");
        buffer.append("palletWeight=[").append(palletWeight).append("] ");
        buffer.append("boxWeight=[").append(boxWeight).append("] ");
        buffer.append("boxArea=[").append(boxArea).append("] ");
        buffer.append("palletArea=[").append(palletArea).append("] ");

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
        if (!(obj instanceof TileProduction))
            return false;
        TileProduction equalCheck = (TileProduction) obj;
        if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
            return false;
        if (id != null && !id.equals(equalCheck.id))
            return false;
        return true;
    }
}
