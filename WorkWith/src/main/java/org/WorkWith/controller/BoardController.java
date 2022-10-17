package org.WorkWith.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.WorkWith.model.BoardVO;
import org.WorkWith.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public void write() {
	}

	// 글쓰기에서 카테고리, 제목, 내용을 DB로 보내기 위한 back작업을 위한...
	@RequestMapping(value = "/main/write", method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
	public ResponseEntity<String> writePost(HttpServletRequest request, @RequestBody BoardVO board) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String department = (String) session.getAttribute("department");
		String position = (String) session.getAttribute("position");

		board.setId(id);
		board.setDepartment(department);
		board.setPosition(position);
		System.out.println("board");
		bs.boardwrite(board);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@RequestMapping(value = "/board/board", method = RequestMethod.GET)
	public void board() {
	}

	@RequestMapping(value = "/board/boardDetail", method = RequestMethod.GET)
	public void boardDetail() {
	}
}
