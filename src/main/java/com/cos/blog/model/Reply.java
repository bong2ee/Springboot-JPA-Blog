package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴 !!
@Entity
public class Reply {

	@Id //Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 200) // null X, 길이 200자 제한
	private String content; 
	
	@ManyToOne // 하나의 게시글은 여러 개의 댓글을 가질 수 있다
	@JoinColumn(name = "boardId")
	private Board board;
	
	@ManyToOne // 한 명의 유저는 여러 개의 댓글을 가질 수 있다.
	@JoinColumn(name = "userId")
	private User user;
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;
}
