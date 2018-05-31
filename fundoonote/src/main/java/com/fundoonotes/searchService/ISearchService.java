/**
 * 
 */
package com.fundoonotes.searchService;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author vikas gaikwad
 *
 */
public interface ISearchService {

	void saveInfo(Note note) throws JsonProcessingException;

	void getNote(String id);

	Map<String, Object> updateNoteById(String id, Note note);

	void deleteNoteById(String id);

}
