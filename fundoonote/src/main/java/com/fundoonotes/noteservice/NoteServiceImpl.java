package com.fundoonotes.noteservice;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fundoonotes.userservice.User;
import com.fundoonotes.userservice.UserServiceImpl;

@Service
public class NoteServiceImpl implements INoteService {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	NoteRepository noteRepository;
	
	@Override
	public int createNote(Note note, int id) {
		
		User user = userService.getUserById(id);
		note.setUser(user);
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
	public Note getNotes(int id) {
	
		 Note note = noteRepository.getOne(id);
		 
		System.out.println("Note is :=> "+note.getDescription()+" "+note.getTitle());
		return note;
	}

	@Override
	public void saveImage(MultipartFile fileUpload, int noteId) throws IOException {
		
		Note note = noteRepository.getOne(noteId);
		note.setImage(fileUpload.getBytes());
		noteRepository.save(note);
	}

	@Override
	public Note getNoteByNoteId(int id) {
		
		 return noteRepository.getOne(id);
	}

}