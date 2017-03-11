package com.amu.domain.DTO;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDTO {

	@NotNull
	private Long id;
	
	@NotNull
	@Size(min=1,max=200)
	private String name;
	
	private BigDecimal hkd;
	
	@Size(max=1000)
	private String description;
	
	private Long brandId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	
}
