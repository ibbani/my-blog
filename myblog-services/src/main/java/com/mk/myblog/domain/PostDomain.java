package com.mk.myblog.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MB_POSTS")
public class PostDomain extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POST_ID")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "CATEGORY_ID")
	private CategoryDomain category;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "TAGS")
	private String tags;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LIKES")
	private Integer likes;

	@OneToMany
	private List<PostCommentDomain> comments;

	public PostDomain() {
	}

	public PostDomain(CategoryDomain category, String tags, String description, Integer likes) {
		super();
		this.category = category;
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

	public CategoryDomain getCategory() {
		return category;
	}

	public void setCategory(CategoryDomain category) {
		this.category = category;
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

	public List<PostCommentDomain> getComments() {
		return comments;
	}

	public void setComments(List<PostCommentDomain> comments) {
		this.comments = comments;
	}

}
