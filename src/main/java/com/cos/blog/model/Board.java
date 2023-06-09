package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴!!
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@Column(nullable = false, length = 100) // null X, 길이 100자 제한
	private String title;
	
	@Lob // 대용량 데이터
	private String content; // 섬머노트 라이브러리 <html> 태그가 섞여서 디자인 됨
	
	@ColumnDefault("0")
	private int count; // 조회수
	
	@ManyToOne(fetch = FetchType.EAGER) // 한 명의 유저는 여러 개의 게시글을 가질 수 있다
	@JoinColumn(name = "userId")
	private User user; // DB는 오브젝트를 저장할 수 없다. FK, Java는 오브젝트를 저장할 수 있다
	
	// mappedBy 연관관계의 주인X , 컬럼을 만들지 마세요 (FK가 아니에요)
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // reply 테이블에 있는 board
	private List<Reply> reply; // 하나의 게시글은 여러개의 댓글을 가질 수 있다
	
	@CreationTimestamp //시간 자동 입력
	private Timestamp createDate;

}
