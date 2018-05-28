package com.fundoonotes.noteservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fundoonotes.utility.TokenUtils;


@RestController
public class NoteController {

	@Autowired
	INoteService noteService;

	@RequestMapping(value="createnote", method = RequestMethod.PUT)
	ResponseEntity<Note> createNote(@RequestBody Note note, HttpServletRequest request){
		
		int id = TokenUtils.verifyToken(request.getHeader("Authorization"));
		noteService.createNote(note, id);
		return new ResponseEntity<Note>(note ,HttpStatus.OK);	
	}

	@RequestMapping(value="updatenote", method = RequestMethod.PUT)
	ResponseEntity<Note> updateNote(@RequestBody Note note){

		noteService.updateNote(note);
		return new ResponseEntity<Note>(note, HttpStatus.OK);
	}

	@RequestMapping(value="deletenote/{id}", method = RequestMethod.DELETE)
	ResponseEntity<String> deleteNote(@PathVariable int id){
		noteService.deleteNote(id);
		return new ResponseEntity<String>("Note deleted succesfully", HttpStatus.OK);
	}

	@RequestMapping(value="getnotes", method = RequestMethod.GET)
	public ResponseEntity<?> getNotes(@RequestHeader("Authorization") String token){

		int id = TokenUtils.verifyToken(token);
		List<NoteResDto> note =  noteService.getNotes(id);
		return new ResponseEntity<List>(note, HttpStatus.OK);
	}

	@RequestMapping(value = "uploadNoteImage",  method = RequestMethod.POST)
	public ResponseEntity<String> uploadImage(HttpServletRequest request, @RequestParam("image") MultipartFile fileUpload, @RequestParam int noteId)
			throws Exception {
		System.out.println("file name -- "+fileUpload.getOriginalFilename());
		noteService.saveImage(fileUpload, noteId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "deleteimage/{noteId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteImage(@PathVariable("noteId") int noteId){
		System.out.println("noteId is.. "+noteId);
		noteService.deleteImage(noteId);
		return null;
	}
}