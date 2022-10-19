package org.WorkWith.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.WorkWith.model.BoardVO;
import org.WorkWith.service.BoardService;
import org.WorkWith.model.AttachFileVO;
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
import org.springframework.web.bind.annotation.ResponseBody;

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
	   public String detail(BoardVO board, Model model) {
	      model.addAttribute("detail", bs.detail(board));
	      return "board/boardDetail";
	   }
	
	   //@RequestMapping(value = "/detail/modify", method = RequestMethod.POST)
	   @RequestMapping(value = "/detail/modify", method = RequestMethod.PUT)
	   //public String modify(BoardVO board, RedirectAttributes rttr) {
	   public ResponseEntity <String> modify(@RequestBody BoardVO board) {	
		   int result = bs.modify(board);
		   return result==1? new ResponseEntity<> ("success", HttpStatus.OK)
			               : new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
	   @RequestMapping(value = "/board/addAttach", method = RequestMethod.POST)
	   public ResponseEntity <String> addAttach(@RequestBody ArrayList<AttachFileVO> attach) {	
		   int result = bs.addAttach(attach);
		   System.out.println(result);
		   return result==1? new ResponseEntity<> ("success", HttpStatus.OK)
			               : new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
	// @RequestMapping(value = "/detail/remove", method = RequestMethod.POST)
	   @RequestMapping(value = "/detail/remove", method = RequestMethod.GET)
	   public String remove(BoardVO board) {
	      bs.remove(board);
	      return "redirect:/board/board";
	   }
	   
	   // 해당게시물의 첨부파일의 데이터를 ajax로 전송
	   @RequestMapping(value = "/attachlist", method = RequestMethod.GET)
	   public ResponseEntity<ArrayList<AttachFileVO>> attachlist(int bno){
		   return new ResponseEntity<>(bs.attachlist(bno), HttpStatus.OK);
	   }
	   
	   
	   @RequestMapping(value = "/attach/remove", method = RequestMethod.DELETE)
	   public ResponseEntity <String> attachremove (@RequestBody AttachFileVO attach){
		   int result = bs.attachremove(attach);
		   return result==1? new ResponseEntity<> ("success", HttpStatus.OK)
				   			: new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
	   }
}
