package com.shxt.framwork.rbac.role.service;

import java.util.List;

import com.shxt.framwork.rbac.menu.model.Menu;
import com.shxt.framwork.rbac.role.model.Role;


public interface IRoleService {
	
	public List<Role> listAll();
	public void updateStatus(Integer role_id) throws Exception;
	
	public void deleteByPK(Integer role_id)  throws Exception;
	
	public Role getRoleByPK(Integer role_id);
	
	public List<Menu> getSelectedMenuListByRoleId(Integer role_id);
	
	public List<Menu> getUnSelectedMenuListByRoleId(Integer role_id);

}
