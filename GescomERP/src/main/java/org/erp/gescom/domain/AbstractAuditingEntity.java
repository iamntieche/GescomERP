package org.erp.gescom.domain;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

public  abstract class AbstractAuditingEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@CreatedBy
	@Field("create_by")
	@JsonIgnore
	private String createdBy;
	
	@CreatedDate
	@Field("create_date")
	@JsonIgnore
	private Instant createdDate = Instant.now();
	
	@CreatedBy
	@Field("last_modified_by")
	@JsonIgnore
	private String lastModifiedBy;
	
	@CreatedDate
	@Field("last_modified_date")
	@JsonIgnore
	private Instant lastModifiedDate = Instant.now();
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Instant getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
	

}
