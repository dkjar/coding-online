package com.dragon.codingol.common;

import java.util.List;
 
public class Highchart  {
	private String name; // x轴下方统计项目
	private String type;// 统计类型 柱形 还是 曲线
	private List data;// 数据

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
