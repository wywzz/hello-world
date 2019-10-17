package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.service.SysUserService;

import lombok.val;
@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysUserDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUserDeptVo> records = sysUserDao.findPageObjects(username, startIndex, pageSize);
		int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0) {
			pageCount++;
		}
		return new PageObject<>(pageCurrent, pageSize, rowCount, pageCount, records);
	}
	@Override
	public int doValidById(Integer id, Integer valid,String modifiedUser) {
		if(id==null||id<1)
			throw new IllegalArgumentException("id");
			if(valid==null||valid!=1&&valid!=0)
				throw new IllegalArgumentException("状态不对");
			int rows=sysUserDao.doValidById(id, valid,modifiedUser);
		if(rows==0)
			throw new ServiceException("查找记录不存在");
			return rows;
	}
}
