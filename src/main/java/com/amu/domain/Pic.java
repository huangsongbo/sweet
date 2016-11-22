package com.amu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 图片资源
 * @author huangsongbo
 *
 */
@Entity
@Table(name="pic")
public class Pic extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -4494557412586527607L;

	/*图片名(上传后)*/
	@Column(name="pic_name",nullable=false,length=200)
	@Size(min=1,max=200)
	private String picName;
	
	/*图片修改名称(可修改)*/
	@Column(name="confirm_name",nullable=false,length=200)
	@Size(min=1,max=200)
	private String confirmName;
	
	/*图片路径(相对)*/
	@Column(name="pic_path",nullable=false,length=500)
	@Size(min=1,max=500)
	private String picPath;
	
	/*图片格式*/
	@Column(name="suffix",nullable=false,length=100)
	@Size(min=1,max=100)
	private String suffix;
	
	/*图片描述*/
	@Column(name="description",length=1000)
	@Size(min=0,max=1000)
	private String description;

	/*
	 * 图片类型
	 * 产品:product
	 */
	@Column(name="type",nullable=false,length=100)
	@Size(min=0,max=100)
	private String type;
	
	/*关联id*/
	@Column(name="business_id",nullable=false)
	private Long businessId;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getConfirmName() {
		return confirmName;
	}

	public void setConfirmName(String confirmName) {
		this.confirmName = confirmName;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
