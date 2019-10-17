package com.cy.pj.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Node implements Serializable{
	private static final long serialVersionUID = 2222849709976580709L;
	/**
	 * 节点id
	 */
	private Integer id;
	/**
	 * 节点名称
	 */
	private String name;
	/**
	 * 上个节点ID
	 * 
	 */
	private Integer parentId;
}
