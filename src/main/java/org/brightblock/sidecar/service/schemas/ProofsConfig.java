package org.brightblock.sidecar.service.schemas;

import java.io.Serializable;

public class ProofsConfig implements Serializable {

	private static final long serialVersionUID = -7656843255912709675L;
	private Integer proofsRequired = 0;

	public ProofsConfig() {
		super();
	}

	public Integer getProofsRequired() {
		return proofsRequired;
	}

	public void setProofsRequired(Integer proofsRequired) {
		this.proofsRequired = proofsRequired;
	}

}
