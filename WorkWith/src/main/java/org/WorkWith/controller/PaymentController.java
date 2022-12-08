package org.WorkWith.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.WorkWith.model.PaymentVO;
import org.WorkWith.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {

	@Autowired
	PaymentService ps;

	@RequestMapping(value = "/payment/paymentPage", method = RequestMethod.GET)
	public void paymentPage() {

	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST, consumes = "application/json; charset=utf-8")
	public ResponseEntity<String> writePost(HttpServletRequest request, @RequestBody PaymentVO pay) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		pay.setId(id);

		ps.paymentWrite(pay);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

}
