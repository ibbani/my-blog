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
@Table(name = "MB_USER_ROLE")
public class UserRoleDomain extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ROLE_ID")
	private Integer id;

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private UserDomain user;

	@OneToOne
	@JoinColumn(name = "ROLE_ID")
	private RoleDomain role;

	public UserRoleDomain() {
	}

	public UserRoleDomain(UserDomain user, RoleDomain role) {
		super();
		this.user = user;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDomain getUser() {
		return user;
	}

	public void setUser(UserDomain user) {
		this.user = user;
	}

	public RoleDomain getRole() {
		return role;
	}

	public void setRole(RoleDomain role) {
		this.role = role;
	}

}
