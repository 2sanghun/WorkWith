package org.WorkWith.service;

import org.WorkWith.model.MemberVO;

public interface MemberService {
	// 아이디 중복확인
	public int idcheck(MemberVO member);
	
	// 사원번호 관련 중복 개수
	public int emplno(MemberVO member);
}
