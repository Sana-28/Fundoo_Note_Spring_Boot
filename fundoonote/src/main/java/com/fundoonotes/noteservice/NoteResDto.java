package com.fundoonotes.noteservice;

public class NoteResDto {

	private int noteId;

	private String title;

	private String description;

	private Boolean inTrash = false;

	private Boolean isArchive = false;

	private Boolean isPin = false;

	private byte[] image;

	public NoteResDto(Note note) {
		this.noteId = note.getNoteId();
		this.title = note.getTitle();
		this.description = note.getDescription();
		this.inTrash = note.getInTrash();
		this.isPin = note.getIsPin();
		this.isArchive = note.getIsArchive();
		this.image = note.getnoteImage();
	}

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
		return image;
	}

	public void setnoteImage(byte[] image) {
		this.image = image;
	}

}
