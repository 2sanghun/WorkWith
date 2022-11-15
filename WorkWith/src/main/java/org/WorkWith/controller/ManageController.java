package org.WorkWith.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.WorkWith.model.MemberVO;
import org.WorkWith.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManageController {

	@Autowired
	ManageService ms;

	@RequestMapping(value = "/manage/manage", method = RequestMethod.GET)
	public void manage() {
	}

	// 사원 목록
	@RequestMapping(value = "/memberManage", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<MemberVO>> memberManage(MemberVO member) {
		return new ResponseEntity<>(ms.memberManage(member), HttpStatus.OK);
	}

	// 회원가입 목록
	@RequestMapping(value = "/signupManage", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<MemberVO>> signupManage(MemberVO member) {
		return new ResponseEntity<>(ms.signupManage(member), HttpStatus.OK);
	}

	// 사원 정보 변경
	@RequestMapping(value = "/member_update", method = RequestMethod.POST)
	public ResponseEntity<String> member_update(MemberVO member) {
		int result = ms.mamber_update(member);
		return result == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 사원 퇴사
	@RequestMapping(value = "/quitMember", method = RequestMethod.POST)
	public String quitMember(MemberVO member) {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		member.setEnddate(date.format(formatter));
		ms.quitMember(member);
		return "redirect:/manage/manage";
	}

	// 회원가입 허가
	@RequestMapping(value = "/signupPermit", method = RequestMethod.POST)
	public ResponseEntity<String> signupPermit(MemberVO member) {
		int result = ms.signupPermit(member);
		if(result==1) {
			ms.signupRefuse(member);
		}
		return result == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// 회원가입 거절
	@RequestMapping(value = "/signupRefuse", method = RequestMethod.POST)
	public String signupRefuse(MemberVO member) {
		ms.signupRefuse(member);
		return "redirect:/manage/manage";
	}

}
