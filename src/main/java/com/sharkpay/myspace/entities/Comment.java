package com.sharkpay.myspace.entities;

import java.time.LocalDate;

public class Comment {
	
	private String text;
	private LocalDate moment;
	private Integer likes;
	private User author;
	
	public Comment(String text, LocalDate moment, Integer likes, User author) {
		this.text = text;
		this.moment = moment;
		this.likes = likes;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getMoment() {
		return moment;
	}

	public void setMoment(LocalDate moment) {
		this.moment = moment;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
}
