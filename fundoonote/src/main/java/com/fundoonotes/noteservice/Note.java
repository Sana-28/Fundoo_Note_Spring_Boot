package com.fundoonotes.noteservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fundoonotes.userservice.User;

@Entity
@Table(name = "Note")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int noteId;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private Boolean inTrash = false;

	@Column
	private Boolean isArchive = false;

	@Column
	private Boolean isPin = false;

	@Lob
	@Column
	private byte[] noteImage;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
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

	public Boolean getInTrash() {
		return inTrash;
	}

	public void setInTrash(Boolean inTrash) {
		this.inTrash = inTrash;
	}

	public Boolean getIsArchive() {
		return isArchive;
	}

	public void setIsArchive(Boolean isArchive) {
		this.isArchive = isArchive;
	}

	public Boolean getIsPin() {
		return isPin;
	}

	public void setIsPin(Boolean isPin) {
		this.isPin = isPin;
	}

	public byte[] getnoteImage() {
		return noteImage;
	}

	public void setnoteImage(byte[] image) {
		this.noteImage = noteImage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}