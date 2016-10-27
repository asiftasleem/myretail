/**
 * 
 */
package io.github.asiftasleem.myretail.integration;

import io.github.asiftasleem.myretail.integration.json.ProductQueryResponse;

/**
 * @author muhammad.tasleem
 *
 */
public interface IntegrationService {
	
	ProductQueryResponse getProductDetailsById(String id);

}
