package com.fundoonotes.searchService;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

//@Document(indexName="search",type="notes")


public class Note {
	
	@Id
	private String id;
	@Field
	private String title;
	@Field
	private String description;

	public Note() {
		
	}
	public Note(String id, String title, String description) {
		
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
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
	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", description=" + description + "]";
	}


}
