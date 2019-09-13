package org.brightblock.sidecar.service.schemas;

import java.io.Serializable;

public class AzCredentials implements Serializable {

	private static final long serialVersionUID = -7580753146039635479L;
	private String accountName;
	private String accountKey;

	public AzCredentials() {
		super();
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountKey() {
		return accountKey;
	}

	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

}
