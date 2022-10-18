package org.WorkWith.service;

import java.util.ArrayList;

import org.WorkWith.mapper.BoardAttachMapper;
import org.WorkWith.mapper.BoardMapper;
import org.WorkWith.model.BoardVO;
import org.WorkWith.model.CriteriaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
		
	@Autowired
	BoardMapper bm;
	
	@Autowired
	BoardAttachMapper bam; 

	// 글쓰기 설계도를 보고 구현하기
	public void boardwrite(BoardVO board) {
		bm.boardwrite(board);
		System.out.println(board.getBno());
		System.out.println(board.getAttach());
		if (board.getAttach() != null) {
			board.getAttach().forEach(attach -> {
				attach.setBno(board.getBno());
				bam.insert(attach);
			});
		}
	}
	
	// ListService에서 설계되어 진 list 추상메서드를  구현
	public ArrayList<BoardVO> list(CriteriaVO cri){
		return bm.list(cri);
	}
	
	// 공지글 목록 리스트 설계
	public ArrayList<BoardVO> Notice(){
		return bm.Notice();
	}
	
	// ListService에서 설계되어 진 total 추상메서드를 구현
	public int total(CriteriaVO cri) {
		return bm.total(cri);
	}

}
