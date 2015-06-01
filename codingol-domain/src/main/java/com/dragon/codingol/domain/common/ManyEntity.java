package com.dragon.codingol.domain.common;

import com.dragon.codingol.domain.admin.FieldsEntity;
import com.dragon.codingol.domain.admin.TableEntity;


/**
 * 多对多controller 实体参数。
 * @author deng
 *
 */
public class ManyEntity {
	
	private String id;
	private TableEntity table;
	private TableEntity	middle;
	private FieldsEntity fcolumn;
	private FieldsEntity ocolumn;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TableEntity getTable() {
		return table;
	}
	public void setTable(TableEntity table) {
		this.table = table;
	}
	public TableEntity getMiddle() {
		return middle;
	}
	public void setMiddle(TableEntity middle) {
		this.middle = middle;
	}
	public FieldsEntity getFcolumn() {
		return fcolumn;
	}
	public void setFcolumn(FieldsEntity fcolumn) {
		this.fcolumn = fcolumn;
	}
	public FieldsEntity getOcolumn() {
		return ocolumn;
	}
	public void setOcolumn(FieldsEntity ocolumn) {
		this.ocolumn = ocolumn;
	}
	
}
