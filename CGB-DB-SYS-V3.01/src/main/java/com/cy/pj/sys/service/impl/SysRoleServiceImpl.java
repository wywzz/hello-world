package com.cy.pj.sys.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import com.cy.pj.sys.vo.SysRoleMenuVo;
@Service
public class SysRoleServiceImpl implements SysRoleService{
	private SysRoleDao sysRoleDao;
	private SysRoleMenuDao sysRoleMenuDao;
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	public SysRoleServiceImpl(SysRoleDao sysRoleDao, SysRoleMenuDao sysRoleMenuDao, SysUserRoleDao sysUserRoleDao) {
		super();
		this.sysRoleDao = sysRoleDao;
		this.sysRoleMenuDao = sysRoleMenuDao;
		this.sysUserRoleDao = sysUserRoleDao;
	}
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		if(pageCurrent==null || pageCurrent<1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysRoleDao.getRowCount(name);
		if(rowCount==0)
			throw new ServiceException("你要的查询的东西可能不存在");
		int pageSize=3;
		int pageCount =rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}
		if(pageCurrent>pageCurrent)
			throw new IllegalArgumentException("当前页码不正确");

		List<SysRole> records = sysRoleDao.findPageObjects(name,(pageCurrent-1)*pageSize, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount,pageCount,records);
	}
	@Override
	public int deleteObjectById(Integer id) {
		if(id==null || id<1)
			throw new IllegalArgumentException("id参数无效");
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		sysUserRoleDao.deleteObjectsByRoleId(id);
		int rows = sysRoleDao.deleteObjectById(id);
		return rows;
	}
	@Override
	public SysRoleMenuVo findObjectById(Integer id) {
		if(id==null || id<1)
			throw new IllegalArgumentException("id参数无效");
		SysRoleMenuVo sysRoleMenuVo = sysRoleDao.findObjectById(id);
		if(sysRoleMenuVo==null)
			throw new IllegalArgumentException("你查找的记录可能不存在");
		return sysRoleMenuVo;
	}
	@Override
	public int insertObject(SysRole sysRole, Integer[] menuIds) {
		if(sysRole==null)
			throw new IllegalArgumentException("保存数据不能为空");
		if(StringUtils.isEmpty(sysRole.getName()))
			throw new IllegalArgumentException("角色名不能为空");
		if(menuIds==null||menuIds.length==0) {
			throw new IllegalArgumentException("权限不能为空");
		}
		int rows =sysRoleDao.insertObject(sysRole);
		sysRoleMenuDao.insertObjects(menuIds, sysRole.getId());
		return rows;
	}
	@Override
	public int updateObject(SysRole sysRole,Integer[] menuIds) {
		if(sysRole==null)
			throw new IllegalArgumentException("保存数据不能为空");
		if(StringUtils.isEmpty(sysRole.getName()))
			throw new IllegalArgumentException("角色名不能为空");
		if(menuIds==null||menuIds.length==0) {
			throw new IllegalArgumentException("权限不能为空");
		}
		
		sysRoleMenuDao.deleteObjectsByRoleId(sysRole.getId());
		sysRoleDao.deleteObjectById(sysRole.getId());
		int rows =sysRoleDao.insertObject(sysRole);
		sysRoleMenuDao.insertObjects(menuIds, sysRole.getId());
		return rows;
	}
}
