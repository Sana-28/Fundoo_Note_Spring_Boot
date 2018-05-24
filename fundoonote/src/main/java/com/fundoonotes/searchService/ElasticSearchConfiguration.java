/**
 * 
 */
package com.fundoonotes.searchService;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
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
	public Client client() throws Exception {

		//Settings esSettings = Settings.builder().put("cluster.name", EsClusterName).build();
		return new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(
				new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
//		return TransportClient.builder().settings(esSettings).build()
//				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}

}
