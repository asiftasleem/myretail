/**
 * 
 */
package io.github.asiftasleem.myretail.service;

import java.util.concurrent.ExecutionException;

import io.github.asiftasleem.myretail.model.Product;

/**
 * @author muhammad.tasleem
 *
 */
public interface ProductsService {
	
	Product getProduct(String id) throws InterruptedException, ExecutionException;
	Product updateProductPrice(String id, Product price);

}
