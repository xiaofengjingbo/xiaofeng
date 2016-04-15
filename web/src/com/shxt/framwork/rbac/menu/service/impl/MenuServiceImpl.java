package com.shxt.framwork.rbac.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shxt.base.dao.BaseDaoImpl;
import com.shxt.base.dao.IBaseDao;
import com.shxt.framwork.rbac.menu.model.Menu;
import com.shxt.framwork.rbac.menu.service.IMenuService;
@Service(value="menuService")
public class MenuServiceImpl implements IMenuService {
	
	private IBaseDao baseDao;
	@Autowired
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<Menu> getParentMenuList(Integer role_id) throws Exception {
		// 使用SQL语句
		String sql = "select mm.* from web_sys_menu mm where menu_id in (select distinct m.parent_id from role_link_menu rlm,web_sys_menu m where rlm.fk_menu_id=m.menu_id and rlm.fk_role_id=?)";
		return (List<Menu>) this.baseDao.listBySQL(sql, role_id, Menu.class, true);
	}

	public List<Menu> getChildMenuList(Integer role_id) throws Exception {
		// 使用SQL语句
		String sql = "select m.* from role_link_menu rlm,web_sys_menu m where rlm.fk_menu_id=m.menu_id and rlm.fk_role_id=?";
		
		return (List<Menu>) this.baseDao.listBySQL(sql, role_id, Menu.class, true);
	}

}
