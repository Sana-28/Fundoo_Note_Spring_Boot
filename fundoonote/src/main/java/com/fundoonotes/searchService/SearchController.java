/**
 * 
 */
package com.fundoonotes.searchService;

import java.util.Map;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vikas gaikwad
 *
 */
@RestController
public class SearchController {

	@Autowired
	RestHighLevelClient client;

	@Autowired
	ISearchService searchService;

	@PostMapping("/save")
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
}
