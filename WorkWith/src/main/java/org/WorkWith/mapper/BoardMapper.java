package org.WorkWith.mapper;

import java.util.ArrayList;

import org.WorkWith.model.BoardVO;
import org.WorkWith.model.CriteriaVO;

public interface BoardMapper {

	public void boardwrite(BoardVO board);

	// 전체 게시글 목록 리스트에 해당되는 DB작업 설계
	public ArrayList<BoardVO> list(CriteriaVO cri);

	// 매니저 글 목록 리스트에 해당되는 DB작업 설계
	public ArrayList<BoardVO> Notice();

	// board 테이블 전체건수 DB설계
	public int total(CriteriaVO cri);

	// 목록에서 제목을 클릭한 후 상세 내용을 조회하는 DB작업 설계
	public BoardVO detail(BoardVO board);

	// 목록에서 제목을 클릭한 후 상세 내용을 조회할 때 조회수도 같이 update하는 DB작업 설계
	public void cntup(BoardVO board);

	// 상세내용에 해당되는 내용을 수정하는 DB작업 설계
	public int modify(BoardVO board);

	// 상세내용에 해당되는 내용을 삭제하는 DB작업 설계
	public void remove(BoardVO board);
}
