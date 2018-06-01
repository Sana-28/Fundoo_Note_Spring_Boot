/**
 * 
 */
package com.fundoonotes.searchService;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bridgeit
 *
 */

@Repository
public interface NoteRepository extends ElasticsearchCrudRepository<Note, String> {

}
