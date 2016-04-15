package com.shxt.framwork.rbac.menu.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shxt.base.action.BaseAction;
import com.shxt.framwork.rbac.menu.model.Menu;
import com.shxt.framwork.rbac.menu.service.IMenuService;
import com.shxt.framwork.rbac.menu.service.impl.MenuServiceImpl;
import com.shxt.framwork.rbac.user.model.User;
@Controller
@Scope(value="prototype")
public class MenuAction extends BaseAction {
	
	private List<Menu> parentList;
	
	private List<Menu> childList;
	
	private IMenuService menuService;
	@Autowired
	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public String toNav() throws Exception{
		
		//获取登录用户的角色ID
		User user = (User) this.session.get("session_user");
		
		parentList = this.menuService.getParentMenuList(user.getRole().getRole_id());
		childList = this.menuService.getChildMenuList(user.getRole().getRole_id());
		
		this.toJsp = "main/main";
		
		return DISPATCHER;
	}

	public List<Menu> getParentList() {
		return parentList;
	}

	public void setParentList(List<Menu> parentList) {
		this.parentList = parentList;
	}

	public List<Menu> getChildList() {
		return childList;
	}

	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}

}
