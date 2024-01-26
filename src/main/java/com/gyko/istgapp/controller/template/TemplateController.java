package com.gyko.istgapp.controller.template;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/")
	public ModelAndView content(
			@RequestParam(required = false, name = "name") String name) throws UnknownHostException {
		
		
		log.debug("logger name :  " + name);
		
		ModelAndView model = new ModelAndView();
		
		model.setViewName("content");
		model.addObject("name", name);
		model.addObject("hostname", InetAddress.getLocalHost().getHostAddress());
		
		return model;
	}
}
