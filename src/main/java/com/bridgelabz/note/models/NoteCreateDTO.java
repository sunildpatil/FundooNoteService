package com.bridgelabz.note.models;

public class NoteCreateDTO {

	private String title;
	private String description;
	private String color;
		
	public NoteCreateDTO() {

	}

	public NoteCreateDTO(String title, String description, String color) {
		super();
		this.title = title; 
		this.description = description;
		this.color = color;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "NoteDTO [title=" + title + ", description=" + description + ", color=" + color + "]";
	}

}
