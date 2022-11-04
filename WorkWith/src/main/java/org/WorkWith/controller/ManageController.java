package org.WorkWith.controller;

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
	
	@RequestMapping(value = "/memberManage", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<MemberVO>> memberManage(MemberVO member) {
		return new ResponseEntity<>(ms.memberManage(member), HttpStatus.OK);
	}
}
