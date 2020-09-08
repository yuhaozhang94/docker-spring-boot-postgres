package com.platform.cloud.xpmanagement;

import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;

/**
*
* @author Zhang Yuhao <yuhao.zhang94@gmail.com>
* Created on: 7/9/2020
*/
@SpringBootApplication
public class AppStarter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppStarter.class);
    
    public static void main(String[] args) {
        String version = AppStarter.class.getPackage().getImplementationVersion();
        LOGGER.info("Starting Experience Management with version: {}", version);
        SpringApplication.run(AppStarter.class, args);
    }

    @EventListener
    private void appStarted(ApplicationReadyEvent event) {
        LOGGER.info("Application started.");
    }

    @PreDestroy
    private void appStopped() {
        LOGGER.info("Application stopped.");
    }

}
