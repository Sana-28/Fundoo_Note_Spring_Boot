/**
 * 
 */
package com.fundoonotes.searchService;

import java.util.Map;

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
		System.out.println("id---"+id);
		searchRepository.getNote(id);
		
	}

	@Override
	public Map<String, Object> updateNoteById(String id, Note note) {
		searchRepository.updateNoteById(id,note);
		
		return null;
	}

	@Override
	public void deleteNoteById(String id) {
		searchRepository.deleteNoteById(id);
		
	}

}
