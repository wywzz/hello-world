package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;

public interface SysUserService {
	PageObject<SysUserDeptVo> findPageObjects(String username,Integer pageCurrent);
	int doValidById(Integer id,Integer valid,String modifiedUser);
}
