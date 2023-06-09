 package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것

@Configuration // IoC
public class SecurityConfig {
	
	@Bean //IoC
	BCryptPasswordEncoder encode() { //encode 함수 호출 -> BCryptPasswordEncoder 객체 리턴 
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable() //csrf 토큰 비활성화
				.authorizeRequests()
				.antMatchers("/", "/auth/**", "/js/**" , "/css/**", "/image/**")//이쪽 경로로 요청이 들어오면 누구나 허용
				.permitAll()
				.anyRequest()
				.authenticated()//다른 요청은 인증이 필요
				.and()
				.formLogin()
				.loginPage("/auth/loginForm");
		return http.build();
	}

}

