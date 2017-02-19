package com.amu.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.amu.dao.custom.BrandDaoCustom;
import com.amu.domain.Brand;

public class BrandDaoImpl implements BrandDaoCustom{

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * 自定义保存Brand方法(识别:如果字段为空的话则不更新该字段)
	 * @author huangsongbo
	 */
	public int updateCustom(Brand brand) {
		if(brand.getId() == null)
			return 0;
		// 识别是否所有参数都为空->如果都为空,则不执行hql
		boolean flag = false;
		/*String hql = "update Brand b set b.name = :name,b.description = :description where b.id = :id";*/
		// 组装hql->start
		StringBuffer hql = new StringBuffer("update Brand b set ");
		if(brand.getName() != null){
			flag = true;
			hql.append("b.name = :name,");
		}
		if(brand.getDescription() != null){
			flag = true;
			hql.append("b.description = :description,");
		}
		if(brand.getModifyTime() != null){
			flag = true;
			hql.append("b.modifyTime = :modifyTime,");
		}
		// 组装hql->end
		if(!flag)
			return 0;
		hql.deleteCharAt(hql.length() - 1).append(" where b.id = :id");
		Query query = entityManager.createQuery(hql.toString());
		// hql传入参数->start
		if(brand.getName() != null){
			query.setParameter("name", brand.getName());
		}
		if(brand.getDescription() != null){
			query.setParameter("description", brand.getDescription());
		}
		if(brand.getModifyTime() != null){
			query.setParameter("modifyTime", brand.getModifyTime());
		}
		query.setParameter("id", brand.getId());
		// hql传入参数->end
		return query.executeUpdate();
	}

}
