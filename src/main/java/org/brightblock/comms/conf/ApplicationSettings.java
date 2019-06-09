package org.brightblock.comms.conf;

import java.util.List;

import org.brightblock.comms.conf.settings.DomainModel;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "application")
public class ApplicationSettings {
	private String blockstackNamesIndex;
	private String artMarketIndex;
	private String auctionIndex;
	private String blockstackBase;
	private String blockstackOrgBase;
	private List<DomainModel> domains;
	private String mongoIp;

	public String getBlockstackBase() {
		return blockstackBase;
	}

	public void setBlockstackBase(String blockstackBase) {
		this.blockstackBase = blockstackBase;
	}

	public String getBlockstackNamesIndex() {
		return blockstackNamesIndex;
	}

	public void setBlockstackNamesIndex(String blockstackNamesIndex) {
		this.blockstackNamesIndex = blockstackNamesIndex;
	}

	public String getArtMarketIndex() {
		return artMarketIndex;
	}

	public void setArtMarketIndex(String artMarketIndex) {
		this.artMarketIndex = artMarketIndex;
	}

	public String getAuctionIndex() {
		return auctionIndex;
	}

	public void setAuctionIndex(String auctionIndex) {
		this.auctionIndex = auctionIndex;
	}

	public String getBlockstackOrgBase() {
		return blockstackOrgBase;
	}

	public void setBlockstackOrgBase(String blockstackOrgBase) {
		this.blockstackOrgBase = blockstackOrgBase;
	}

	public List<DomainModel> getDomains() {
		return domains;
	}

	public void setDomains(List<DomainModel> domains) {
		this.domains = domains;
	}

	public String getMongoIp() {
		return mongoIp;
	}

	public void setMongoIp(String mongoIp) {
		this.mongoIp = mongoIp;
	}
}
