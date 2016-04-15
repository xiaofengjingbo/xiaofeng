package com.shxt.framwork.rbac.login.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shxt.base.action.BaseAction;
import com.shxt.framwork.rbac.user.model.User;
import com.shxt.framwork.rbac.user.service.IUserService;
import com.shxt.framwork.rbac.user.service.impl.UserServiceImpl;

@Controller
@Scope(value="prototype")
public class LoginAction extends BaseAction {
	
	private IUserService userService ;
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	private User user;
	
	
	public String login(){
		
		this.toJsp = "main/main";
		
		user = this.userService.login(user);
		
		if(user!=null){
			
			this.session.put("session_user", user);
			//一个MenuAction
			this.toAction="toNavMenuAction";
			return CHAIN;
			
		}else{
			
			this.message = "用户名或者密码错误，请重新登录";
			//跳转
			this.toJsp = "login";
			return DISPATCHER;
		}
		
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
