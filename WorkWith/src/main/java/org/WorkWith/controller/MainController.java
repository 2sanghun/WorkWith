package org.WorkWith.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value = "/main/login", method = RequestMethod.POST)
	public String login(MemberVO member, HttpSession session,HttpServletResponse response) throws IOException {
		MemberVO a = ms.login(member);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(a!=null) {
			String id = a.getId();
			String position = a.getPosition();
			session.setAttribute("id",id);
			session.setAttribute("position", position);
		}else {
			out.println("<script>alert('아이디, 비밀번호를 확인해 주세요'); </script>");
			out.flush();
			return "/main/login";
		}
		return "redirect:/board/board";
	}
	
	@RequestMapping(value = "/main/idpwSearch", method = RequestMethod.GET)
	public void idpwSearch() {
	}
	
	@RequestMapping(value = "/main/emplno", method = RequestMethod.GET)
	public ResponseEntity<Integer> emplno(MemberVO member, HttpServletResponse response) throws IOException {	
		int result = ms.emplno(member);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/main/idcheck", method = RequestMethod.POST)
	public ResponseEntity<Integer> idcheck(MemberVO member, HttpServletResponse response) throws IOException {
		int result = ms.idcheck(member);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/main/signup", method = RequestMethod.GET)
	public void signup() {
	}
	
	@RequestMapping(value = "/main/signup", method = RequestMethod.POST)
	public String signupPost(MemberVO member) {
		member.setEmail(member.getEmail().replace(",", ""));
		member.setPhone(member.getPhone().replace(",", "-"));
		member.setAddr(member.getAddr().replace(",", "/"));
		ms.signup(member);
		return "/main/login";
	}
	
	
}
