package org.WorkWith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public void write() {
	}
	
	@RequestMapping(value = "/board/board", method = RequestMethod.GET)
	public void board() {
	}
	
	@RequestMapping(value = "/board/boardDetail", method = RequestMethod.GET)
	public void boardDetail() {
	}
}
