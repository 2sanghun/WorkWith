package org.WorkWith.service;

import org.WorkWith.model.MemberVO;

public interface MemberService {
	// 아이디 중복확인
	public int idcheck(MemberVO member);

	// 사원번호 관련 중복 개수
	public int emplno(MemberVO member);

	// 회원가입
	public void signup(MemberVO member);

	// 로그인
	public MemberVO login(MemberVO member);

	// 아이디 찾기
	public String idsearch(MemberVO member);

	// 비밀번호 찾기(메일 관련)
	public int findPwCheck(MemberVO member) throws Exception;
	public void findPw(MemberVO member) throws Exception;
	
	public MemberVO myInfo(MemberVO member);
}
