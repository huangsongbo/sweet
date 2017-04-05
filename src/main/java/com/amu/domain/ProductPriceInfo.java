package com.amu.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 产品对应门店价格(不同门店价格不同)
 * @author huangsongbo
 *
 */
@Entity
@Table(name = "product_price_info")
public class ProductPriceInfo implements Serializable{

	private static final long serialVersionUID = 1057662788485055938L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "product_id", nullable = false, unique = true)
	private Long productId;
	
	/*@Column(name = "store_id", nullable = false)
	private Long storeId;*/
	
	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@ManyToOne(fetch = FetchType.EAGER, optional = true)
	@JoinColumn(name = "store_id")
	private Store store;
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/*public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}*/

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
