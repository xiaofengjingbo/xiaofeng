package com.shxt.framwork.rbac.user.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shxt.base.action.BaseAction;
import com.shxt.base.dao.PageBean;
import com.shxt.framwork.rbac.user.service.IUserService;
import com.shxt.framwork.rbac.user.service.impl.UserServiceImpl;
@Controller
@Scope(value="prototype")
public class UserAction extends BaseAction {
	
	private PageBean pageBean;
	
	private IUserService userService;
	@Autowired	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String toFind(){
		
		pageBean = new PageBean();
		
		this.toJsp = "user/list";
		return DISPATCHER;
	}
	
	public String find(){
		try {
			this.jsonResult = this.userService.find(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return JSON;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

}
