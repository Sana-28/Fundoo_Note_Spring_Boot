/**
 * 
 */
package com.fundoonotes.searchService;

import java.net.UnknownHostException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


/**
 * @author bridgeit
 *
 */

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.fundoonotes.searchService")
public class ElasticSearchConfiguration {

	@Value("${elasticsearch.host}")
	private String EsHost;

	@Value("${elasticsearch.port}")
	private int EsPort;

	@Value("${elasticsearch.clustername}")
	private String EsClusterName;

	@Bean
	public RestHighLevelClient restClient() throws UnknownHostException {
	RestHighLevelClient client = null;
	client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
	return client;
	}
	/*@Bean
    public Client client() throws Exception {
        @SuppressWarnings("resource")
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
        return client;
    }*/

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate((Client) restClient());
	}

}
