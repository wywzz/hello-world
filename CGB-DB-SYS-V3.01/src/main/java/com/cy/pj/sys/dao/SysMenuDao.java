package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;

@Mapper
public interface SysMenuDao {
	/**
	 * 许多优秀的产品不推荐使用map因为可读性比较差
	 * 它的值的类型不可控
	 * 但是有时为了提高开发的速度,map可以直接为映射存储对象,尤其一些外包
	 * */
	@Select("select id,name,parentId from sys_menus")
	List<Node> findZtreemenuNodes();
	
	List<Map<String,Object>> findObjects();
	@Delete("delete from sys_menus where id=#{id}")
	int deleteObject(Integer id);
	
	int insertObject(SysMenu entity);
	int updateObject(SysMenu entity);
}
