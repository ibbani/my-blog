package com.mk.myblog.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MB_POST_COMMENTS")
public class PostCommentDomain extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMMENT_ID")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "POST_ID")
	private PostDomain post;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "TAGS")
	private String tags;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LIKES")
	private Integer likes;

	public PostCommentDomain() {
	}

	public PostCommentDomain(PostDomain post, String title, String tags, String description, Integer likes) {
		super();
		this.post = post;
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

	public PostDomain getPost() {
		return post;
	}

	public void setPost(PostDomain post) {
		this.post = post;
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
