/**
 * 
 */
package com.fundoonotes.searchService;

import java.net.UnknownHostException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bridgeit
 *
 */

@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.fundoonotes.searchService")
public class ElasticSearchConfiguration extends AbstractFactoryBean {

	
	
	@Value("${spring.data.elasticsearch.cluster-name}")
	private String clusterName;
	
	
	@Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusterNodes;

	

	/*@Value("${elasticsearch.clustername}")
	private String EsClusterName;*/

	private RestHighLevelClient restHighLevelClient;

	@Override
	public void destroy() throws Exception {
		try {
			if (restHighLevelClient != null) {
				restHighLevelClient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * RestHighLevelClient :- it accepts the same request arguments as the
	 * TransportClient and returns the same response objects. High level REST client
	 * that wraps an instance of the low level RestClient and allows to build
	 * requests and read responses.
	 */

	@Override
	public Class<RestHighLevelClient> getObjectType() {
		return RestHighLevelClient.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Bean
	public RestHighLevelClient restClient() throws UnknownHostException {
		RestHighLevelClient client = null;
		client = new RestHighLevelClient(
				RestClient.builder(new HttpHost("localhost", 9200, "http"), new HttpHost("localhost", 9201, "http")));
		return client;
	}
	/*
	 * @Bean public Client client() throws Exception {
	 * 
	 * @SuppressWarnings("resource") TransportClient client = new
	 * PreBuiltTransportClient(Settings.EMPTY) .addTransportAddress(new
	 * InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort)); return
	 * client; }
	 */

	/*@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate((Client) restClient());
	}
*/
	@Override
	protected Object createInstance() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
