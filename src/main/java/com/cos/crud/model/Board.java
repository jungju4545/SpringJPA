package com.cos.crud.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	@ManyToOne
//@JsonManagedReference : 정방향 매핑시 파싱됨
//	@JsonIgnoreProperties({"boards"})
	@JoinColumn(name = "userId") // 실제 테이블에 들어갈 컬럼
	private User user;
	@CreationTimestamp //
	private Timestamp createDate;

	// 이건 더미데이터를 만들려고 만듬
	public Board(String title, String content, User user) {
		this.title = title;
		this.content = content;
		this.user = user;
	}

}
