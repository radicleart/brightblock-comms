package org.brightblock.sidecar.api;

import javax.servlet.http.HttpServletRequest;

import org.brightblock.sidecar.common.models.ApiModel;
import org.brightblock.sidecar.common.models.ResponseCodes;
import org.brightblock.sidecar.service.SidecarRepository;
import org.brightblock.sidecar.service.schemas.GaiaConfigSchema;
import org.brightblock.sidecar.service.schemas.UserGaiaConfigSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081", "https://radicle.art", "https://tart.radiclesociety.org", "https://radicle.store", "https://tstore.radiclesociety.org", "https://tdbid.radiclesociety.org",  "https://dbid.io", "https://brightblock.org" }, maxAge = 6000)
public class SidecarController {

	@Autowired private SidecarRepository sidecarRepository;

	@RequestMapping(value = "/v1/admin/reload", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel> findByToUser(HttpServletRequest request, @RequestBody GaiaConfigSchema config) {
		String blockstackName = getCurrentUser(request);
		UserGaiaConfigSchema userGaiaConfigSchema = sidecarRepository.findByBlockstackName(blockstackName);
		userGaiaConfigSchema.setConfig(config);
		ApiModel model = ApiModel.getSuccess(ResponseCodes.OK, "reloaded");
		model.setHeaders(request);
		return new ResponseEntity<ApiModel>(model, HttpStatus.OK);
	}

	@RequestMapping(value = "/v1/admin/config", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserGaiaConfigSchema getConfig(HttpServletRequest request) {
		String blockstackName = getCurrentUser(request);
		UserGaiaConfigSchema userGaiaConfigSchema = sidecarRepository.findByBlockstackName(blockstackName);
		return userGaiaConfigSchema;
	}

	@RequestMapping(value = "/v1/admin/config", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public UserGaiaConfigSchema setConfig(HttpServletRequest request, @RequestBody GaiaConfigSchema config) {
		String blockstackName = getCurrentUser(request);
		UserGaiaConfigSchema userGaiaConfigSchema = sidecarRepository.findByBlockstackName(blockstackName);
		if (userGaiaConfigSchema == null) {
			userGaiaConfigSchema = new UserGaiaConfigSchema(blockstackName);
		}
		userGaiaConfigSchema.setConfig(config);
		userGaiaConfigSchema = sidecarRepository.save(userGaiaConfigSchema);
		return userGaiaConfigSchema;
	}

	private String getCurrentUser(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("USERNAME");
		return username;
	}
}
