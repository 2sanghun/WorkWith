package org.WorkWith.mapper;

import org.WorkWith.model.PaymentStatusVO;
import org.WorkWith.model.PaymentVO;

public interface PaymentMapper {

	public void paymentWrite(PaymentVO pay);

	public void statusInsert(PaymentStatusVO status);

}
