package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
/**
 * @Mapper注解一般用于描述数据层接口对象
 * 表示此接口对象的实现类由系统底层自动创建,并且会在此接口实现类中注入
 * SQLSessionFactory对象
 * @author Administrator
 *
 */
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;
@Mapper
public interface SysMenuDao {
	int insertObject(SysMenu entity);
	List<Node> findZtreeMenuNodes();
	@Select("select count(*) from sys_menus where parentId=#{id}")
	int getChildCount(Integer id);
	List<Map<String, Object>> findObjects();
}
