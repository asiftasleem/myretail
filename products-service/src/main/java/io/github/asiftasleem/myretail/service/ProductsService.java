/**
 * 
 */
package io.github.asiftasleem.myretail.service;

import io.github.asiftasleem.myretail.model.Price;
import io.github.asiftasleem.myretail.model.Product;

/**
 * @author muhammad.tasleem
 *
 */
public interface ProductsService {
	
	Product getProduct(String id);
	void updateProductPrice(String id, Price price);

}
