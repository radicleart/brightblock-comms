package org.brightblock.sidecar.service;

import org.brightblock.sidecar.service.schemas.UserGaiaConfigSchema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SidecarRepository extends MongoRepository<UserGaiaConfigSchema, String> {

    public UserGaiaConfigSchema findByBlockstackName(String username);
}
