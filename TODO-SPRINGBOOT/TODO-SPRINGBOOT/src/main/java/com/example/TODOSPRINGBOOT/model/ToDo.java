package com.example.TODOSPRINGBOOT.model;



import java.sql.Date;
import java.time.Instant;

import org.hibernate.annotations.ValueGenerationType;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TODO")
public class ToDo {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Todo_id")
	private Long id;
	
	
	private String description;
	
	@Column(name="Status")
	private boolean completed;
	
	private Date createdDate;
	
	private Date completionDate;
	

	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDo(Long id, String description, boolean completed, Date createdDate,Date completionDate) {
		super();
		this.id = id;
		this.description = description;
		this.completed = completed;
		this.createdDate = createdDate;
		this.completionDate=completionDate;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getCompletionDate() {
		return  completionDate;
	}
	
	public void setCompletionDate(Date completionDate) {
		this.completionDate=completionDate;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", description=" + description + ", completed=" + completed + ", createdDate="
				+ createdDate + ", completionDate=" + completionDate + "]";
	}

	
}
