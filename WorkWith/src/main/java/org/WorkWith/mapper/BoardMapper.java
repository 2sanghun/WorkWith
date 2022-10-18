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
}
