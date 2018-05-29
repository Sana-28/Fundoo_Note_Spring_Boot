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
 * @author bridgeit
 *
 */

@Configuration
public class ElasticSearchConfiguration {

	@Value("${spring.data.elasticsearch.cluster-name}")
	private String clusterName;

	@Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusterNodes;

	private RestHighLevelClient restHighLevelClient;

	@Bean
	public RestHighLevelClient restClient() throws UnknownHostException {
		RestHighLevelClient client = null;
		client = new RestHighLevelClient(
				RestClient.builder(new HttpHost("localhost", 9200, "http"), new HttpHost("localhost", 9300, "http")));
		return client;
	}

}
