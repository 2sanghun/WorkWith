package org.WorkWith.service;

import org.WorkWith.mapper.MemberMapper;
import org.WorkWith.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper mm;
	
	public int idcheck(MemberVO member) {
		return mm.idcheck(member);
	}
	
	public int emplno(MemberVO member) {
		return mm.emplno(member);
	}
	
	public void signup(MemberVO member) {
		mm.signup(member);
	}
	
	public MemberVO login(MemberVO member) {
		return mm.login(member);
	}
}
