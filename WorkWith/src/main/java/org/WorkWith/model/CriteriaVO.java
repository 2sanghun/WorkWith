package org.WorkWith.model;
 
// pageNum(페이지 번호)와 amount(한페이지당 게시물 갯수) 값을 전달하는 model
public class CriteriaVO {
	private int pageNum; // 페이지 번호
	private int amount; // 한 페이지당 게시물 갯수
	private String keyword;
	private String type;
	private String period;	// 검색 조건에 기간
	private String category;	// total에 반영하기 위해 category 필요
	
	// 생성자
	public CriteriaVO() {
		this(1, 10);
	}

	public CriteriaVO(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
		

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CriteriaVO [pageNum=" + pageNum + ", amount=" + amount +", keyword=" + keyword
				+ ", type=" + type + ", period=" + period + ", category=" + category + ", orderby=" + "]";
	}

}