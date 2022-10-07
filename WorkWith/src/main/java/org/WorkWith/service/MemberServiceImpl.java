package org.WorkWith.service;

import org.WorkWith.mail.MailUtils;
import org.WorkWith.mail.TempKey;
import org.WorkWith.mapper.MemberMapper;
import org.WorkWith.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberMapper mm;
	
	@Autowired
	private JavaMailSender mailSender;
	
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
	
	public String idsearch(MemberVO member) {
		return mm.idsearch(member);
	}
	
	public int findPwCheck(MemberVO member) {
		return mm.findPwCheck(member);
	}
	public void findPw(MemberVO member) throws Exception {
		String memberKey = new TempKey().getKey(6,false);
		MailUtils sendMail = new MailUtils(mailSender);
		sendMail.setSubject("[WorkWith 임시 비밀번호 입니다.]");
		sendMail.setText(
					"<h1>임시 비밀번호 발급</h1>"+
							"<br/>"+member.getId()+"님"+
							"<br/>비밀번호 찾기를 통한 임시 비밀번호 입니다."+
							"<br/>임시 비밀번호 :   <h2>"+memberKey+"</h2>"+
							"<br/>로그인 후 비밀번호 변경을 해주세요."+
							"<a href='http://localhost:8080/main/login"+
							">로그인 페이지</a>");
		sendMail.setFrom("lnwst21@daum.net", "WorkWith");
		sendMail.setTo(member.getEmail());
		sendMail.send();
		member.setPassword(memberKey);
		mm.findPw(member);
		
	}
}
