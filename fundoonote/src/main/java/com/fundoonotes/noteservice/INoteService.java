package com.fundoonotes.noteservice;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface INoteService {

	int createNote(Note note);
	int updateNote(Note note);
	void deleteNote(int id);
	void getNotes(int id);	
	void saveImage(MultipartFile fileUpload, int noteId) throws IOException;
	
}
