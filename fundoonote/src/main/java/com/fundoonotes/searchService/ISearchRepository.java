/**
 * 
 */
package com.fundoonotes.searchService;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author bridgeit
 *
 */
// @Repository
public interface ISearchRepository extends ElasticsearchRepository<Note, Integer> {

}
