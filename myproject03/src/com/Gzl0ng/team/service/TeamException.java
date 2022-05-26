package com.Gzl0ng.team.service;
/**
 * 
* @Description 自定义异常类
* @author Gzl0ng Email:1329087835@qq.com
* @version
* @date 2021年5月13日下午3:31:51
*
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -33875169929948L;
    
    public TeamException(){
    	super();
    }
    
    public TeamException(String msg){
    	super(msg);
    }
}
