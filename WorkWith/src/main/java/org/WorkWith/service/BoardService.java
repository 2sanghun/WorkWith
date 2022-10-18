package org.WorkWith.service;

import java.util.ArrayList;

import org.WorkWith.model.BoardVO;
import org.WorkWith.model.CriteriaVO;

public interface BoardService {
	
	public void boardwrite(BoardVO board);
	
	public ArrayList<BoardVO> Notice();
	
	public ArrayList<BoardVO> list(CriteriaVO cri);
	
	public int total(CriteriaVO cri);
}
