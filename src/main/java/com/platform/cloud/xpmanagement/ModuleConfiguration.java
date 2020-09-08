package com.platform.cloud.xpmanagement;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
*
* @author Zhang Yuhao <yuhao.zhang94@gmail.com>
* Created on: 7/9/2020
*/
@Configuration
@ConfigurationProperties(prefix = "app")
public class ModuleConfiguration {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ModuleConfiguration.class);
	
	private String name;
	
	@PostConstruct
    private void init() {
        printProperties();
    }
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private void printProperties() {
        LOGGER.info("PROPERTIES: 'name={}'", name);
    }
}
