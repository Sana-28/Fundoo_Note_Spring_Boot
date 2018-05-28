/**
 * 
 */
package com.fundoonotes.searchService;

import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements ISearchService {

	private SearchRepository searchRepository;

	public void setSearchRepository(SearchRepository searchRepository) {
		this.searchRepository = searchRepository;
	}

	@Override	
	public void saveInfo(Note note) {
		searchRepository.insertNote(note);

	}

}
