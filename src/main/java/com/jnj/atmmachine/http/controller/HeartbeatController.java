package com.jnj.atmmachine.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jnj.atmmachine.environment.ApplicationData;

@RestController
public class HeartbeatController {

	private ApplicationData applicationData;
	
	public ApplicationData getApplicationData() {
		return applicationData;
	}

	@Autowired
	public void setApplicationData(ApplicationData appData) {
		this.applicationData = appData;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> heartbeat() {
		
		System.out.println(getApplicationData().getAtmMachine().getCustomersAll());
		System.out.println(getApplicationData().getAtmMachine().getDenominationAll());
		System.out.println(getApplicationData().getAtmMachine().getBalanceMoney());
		
		return new ResponseEntity<String>("ATM is running", HttpStatus.OK);
	}
}
