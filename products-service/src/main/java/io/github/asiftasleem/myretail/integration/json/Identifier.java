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
public class Identifier {
	
	@JsonProperty("id_type")
	private String idType;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("source")
	private String source;
	
	@JsonProperty("is_primary")
	private Boolean isPrimary;

}
