package org.WorkWith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManageController {
	
	@RequestMapping(value = "/manage/memberManage", method = RequestMethod.GET)
	public void memberManage() {
	}
}
