/**
 * 
 */
package com.fundoonotes.searchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements ISearchService {

	/*@Autowired
	private SearchRepository searchRepository;*/
	@Autowired
	private NoteRepository noteRepository;
	
	/*@Autowired
	ElasticsearchTemplate elasticsearchTemplate;*/
/*
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
		
	}*/
	
	

	@Override
	public Note addNote(Note note) {
		noteRepository.save(note);
		return null;
	}

	@Override
	public void deleteNote(String id) {
		noteRepository.deleteById(id);
		
	}

}
