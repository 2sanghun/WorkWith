package org.WorkWith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	
	@RequestMapping(value = "/main/login", method = RequestMethod.GET)
	public void login() {
	}
	
	@RequestMapping(value = "/main/idpwSearch", method = RequestMethod.GET)
	public void idpwSearch() {
	}
	
	@RequestMapping(value = "/main/signup", method = RequestMethod.GET)
	public void signup() {
	}
}
