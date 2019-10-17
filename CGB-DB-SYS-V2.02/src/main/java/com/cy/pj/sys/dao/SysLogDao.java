package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.entity.SysLog;

@Mapper
public interface SysLogDao {
	/**
	 * 基于条件统计记录总数
	 * @return 具体行数
	 * @Param 注解可以描述数据层参数,尤其是当方法有
	 * 多个参数或者参数可能会用在动态sql中
	 * */
	int deleteObjects(@Param("ids") Integer... ids);
	int getRowCount(@Param("username") String username);
	
/**
 * 查询当前页记录
 * @param username 查询条件,允许为空
 * @param startIndex 表示起始位置
 * @param pageSize 页面大小
 * @return 当前页记录
 * */
	List<SysLog>findPageObjects(
		@Param("username")String username,
		@Param("startIndex")Integer startIndex,
		@Param("pageSize")Integer pageSize);
}
