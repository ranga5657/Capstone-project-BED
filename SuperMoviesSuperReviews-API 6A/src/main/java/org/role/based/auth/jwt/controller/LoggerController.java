package org.role.based.auth.jwt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4203")
public class LoggerController {
	
	Logger logger = LoggerFactory.getLogger(LoggerController.class);
	
	
	//@PreAuthorize("hasRole('Admin')")
	
	@RequestMapping("/logs")
	
	public String log() {
		
		logger.trace("Log Level : This is a TRACE Message");
		logger.info("Log Level : This is a Info Message");
		logger.debug("Log Level :This is a Debug Message");
		logger.error("Log Level : This is a Error Message");
		logger.warn("Log Level :This is a Warn Message");
		
		
		return "Hey Ranga You can check the logs Here....!!! ";
	
		
		
		
		
	}

}
