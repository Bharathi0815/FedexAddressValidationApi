package org.bharathi.RestController;

import org.bharathi.pojo.OutputTransaction;
import org.bharathi.model.AddressToValidate;
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
	
	String transactionId="";
	String invalidAddress="";
	
	String jsonData="";
	
	
	@PostMapping("/resolve")
	public ResponseEntity<?> validateAddress(@RequestBody AddressToValidate addresstovalidate)
	{
		
		System.out.println("java pojo data"+addresstovalidate);
		
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			 jsonData=mapper.writeValueAsString(addresstovalidate);
			
			System.out.println("jsondata"+jsonData);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
			
			try
			{
		String url="https://apis-sandbox.fedex.com/address/v1/addresses/resolve";
		
		String bearerToken="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJDWFMtVFAiXSwiUGF5bG9hZCI6eyJjbGllbnRJZGVudGl0eSI6eyJjbGllbnRLZXkiOiJsNzNhNzYzZmQ1M2UwNTQ5NDY5NTU4MTE5NjhiNjA0NTRiIn0sImF1dGhlbnRpY2F0aW9uUmVhbG0iOiJDTUFDIiwiYWRkaXRpb25hbElkZW50aXR5Ijp7InRpbWVTdGFtcCI6IjI0LU5vdi0yMDIzIDE2OjQ4OjE0IEVTVCIsImdyYW50X3R5cGUiOiJjbGllbnRfY3JlZGVudGlhbHMiLCJhcGltb2RlIjoiU2FuZGJveCIsImN4c0lzcyI6Imh0dHBzOi8vY3hzYXV0aHNlcnZlci1zdGFnaW5nLmFwcC5wYWFzLmZlZGV4LmNvbS90b2tlbi9vYXV0aDIifSwicGVyc29uYVR5cGUiOiJEaXJlY3RJbnRlZ3JhdG9yX0IyQiJ9LCJleHAiOjE3MDA4NjYwOTQsImp0aSI6IjA4ZDdkNjk5LTkzODktNDA1Ny04Mjc0LWE2N2EwYmJhNWE3ZCJ9.Z7ikTSicaWpXarviP0ar1koXPohL99O01bDrAlfBP8vpziRD00LP4iNHdr-oZnI3iZjFBRc8jFFqS5j8J2jsWBarXVzhmZdW8HsNj-nvibFfzlpM5SLQtKVYSaugK-f4u53rUcYT85heLvimuNFkHLy40f-I_FYW80u0Im5G8kDCDtWWq6NvJVEqS08DoaPNRcYaVGVqVJVLXw9E8Fx4U3xli79bp2Oe8NJUq-0-bG7Hy9o5F8Xvd1N2985Gc-daho_KTshoS2TdICuJHc4y2C2mw_gDhvfJAnFiKWNsjbMeRSAimEH6qnKo77wkyrncQ48aixPca7is8AnH0VIy5aqBXfKndcq9O66fyLY5LYAYmR4LbLbjjErTdohkZw6t7FEsCLiuvhFyJpiLd5SMkZLjJP3PxUCqG8qYs9MqDagJbQPI1cgSmqX7vedIp0swntwadVt7HjeaI-rK051_4C8o6COCnl_pNi3MVg-Mww6HjZIqNulGzsVZN83o1WBxJ24B7u9wBZm9YGS6pRv-1HH0NANe9s1H5HIcYOhUM1gxUmO-R7w9X3HqLZYZCM9YgTt0ZJCNbHfmXYM7bjrCXRtCwWQCOmwBWeQRc7UFunxks6yGZQkiTGcYXT6mz1iOhLCADXvlsvdAfhDT9jgVpgV2u6RwD-amrH7yW-DM0Z4";
		
		HttpMethod method=HttpMethod.POST;
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(bearerToken);
		HttpEntity<String> requestEntity=new HttpEntity<>(jsonData,headers);
		System.out.println("Request Entity"+requestEntity);
	  
		ResponseEntity<OutputTransaction> response=restTemplate.exchange(url, method, requestEntity, OutputTransaction.class);
		System.out.println("Api called");
		OutputTransaction responseBody=response.getBody();
	    System.out.println("Response data :"+responseBody);
	    return ResponseEntity.ok(responseBody);
	    
	   
			}
			
		catch(HttpClientErrorException ex)
		{
			HttpStatus statusCode = ex.getStatusCode();
	        String errorMessage = ex.getResponseBodyAsString();
	        // Handle the error or return an appropriate error response
	        return ResponseEntity.status(statusCode).body(errorMessage);
		}

		
		
		
		
	
		
		
		
		
			
			
		
		
	}


}
