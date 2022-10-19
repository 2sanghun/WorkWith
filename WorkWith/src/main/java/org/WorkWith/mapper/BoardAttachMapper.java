package org.WorkWith.mapper;

import java.util.ArrayList;

import org.WorkWith.model.AttachFileVO;
  
public interface BoardAttachMapper {
	
	public void insert(AttachFileVO attach);
	
	// 해당게시물의 첨부파일 조회
	public ArrayList<AttachFileVO> attachlist(int bno);

	// 해당게시물의 첨부파일 삭제
	public int attachremove(AttachFileVO attach);
}
