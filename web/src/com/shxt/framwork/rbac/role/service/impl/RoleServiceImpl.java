package com.shxt.framwork.rbac.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shxt.base.dao.IBaseDao;
import com.shxt.framwork.rbac.menu.model.Menu;
import com.shxt.framwork.rbac.role.model.Role;
import com.shxt.framwork.rbac.role.service.IRoleService;

@Service(value="roleService")
public class RoleServiceImpl implements IRoleService {
	
	private IBaseDao baseDao;
	@Autowired
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<Role> listAll() {
		String hql = "from Role r order by  r.role_status";
		return (List<Role>) this.baseDao.listByHQL(hql);
	}

	public void updateStatus(Integer role_id) throws Exception {
		//--通过角色ID获取对象
		Role role = (Role) this.baseDao.load(Role.class, role_id);
		if("1".equals(role.getRole_status())){
			role.setRole_status("2");
		}else{
			role.setRole_status("1");
		}
		
		this.baseDao.update(role);//这句话没有作用--为什么没有作用，因为我们的Session过滤器已经扩大了访问
		
	}

	public void deleteByPK(Integer role_id) throws Exception {
		// 我应该操作哪几个表  web_sys_role  ->web_sys_user  --> role_link_menu
		
		String sql = "update web_sys_user set fk_role_id=null where fk_role_id=?";//解除跟用户的关系
		this.baseDao.updateBySQL(sql, role_id);
		sql = "delete from role_link_menu where fk_role_id=?";//删除中间表的信息
		this.baseDao.updateBySQL(sql, role_id);
		sql = "delete from web_sys_role where role_id=?";//删除角色
		this.baseDao.updateBySQL(sql, role_id);
		
		
	}

	public Role getRoleByPK(Integer role_id) {
		return (Role) this.baseDao.load(Role.class, role_id);
	}

	public List<Menu> getSelectedMenuListByRoleId(Integer role_id) {
		String sql = "select m.* from role_link_menu rlm , web_sys_menu m where rlm.fk_menu_id=m.menu_id and rlm.fk_role_id=?";
		return (List<Menu>) this.baseDao.listBySQL(sql, role_id, Menu.class, false);
	}

	public List<Menu> getUnSelectedMenuListByRoleId(Integer role_id) {
		String sql = "select mm.* from web_sys_menu mm where mm.menu_id not in (select m.menu_id from role_link_menu rlm , web_sys_menu m where rlm.fk_menu_id=m.menu_id and rlm.fk_role_id=?) and mm.parent_id is not null";
		return (List<Menu>) this.baseDao.listBySQL(sql, role_id, Menu.class, false);
	}

}
