/**
 * 
 */
package com.fundoonotes.searchService;

import java.util.Map;
import java.util.UUID;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author vikas gaikwad
 *
 */
@Repository
public class SearchRepository {

	private final String INDEX = "noteData";

	private final String Type = "notes";

	/*
	 * High level REST client that wraps an instance of the low level (RestClient)
	 * and allows to build requests and read responses. The {@link RestClient}
	 * instance is internally built based on the provided {@link RestClientBuilder}
	 * and it gets closed automatically when closing the {@link RestHighLevelClient}
	 * instance that wraps it.
	 */
	@Autowired
	private RestHighLevelClient restHighLevelClient;

	
	
	/*
	 * ObjectMapper provides functionality for reading and writing JSON, either to
	 * and from basic POJOs (Plain Old Java Objects), or to and from a
	 * general-purpose JSON Tree Model
	 */
	@Autowired
	private ObjectMapper objectmapper;

	public Note insertNote(Note note) throws JsonProcessingException {

		
		
		/*
		 * writeValueAsString() :- Method that can be used to serialize any Java value
		 * as a String
		 */
		String json = objectmapper.writeValueAsString(note);

		
		
		/*
		 * Index request to index a typed JSON document into a specific index and make
		 * it searchable
		 */
		IndexRequest indexRequest = new IndexRequest("search", "notes", note.getId()).source(json, XContentType.JSON);

		
		try {

			/* IndexResponse :- response of an index operation */
			IndexResponse response = restHighLevelClient.index(indexRequest);
			System.out.println(response.getId());
		} catch (Exception e) {
			e.getMessage();
		}
		return note;
	}

	public Map<String, Object> getNote(String id) {

		GetRequest getRequest = new GetRequest(INDEX, Type, id);
		GetResponse getResponse = null;
		try {
			getResponse = restHighLevelClient.get(getRequest);
		} catch (java.io.IOException e) {
			e.getLocalizedMessage();
		}
		Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
		return sourceAsMap;
	}
}
