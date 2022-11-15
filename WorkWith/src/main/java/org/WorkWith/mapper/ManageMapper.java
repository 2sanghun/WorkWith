package org.WorkWith.mapper;

import java.util.ArrayList;

import org.WorkWith.model.MemberVO;

public interface ManageMapper {
	// 사원 목록 가져오기
	public ArrayList<MemberVO> memberManage(MemberVO member);

	// 회원가입 목록 가져오기
	public ArrayList<MemberVO> signupManage(MemberVO member);

	// 사원 정보 변경
	public int member_update(MemberVO member);

	// 사원 퇴사
	public void quitMember(MemberVO member);

	// 회원가입 허가
	public int signupPermit(MemberVO member);

	// 회원가입 테이블에서 삭제
	public void signupRefuse(MemberVO member);

}
