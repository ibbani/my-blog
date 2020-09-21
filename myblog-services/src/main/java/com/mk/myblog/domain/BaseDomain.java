package com.mk.myblog.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDomain {

	@Column(name = "CREATED_DATE", insertable = true, updatable = false)
	public Date createdDate;

	@Column(name = "CREATED_BY", insertable = true, updatable = false)
	public String createdBy;

	@Column(name = "UPDATED_DATE", insertable = true, updatable = true)
	public Date updatedDate;

	@Column(name = "UPDATED_BY", insertable = true, updatable = true)
	public String updatedBy;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
