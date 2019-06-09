package org.brightblock.comms.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

@Configuration
public class MongodbConfiguration extends AbstractMongoConfiguration {

	@Autowired private ApplicationSettings applicationSettings;

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
		return new MongoClient(applicationSettings.getMongoIp(), 27017);
	}
}
