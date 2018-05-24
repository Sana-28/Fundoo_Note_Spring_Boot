/**
 * 
 */
package com.fundoonotes.searchService;

import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements ISearchService {

	private ISearchRepository searchRepository;

	public void setSearchRepository(ISearchRepository searchRepository) {
		this.searchRepository = searchRepository;
	}

	@Override	
	public void saveInfo(Note note) {
		searchRepository.save(note);

	}

}
