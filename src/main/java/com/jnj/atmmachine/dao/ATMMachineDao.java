package com.jnj.atmmachine.dao;

import java.util.List;

import com.jnj.atmmachine.model.Denomination;
import com.jnj.atmmachine.model.Withdrawal;

public interface ATMMachineDao {

	public long fethcATMBalance();

	public boolean validateWithdrawalAmount(int amount);
	
	public List<Denomination> dispenseMoney(int amount);
	
	public List<Withdrawal> fethcAllWithdrawals();
	
	public void updateAllWithdrawals(String accountNumber, int amount);
	
}
