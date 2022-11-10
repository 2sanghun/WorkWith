package org.WorkWith.service;

import java.util.ArrayList;

import org.WorkWith.model.MemberVO;

public interface ManageService {
	// 사원 목록 가져오기
	public ArrayList<MemberVO> memberManage(MemberVO member);
	
	// 사원 정보 변경
	public int mamber_update(MemberVO member);
	
	// 사원 퇴사
	public void quitMember(MemberVO member);

}
