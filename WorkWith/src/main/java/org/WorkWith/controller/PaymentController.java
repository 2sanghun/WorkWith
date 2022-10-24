package org.WorkWith.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {
	@RequestMapping(value = "/payment/payment", method = RequestMethod.GET)
	public void payment() {
		
	}


}
