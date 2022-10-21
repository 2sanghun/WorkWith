package org.WorkWith.controller;
import java.util.ArrayList;

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
}
