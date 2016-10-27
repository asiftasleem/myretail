/**
 * 
 */
package io.github.asiftasleem.myretail.repository;
import io.github.asiftasleem.myretail.model.Price;

/**
 * @author muhammad.tasleem
 *
 */
public interface PriceSearchRepository {
	Price searchProductCurrentPrice(String id);
}
