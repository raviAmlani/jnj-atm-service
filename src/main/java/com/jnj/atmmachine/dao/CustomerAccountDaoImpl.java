package com.jnj.atmmachine.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.jnj.atmmachine.environment.ApplicationData;
import com.jnj.atmmachine.model.Customer;

public class CustomerAccountDaoImpl implements CustomerAccountDao {

	private ApplicationData applicationData;
	
	public ApplicationData getApplicationData() {
		return applicationData;
	}

	@Autowired
	public void setApplicationData(ApplicationData applicationData) {
		this.applicationData = applicationData;
	}

	@Override
	public boolean validateCustomer(String accountNumber, int pin) {
		
		Optional<Customer> customer = findCustomer(accountNumber);
		
		// TODO - change to custom exception
		int pinActual = customer.orElseThrow(NullPointerException::new).getPin();
		
		return pin == pinActual;
	}

	@Override
	public long fetchCustomerBalance(String accountNumber) {
		
		Optional<Customer> customer = findCustomer(accountNumber);
		
		// TODO - change to custom exception
		return customer.orElseThrow(NullPointerException::new).getBalance();
	}

	@Override
	public int fetchCustomerOverdraft(String accountNumber) {
		
		Optional<Customer> customer = findCustomer(accountNumber);
			
		// TODO - change to custom exception
		return customer.orElseThrow(NullPointerException::new).getOverdraft();
	}

	@Override
	public void updateCustomerBalance(String accountNumber, long customerBalanceNew) {
		
		Optional<Customer> customer = findCustomer(accountNumber);
		
		// TODO - change to custom exception
		customer.orElseThrow(NullPointerException::new).setBalance(customerBalanceNew);
	}
	
	@Override
	public void updateCustomerOverdraft(String accountNumber, int overdraftNew) {
		
		Optional<Customer> customer = findCustomer(accountNumber);
			
		// TODO - change to custom exception
		customer.orElseThrow(NullPointerException::new).setOverdraft(overdraftNew);
	}

	private Optional<Customer> findCustomer(String accountNumber) {
		
		Customer customerToBeUpdated = new Customer();
		customerToBeUpdated.setAccountNumber(accountNumber);
		
		return getApplicationData().getAtmMachine().getCustomersAll().stream().
				filter(c -> c.equals(customerToBeUpdated)).findFirst();
	}

}
