/**
 * 
 */
package io.github.asiftasleem.myretail.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
	@Id
	private String id;

	@JsonIgnore
	@Indexed
	private String productId;
	
	@JsonProperty("value")
	private String value;
	
	@JsonProperty("currency_code")
	private String currencyCode;
	
	@JsonIgnore
	//@CreatedDate
	private Date createdAt = new Date();
	
	public Price(String value, String currencyCode){
		this.value = value;
		this.currencyCode = currencyCode;		
	}

}
