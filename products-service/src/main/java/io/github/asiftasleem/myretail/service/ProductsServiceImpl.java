/**
 * 
 */
package io.github.asiftasleem.myretail.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
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
	public Product getProduct(String id) throws InterruptedException, ExecutionException {
		Future<Product> productDesc = getProductDescription(id);
		Future<Price> currentPrice = getProductPrice(id);
		
		Product product = productDesc.get();
		product.setCurrentPrice(currentPrice.get());		
		return product;
	}

	/**
	 * @param id
	 */
	@Async
	private Future<Price> getProductPrice(String id) {
		Price price = priceSearchRepository.searchProductCurrentPrice(id);
		return new AsyncResult<>(price);		
	}

	/**
	 * @param id
	 * @return
	 */
	@Async
	private Future<Product> getProductDescription(String id) {
		ProductQueryResponse response = integrationService.getProductDetailsById(id);
		Product product = new Product();
		product.setId(id);
		product.setDescription(response.getProductCompositeResponse().getItems().get(0).getGeneralDescription());
		return new AsyncResult<>(product);
	}

	@Override
	@CacheEvict(key="#p0")
	public Product updateProductPrice(String id, Product product) {
		Price p = product.getCurrentPrice();
		p.setProductId(product.getId());
		
		priceRepository.save(p);
		
		product.setCurrentPrice(p);
		return product;
	}

}
