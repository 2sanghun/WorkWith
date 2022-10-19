package org.WorkWith.service;

import java.util.ArrayList;

import org.WorkWith.mapper.BoardAttachMapper;
import org.WorkWith.mapper.BoardMapper;
import org.WorkWith.model.BoardVO;
import org.WorkWith.model.CriteriaVO;
import org.WorkWith.model.AttachFileVO;
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

	// BoardService에서 설계되어 진 list 추상메서드를 구현
	public ArrayList<BoardVO> list(CriteriaVO cri) {
		return bm.list(cri);
	}

	// 공지글 목록 리스트 설계
	public ArrayList<BoardVO> Notice() {
		return bm.Notice();
	}

	// BoardService에서 설계되어 진 total 추상메서드를 구현
	public int total(CriteriaVO cri) {
		return bm.total(cri);
	}

	public BoardVO detail(BoardVO board) {
		bm.cntup(board);

		return bm.detail(board);
	}

	public int modify(BoardVO board) {
		System.out.println(board);
		int result = bm.modify(board);
		return result;
	}
	
	public int addAttach(ArrayList<AttachFileVO> attach) {
		if(attach.size()>0) {
		attach.forEach(newAttach ->{
			bam.insert(newAttach);
		});
			return 1;
		}else{
			return 0;
		}
	}

	public void remove(BoardVO board) {
		bm.remove(board);
	}

	// 첨부파일 조회 구현
	// public ArrayList<AttachFileVO> attachlist(int bno){
	public ArrayList<AttachFileVO> attachlist(int bno) {
		return bam.attachlist(bno);
	}
	
	public int attachremove(AttachFileVO attach) {
		return bam.attachremove(attach);
	}

}
