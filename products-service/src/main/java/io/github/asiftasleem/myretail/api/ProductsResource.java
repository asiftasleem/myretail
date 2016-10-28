package io.github.asiftasleem.myretail.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.asiftasleem.myretail.model.Price;
import io.github.asiftasleem.myretail.model.Product;
import io.github.asiftasleem.myretail.service.ProductsService;
/**
 * @author muhammad.tasleem
 *
 */
@RestController()
@RequestMapping("/")
public class ProductsResource {
	
	@Autowired
	ProductsService productsService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Product> getProducts() {    	
    	List<Product> products = getMockProducts();
    	return products;        
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Product getProduct(@PathVariable("id") String id) throws InterruptedException, ExecutionException {
    	return productsService.getProduct(id);        
    }
    
    @RequestMapping(value = "/{id}/price", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json" )
    public Product updateProductPrice(@PathVariable("id") String id, @RequestBody Product product) {    	
    	return productsService.updateProductPrice(id, product);        
    }

	private List<Product> getMockProducts() {
		List<Product> products = new ArrayList<>();
		Product product = new Product("13860428", "The Big Lebowski (Blu-ray) (Widescreen)", new Price("13.49", "USD"));
		products.add(product);
		
		return products;
	}

}