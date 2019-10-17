package com.cy.pj.sys.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.vo.PageObject;
import com.cy.pj.common.ServiceException;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService {
	//@Autowired
	private SysRoleDao sysRoleDao;
	//@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	//@Autowired
	@Autowired

	@Override
	public int deleteObject(Integer id) {
		//1.参数校验
		if(id==null||id<1)
			throw new IllegalArgumentException("id值无效");
		//2.删除关系数据
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		//3.删除自身信息
		int rows=sysRoleDao.deleteObject(id);
		//4.返回结果
		return rows;
	}
	
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		//1.对参数进行有效性验证
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("页码值无效"); 
		//2.查询记录总数并验证
		int rowCount=sysRoleDao.getRowCount(name);
		if(rowCount==0)
			throw new ServiceException("没有对应的记录");
		//3.查询当前页记录
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> records=
		sysRoleDao.findPageObjects(name, startIndex, pageSize);
		//4.封装结果并返回.
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

}
