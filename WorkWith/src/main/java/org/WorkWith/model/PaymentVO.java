package org.WorkWith.model;

import java.util.ArrayList;

public class PaymentVO {

	private int pno;

	private String title;

	private String content;

	private String status; // payment와 paymentStatus두 테이블의 status

	private String id; // sendId

	// AttachFileVO(파일 업로드 관련 model)
	private ArrayList<PaymentAttachVO> attach;
	
	private ArrayList<PaymentStatusVO> paymentStatus;
	
	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<PaymentAttachVO> getAttach() {
		return attach;
	}

	public void setAttach(ArrayList<PaymentAttachVO> attach) {
		this.attach = attach;
	}

	

	public ArrayList<PaymentStatusVO> getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(ArrayList<PaymentStatusVO> paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "PaymentVO [pno=" + pno + ", title=" + title + ", content=" + content + ", status=" + status + ", id="
				+ id + ", attach=" + attach + ", paymentStatus=" + paymentStatus + "]";
	}
}
