package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.common.vo.PageObject;
import com.cy.pj.common.ServiceException;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysLogService;
@Service
public class SysLogServiceImpl implements SysLogService{
@Autowired
	private SysLogDao SysLogDao;
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("page.argument.illegal");
		int rowCount = SysLogDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		int pageSize=4;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysLog> records=
		SysLogDao.findPageObjects(username, startIndex, pageSize);
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

	@Override
	public int deleteObjects(Integer...ids) {
			//1.判定参数合法性
			if(ids==null||ids.length==0)
		    throw new IllegalArgumentException("请选择一个");
			//2.执行删除操作
			int rows;
			try{
			rows=SysLogDao.deleteObjects(ids);
			}catch(Throwable e){
			e.printStackTrace();
			//发出报警信息(例如给运维人员发短信)
			throw new ServiceException("系统故障，正在恢复中...");
			}
			//4.对结果进行验证
			if(rows==0)
			throw new ServiceException("记录可能已经不存在");
			//5.返回结果
			return rows;
	}

	@Override
	public List<Map<String, Object>> findObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteObject(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveObject(SysMenu entity) {
		// TODO Auto-generated method stub
		return 0;
	}
}

