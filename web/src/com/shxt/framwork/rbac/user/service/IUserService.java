package com.shxt.framwork.rbac.user.service;

import com.shxt.base.dao.PageBean;
import com.shxt.framwork.rbac.user.model.User;

public interface IUserService {
	
	public User login(User user);
	
	public PageBean find(PageBean pageBean);

}
