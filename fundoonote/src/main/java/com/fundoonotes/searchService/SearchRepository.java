/**
 * 
 */
package com.fundoonotes.searchService;

import java.util.Map;
import java.util.UUID;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author bridgeit
 *
 */
@Repository

public class SearchRepository {
private final String INDEX = "noteData";
private final String Type = "notes";
 	private RestHighLevelClient restHighLevelClient;
 	private ObjectMapper objectmapper;
 	
 	public SearchRepository(ObjectMapper objectMapper,RestHighLevelClient restHighLevelClient) {
 		this.objectmapper=objectMapper;
 		this.restHighLevelClient=restHighLevelClient;
 	}
 	public Note insertNote(Note note) {
 		//note.setId(UUID.randomUUID().toString());
 		Map dataMap=(Map) objectmapper.convertValue(note, Map.class);
 		IndexRequest indexRequest = new IndexRequest(INDEX, Type, note.getId()).source(dataMap);
 		try {
			IndexResponse response = restHighLevelClient.index(indexRequest);
		} catch (Exception e) {
			e.getMessage();
		}
 		return note;
 	}

}
