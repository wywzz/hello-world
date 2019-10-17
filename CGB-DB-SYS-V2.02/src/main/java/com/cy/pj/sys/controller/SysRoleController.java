package com.cy.pj.sys.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.SysRoleService;
@RestController
@RequestMapping("/role/")
public class SysRoleController {
     @Autowired //has a
	 private SysRoleService sysRoleService;
     
     @RequestMapping("doDeleteObject")
     public JsonResult doDeleteObject(Integer id) {
    	 sysRoleService.deleteObject(id);
    	 return new JsonResult("delete ok");
     }
     @RequestMapping("doFindPageObjects")
     public JsonResult doFindPageObjects(
    		 String name,Integer pageCurrent) {
    	 System.out.println("doFindPageObjects()");
    	 return new JsonResult(
    	 sysRoleService.findPageObjects(name, pageCurrent));
     }
}
