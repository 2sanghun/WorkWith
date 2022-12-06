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
	public String login(HttpSession session) {
		if (session.getAttribute("id") != null) {
			return "redirect:/board/board";
		}else { 
			return "/main/login";
		}
	}

	@RequestMapping(value = "/main/login", method = RequestMethod.POST)
	public String login(MemberVO member, HttpSession session, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		MemberVO a = ms.login(member);
		if (a != null) {
			String id = a.getId();
			String position = a.getPosition();
			String department = a.getDepartment();
			String name = a.getName();
			session.setAttribute("id", id);
			session.setAttribute("position", position);
			session.setAttribute("department", department);
			session.setAttribute("name", name);
		} else {
			out.println("<script>alert('아이디, 비밀번호를 확인해 주세요');location.href='/main/login'</script>");
			out.flush();
			out.close();
			return "/main/login";
		}
		return "redirect:/board/board";
	}

	@RequestMapping(value = "/main/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/login";
	}

	@RequestMapping(value = "/main/emplno", method = RequestMethod.GET)
	public ResponseEntity<Integer> emplno(MemberVO member) {
		int result = ms.emplno(member);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/main/idcheck", method = RequestMethod.POST)
	public ResponseEntity<Integer> idcheck(MemberVO member) {
		int result = ms.idcheck(member);
		return new ResponseEntity<>(result, HttpStatus.OK);
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
		return "redirect:/main/login";
	}

	@RequestMapping(value = "/main/idpwSearch", method = RequestMethod.GET)
	public void idpwSearch() {
	}

	@RequestMapping(value = "/main/idsearch", method = RequestMethod.POST)
	public void idsearch(MemberVO member, HttpServletResponse response) throws IOException {
		String id = ms.idsearch(member);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (id != null) {
			int a = id.length() / 2;
			String b = "";
			String serid;
			for (int i = 0; i < a; i++) {
				b += "*";
			}
			if (id.length() % 2 == 0) {
				serid = id.substring(0, a) + b;
			} else {
				serid = id.substring(0, a) + b + "*";
			}
			out.println("<script>alert('아이디:" + serid + "');location.href='/main/login'</script>");
			out.flush();
			out.close();
		} else {
			out.println("<script>alert('아이디를 찾을 수 없습니다.');location.href='/main/idpwSearch'</script>");
			out.flush();
			out.close();
		}
	}

	// 비밀번호 찾기
	@RequestMapping(value = "/main/pwsearch", method = RequestMethod.POST)
	public void pwsearch(MemberVO member, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (ms.findPwCheck(member) == 0) {
			out.println("<script>alert('아이디와 이메일을 확인해 주세요');location.href='/main/idpwSearch'</script>");
			out.flush();
			out.close();
		} else {
			ms.findPw(member);
			out.println("<script>alert('이메일에서 임시 비밀번호를 확인해주세요.');location.href='/main/login'</script>");
			out.flush();
			out.close();
		}
	}
}
