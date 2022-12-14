package org.WorkWith.mapper;

import org.WorkWith.model.MemberVO;

public interface MemberMapper {
	public int idcheck(MemberVO member);

	public int emplno(MemberVO member);

	public void signup(MemberVO member);

	public MemberVO login(MemberVO member);

	public String idsearch(MemberVO member);

	public void findPw(MemberVO member);
	public int findPwCheck(MemberVO member);
	
	public MemberVO myInfo(MemberVO member);
	
	public int PwCheck(MemberVO member);
	
	public void newPw(MemberVO member);
}
