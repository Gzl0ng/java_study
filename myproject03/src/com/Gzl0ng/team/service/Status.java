package com.Gzl0ng.team.service;
/**
 * 
* @Description 表示员工的状态
* @author Gzl0ng Email:1329087835@qq.com
* @version
* @date 2021年5月13日下午2:05:27
*
 */
//public class Status {
//	private final String NAME;
//	private Status(String name){
//		this.NAME = name;
//	}
//
//	public static final Status FREE = new Status("FREE");
//	public static final Status BUSY = new Status("BUSY");
//	public static final Status VOCATION = new Status("VOCATION");
//	public String getNAME() {
//		return NAME;
//	}
//
//	@Override
//	public String toString() {
//		return NAME;
//	}
//}

public enum Status{
	FREE,BUSY,VOCATION;
}
