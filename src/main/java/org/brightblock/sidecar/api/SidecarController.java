package org.brightblock.sidecar.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.brightblock.sidecar.common.models.ApiModel;
import org.brightblock.sidecar.common.models.ResponseCodes;
import org.brightblock.sidecar.service.SidecarRepository;
import org.brightblock.sidecar.service.schemas.GaiaConfigSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081", "https://radicle.art", "https://tart.radiclesociety.org", "https://radicle.store", "https://tstore.radiclesociety.org", "https://tdbid.radiclesociety.org",  "https://dbid.io", "https://brightblock.org" }, maxAge = 6000)
public class SidecarController {

	@Autowired private SidecarRepository sidecarRepository;

	@RequestMapping(value = "/v1/admin/reload", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel> findByToUser(HttpServletRequest request, @RequestBody GaiaConfigSchema config) {
		GaiaConfigSchema savedMessage = sidecarRepository.save(config);
		ApiModel model = ApiModel.getSuccess(ResponseCodes.OK, savedMessage);
		model.setHeaders(request);
		return new ResponseEntity<ApiModel>(model, HttpStatus.OK);
	}

	@RequestMapping(value = "/v1/admin/config", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel> getConfig(HttpServletRequest request) {
//		if (message.getDomain() == null) {
//			message.setDomain(request.getHeader(ForwardHeaderModel.X_FORWARDED_HOST));
//		}
//		GaiaConfigSchema savedMessage = sidecarRepository.save(message);
		ApiModel model = ApiModel.getSuccess(ResponseCodes.OK, "Hoorah");
		model.setHeaders(request);
		return new ResponseEntity<ApiModel>(model, HttpStatus.OK);
	}

	@RequestMapping(value = "/v1/admin/config", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel> setConfig(HttpServletRequest request, @PathVariable String username) {
		List<GaiaConfigSchema> messages = sidecarRepository.findByBlockstackName(username);
		ApiModel model = ApiModel.getSuccess(ResponseCodes.OK, messages);
		model.setHeaders(request);
		return new ResponseEntity<ApiModel>(model, HttpStatus.OK);
	}
}
