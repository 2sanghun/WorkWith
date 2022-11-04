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
	
	public ArrayList<MemberVO> memberManage(MemberVO member) {
		return mm.memberManage(member);
	}

}
