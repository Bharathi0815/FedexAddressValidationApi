package org.bharathi.model;

import lombok.Data;

@Data
public class AddressResponse {
	private String transactionId;
	private String customerTransactionId;
	private Output output;
}
