package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.common.vo.SysUserDeptVo;

@Mapper
public interface SysUserDao {
	int getRowCount(@Param("username") String username);
	List<SysUserDeptVo> findPageObjects(@Param("username") String username,@Param("startIndex") Integer startIndex,@Param("pageSize") Integer pageSize);
	int doValidById(@Param("id") Integer id,@Param("valid") Integer valid,@Param("modifiedUser")String modifiedUser);
}
