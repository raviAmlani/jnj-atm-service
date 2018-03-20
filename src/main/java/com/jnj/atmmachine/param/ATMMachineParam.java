package com.jnj.atmmachine.param;

import com.jnj.atmmachine.model.Customer;

public class ATMMachineParam {

	private int withdrawalAmount;
	
	private Customer customer;

	public int getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(int withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
