package org.bharathi.model;

import lombok.Data;

@Data
public class AddressInfo {
	private Address address;
	private Contact contact;
	private String clientReferenceId;

}
