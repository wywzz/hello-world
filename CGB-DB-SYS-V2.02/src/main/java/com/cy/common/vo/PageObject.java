package com.cy.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class PageObject<T> implements Serializable {

	private static final long serialVersionUID = 7160293007556675158L;
	private Integer pageCurrent=1;
	private Integer pageSize=3;
	private Integer rowCount=0;
	private Integer pageCount=0;
	private List<T> records;
	public PageObject() {}
	public PageObject(Integer pageCurrent,Integer pageSize,Integer
			rowCount,List<T> records) {
		super();
		this.pageCurrent=pageCurrent;
		this.pageSize=pageSize;
		this.rowCount=rowCount;
		this.records=records;
		this.pageCount=(rowCount-1)/pageSize+1;
	}
	
}
