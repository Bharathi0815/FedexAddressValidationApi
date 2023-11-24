package org.bharathi.model;

import lombok.Data;

@Data
public  class Attributes {
	private boolean POBox;
    private boolean POBoxOnlyZIP;
    private boolean SplitZip;
    private boolean SuiteRequiredButMissing;
    private boolean InvalidSuiteNumber;
    private String ResolutionInput;
    private boolean DPV;
    private String ResolutionMethod;
    private String DataVintage;
    private String MatchSource;
    private boolean CountrySupported;
    private boolean ValidlyFormed;
    private boolean Matched;
    private boolean Resolved;
    private boolean Inserted;
    private boolean MultiUnitBase;
    private boolean ZIP11Match;
    private boolean ZIP4Match;
    private boolean UniqueZIP;
    private boolean StreetAddress;
    private boolean RRConversion;
    private boolean ValidMultiUnit;
    private String AddressType;
    private String AddressPrecision;
    private boolean MultipleMatches;


}
