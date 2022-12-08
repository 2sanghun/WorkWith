package org.WorkWith.model;

public class PaymentStatusVO {
	private int sno;
	
	private String sendId;
	
	private String recvId;

	private String sendPosi;

	private String recvPosi;

	private String sendName;

	private String recvName;

	private String sendDep;

	private String recvDep;

	private int pno;
	
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}
	
	

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
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

	
	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	@Override
	public String toString() {
		return "PaymentStatusVO [sno=" + sno + ", sendId=" + sendId + ", recvId=" + recvId + ", sendPosi=" + sendPosi
				+ ", recvPosi=" + recvPosi + ", sendName=" + sendName + ", recvName=" + recvName + ", sendDep="
				+ sendDep + ", recvDep=" + recvDep + ", pno=" + pno + "]";
	}
}
