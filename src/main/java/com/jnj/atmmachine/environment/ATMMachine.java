package com.jnj.atmmachine.environment;

import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.jnj.atmmachine.model.Customer;
import com.jnj.atmmachine.model.Denomination;
import com.jnj.atmmachine.model.Withdrawal;

@ConfigurationProperties(prefix="com.jnj.atmmachine.resourcemappings")
public class ATMMachine {

	private TreeSet<Denomination> denominationAll;
	
	private List<Customer> customersAll;
	
	private List<Withdrawal> withdrawalsAll;
	
	private long balanceMoney;

	public TreeSet<Denomination> getDenominationAll() {
		return denominationAll;
	}

	public void setDenominationAll(TreeSet<Denomination> denominationAll) {
		this.denominationAll = denominationAll;
	}

	public List<Customer> getCustomersAll() {
		return customersAll;
	}

	public void setCustomersAll(List<Customer> customersAll) {
		this.customersAll = customersAll;
	}
	
	public long getBalanceMoney() {
		
		long balanceMoney = 0;
		Iterator<Denomination> iterator = this.denominationAll.iterator();
		
		while (iterator.hasNext()) {
			Denomination d = iterator.next();
			balanceMoney += (d.getNoteValue() * d.getNoteQuantity()); 
		}
		
		return balanceMoney;
	}

	public List<Withdrawal> getWithdrawalsAll() {
		return withdrawalsAll;
	}

	public void setWithdrawalsAll(List<Withdrawal> withdrawalsAll) {
		this.withdrawalsAll = withdrawalsAll;
	}

}
