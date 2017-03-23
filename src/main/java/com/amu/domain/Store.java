package com.amu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

/**
 * 门店
 * @author huangsongbo
 *
 */
@Entity
@Table(name = "store")
@DynamicUpdate(true)
public class Store extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 447770631486336358L;

	/**门店名称*/
	@Column(name = "name", unique = true, nullable = false, length = 100)
	@Size(min = 1, max = 100)
	private String name;
	
	/**描述*/
	@Column(name = "description", length = 1000)
	@Size(max = 1000)
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
