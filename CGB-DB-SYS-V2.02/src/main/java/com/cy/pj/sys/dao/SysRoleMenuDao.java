package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * 此Dao对象负责操作sys_role_menus中间表数据
 */
@Mapper
public interface SysRoleMenuDao {
     /**
            * 基于角色id删除菜单和角色的关系数据
      * @param menuId
      * @return
      */
	 @Delete("delete from sys_role_menus where role_id=#{roleId}")
	 int deleteObjectsByRoleId(Integer roleId);
	 /**
	  * 基于菜单id删除菜单和角色的关系数据
	  * @param menuId
	  * @return
	  */
	 @Delete("delete from sys_role_menus where menu_id=#{menuId}")
	 int deleteObjectsByMenuId(Integer menuId);
	int getChildCount(Integer id);
}






