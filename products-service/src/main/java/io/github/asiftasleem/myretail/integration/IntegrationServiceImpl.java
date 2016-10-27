package io.github.asiftasleem.myretail.integration;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.asiftasleem.myretail.integration.json.ProductQueryResponse;

/**
 * @author muhammad.tasleem
 *
 */
@Service
class IntegrationServiceImpl implements IntegrationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationServiceImpl.class);

	@Autowired
	private Environment environment;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ProductQueryResponse getProductDetailsById(String id) {
		
		StopWatch stopWatch = new StopWatch();
		try {
			stopWatch.start("getProductDetailsById-Integration: Target Store' cvcnvm");
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<?> request = new HttpEntity<>(headers);
			
			String uri = MessageFormat.format(environment.getProperty("target.api.url"), id);
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);


			ProductQueryResponse responseDTO = restTemplate
					.exchange(builder.build().encode().toUri(), 
			        		HttpMethod.GET, 
			        		request, 
			        		ProductQueryResponse.class)
					.getBody();
			
			return responseDTO;

		} catch (Exception e) {
			throw e;
		} finally {
			stopWatch.stop();
			LOGGER.info("Service : {} took {} ms", stopWatch.getLastTaskName(), stopWatch.getLastTaskTimeMillis());
		}

	}
}
