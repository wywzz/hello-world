package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;

@Mapper
public interface SysRoleDao {
	int getRowCount(@Param("name") String name);
	List<SysRole> findPageObjects(@Param("name") String name,@Param("startIndex") Integer startIndex,@Param("pageSize") Integer pageSize);
	
	@Delete("delete from sys_roles where id=#{id}")
	int deleteObjectById(Integer id);
	
	SysRoleMenuVo findObjectById(Integer id);
	
	int insertObject(SysRole sysRole);
	int updateObject(SysRole sysRole);
}
