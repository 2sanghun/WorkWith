package org.WorkWith.service;

import java.util.ArrayList;

import org.WorkWith.model.MemberVO;

public interface ManageService {
	public ArrayList<MemberVO> memberManage(MemberVO member);

	public int mamber_update(MemberVO member);
	
	public void quitMember(MemberVO member);

}
