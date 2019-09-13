package org.brightblock.sidecar.service.schemas;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;

public class GaiaConfigSchema implements Serializable {
	private static final long serialVersionUID = 8881676989788164180L;
	@Id public String id;
	public String blockstackName;
	public long updated;
	public List<String> validHubUrls;
	public Boolean requireCorrectHubUrl;
	public String serverName;
	public Integer port;
	public Integer proofsConfig;
	public List<String> whitelist;
	public String driver;
	public String readURL;
	public Integer pageSize;
	public String bucket;
	public String cacheControl;
	public AzCredentials azCredentials;
	public DiskSettings diskSettings;
	public GcCredentials gcCredentials;
	public AwsCredentials awsCredentials;

	public GaiaConfigSchema() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getValidHubUrls() {
		return validHubUrls;
	}

	public void setValidHubUrls(List<String> validHubUrls) {
		this.validHubUrls = validHubUrls;
	}

	public Boolean getRequireCorrectHubUrl() {
		return requireCorrectHubUrl;
	}

	public void setRequireCorrectHubUrl(Boolean requireCorrectHubUrl) {
		this.requireCorrectHubUrl = requireCorrectHubUrl;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getProofsConfig() {
		return proofsConfig;
	}

	public void setProofsConfig(Integer proofsConfig) {
		this.proofsConfig = proofsConfig;
	}

	public List<String> getWhitelist() {
		return whitelist;
	}

	public void setWhitelist(List<String> whitelist) {
		this.whitelist = whitelist;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getReadURL() {
		return readURL;
	}

	public void setReadURL(String readURL) {
		this.readURL = readURL;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getCacheControl() {
		return cacheControl;
	}

	public void setCacheControl(String cacheControl) {
		this.cacheControl = cacheControl;
	}

	public AzCredentials getAzCredentials() {
		return azCredentials;
	}

	public void setAzCredentials(AzCredentials azCredentials) {
		this.azCredentials = azCredentials;
	}

	public DiskSettings getDiskSettings() {
		return diskSettings;
	}

	public void setDiskSettings(DiskSettings diskSettings) {
		this.diskSettings = diskSettings;
	}

	public GcCredentials getGcCredentials() {
		return gcCredentials;
	}

	public void setGcCredentials(GcCredentials gcCredentials) {
		this.gcCredentials = gcCredentials;
	}

	public AwsCredentials getAwsCredentials() {
		return awsCredentials;
	}

	public void setAwsCredentials(AwsCredentials awsCredentials) {
		this.awsCredentials = awsCredentials;
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

}
