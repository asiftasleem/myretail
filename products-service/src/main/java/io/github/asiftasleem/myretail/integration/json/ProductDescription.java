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
public class ProductDescription {
	
	@JsonProperty("identifier")
	private List<Identifier> identifiers = new ArrayList<>();
	
	@JsonProperty("relation")
	private String relation; // "TAC",
	
	@JsonProperty("relation_description")
	private String relationDescription; //"Title Authority Child",
	
	@JsonProperty("data_page_link")
	private String dataPageLink; //"http://www.target.com/p/the-big-lebowski-blu-ray/-/A-13860428",
	
	@JsonProperty("imn_identifier")
	private String imnIdentifier; // 12244586,
	
	@JsonProperty("is_orderable")
	private Boolean isOrderable; //true,
	
	@JsonProperty("is_sellable")
	private Boolean isSellable; //true,
	
	@JsonProperty("general_description")
	private String generalDescription; //"Blu-ray BIG LEBOWSKI, THE Movies",
	
	@JsonProperty("is_circular_publish")
	private Boolean isCircularPublish; //true,
	
	@JsonProperty("dpci")
	private String dpci;//"058-34-0436",
	
	@JsonProperty("department_id")
	private String departmentId;//58,
	
	@JsonProperty("class_id")
	private String classId;//34,"
			
	@JsonProperty("item_id")
	private String itemId;//436,
	
	@JsonProperty("business_process_status")
	private List<ProcessStatus> businessProcessStatuses = new ArrayList<>(); 
	
	@JsonProperty("online_description")
	private OnlineDescription onlineDescription;
	
	@JsonProperty("store_description")
	private StoreDescription storeDescription;
	
	@JsonProperty("alternate_description")
	private List<AlternateDescription> alternateDescriptions = new ArrayList<>(); 
	
	@JsonProperty("features")
	private List<Feature> features = new ArrayList<>();
}
