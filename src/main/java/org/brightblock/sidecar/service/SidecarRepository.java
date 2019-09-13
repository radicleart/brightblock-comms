package org.brightblock.sidecar.service;

import java.util.List;

import org.brightblock.sidecar.service.schemas.GaiaConfigSchema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SidecarRepository extends MongoRepository<GaiaConfigSchema, String> {

    public List<GaiaConfigSchema> findByBlockstackName(String username);
}
