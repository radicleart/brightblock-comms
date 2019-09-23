package org.brightblock.sidecar.service.schemas;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class UserGaiaConfigSchema implements Serializable {
	private static final long serialVersionUID = -4568774967379661688L;
	@Id public String id;
	public String blockstackName;
	public long updated;
	public GaiaConfigSchema config;

	public UserGaiaConfigSchema() {
		super();
	}

	public UserGaiaConfigSchema(String blockstackName) {
		super();
		this.blockstackName = blockstackName;
		this.updated = new Date().getTime();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBlockstackName() {
		return blockstackName;
	}

	public void setBlockstackName(String blockstackName) {
		this.blockstackName = blockstackName;
	}

	public long getUpdated() {
		return updated;
	}

	public void setUpdated(long updated) {
		this.updated = updated;
	}

	public GaiaConfigSchema getConfig() {
		return config;
	}

	public void setConfig(GaiaConfigSchema config) {
		this.config = config;
	}

}
