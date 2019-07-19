package com.tledu.zrz.model;

/**
 * 1 继承一个已有的异常类
 * 2 无参构造
 * 3 有参构造
 */
public class UserException extends Exception {
	public UserException(){
		
	}
	public UserException(String message){
		super(message);
	}
}
