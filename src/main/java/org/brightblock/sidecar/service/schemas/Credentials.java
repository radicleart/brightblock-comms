package org.brightblock.sidecar.service.schemas;

import java.io.Serializable;

public class Credentials implements Serializable {

	private static final long serialVersionUID = -3314531359653857092L;
	private String clientEmail;
	private String privateKey;

	public Credentials() {
		super();
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

}
