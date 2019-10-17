package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService{
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Override
	public List<Map<String, Object>> findObjects(){
		List<Map<String, Object>> list = sysMenuDao.findObjects();
		if(list==null||list.size()==0) {
			throw new ServiceException("没有找到对应记录");
		}
		return list;
	}
	@Override
	public int deleteObject(Integer id) {
		if(id==null||id<1)
			throw new IllegalArgumentException("参数不对");
		int child = sysRoleMenuDao.getChildCount(id);
		if(child>0)
			throw new ServiceException("请先删除子菜单");
		sysRoleMenuDao.deleteObjectByMenuId(id);
		int rows = sysMenuDao.deleteObject(id);
		if(rows==0)
			throw new ServiceException("你选择的记录可能不存在");
		return rows;
	}
	@Override
	public List<Node> findZtreemenuNodes() {
		List<Node> list = sysMenuDao.findZtreemenuNodes();
		return list;
	}
	@Override
	public int saveObject(SysMenu entity) {
		if(entity==null)
			throw new IllegalArgumentException("参数不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("姓名不能为空");
		int rows = sysMenuDao.insertObject(entity);
		return rows;
	}
	@Override
	public int updateObject(SysMenu entity) {
		if(entity==null)
			throw new IllegalArgumentException("参数不能为空");
		if(StringUtils.isEmpty(entity.getName()))
				throw new IllegalArgumentException("参数不能为空");
		int rows = sysMenuDao.updateObject(entity);
		return rows;
	}
}

