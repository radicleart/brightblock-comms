package org.brightblock.sidecar.service.schemas;

import java.io.Serializable;

public class AwsCredentials implements Serializable {

	private static final long serialVersionUID = 7759274216590954548L;
	private String accessKeyId;
	private String secretAccessKey;
	private String sessionToken;

	public AwsCredentials() {
		super();
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getSecretAccessKey() {
		return secretAccessKey;
	}

	public void setSecretAccessKey(String secretAccessKey) {
		this.secretAccessKey = secretAccessKey;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

}
