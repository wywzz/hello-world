package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.common.vo.PageObject;
import com.cy.pj.common.ServiceException;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysLogService;

@Service
public class SysMenuServiceImpl  implements SysLogService{
@Autowired
private SysMenuDao sysMenuDao;
@Autowired 
private SysRoleMenuDao SysRoleMenuDao;
 @Override
 public int saveObject(SysMenu entity) {
	 if(entity==null)throw new IllegalArgumentException("保存对象不能为空");
	 if(StringUtils.isEmpty(entity.getName()))throw new IllegalArgumentException("菜单不能为空");
	 int rows=sysMenuDao.insertObject(entity);
	 return 0;
 }
@Override
public int deleteObject(Integer id) {
	if(id==null||id<1)
		throw new IllegalArgumentException("id值无效");
	int childCount=( (com.cy.pj.sys.dao.SysRoleMenuDao) sysMenuDao).getChildCount(id);
	if(childCount>0)
		throw new ServiceException("请先删除子菜单");
	SysRoleMenuDao.deleteObjectsByMenuId(id);
	int rows=((com.cy.pj.sys.dao.SysRoleMenuDao) sysMenuDao).deleteObjectsByRoleId(id);
	if(rows==0)
		throw new ServiceException("记录可能已经不存在");
	return rows;
}
@Override
public List<Map<String, Object>> findObjects(){
	List<Map<String, Object>>list =
			sysMenuDao.findObjects();
	if(list==null||list.size()==0)throw new ServiceException("没有对应的菜单信息");
		return list;
}
@Override
public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public int deleteObjects(Integer... ids) {
	// TODO Auto-generated method stub
	return 0;
}

}
