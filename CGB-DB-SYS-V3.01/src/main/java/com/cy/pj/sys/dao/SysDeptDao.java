package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.entity.SysDept;
@Mapper
public interface SysDeptDao {
	 List<SysDept> findById(Integer id);
}
