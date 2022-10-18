package org.WorkWith.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.WorkWith.model.BoardVO;
import org.WorkWith.service.BoardService;
import org.WorkWith.model.CriteriaVO;
import org.WorkWith.model.pageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		String name = (String) session.getAttribute("name");

		board.setId(id);
		board.setDepartment(department);
		board.setPosition(position);
		board.setName(name);
		System.out.println("board");
		bs.boardwrite(board);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/board/board", method = RequestMethod.GET)
	public String list(Model model, CriteriaVO cri) {
		// board.jsp 실행 할 때 공지가 select 된 결과를 가져가라.
		model.addAttribute("Notice",bs.Notice());
		// board.jsp 실행 할 때 select 된 결과를 가져가라.
		model.addAttribute("list", bs.list(cri));
		// board 폴더 안에 있는 board.jsp 실행 할 때 pageVO에 저장되어 있는 데이터를 가져와라.
		//							생성자 호출(매개변수가 없는 생성자)
		int total = bs.total(cri);
		model.addAttribute("paging", new pageVO(cri, total));
		
		// 공지가 1페이지에서만(검색결과는 제외) 보이기 위한 변수 선언
		String keyword = cri.getKeyword();
		model.addAttribute("keyword", keyword);
		return "board/board";
		
	}

	@RequestMapping(value = "/board/boardDetail", method = RequestMethod.GET)
	public void boardDetail() {
	}
}
