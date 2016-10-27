/**
 * 
 */
package io.github.asiftasleem.myretail.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Document(collection = "prices")
public class Price implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	private String id;
	
	@JsonProperty("value")
	private BigDecimal value;
	
	@JsonProperty("currency_code")
	private String currency;
	
	@JsonIgnore
	private Date timestamp;
	
	public Price(String value, String currencyCode){
		this.value = new BigDecimal(value);
		this.currency = currencyCode;		
	}

}
