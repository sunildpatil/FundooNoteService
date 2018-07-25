package com.bridgelabz.note.models;

public class NoteResponseDTO {

	private int id;
	private String title;
	private String description;
	private String createdDate;
	private String updatedDate;
	private String color;
	
	public NoteResponseDTO() {

	}

	public NoteResponseDTO(int id, String title, String description, String createdDate, String updatedDate,
			String color) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "NoteResponseDTO [id=" + id + ", title=" + title + ", description=" + description + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", color=" + color + "]";
	}
}