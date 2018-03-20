package com.jnj.atmmachine.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jnj.atmmachine.dao.ATMMachineDao;
import com.jnj.atmmachine.dao.ATMMachineDaoImpl;
import com.jnj.atmmachine.dao.CustomerAccountDao;
import com.jnj.atmmachine.dao.CustomerAccountDaoImpl;
import com.jnj.atmmachine.environment.ApplicationData;
import com.jnj.atmmachine.helper.ErrorMessageProvider;
import com.jnj.atmmachine.http.controller.ControllerHelper;
import com.jnj.atmmachine.manager.ATMMachineRequestManager;
import com.jnj.atmmachine.service.GetATMMachineService;
import com.jnj.atmmachine.service.PostATMMachineService;
import com.jnj.atmmachine.validator.ATMMachineRequestValidator;

@Configuration
public class GeneralBeanConfiguration {

	@Bean
	public ApplicationData applicationData() {
		return new ApplicationData();
	}
	
	@Bean
	public GetATMMachineService getATMMachineService() {
		return new GetATMMachineService();
	}
	
	@Bean
	public PostATMMachineService postATMMachineService() {
		return new PostATMMachineService();
	}
	
	@Bean
	public ATMMachineRequestManager atmMachineRequestManager() {
		return new ATMMachineRequestManager();
	}
	
	@Bean
	public ATMMachineDao atmMachineDao() {
		return new ATMMachineDaoImpl();
	}
	
	@Bean
	public CustomerAccountDao customerAccountDao() {
		return new CustomerAccountDaoImpl();
	}
	
	@Bean
	public ATMMachineRequestValidator atmMachineRequestValidator() {
		return new ATMMachineRequestValidator();
	}
	
	@Bean
	public ErrorMessageProvider errorMessageProvider(@Value("${com.jnj.atmmachine.errors.file}") String messageFilePath) {
		return new ErrorMessageProvider(messageFilePath);
	}
	
	@Bean
	public ControllerHelper controllerHelper() {
		return new ControllerHelper();
	}
	
}
