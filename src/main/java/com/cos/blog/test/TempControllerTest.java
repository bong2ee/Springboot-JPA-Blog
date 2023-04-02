package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //-> 파일을 리턴
public class TempControllerTest {

	//http://localhost8000/blog/temp/home
	@GetMapping("/temp/home")
	public String TempHome() {
		System.out.println("TempHome()");
		// 파일 리턴 기본경로 : src/main/resources/static
		// 리턴명 : /home.html
		// 풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String TempImg() {
		return "/a.png";
	}
	
	@GetMapping("/temp/jsp")
	public String TempJsp() {
	    // prefix: /WEB-INF/views/
        // suffix: .jsp
		// 풀경로 : /WEB-INF/views/test.jsp
		return "test";
	}
}
