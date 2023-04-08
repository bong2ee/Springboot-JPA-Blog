package com.cos.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // 어디에서든 exception이 발생하면 이쪽에서 처리
@RestController
public class GlobalExceptionHandler {

//	@ExceptionHandler(value=IllegalArgumentException.class) // IllegalArgumentException만 처리
//	public String handleArgumentException(IllegalArgumentException e) {
//		return "<h1>"+e.getMessage()+"</h1>";
//	}
	
	@ExceptionHandler(value=Exception.class) // 모든 Exception 처리
	public String handleArgumentException(Exception e) {
		return "<h1>"+e.getMessage()+"</h1>";
	}
}
