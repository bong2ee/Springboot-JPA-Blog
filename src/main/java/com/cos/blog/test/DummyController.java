package com.cos.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

// html 파일이 아니라 data를 리턴해주는 controller = RestController
@RestController
public class DummyController {

	// http://localhost:8000/blog/dummy/join (요청)
	// http의 body에 username, password, email 데이터를 가지고 (요청)
	// @RequestParam("username") String u 안해도 됨 -> 변수명을 정확히
	//	@PostMapping("/dummy/join")
	//	public String join(String username, String password, String email) { // key-value
	//		System.out.println("username : " + username);
	//		System.out.println("password : " + password);
	//		System.out.println("email : " + email);
	//		return "회원가입이 완료되었습니다.";
	//	}
	
	@Autowired // 의존성 주입(DI)
	private UserRepository userRepository;
	
	// {id} 주소로 파라미터를 전달 받을 수 있음
	// http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")            // findById => 데이터베이스에서 값을 찾지 못하면 null을 리턴함 => 프로그램 문제
	public User detail(@PathVariable int id) {  // 데이터를 Optional로 감싸서 가져옴 => null인지 아닌지 판단해서 사용해야함
		//User user = userRepository.findById(id).get(); -> 바로 가져옴 null 위험
		//User user = userRepository.findById(id).orElseGet(new Supplier<User>() { 
		//			@Override
		//			public User get() {									  -> 값이 있으면 가져옴, 없으면 빈 객체 생성해서 리턴
		//				// Supplier -> get 오버라이딩
		//				return new User();
		//			}
		//	}); 
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalStateException>() {
			@Override
			public IllegalStateException get() {
				// TODO Auto-generated method stub
				return new IllegalStateException("해당 유저는 없습니다. id : " + id);
			}
		}); 						
		// 요청 : 웹브라우저
		// user 객체 : 자바 오브젝트
		// 변환 (웹브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)
		// 스프링부트 = MessageConverter가 응답시에 자동 작동
		// 만약에 자바 오브젝트 리턴을 하게 되면 Jackson 라이브러리를 호출해서 
		// user 오브젝트를 json으로 변환해서 브라우저에게 던져줌
		return user;											 
	}
	
	@PostMapping("/dummy/join")
	public String join(User user) { // key-value
		System.out.println("username : " + user.getId()); // 0
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("username : " + user.getRoll()); // null
		System.out.println("username : " + user.getCreateDate()); // null
		
		user.setRoll(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
}