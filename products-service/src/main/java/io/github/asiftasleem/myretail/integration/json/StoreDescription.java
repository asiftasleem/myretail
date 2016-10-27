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
public class StoreDescription {
	
	@JsonProperty("type")
	private String type;//"GENL"

	@JsonProperty("value")
	private String value;//"Blu-ray BIG LEBOWSKI, THE Movies",

}
