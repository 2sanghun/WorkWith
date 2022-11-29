package org.WorkWith.model;

public class PaymentStatus {
	private int sno;
	
	private String sendId;
	
	private String recvId;
	
	private String status;
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	@Override
	public String toString() {
		return "PaymentStatus [sno=" + sno + ", sendId=" + sendId + ", recvId=" + recvId + ", status=" + status
				+ ", pno=" + pno + "]";
	}
}
