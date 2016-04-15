package com.shxt.framwork.rbac.role.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shxt.base.action.BaseAction;
import com.shxt.framwork.rbac.menu.model.Menu;
import com.shxt.framwork.rbac.role.model.Role;
import com.shxt.framwork.rbac.role.service.IRoleService;
@Controller
@Scope(value="prototype")
public class RoleAction extends BaseAction {
	
	private IRoleService roleService;
	@Autowired
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	
	private List<Role> roleList;
	
	private Integer role_id;
	
	private List<Menu> selectedMenuList;
	
	private List<Menu> unSelectedMenuList;
	
	private Role role;
	

	public String list(){
		
		roleList = this.roleService.listAll();
		
		//跳转页面
		this.toJsp = "role/list";
		
		return DISPATCHER;
	}
	
	public String updateStatus(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			this.roleService.updateStatus(role_id);
			map.put("flag", "success");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "error");
			map.put("message", "更新失败，原因为:"+e.getMessage());
		}
		//数据转换
		this.jsonResult = map;
		return JSON;
	}
	
	public String delete(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		try {
			this.roleService.deleteByPK(role_id);
			map.put("flag", "success");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", "error");
			map.put("message", "更新失败，原因为:"+e.getMessage());
		}
		//数据转换
		this.jsonResult = map;
		return JSON;
	}
	
	public String toAuthorization(){
		try {
			//获取该角色已经拥有的菜单信息
			this.selectedMenuList = this.roleService.getSelectedMenuListByRoleId(role_id);
			//获取该角色没有拥有的菜单信息
			this.unSelectedMenuList = this.roleService.getUnSelectedMenuListByRoleId(role_id);
			//通过主键ID获取角色信息
			this.role = this.roleService.getRoleByPK(role_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.toJsp = "role/authorization";
		return DISPATCHER;
	}
	
	
	
	
	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public List<Menu> getUnSelectedMenuList() {
		return unSelectedMenuList;
	}

	public void setUnSelectedMenuList(List<Menu> unSelectedMenuList) {
		this.unSelectedMenuList = unSelectedMenuList;
	}

	public List<Menu> getSelectedMenuList() {
		return selectedMenuList;
	}

	public void setSelectedMenuList(List<Menu> selectedMenuList) {
		this.selectedMenuList = selectedMenuList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
