/**
 * 
 */
package io.github.asiftasleem.myretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import io.github.asiftasleem.myretail.integration.IntegrationService;
import io.github.asiftasleem.myretail.integration.json.ProductQueryResponse;
import io.github.asiftasleem.myretail.model.Price;
import io.github.asiftasleem.myretail.model.Product;
import io.github.asiftasleem.myretail.repository.PriceRepository;
import io.github.asiftasleem.myretail.repository.PriceSearchRepository;

/**
 * @author muhammad.tasleem
 *
 */
@Service
@CacheConfig(cacheNames={"products"})
class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	IntegrationService integrationService;	
	
	@Autowired
	PriceRepository priceRepository;
	
	@Autowired
	PriceSearchRepository priceSearchRepository;

	@Override
	@Cacheable
	public Product getProduct(String id) {
		ProductQueryResponse response = integrationService.getProductDetailsById(id);
		Product product = new Product();
		product.setId(id);
		product.setDescription(response.getProductCompositeResponse().getItems().get(0).getGeneralDescription());
		
		Price currentPrice = priceSearchRepository.searchProductCurrentPrice(id);
		product.setCurrentPrice(currentPrice);
		
		return product;
	}

	@Override
	@CacheEvict(key = "id")
	public void updateProductPrice(String id, Price price) {
		
		price.setId(id);
		priceRepository.insert(price);
		
		
	}

}
