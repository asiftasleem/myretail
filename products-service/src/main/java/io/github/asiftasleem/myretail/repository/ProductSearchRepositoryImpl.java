/**
 * 
 */
package io.github.asiftasleem.myretail.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import io.github.asiftasleem.myretail.model.Price;

/**
 * @author muhammad.tasleem
 *
 */
@Repository
public class ProductSearchRepositoryImpl implements PriceSearchRepository{
	

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Price searchProductCurrentPrice(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		query.with(new Sort(Sort.Direction.DESC, "timestamp"));
		query.limit(1);
		
		return mongoTemplate.findOne(query, Price.class);
	}
	
}