package com.sharkpay.myspace.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sharkpay.myspace.entities.Post;

public class PostDTO {
	
	private String id;
	private LocalDate moment;
	private String title;
	private String content;
	private Integer likes;
	private String authorName;
	private List<CommentDTO> comments = new ArrayList<>();
	
	public PostDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getMoment() {
		return moment;
	}

	public void setMoment(LocalDate moment) {
		this.moment = moment;
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

	public List<CommentDTO> getComments() {
		return comments;
	}

	public static PostDTO convertToDTO(Post post) {
		PostDTO postDTO = new PostDTO();
		postDTO.setAuthorName(post.getAuthor().getName());
		postDTO.setContent(post.getContent());
		postDTO.setId(post.getId());
		postDTO.setLikes(post.getLikes());
		postDTO.setMoment(post.getMoment());
		postDTO.setTitle(post.getTitle());
		post.getComments().forEach(comment -> postDTO.getComments().add(CommentDTO.convertToDTO(comment)));
		return postDTO;
	}

}
