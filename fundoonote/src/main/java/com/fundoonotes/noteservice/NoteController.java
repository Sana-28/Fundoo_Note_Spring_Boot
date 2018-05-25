package com.fundoonotes.noteservice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value="createnote", method = RequestMethod.POST)
	ResponseEntity<Note> createNote(@RequestBody Note note, HttpServletRequest request){
		
		int id = TokenUtils.verifyToken(request.getHeader("Authorization"));
		noteService.createNote(note, id);
		return new ResponseEntity<Note>(note ,HttpStatus.OK);	
	}

	@RequestMapping(value="updatenote", method = RequestMethod.POST)
	ResponseEntity<Note> updateNote(@RequestBody Note note){

		noteService.updateNote(note);
		return new ResponseEntity<Note>(note, HttpStatus.OK);
	}

	@RequestMapping(value="deletenote/{id}", method = RequestMethod.DELETE)
	ResponseEntity<String> deleteNote(@PathVariable int id){
		noteService.deleteNote(id);
		return new ResponseEntity<String>("Note deleted succesfully", HttpStatus.OK);
	}


	@RequestMapping(value="getnotes/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getNotes(@PathVariable int id){

		Note note = noteService.getNotes(id);
		return new ResponseEntity<Note>(note, HttpStatus.OK);
	}

	@RequestMapping(value = "uploadimage",  method = RequestMethod.POST, headers= {"content-type=multipart/*"})
	public ResponseEntity<String> uploadImage(HttpServletRequest request, @RequestParam("file") MultipartFile fileUpload, @RequestParam int noteId)
			throws Exception {
		System.out.println("file name -- "+fileUpload.getOriginalFilename());
		noteService.saveImage(fileUpload, noteId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}