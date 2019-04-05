package org.brightblock.comms.conf;

import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

public class MongodbConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "radicleart";
	}

	@Override
	protected String getMappingBasePackage() {
		return "org.brightblock.comms.collaboration.service";
	}

	@Override
	public MongoClient mongoClient() {
		return new MongoClient();
	}
}
