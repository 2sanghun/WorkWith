package org.WorkWith.service;

import java.util.ArrayList;

import org.WorkWith.mapper.ManageMapper;
import org.WorkWith.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl implements ManageService{
	
	@Autowired
	ManageMapper mm;
	
	// 사원 목록 가져오기
	public ArrayList<MemberVO> memberManage(MemberVO member) {
		return mm.memberManage(member);
	}
	
	// 사원 정보 변경
	public int mamber_update(MemberVO member) {
		return mm.member_update(member);
	}

	// 사원 퇴사
	public void quitMember(MemberVO member) {
		mm.quitMember(member);
	}

}
