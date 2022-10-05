package org.WorkWith.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import org.WorkWith.service.MemberService;
import org.WorkWith.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@Autowired
	MemberService ms;
	
	@RequestMapping(value = "/main/login", method = RequestMethod.GET)
	public void login() {
	}
	
	@RequestMapping(value = "/main/idpwSearch", method = RequestMethod.GET)
	public void idpwSearch() {
	}
	
	@RequestMapping(value = "/main/signup", method = RequestMethod.GET)
	public void signup() {
	}
	
	@RequestMapping(value = "/main/idcheck", method = RequestMethod.POST)
	public ResponseEntity<Integer> idcheck(MemberVO member, HttpServletResponse response) throws IOException {
		System.out.println(member);
		int result = ms.idcheck(member);
		System.out.println(result);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
}
