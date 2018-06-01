/**
 * 
 */
package com.fundoonotes.searchService;

/**
 * @author vikas gaikwad
 *
 */

/*@Configuration
@EnableElasticsearchRepositories(basePackages = "com.fundoonotes.searchService")
public class ElasticSearchConfiguration {
	
	
	@Value("${elasticsearch.host}")
    private String EsHost;

    @Value("${elasticsearch.port}")
    private int EsPort;

    @Value("${elasticsearch.clustername}")
    private String EsClusterName;
    private RestHighLevelClient restHighLevelClient;
    
    private RestHighLevelClient buildClient() {
        try {
            restHighLevelClient = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost("localhost", 9200, "http")));
                            
        } catch (Exception e) {
           
        }
        return restHighLevelClient;
    }*/
    /*TransportClient client;
    Settings setting = Settings.builder().put("cluster.name",EsClusterName).build();
    
    new PreBuiltTransportClient(setting);
    client = new TransportClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
	return client;*/
	
	/*@Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }*/

    
    
    
    
    
    
    
    
    

	/*@Value("${spring.data.elasticsearch.cluster-name}")
	private String clusterName;

	@Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusterNodes;

	private RestHighLevelClient restHighLevelClient;
*/
	/*
	 * High level REST client that wraps an instance of the low level RestClient and
	 * allows to build requests and read responses.
	 */
	
	/*
	 * restClient() :- Client that connects to an Elasticsearch cluster through
	 * HTTP.
	 */
	/*@Bean
	public RestHighLevelClient restClient() throws UnknownHostException {
		RestHighLevelClient client = null;

		
		 * builder() :- Returns a new RestClientBuilder to help with RestClient
		 * creation. Creates a new builder instance and sets the hosts that the client
		 * will send requests to.
		  client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
		return client;
	}*/

//}
