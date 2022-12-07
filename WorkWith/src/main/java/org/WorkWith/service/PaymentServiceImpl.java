package org.WorkWith.service;

import org.WorkWith.mapper.PaymentAttachMapper;
import org.WorkWith.mapper.PaymentMapper;
import org.WorkWith.model.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	PaymentMapper pm;
	
	@Autowired
	PaymentAttachMapper pam;
	
	public void paymentWrite(PaymentVO pay) {
		pm.paymentWrite(pay);
	}

}
