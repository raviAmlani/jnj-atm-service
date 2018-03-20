package com.jnj.atmmachine.validator;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ATMMachineRequestValidatorUnitTest {

	@Test
	public void test_validateAccountNumber_validPin() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method validatePinMethod
	      = ATMMachineRequestValidator.class.getDeclaredMethod("validatePin", int.class);
	 
		validatePinMethod.setAccessible(true);
		ATMMachineRequestValidator atnMachineRequestValidator = new ATMMachineRequestValidator();
	    boolean result 
	      = (boolean) validatePinMethod.invoke(atnMachineRequestValidator, 1111);
	    
	    assertTrue(result);
	 
	}
	
	// TODO - negative scenarios and more test cases
	
}
