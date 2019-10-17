package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysRoleMenuDao {
	@Delete("delete from sys_role_menus where menu_id=#{menuId}")
	int deleteObjectByMenuId(Integer menuId);
	@Select("select count(*) from sys_menus where parentId=#{id}")
	int getChildCount(Integer id);
	@Delete("delete from sys_role_menus where role_id=#{roleId}")
	int deleteObjectsByRoleId(Integer roleId);
	int insertObjects(@Param("menuIds") Integer[] menuIds,@Param("roleId") Integer roleId);
	int updateObjects(@Param("menuIds") Integer[] menuIds,@Param("roleId") Integer roleId);
}
