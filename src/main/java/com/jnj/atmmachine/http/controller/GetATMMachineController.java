package com.jnj.atmmachine.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jnj.atmmachine.constants.ATMMachineEndPoints;
import com.jnj.atmmachine.param.ATMMachineParam;
import com.jnj.atmmachine.result.ATMMachineRequestResult;
import com.jnj.atmmachine.service.GetATMMachineService;

@RestController
public class GetATMMachineController {

	private GetATMMachineService getRequestService;
	
	private ControllerHelper controllerHelper;
	
	public GetATMMachineService getGetRequestService() {
		return getRequestService;
	}

	@Autowired
	public void setGetRequestService(GetATMMachineService getRequestService) {
		this.getRequestService = getRequestService;
	}

	public ControllerHelper getControllerHelper() {
		return controllerHelper;
	}

	@Autowired
	public void setControllerHelper(ControllerHelper controllerHelper) {
		this.controllerHelper = controllerHelper;
	}

	@RequestMapping(path = ATMMachineEndPoints.ATMMACHINE_GET_BALANCE_ENQUIRY_ENDPOINT,
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ATMMachineRequestResult> getBalanceEnquiry(
					@RequestParam("accountNumber") String accountNumber, 
					@RequestParam("pin") String pin) {
		
		System.out.println("In getBalanceEnquiry() for: "+accountNumber);
		
		ATMMachineParam inputParam = getControllerHelper().createParam(accountNumber, Integer.parseInt(pin));
		
		ATMMachineRequestResult requestResult = getGetRequestService().execute(inputParam);
		
		ResponseEntity<ATMMachineRequestResult> response = getControllerHelper().createResponse(requestResult);
		
		System.out.println("Leaving getBalanceEnquiry()");
		
		return response;
	}

}
