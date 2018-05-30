/**
 * 
 */
package com.fundoonotes.searchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class SearchServiceImpl implements ISearchService {

	@Autowired
	private SearchRepository searchRepository;

	@Override	
	public void saveInfo(Note note) throws JsonProcessingException {
		searchRepository.insertNote(note);

	}

	@Override
	public void getNote(String id) {
		searchRepository.getNote(id);
		
	}

}
