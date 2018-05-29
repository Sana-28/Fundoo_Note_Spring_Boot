/**
 * 
 */
package com.fundoonotes.searchService;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bridgeit
 *
 */
@RestController
public class SearchController {

	@Autowired
	RestHighLevelClient client;

	@Autowired
	ISearchService searchService;

	public SearchController(ISearchService searchService) {
		this.searchService = searchService;
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Note note) {
		searchService.saveInfo(note);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

}
