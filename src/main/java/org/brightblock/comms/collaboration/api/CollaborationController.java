package org.brightblock.comms.collaboration.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.brightblock.comms.collaboration.service.CollaborationMessage;
import org.brightblock.comms.collaboration.service.CollaborationRepository;
import org.brightblock.comms.rest.models.ApiModel;
import org.brightblock.comms.rest.models.ForwardHeaderModel;
import org.brightblock.comms.rest.models.ResponseCodes;
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
@CrossOrigin(origins = { "http://localhost:8080", "https://radicle.art", "https://brightblock.org" }, maxAge = 6000)
public class CollaborationController {

	@Autowired private CollaborationRepository collaborationRepository;

	@RequestMapping(value = "/comms/send-to", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel> findByToUser(HttpServletRequest request, @RequestBody CollaborationMessage message) {
		if (message.getDomain() == null) {
			message.setDomain(request.getHeader(ForwardHeaderModel.X_FORWARDED_HOST));
		}
		CollaborationMessage savedMessage = collaborationRepository.save(message);
		ApiModel model = ApiModel.getSuccess(ResponseCodes.OK, savedMessage);
		model.setHeaders(request);
		return new ResponseEntity<ApiModel>(model, HttpStatus.OK);
	}

	@RequestMapping(value = "/comms/find-to/{username}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel> findByToUser(HttpServletRequest request, @PathVariable String username) {
		List<CollaborationMessage> messages = collaborationRepository.findByRecipient(username);
		ApiModel model = ApiModel.getSuccess(ResponseCodes.OK, messages);
		model.setHeaders(request);
		return new ResponseEntity<ApiModel>(model, HttpStatus.OK);
	}

	@RequestMapping(value = "/comms/find-from/{username}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel> findByFromUser(HttpServletRequest request, @PathVariable String username) {
		List<CollaborationMessage> messages = collaborationRepository.findByRecipient(username);
		ApiModel model = ApiModel.getSuccess(ResponseCodes.OK, messages);
		model.setHeaders(request);
		return new ResponseEntity<ApiModel>(model, HttpStatus.OK);
	}

	@RequestMapping(value = "/comms/find-all", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ApiModel> findAll(HttpServletRequest request) {
		List<CollaborationMessage> messages = collaborationRepository.findAll();
		ApiModel model = ApiModel.getSuccess(ResponseCodes.OK, messages);
		model.setHeaders(request);
		return new ResponseEntity<ApiModel>(model, HttpStatus.OK);
	}

}
