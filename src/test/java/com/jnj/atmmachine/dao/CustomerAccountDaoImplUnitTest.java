package com.jnj.atmmachine.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.jnj.atmmachine.environment.ApplicationData;
import com.ravi.atmmachine.utility.TestUtility;

@RunWith(MockitoJUnitRunner.class)
public class CustomerAccountDaoImplUnitTest {

	@InjectMocks
	CustomerAccountDaoImpl customerDaoImpl;
	
	@Mock
	ApplicationData applicationData = TestUtility.getApplicationData();
	
	@Test
	public void test_fetchCustomerBalance_validInput() {
		
		String inputAccountNumber = "111111111";
		Mockito.when(applicationData.getAtmMachine()).thenReturn(TestUtility.getAtmMachine());
		
		long balance = customerDaoImpl.fetchCustomerBalance(inputAccountNumber);
		
		assertEquals(100, balance);
	}
	
	@Test(expected = NullPointerException.class)
	public void test_fetchCustomerBalance_invalidInput() {
		
		String inputAccountNumber = "1";
		Mockito.when(applicationData.getAtmMachine()).thenReturn(TestUtility.getAtmMachine());
		
		customerDaoImpl.fetchCustomerBalance(inputAccountNumber);
	}
	
	// TODO - more test cases
	
}
