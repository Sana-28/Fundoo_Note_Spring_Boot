package com.fundoonotes.noteservice;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoteServiceImpl implements INoteService {

	@Autowired
	NoteRepository noteRepository;
	
	@Override
	public int createNote(Note note) {
		
		noteRepository.save(note);
		return 0;
	}

	@Override
	public int updateNote(Note note) {
		noteRepository.save(note);
		return 0;
	}

	@Override
	public void deleteNote(int id) {
		
	noteRepository.deleteById(id);	
	
	}
	@Override
	public void getNotes(int id) {
	
		
	}

	@Override
	public void saveImage(MultipartFile fileUpload, int noteId) throws IOException {
		// TODO Auto-generated method stub
		
	}

}