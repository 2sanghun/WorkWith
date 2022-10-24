package org.WorkWith.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.WorkWith.model.BoardVO;
import org.WorkWith.model.MemberVO;
import org.WorkWith.service.BoardService;
import org.WorkWith.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyPageController {
	
	@Autowired
	MemberService ms;
	
	@Autowired
	BoardService bs;
	
	@RequestMapping(value = "/myInfo", method = RequestMethod.GET)
	public ResponseEntity<MemberVO> myInfo(MemberVO member) {
		MemberVO my = ms.myInfo(member);
		my.setAddr(my.getAddr().replace("/", " "));
		return new ResponseEntity<>(my, HttpStatus.OK);
	}

	@RequestMapping(value = "/myBoard", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<BoardVO>> myBoard(String id) {
		return new ResponseEntity<>(bs.myBoard(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/myPage/pwChange", method = RequestMethod.GET)
	public void pwChangepage() {
	}
	
	@RequestMapping(value = "/pwChange", method = RequestMethod.POST)
	public void pwChange(MemberVO member, HttpServletResponse response, String newPw) throws IOException  {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(ms.PwCheck(member)==0) {
			out.println("<script>alert('비밀번호를 확인해 주세요.'); location.href='/myPage/pwChange'</script>");
			out.flush();
			out.close();
		}else {
			member.setPassword(newPw);
			ms.newPw(member);
			out.println("<script>alert('비밀번호가 변경되었습니다.'); location.href='/board/board'</script>");
			out.flush();
			out.close();
		}
	}
	
}
