package com.jnj.atmmachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.jnj.atmmachine.environment.ATMMachine;

/**
 *  * @author RaviAmlani
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.jnj.atmmachine.configuration", "com.jnj.atmmachine.http.controller"})
//@ComponentScan
//@EnableConfigurationProperties
@EnableConfigurationProperties(ATMMachine.class)
@EnableAutoConfiguration
public class ATMMachineApplication
{
    public static void main( String[] args )
    {
        System.out.println("Starting ATMApplication..." );
        
        SpringApplication.run(ATMMachineApplication.class, args);
    }
}
