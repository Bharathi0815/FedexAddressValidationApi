package org.bharathi.pojo;
import java.util.List;

import lombok.Data;


@Data
public  class ResolvedAddress {
	
	
	private String clientReferenceId;
    private List<String> streetLinesToken;
    private String city;
    private String stateOrProvinceCode;
    private String postalCode;
    private ParsedPostalCode parsedPostalCode;
    private String countryCode;
    private String classification;
    private boolean ruralRouteHighwayContract;
    private boolean generalDelivery;
    private List<String> customerMessages;
    private boolean normalizedStatusNameDPV;
    private String standardizedStatusNameMatchSource;
    private String resolutionMethodName;
    private Contact contact;
    private Attributes attributes;


}
