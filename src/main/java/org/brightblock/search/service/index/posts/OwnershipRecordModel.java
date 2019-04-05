package org.brightblock.search.service.index.posts;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OwnershipRecordModel implements Serializable, Comparable<OwnershipRecordModel> {

	private static final long serialVersionUID = 8617555047178804394L;
	private Long id;
	private Long editions;
	private String title;
	private String description;
	private String uploader;
	private String artist;
	private String owner;
	private String itemType;
	private String keywords;
	private String appUrl;
	private String gaiaUrl;
	private String status;
	private String buyer;
	private String txid;
	private SaleDataModel saleData;

	public OwnershipRecordModel() {
		super();
	}

	@JsonCreator
	public OwnershipRecordModel(@JsonProperty("id") String id, 
			@JsonProperty("uploader") String uploader, 
			@JsonProperty("title") String title, 
			@JsonProperty("description") String description, 
			@JsonProperty("itemType") String itemType, 
			@JsonProperty("owner") String owner, 
			@JsonProperty("artist") String artist, 
			@JsonProperty("keywords") String keywords, 
			@JsonProperty("editions") Long editions, 
			@JsonProperty("status") String status, 
			@JsonProperty("buyer") String buyer, 
			@JsonProperty("txid") String txid, 
			@JsonProperty("sold") Boolean sold) {
		super();
		this.id = Long.valueOf(id);
		this.title = title;
		this.description = description;
		this.uploader = uploader;
		this.artist = artist;
		this.owner = owner;
		this.itemType = itemType;
		this.editions = editions;
		this.keywords = keywords;
		this.status = status;
		this.buyer = buyer;
		this.txid = txid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getGaiaUrl() {
		return gaiaUrl;
	}

	public void setGaiaUrl(String gaiaUrl) {
		this.gaiaUrl = gaiaUrl;
	}

	@Override
	public int compareTo(OwnershipRecordModel model) {
		return this.id.compareTo(model.getId());
	}

	@Override
	public boolean equals(Object model) {
		OwnershipRecordModel record = (OwnershipRecordModel) model;
		return this.id.equals(record.getId());
	}

	public SaleDataModel getSaleData() {
		return saleData;
	}

	public void setSaleData(SaleDataModel saleData) {
		this.saleData = saleData;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Long getEditions() {
		return editions;
	}

	public void setEditions(Long editions) {
		this.editions = editions;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}
}
