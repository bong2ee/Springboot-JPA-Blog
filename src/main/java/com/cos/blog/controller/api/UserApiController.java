package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { // json-RequestBody / username, passwor, email만 받음--> role은 넣어줘야 함
		System.out.println("UserApiController : save 호출됨");
		userService.회원가입(user); 
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
/*	
 *	@PostMapping("/api/user/login")
 *  public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) { // json-RequestBody / username, passwor, email만 받음--> role은 넣어줘야 함
 *		System.out.println("UserApiController : login 호출됨");
 *	 	User principal = userService.로그인(user); // principal (접근주체)
 *		if(principal != null) {
 *			session.setAttribute("principal", principal);
 *		}
 *		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
 *	}
 */
}
