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
	
	private int sno;

	private String recvId;
	
	private String sendPosi;
	
	private String recvPosi;
	
	private String sendName;
	
	private String recvName;
	
	private String sendDep;
	
	private String recvDep;
	
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

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getRecvId() {
		return recvId;
	}

	public void setRecvId(String recvId) {
		this.recvId = recvId;
	}

	public String getSendPosi() {
		return sendPosi;
	}

	public void setSendPosi(String sendPosi) {
		this.sendPosi = sendPosi;
	}

	public String getRecvPosi() {
		return recvPosi;
	}

	public void setRecvPosi(String recvPosi) {
		this.recvPosi = recvPosi;
	}

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		this.sendName = sendName;
	}

	public String getRecvName() {
		return recvName;
	}

	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}

	public String getSendDep() {
		return sendDep;
	}

	public void setSendDep(String sendDep) {
		this.sendDep = sendDep;
	}

	public String getRecvDep() {
		return recvDep;
	}

	public void setRecvDep(String recvDep) {
		this.recvDep = recvDep;
	}

	@Override
	public String toString() {
		return "PaymentVO [pno=" + pno + ", title=" + title + ", content=" + content + ", status=" + status + ", id="
				+ id + ", attach=" + attach + ", sno=" + sno + ", recvId=" + recvId + ", sendPosi=" + sendPosi
				+ ", recvPosi=" + recvPosi + ", sendName=" + sendName + ", recvName=" + recvName + ", sendDep="
				+ sendDep + ", recvDep=" + recvDep + "]";
	}
}
