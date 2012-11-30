package bean;

import java.util.ArrayList;
import java.util.List;

public class PageResult<T> implements java.io.Serializable{
	private static final long serialVersionUID = -1826830567659349558L;
	
	private List<T> topicList;
	private int total;
	private int currentPage;
	private int startPage;
	private int endPage;
	private int maxPage;
	private int itemNumber;
	

	public PageResult(int currentPage) {
		super();
		this.itemNumber = 6;
		this.currentPage = currentPage;
		topicList = new ArrayList<T>();
	}
	public List<T> getTopicList() {
		return topicList;
	}
	
	public void setTopicList(List<T> topicList) {
		this.topicList = topicList;
	}
	
	public int getItemNumber() {
		return itemNumber;
	}
	
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotal() {
		return total;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public void setPageNation() {
		this.maxPage = (int) Math.ceil((double)total/(double)itemNumber);
		this.startPage = currentPage-2;
		this.endPage = currentPage+2;
		
		if(maxPage<itemNumber){
			startPage=1;
			endPage=maxPage;
		}
		else{
			switch(startPage){
			case -1 : 	startPage=1;
						endPage=currentPage+4; break;
			case 0 : 	startPage=1;
						endPage=currentPage+3; break;
			default : break;
			}
			if(endPage == maxPage+1){
				endPage=maxPage;
				startPage=currentPage-3;
			}
			else if(endPage == maxPage+2){
				endPage=maxPage;
				startPage=currentPage-4;
			}
		}
	}
}