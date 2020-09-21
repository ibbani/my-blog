package com.mk.myblog.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostComment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer postId;
	private String title;
	private String tags;
	private String description;
	private Integer likes;

	public PostComment() {
	}

	public PostComment(Integer id, Integer postId, String title, String tags, String description, Integer likes) {
		super();
		this.id = id;
		this.postId = postId;
		this.title = title;
		this.tags = tags;
		this.description = description;
		this.likes = likes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

}
