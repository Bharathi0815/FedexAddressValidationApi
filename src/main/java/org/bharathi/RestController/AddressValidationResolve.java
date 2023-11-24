package org.bharathi.RestController;

import org.bharathi.model.AddressToValidate;
import org.bharathi.response.model.OutputTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/addressresolve")
public class AddressValidationResolve {

	@Autowired
	RestTemplate restTemplate;

	String jsonData = "";

	@PostMapping("/resolve")
	public ResponseEntity<?> validateAddress(@RequestBody AddressToValidate addresstovalidate) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			jsonData = mapper.writeValueAsString(addresstovalidate);
			System.out.println("jsondata" + jsonData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		try {
			String url = "https://apis-sandbox.fedex.com/address/v1/addresses/resolve";

			String bearerToken = "";    //  REPLACE with Actual Token before run
			
			HttpMethod method = HttpMethod.POST;
			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setBearerAuth(bearerToken);
			HttpEntity<String> requestEntity = new HttpEntity<>(jsonData, headers);
			System.out.println("Request Entity" + requestEntity);

			ResponseEntity<OutputTransaction> response = restTemplate.exchange(url, method, requestEntity,
					OutputTransaction.class);
			System.out.println("Api called");
			OutputTransaction responseBody = response.getBody();
			System.out.println("Response data :" + responseBody);
			return ResponseEntity.ok(responseBody);

		}

		catch (HttpClientErrorException ex) {
			HttpStatus statusCode = ex.getStatusCode();
			String errorMessage = ex.getResponseBodyAsString();
			return ResponseEntity.status(statusCode).body(errorMessage);
		}

	}

}
