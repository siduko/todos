package com.todos.webapp.models;

import javax.validation.constraints.NotNull;


public class Note {
	private static final long serialVersionUID = -7788619177798332712L;
	
	@NotNull
	private String title;
	private String note;
	private String remindTime;
	public Note(String title, String note, String remindTime) {
		super();
		this.title = title;
		this.note = note;
		this.remindTime = remindTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getRemindTime() {
		return remindTime;
	}
	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}
	
	
}
