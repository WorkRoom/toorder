package com.zykj.toorder.model;

import java.io.Serializable;

public class SortModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;   //姓名
	private String sortLetters;  //首字母
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSortLetters() {
		return sortLetters;
	}
	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}
}
