package com.amu.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.amu.dao.custom.BrandDaoCustom;
import com.amu.domain.Brand;

public interface BrandDao extends JpaRepository<Brand, Long> , BrandDaoCustom{

	@Modifying
	@Query("update Brand b set b.name = :name,b.description = :description,b.modifyTime=:modifyTime where b.id = :id")
	int update(@Param("id") Long id,@Param("name") String name,@Param("description") String description,@Param("modifyTime") Date modifyTime);

}