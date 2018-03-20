package com.jnj.atmmachine.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.jnj.atmmachine.constants.ATMMachineConstants;
import com.jnj.atmmachine.constants.ATMMachineErrorKeys;
import com.jnj.atmmachine.dao.CustomerAccountDao;
import com.jnj.atmmachine.exception.ValidationException;

public class ATMMachineRequestValidator {

	private CustomerAccountDao customerAccountDao;
	
	public CustomerAccountDao getCustomerAccountDao() {
		return customerAccountDao;
	}

	@Autowired
	public void setCustomerAccountDao(CustomerAccountDao customerAccountDao) {
		this.customerAccountDao = customerAccountDao;
	}

	public void validateCustomerAccount(String accountNumber, int pin) {
		if (validateAccountNumber(accountNumber) && validatePin(pin)) {
			boolean isPinValid = false;
			try {
				isPinValid = getCustomerAccountDao().validateCustomer(accountNumber, pin);
			} catch (Exception e) {
				throw new ValidationException(ATMMachineErrorKeys.BAD_REQUEST.getErrorKey(), e);
			}
			
			if(!isPinValid) {
				throw new ValidationException(ATMMachineErrorKeys.AUTHENTICATION_ERROR.getErrorKey());
			}
		}
	}
	
	private boolean validateAccountNumber(String accountNumber) {
		if (accountNumber.length() != ATMMachineConstants.CUSTOMER_ACCOUNT_NUMBER_LENGTH) {
			throw new ValidationException(ATMMachineErrorKeys.BAD_REQUEST.getErrorKey());
		} else {
			return true;
		}
	}
	
	private boolean validatePin(int pin) {
		String pinStr = pin + "";
		if (pinStr.length() != ATMMachineConstants.CUSTOMER_ACCOUNT_PIN_LENGTH) {
			throw new ValidationException(ATMMachineErrorKeys.BAD_REQUEST.getErrorKey());
		} else {
			return true;
		}
	}
	
}
