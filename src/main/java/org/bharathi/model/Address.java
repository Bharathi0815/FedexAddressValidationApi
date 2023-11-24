package org.bharathi.model;

import java.util.List;

import lombok.Data;

@Data
public class Address {

	private List<String> streetLines;
	private String city;
	private String stateOrProvinceCode;
	private String postalCode;
	private String countryCode;

}
