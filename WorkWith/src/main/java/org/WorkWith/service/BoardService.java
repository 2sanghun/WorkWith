package org.WorkWith.service;

import java.util.ArrayList;

import org.WorkWith.model.BoardVO;
import org.WorkWith.model.CriteriaVO;
import org.WorkWith.model.AttachFileVO;

public interface BoardService {

	public void boardwrite(BoardVO board);

	public ArrayList<BoardVO> Notice();

	public ArrayList<BoardVO> list(CriteriaVO cri);

	public int total(CriteriaVO cri);

	// 글 상세 내용 보기 설계
	public BoardVO detail(BoardVO board);

	// 글 수정 설계
	public int modify(BoardVO board);

	// 첨부파일 추가 
	public int addAttach(ArrayList<AttachFileVO> attach);
	
	// 글 삭제 설계
	public void remove(BoardVO board);

	// 첨부파일 조회 설계
	// public ArrayList<AttachFileVO> attachlist (int bno);
	public ArrayList<AttachFileVO> attachlist(int bno);

	public int attachremove(AttachFileVO attach);
}
