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
		if (pay.getAttach() != null) {
			pay.getAttach().forEach(attach -> {
				attach.setPno(pay.getPno());
				pam.insert(attach);
			});
		}
		if (pay.getPaymentStatus() != null) {
			pay.getPaymentStatus().forEach(status -> {
				status.setPno(pay.getPno());
				pm.statusInsert(status);
			});
		}
	}

}
