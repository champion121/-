package com.tledu.zrz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class InitDateController {
	/**
	 * 请求的时候,如果有传递参数,就会执行这个方法
	 * 并且是在执行请求方法之前,先执行 @InitBinder 对应的方法
	 * 并且 传递一个参数,就执行一次这个方法
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
