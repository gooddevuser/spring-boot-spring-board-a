package com.springdemo.bootboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping(path = { "/", "/home" })
	public String home() {
		
		logger.trace("Trace Level Log from Home");
		logger.debug("Debug Level Log from Home");
		logger.info("Info Level Log from Home");
		logger.warn("Warn Level Log from Home");
		logger.error("Error Level Log from Home");
		
		return "home"; // /WEB-INF/views/home.jsp
		
	}
	
}
