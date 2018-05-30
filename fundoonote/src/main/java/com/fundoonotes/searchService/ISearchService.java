/**
 * 
 */
package com.fundoonotes.searchService;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author vikas gaikwad
 *
 */
public interface ISearchService {

	void saveInfo(Note note) throws JsonProcessingException;

	void getNote(String id);

}
