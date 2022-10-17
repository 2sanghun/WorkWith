package org.WorkWith.service;

import org.WorkWith.mapper.BoardAttachMapper;
import org.WorkWith.mapper.BoardMapper;
import org.WorkWith.model.BoardVO;
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

}
