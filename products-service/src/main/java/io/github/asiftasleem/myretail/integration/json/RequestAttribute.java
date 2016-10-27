/**
 * 
 */
package io.github.asiftasleem.myretail.integration.json;

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
public class RequestAttribute {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("value")
	private String value;

}
