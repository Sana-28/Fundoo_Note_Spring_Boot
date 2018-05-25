/**
 * 
 */
package com.fundoonotes.searchService;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author bridgeit
 *
 */
@Repository
//@Service("elasticSearchRepository")
public interface ISearchRepository extends ElasticsearchRepository<Note, Integer> {

}
