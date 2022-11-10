package org.WorkWith.mapper;

import java.util.ArrayList;

import org.WorkWith.model.MemberVO;

public interface ManageMapper {
	public ArrayList<MemberVO> memberManage(MemberVO member);

	public int member_update(MemberVO member);
	
	public void quitMember(MemberVO member);

}
