package org.WorkWith.service;

import java.util.ArrayList;

import org.WorkWith.mapper.ManageMapper;
import org.WorkWith.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl implements ManageService {

	@Autowired
	ManageMapper mm;

	// 사원 목록 가져오기
	public ArrayList<MemberVO> memberManage(MemberVO member) {
		return mm.memberManage(member);
	}

	// 회원가입 목록 가져오기
	public ArrayList<MemberVO> signupManage(MemberVO member) {
		return mm.signupManage(member);
	}

	// 사원 정보 변경
	public int mamber_update(MemberVO member) {
		return mm.member_update(member);
	}

	// 사원 퇴사
	public void quitMember(MemberVO member) {
		mm.quitMember(member);
	}

	// 회원가입 허가
	public int signupPermit(MemberVO member) {
		return mm.signupPermit(member);
	}

	// 회원가입 테이블에서 삭제
	public void signupRefuse(MemberVO member) {
		mm.signupRefuse(member);
	}

}
