/**
 * 
 */
package io.github.asiftasleem.myretail.model;

import java.io.Serializable;

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
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("current_price")
	private Price currentPrice;	
	
	
	public void setCurrentPrice(Price price){
		this.currentPrice = price;
	}

}
