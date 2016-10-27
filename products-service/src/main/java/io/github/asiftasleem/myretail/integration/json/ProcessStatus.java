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
public class ProcessStatus {
	
	@JsonProperty("is_ready")
	private Boolean isReady;//true	
	
	@JsonProperty("operation_description")
	private String operationDescription;//"assortment ready",
	
	@JsonProperty("operation_code")
	private String operationCode;//"PAAP"

}
