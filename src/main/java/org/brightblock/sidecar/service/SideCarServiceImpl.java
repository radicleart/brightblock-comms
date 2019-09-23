package org.brightblock.sidecar.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.brightblock.sidecar.service.schemas.UserGaiaConfigSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class SideCarServiceImpl implements SideCarService {

	private static final Logger logger = LogManager.getLogger(SideCarServiceImpl.class);
	@Autowired private SidecarRepository sideCarRepository;
	@Autowired private MongoTemplate mongoTemplate;

	@Override
	public UserGaiaConfigSchema save(UserGaiaConfigSchema gaiaConfigSchema) {
		try {
			return sideCarRepository.save(gaiaConfigSchema);
		} catch (Exception e) {
			logger.error("Error saving category: " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<UserGaiaConfigSchema> findGaiaConfigSchema(String nameQuery) {
		Criteria levels = Criteria.where("level").lt(4);
		List<UserGaiaConfigSchema> results = null;
		if (nameQuery != null && nameQuery.length() > 0) {
			Criteria regex = Criteria.where("name").regex(".*" + nameQuery + ".*", "i");
			results = mongoTemplate.find(new Query().addCriteria(regex).addCriteria(levels), UserGaiaConfigSchema.class);
		} else {
			results = mongoTemplate.find(new Query().addCriteria(levels), UserGaiaConfigSchema.class);
		}
		return results;
	}


}
