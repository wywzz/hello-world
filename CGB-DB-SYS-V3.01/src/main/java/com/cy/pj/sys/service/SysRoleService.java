package com.cy.pj.sys.service;

import java.util.List;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;

public interface SysRoleService {
	 PageObject<SysRole> findPageObjects(
			 String name,
			 Integer pageCurrent);
	 int deleteObjectById(Integer id);
	 SysRoleMenuVo findObjectById(Integer id);
	 int insertObject(SysRole sysRole,Integer[] menuIds);
	 int updateObject(SysRole sysRole,Integer[] menuIds);
}
