package org.brightblock.sidecar.service.schemas;

import java.io.Serializable;

public class GcCredentials implements Serializable {

	private static final long serialVersionUID = 1429153211118023793L;
	private String email;
	private String projectId;
	private String keyFilename;
	private Credentials credentials;

	public GcCredentials() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getKeyFilename() {
		return keyFilename;
	}

	public void setKeyFilename(String keyFilename) {
		this.keyFilename = keyFilename;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}
