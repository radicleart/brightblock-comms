package org.brightblock.comms.collaboration.service;

import org.springframework.data.annotation.Id;

public class CollaborationMessage {
	@Id public String id;
	public String domain;
	public String type;
	public String recipient;
	public String sender;
	public String message;

	public CollaborationMessage(String recipient, String sender, String type, String message) {
		super();
		this.recipient = recipient;
		this.sender = sender;
		this.type = type;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}
