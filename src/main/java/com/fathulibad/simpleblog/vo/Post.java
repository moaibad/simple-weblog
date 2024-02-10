package com.fathulibad.simpleblog.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Post {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "\"user\"")
	private String user;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "reg_date")
	private Date reg_date;
	
	@Column(name = "updt_date")
	private Date updt_date;
	
	public Post() {
		
	}
	
	public Post(Long id, String user, String title, String content) {
		super();
		this.id = id;
		this.user = user;
		this.title = title;
		this.content = content;
		this.reg_date = new Date();
		this.updt_date = new Date();
	}
	
	public Post(String user, String title, String content) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.reg_date = new Date();
		this.updt_date = new Date();
	}
	
	public Post(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.updt_date = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return reg_date;
	}

	public void setRegDate(Date regDate) {
		this.reg_date = regDate;
	}

	public Date getUpdtDate() {
		return updt_date;
	}

	public void setUpdtDate(Date updtDate) {
		this.updt_date = updtDate;
	}
	
	
}
