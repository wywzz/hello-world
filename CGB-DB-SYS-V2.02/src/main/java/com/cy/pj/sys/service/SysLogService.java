package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.entity.SysMenu;

public interface SysLogService {
PageObject<SysLog>findPageObjects(
		String username,
		Integer pageCurrent);

int deleteObjects(Integer... ids);

List<Map<String, Object>> findObjects();

int deleteObject(Integer id);

int saveObject(SysMenu entity);


}