package org.brightblock.sidecar.service;

import java.util.List;

import org.brightblock.sidecar.service.schemas.GaiaConfigSchema;


public interface SideCarService
{
	public GaiaConfigSchema save(GaiaConfigSchema gaiaConfigSchema);
	public List<GaiaConfigSchema> findGaiaConfigSchema(String query);
}
