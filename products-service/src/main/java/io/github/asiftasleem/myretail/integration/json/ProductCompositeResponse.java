/**
 * 
 */
package io.github.asiftasleem.myretail.integration.json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author muhammad.tasleem
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCompositeResponse {
	
	@JsonProperty("request_attributes")
	private List<RequestAttribute> requestAttributes = new ArrayList<>();	
	
	@JsonProperty("items")
	private List<ProductDescription> items = new ArrayList<>(); 

}
