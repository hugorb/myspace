package com.sharkpay.myspace.dto;

import java.time.LocalDate;

import com.sharkpay.myspace.entities.Comment;

public class CommentDTO {
	
	private String text;
	private LocalDate moment;
	private Integer likes;
	private String authorName;
	
	public CommentDTO() {
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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public static CommentDTO convertToDTO(Comment comment) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setLikes(comment.getLikes());
		commentDTO.setMoment(comment.getMoment());
		commentDTO.setText(comment.getText());
		commentDTO.setAuthorName(comment.getAuthor().getName());
		return commentDTO;
	}

}
