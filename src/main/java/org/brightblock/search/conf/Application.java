package org.brightblock.search.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;

@SpringBootApplication
@ComponentScan("org.brightblock")
@EnableMongoRepositories(basePackages = "org.brightblock.search.collaboration")
public class Application {
	
	private String[] mongoHosts = new String[] {"127.0.0.1"};
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    
	@Bean
    public MongoTemplate mongoTemplate() throws Exception {
        final List<ServerAddress> serverAddresses = new ArrayList<>();
        for (String host : mongoHosts) {
            serverAddresses.add(new ServerAddress(host, 27017));
        }

        final MongoClientOptions clientOptions = new MongoClientOptions.Builder()
                .connectTimeout(25000)
                .readPreference(ReadPreference.primaryPreferred())
                .build();

        final MongoClient client = new MongoClient(serverAddresses, clientOptions);
        return new MongoTemplate(client, "Collaboration");
    }

	@Bean
	RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		template.getMessageConverters().add(new StringHttpMessageConverter());
		return template;
	}


	@Bean
	public RestOperations restTemplate1() {
		return createRestTemplate();
	}

	/**
	 * @see https://github.com/FasterXML/jackson-databind
	 * @return
	 */
	@Bean
	public ObjectMapper mapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
		return mapper;
	}

	public static RestTemplate createRestTemplate() {
		RestTemplate template = new RestTemplate();
		template.getMessageConverters().add(new StringHttpMessageConverter());
		return template;
	}
	
	
}
