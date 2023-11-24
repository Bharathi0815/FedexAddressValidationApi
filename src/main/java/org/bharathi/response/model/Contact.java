package org.bharathi.response.model;

import lombok.Data;

@Data
public class Contact {

	private String personName;
	private ParsedPersonName parsedPersonName;
	private String companyName;
	private String phoneNumber;
	private String phoneExtension;
	private String emailAddress;
	private String faxNumber;
	private String contactId;
	private String stateTaxId;
	private String federalTaxId;

	@Data
	public static class ParsedPersonName {
		private String firstName;
		private String middleName;
		private String lastName;
		private String suffix;
	}
}
