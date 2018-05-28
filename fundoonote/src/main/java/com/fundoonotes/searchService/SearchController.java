/**
 * 
 */
package com.fundoonotes.searchService;

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

	
	/*@Autowired
	 ISearchService elasticSearchRepository;*/
	
	private SearchRepository searchRepository;
	@Autowired
	private ISearchService searchService;
	
	 public SearchController(ISearchService searchService) {
		 this.searchService=searchService;
		// TODO Auto-generated constructor stub
	}
	 
/*	@Autowired
	private TransportClient client;*/

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Note note) {
		System.out.println("***********Search controller***********");
		searchService.saveInfo(note);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

}
