package org.brightblock.sidecar.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.brightblock.sidecar.service.schemas.GaiaConfigSchema;
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
	public GaiaConfigSchema save(GaiaConfigSchema gaiaConfigSchema) {
		try {
			return sideCarRepository.save(gaiaConfigSchema);
		} catch (Exception e) {
			logger.error("Error saving category: " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<GaiaConfigSchema> findGaiaConfigSchema(String nameQuery) {
		Criteria levels = Criteria.where("level").lt(4);
		List<GaiaConfigSchema> results = null;
		if (nameQuery != null && nameQuery.length() > 0) {
			Criteria regex = Criteria.where("name").regex(".*" + nameQuery + ".*", "i");
			results = mongoTemplate.find(new Query().addCriteria(regex).addCriteria(levels), GaiaConfigSchema.class);
		} else {
			results = mongoTemplate.find(new Query().addCriteria(levels), GaiaConfigSchema.class);
		}
		return results;
	}


}
