package cn.com.shxt.base.controller;

import cn.com.shxt.util.Page;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = -3703538946469336198L;
	
	/**重定向到action*/
	protected static final String REDIRECT_ACTION = "redirectAction";
	/**重定向到jsp*/
	protected static final String REDIRECT_JSP = "redirect";
	/**转向标*/
	protected String url;
	/**分页对象*/
	protected Page page;
	/**主键*/
	protected Integer id;
	
	public BaseAction() {
		if(page == null) {
			page = new Page();
		}
	}
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
