package com.shxt.framwork.rbac.menu.service;

import java.util.List;

import com.shxt.framwork.rbac.menu.model.Menu;

public interface IMenuService {
	
	public List<Menu> getParentMenuList(Integer role_id)throws Exception;
	public List<Menu> getChildMenuList(Integer role_id)throws Exception;

}
