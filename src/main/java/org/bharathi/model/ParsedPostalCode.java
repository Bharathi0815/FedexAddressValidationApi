package org.bharathi.model;

import lombok.Data;

@Data
public  class ParsedPostalCode {
	private String base;
    private String addOn;
    private String deliveryPoint;

}
