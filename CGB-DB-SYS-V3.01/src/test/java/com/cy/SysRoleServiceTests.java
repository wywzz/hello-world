package com.cy;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import com.cy.pj.sys.service.SysUserService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleServiceTests {
	@Autowired
	private SysUserService sysUserService;
	@Test
	public void findPageObjects() {
		PageObject<SysUserDeptVo> findPageObjects = sysUserService.findPageObjects(null, 1);
		System.out.println(findPageObjects);
	}
	
}
