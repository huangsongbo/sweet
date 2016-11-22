package com.amu.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 商品
 * @author huangsongbo
 *
 */
@Entity
@Table(name="product")
public class Product extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -2054700575022115114L;

	/*商品名*/
	@Column(name="name",nullable=false,length=200)
	@Size(min=1,max=200)
	private String name;
	
	/*港币*/
	@Column(name="hkd",nullable=false)
	private BigDecimal hkd;
	
	/*描述*/
	@Column(name="description",length=1000)
	@Size(min=0,max=1000)
	private String description;

	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;
	
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
