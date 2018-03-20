package com.jnj.atmmachine.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.jnj.atmmachine.helper.ErrorMessageProvider;
import com.jnj.atmmachine.manager.ATMMachineRequestManager;
import com.jnj.atmmachine.param.ATMMachineParam;
import com.jnj.atmmachine.result.ATMMachineRequestResult;
import com.jnj.atmmachine.validator.ATMMachineRequestValidator;

public class PostATMMachineService extends AbstractService {

	private ATMMachineRequestValidator requestValidator;
	
	private ATMMachineRequestManager requestManager;
	
	private ErrorMessageProvider errorMessagesProvider;
	
	public ATMMachineRequestValidator getRequestValidator() {
		return requestValidator;
	}

	@Autowired
	public void setRequestValidator(ATMMachineRequestValidator requestValidator) {
		this.requestValidator = requestValidator;
	}

	public ATMMachineRequestManager getRequestManager() {
		return requestManager;
	}

	@Autowired
	public void setRequestManager(ATMMachineRequestManager requestManager) {
		this.requestManager = requestManager;
	}
	
	public ErrorMessageProvider getErrorMessagesProvider() {
		return errorMessagesProvider;
	}

	@Autowired
	public void setErrorMessagesProvider(ErrorMessageProvider errorMessagesProvider) {
		this.errorMessagesProvider = errorMessagesProvider;
	}

	public ATMMachineRequestResult execute(ATMMachineParam inputParam) {
		
		System.out.println("In service execution");
		ATMMachineRequestResult requestResult = null;
		
		try {
			// Do validation here
			
			getRequestValidator().validateCustomerAccount(inputParam.getCustomer().getAccountNumber(), inputParam.getCustomer().getPin());
			requestResult = getRequestManager().withdrawMoney(inputParam.getCustomer().getAccountNumber(), 
															inputParam.getWithdrawalAmount());
			
		} catch (Exception e) {
			e.printStackTrace();
			
			requestResult = prepareErrorResponse(e.getMessage());
		}
		
		System.out.println("Leaving service execution");
		
		return requestResult;
	}

}
