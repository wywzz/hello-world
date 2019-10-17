package com.cy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * 单元测试类
 * @SpringBootTest 注解表示此类交给spring框架管理
 * @RubWith 注解用于指定测试类中的方法由谁进行调用 
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CgbSboot01ApplicationTests {
	@Autowired
	private ApplicationContext ctx;
	@Test
	public void contextLoads() {
		System.out.println(ctx);
	}

}
