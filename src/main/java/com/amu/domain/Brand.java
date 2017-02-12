package com.amu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 品牌
 * @author huangsongbo
 *
 */
@Entity
@Table(name="brand")
public class Brand extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 5650674369727005055L;

	/*品牌名称*/
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	/*描述*/
	@Column(name="description",length=1000)
	@Size(min=0,max=1000)
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
