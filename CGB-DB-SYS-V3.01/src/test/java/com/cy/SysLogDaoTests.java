package com.cy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogDaoTests {
	@Autowired
	private SysLogDao sysLogDao;

	@Test
	public void testGetRowount() {
		int rowCount = sysLogDao.getRowCount("admin");
		System.out.println("row="+rowCount);
	}
	@Test
	public void testFindPageObject() {
		List<SysLog> findPageObjects = sysLogDao.findPageObjects("admin", 0, 3);
		for (SysLog sysLog : findPageObjects) {
			System.out.println(sysLog);
		}
	}
	@Test
	public void testDeleteObject() {
		int rows = sysLogDao.deleteObjects(1);
		System.out.println("rows="+rows);
	}

}
