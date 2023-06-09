package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML 파일) 
// @Controller

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest";

	@GetMapping("/http/lombok")
	public String lombokTest() {
		//Member m = new Member(1, "ssar", "1234", "email");
		Member m = Member.builder().username("ssar").password("1234").email("email@nate.com").build(); //선택적 인자를 받음
		System.out.println(TAG + "getter : " + m.getId());
		m.setId(5000);
		System.out.println(TAG + "setter : " + m.getId());	
		return "lombokTest 완료";
	}

	//인터넷 브라우저 요청은 무조건 get요청 밖에 할 수 없다
	//http://localhost:8080/http/get (select) & @RequestParam int id, @RequestParam String username
	@GetMapping("/http/get")
	public String getTest(Member m) { //id=1&username=ssar&password=1234&email=ssar@nate.com
		return "get 요청 : " +m.getId()+ ", "+ m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}

	//http://localhost:8080/http/post (insert) 
	//public String postTest(Member m) -> x-www-form-urlencoded
	// raw -> text/plain(@RequestBody String text)
	@PostMapping("/http/post") //-> application/json
	public String postTest(@RequestBody Member m) { // MessageConverter(스프링부트)
		return "post 요청 : " +m.getId()+ ", "+ m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}

// JSON 
// {
//		"id" : 1,
//		"username" : "ssar",
//		"password" : 123456,
//		"email" : "ssar@nate.com"
//	}

	//http://localhost:8080/http/put (update)
	@PutMapping("/http/put")	
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " +m.getId()+ ", "+ m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
// JSON 
// {
//			"id" : 1,
//			"password" : 5555,
// }
	
	//http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
