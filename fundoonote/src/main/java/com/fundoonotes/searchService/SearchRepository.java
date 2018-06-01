/**
 * 
 */
package com.fundoonotes.searchService;

import org.springframework.stereotype.Repository;

/**
 * @author vikas gaikwad
 *
 */
//@Repository
public class SearchRepository {

	/*private final String INDEX = "noteData";

	private final String Type = "notes";
*/
	/*
	 * High level REST client that wraps an instance of the low level (RestClient)
	 * and allows to build requests and read responses. The {@link RestClient}
	 * instance is internally built based on the provided {@link RestClientBuilder}
	 * and it gets closed automatically when closing the {@link RestHighLevelClient}
	 * instance that wraps it.
	 */
	/*@Autowired
	private RestHighLevelClient restHighLevelClient;*/

	/*
	 * ObjectMapper provides functionality for reading and writing JSON, either to
	 * and from basic POJOs (Plain Old Java Objects), or to and from a
	 * general-purpose JSON Tree Model
	 */
	/*@Autowired
	private ObjectMapper objectmapper;

	public Note insertNote(Note note) throws JsonProcessingException {
*/
		/*
		 * writeValueAsString() :- Method that can be used to serialize any Java value
		 * as a String
		 */
		/*String json = objectmapper.writeValueAsString(note);
*/
		/*
		 * Index request to index a typed JSON document into a specific index and make
		 * it searchable
		 */
/*		IndexRequest indexRequest = new IndexRequest(INDEX, Type, note.getId()).source(json, XContentType.JSON);
*/
		/*try {

			 IndexResponse :- response of an index operation 
			IndexResponse response = restHighLevelClient.index(indexRequest);
			System.out.println(response.getId());
		} catch (Exception e) {
			e.getMessage();
		}
		return note;
	}
*/	
	/*----------------------------------------------------------------------------------------------------*/

	/*public Map<String, Object> getNote(String id) {*/

		/**
		 * Constructs a new get request against the specified index with the type and
		 * id.
		 *
		 * @param index:-
		 *            The index to get the document from
		 * @param type:-
		 *            The type of the document
		 * @param id:-
		 *            The id of the document
		 */

		/*
		 * GetRequest :- A request to get a document (its source) from an index based on
		 * its type (optional) and id. Best created using
		 * org.elasticsearch.client.Requests.getRequest(String).
		 * 
		 * The operation requires the index(), type(String) and id(String) to be set.
		 */

		/*GetRequest getRequest = new GetRequest(INDEX, Type, id);*/

		/* GetResponse :- The response of a get action. */
		/*GetResponse getResponse = null;
		System.out.println("*******" + INDEX);
		try {

			getResponse = restHighLevelClient.get(getRequest);
			System.out.println("repository execution : " + id);

		} catch (java.io.IOException e) {
			e.getLocalizedMessage();
		}
		Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
		return sourceAsMap;
	}*/
	/*----------------------------------------------------------------------------------------------------*/

	/*public Map<String, Object> updateNoteById(String id, Note note) {

		
		 * fetchSource(true/false) :- Indicates whether the response should contain the
		 * updated _source.
		 
		UpdateRequest updateRequest = new UpdateRequest(INDEX, Type, id).fetchSource(true); // Fetch Object after its
																							// update

		Map<String, Object> error = new HashMap<>();
		error.put("Error", "Unable to update book");
		try {
			
			 * writeValueAsString() :- Method that can be used to serialize any Java value
			 * as a String.
			 
			String bookJson = objectmapper.writeValueAsString(note);
			updateRequest.doc(bookJson, XContentType.JSON);
			UpdateResponse updateResponse = restHighLevelClient.update(updateRequest);
			Map<String, Object> sourceAsMap = updateResponse.getGetResult().sourceAsMap();
			return sourceAsMap;
		} catch (JsonProcessingException e) {
			e.getMessage();
		} catch (java.io.IOException e) {
			e.getLocalizedMessage();
		}
		return error;
	}*/

	/*----------------------------------------------------------------------------------------------------*/
	/*public void deleteNoteById(String id) {

		
		 * DeleteRequest :- A request to delete a document from an index based on its
		 * type and id.
		 
		DeleteRequest deleteRequest = new DeleteRequest(INDEX, Type, id);
		try {
			DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest);
		} catch (java.io.IOException e) {
			e.getLocalizedMessage();
		}
	}*/
}
