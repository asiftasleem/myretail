/**
 * 
 */
package io.github.asiftasleem.myretail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.asiftasleem.myretail.model.Price;

/**
 * @author muhammad.tasleem
 *
 */
@Repository
public interface PriceRepository extends MongoRepository<Price, String> {

}