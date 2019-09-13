package org.brightblock.sidecar.service.schemas;

import java.io.Serializable;

public class DiskSettings implements Serializable {

	private static final long serialVersionUID = 7329608073294786310L;
	private String storageRootDirectory;

	public DiskSettings() {
		super();
	}

	public String getStorageRootDirectory() {
		return storageRootDirectory;
	}

	public void setStorageRootDirectory(String storageRootDirectory) {
		this.storageRootDirectory = storageRootDirectory;
	}

}
