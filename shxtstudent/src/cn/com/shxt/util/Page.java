package cn.com.shxt.util;

/**
 * 分页对象
 * @author 韩老师
 * @ClassName: Page
 * @Version 1.0
 * @ModifiedBy 
 * @Copyright 四海兴唐
 * @date 2012-8-7 下午01:58:07
 * @description
 */
public class Page {
	
	/**当前第几页*/
	public int index = 1;
	/**总记录数*/
	public int rows;
	/**分页大小，每页显示的行数*/
	public int size = 5;
	/**总页数*/
	public int pages = 1;
	
	/*************************Getter And Setter*************************************/
	
	public int getRows() {
		return rows;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	
}
