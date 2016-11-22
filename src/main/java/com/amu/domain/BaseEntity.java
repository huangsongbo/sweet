package com.amu.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 基础entity
 * @author huangsongbo
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = -6348727948274803697L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="create_time",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+08:00")
	private Date createTime;
	
	@Column(name="modify_time",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+08:00")
	private Date modifyTime;
	
	@Column(name="creator_id",nullable=false)
	private Long creatorId;
	
	@Column(name="modifier_id",nullable=false)
	private Long modifierId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}
	
}
