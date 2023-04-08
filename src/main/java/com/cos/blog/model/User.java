package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴 !!
// ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity //User 클래스가 MySQL에 테이블로 생성된다
//@DynamicInsert // insert 할 때 null인 필드 제외
public class User {

	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 30, unique = true) // null X, 길이 30자 제한, 중복 X 
	private String username; //아이디 
	
	@Column(nullable = false, length = 100) // null X, 123456 -> 해쉬(비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50) // null X, 길이 50자 제한
	private String email;
	
	//@ColumnDefault("'user'")
	//DB는 RoleType이라는 게 없다
	@Enumerated(EnumType.STRING)
	private RoleType roll; // Enum을 쓰는게 좋다 // admin, user, manager
	   
	@CreationTimestamp // 시간이 자동으로 입력
	private Timestamp createDate;
	
}
