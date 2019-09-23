package org.brightblock.sidecar.service;

import java.util.List;

import org.brightblock.sidecar.service.schemas.UserGaiaConfigSchema;


public interface SideCarService
{
	public UserGaiaConfigSchema save(UserGaiaConfigSchema gaiaConfigSchema);
	public List<UserGaiaConfigSchema> findGaiaConfigSchema(String query);
}
