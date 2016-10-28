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
class PriceSearchRepositoryImpl implements PriceSearchRepository{
	

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Price searchProductCurrentPrice(String productId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("productId").is(productId));
		query.with(new Sort(Sort.Direction.DESC, "createdAt"));
		query.limit(1);
		
		return mongoTemplate.findOne(query, Price.class);
	}
	
}