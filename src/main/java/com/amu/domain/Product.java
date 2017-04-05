package com.amu.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 商品
 * @author huangsongbo
 *
 */
@Entity
@Table(name="product")
@DynamicUpdate(true)
public class Product extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -2054700575022115114L;

	/**商品名*/
	@Column(name="name",nullable=false,length=200)
	@Size(min=1,max=200)
	private String name;
	
	/**港币*/
	@Column(name="hkd",nullable=false)
	private BigDecimal hkd;
	
	/**描述*/
	@Column(name="description",length=1000)
	@Size(min=0,max=1000)
	private String description;

	/**品牌*/
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	/**在不同门店的价格*/
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private List<ProductPriceInfo> productPriceInfoList = new ArrayList<ProductPriceInfo>();
	
	/**在不同门店的价格(返回数据用)*/
	@Transient
	private List<BigDecimal> priceList = new ArrayList<BigDecimal>();
	
	public List<BigDecimal> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<BigDecimal> priceList) {
		this.priceList = priceList;
	}

	public List<ProductPriceInfo> getProductPriceInfoList() {
		return productPriceInfoList;
	}

	public void setProductPriceInfoList(List<ProductPriceInfo> productPriceInfoList) {
		this.productPriceInfoList = productPriceInfoList;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getHkd() {
		return hkd;
	}

	public void setHkd(BigDecimal hkd) {
		this.hkd = hkd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
