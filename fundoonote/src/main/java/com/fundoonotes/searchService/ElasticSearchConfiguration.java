/**
 * 
 */
package com.fundoonotes.searchService;

import java.net.UnknownHostException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author vikas gaikwad
 *
 */

@Configuration
public class ElasticSearchConfiguration {

	@Value("${spring.data.elasticsearch.cluster-name}")
	private String clusterName;

	@Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusterNodes;

	private RestHighLevelClient restHighLevelClient;

	/*
	 * High level REST client that wraps an instance of the low level RestClient and
	 * allows to build requests and read responses.
	 */
	
	/*
	 * restClient() :- Client that connects to an Elasticsearch cluster through
	 * HTTP.
	 */
	@Bean
	public RestHighLevelClient restClient() throws UnknownHostException {
		RestHighLevelClient client = null;

		/*
		 * builder() :- Returns a new RestClientBuilder to help with RestClient
		 * creation. Creates a new builder instance and sets the hosts that the client
		 * will send requests to.
		 */ client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
		return client;
	}

}
