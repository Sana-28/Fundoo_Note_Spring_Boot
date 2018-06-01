/**
 * 
 */
package com.fundoonotes.searchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vikas gaikwad
 *
 */
@RestController
public class SearchController {
	 /*@Autowired
	    private ElasticsearchOperations elasticsearchOperations;*/

	 /*@Autowired
	    private ElasticsearchTemplate elasticsearchTemplate;*/
	/*@Autowired
	RestHighLevelClient client;*/

	@Autowired
	ISearchService searchService;

	/*@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Note note) {
		try {
			searchService.saveInfo(note);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<?> get(@PathVariable String id){
		

		searchService.getNote(id);
		System.out.println("note read successfully");
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("update/{id}")
	public Map<String, Object> updateNoteById(@RequestBody Note note, @PathVariable String id) {
	  return searchService.updateNoteById(id, note);
	}

	@DeleteMapping("delete/{id}")
	public void deleteNoteById(@PathVariable String id) {
		searchService.deleteNoteById(id);
	}
	
	*/
	
	@PostMapping("/note/add")
	public ResponseEntity<Note> addNote(@RequestBody Note note) {
		Note saveNote = searchService.addNote(note);
		return new ResponseEntity<>(saveNote, HttpStatus.OK);
	}
	
	@DeleteMapping("/note/{id}/delete")
	public ResponseEntity<?> deletenote(@PathVariable("id") String id) {
		searchService.deleteNote(id);
		return new ResponseEntity<>("deleted...", HttpStatus.OK);
	}
	
	
	 
	
	/*@DeleteMapping("/movie/{id}/delete")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok("Deleted");
    }*/
}
