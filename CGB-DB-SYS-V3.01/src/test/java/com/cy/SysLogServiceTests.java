package com.cy;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogServiceTests {
	@Autowired
	private SysUserDao sysUserDao;
	@Test
	public void findPageObjects() {
		List<SysUserDeptVo> findPageObjects = sysUserDao.findPageObjects(null, 0, 2);
		System.out.println(findPageObjects);
	}
	
}
