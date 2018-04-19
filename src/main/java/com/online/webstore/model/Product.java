package com.online.webstore.model;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCT")
@XmlRootElement
public class Product {

	
	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_PRODUCT")
	@SequenceGenerator(name="SEQ_PRODUCT",sequenceName="SEQ_PRODUCT")
	private Integer productId;

	@Column(name="NAME")
	private String name;
	@Column(name="UNIT_PRICE")
	private BigDecimal unitPrice;
	
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="MANUFACTURER")
	private String manufacturer;
	@Column(name="CATEGORY")
	private String category;
	@Column(name="UNIT_IN_STOCK")
	private long unitsInStock;
	@Column(name="UNIT_IN_ORDER")
	private long unitsInOrder;
	@Column(name="DISCONTINUED")
	private boolean discontinued;
	@Column(name="CONDITION")
	private String condition;
	
	@Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="productImage", nullable=true)
	private MultipartFile  productImage;

	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public Product() {

	}

	public Product(String name, BigDecimal unitPrice) {
		
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public Product( String name, BigDecimal unitPrice, String description, String manufacturer,
			String category, long unitsInStock, long unitsInOrder, boolean discontinued, String condition) {

		this.name = name;
		this.unitPrice = unitPrice;
		this.description = description;
		this.manufacturer = manufacturer;
		this.category = category;
		this.unitsInStock = unitsInStock;
		this.unitsInOrder = unitsInOrder;
		this.discontinued = discontinued;
		this.condition = condition;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public long getUnitsInOrder() {
		return unitsInOrder;
	}

	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", unitPrice=" + unitPrice + ", description="
				+ description + ", manufacturer=" + manufacturer + ", category=" + category + ", unitsInStock="
				+ unitsInStock + ", unitsInOrder=" + unitsInOrder + ", discontinued=" + discontinued + ", condition="
				+ condition + "]";
	}

}
