package com.shxt.framwork.rbac.menu.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;

import com.shxt.framwork.rbac.role.model.Role;
@Entity
@Table(name="web_sys_menu")
public class Menu implements Serializable{
	/**系统菜单信息表的主键标识*/
	private Integer menu_id;
	/**菜单名称*/
	private String menu_name;
	/**菜单的父节点ID*/
	private String parent_id;
	/**菜单的访问路径*/
	private String url;
	/**菜单的图片，根据情况设置*/
	private String icon;
	/**菜单的显示位置 默认值有  LEFT和TOP*/
	private String postion = "LEFT";
	/**对应超级连接的target属性的值*/
	private String target = "rightFrame";
	
	private Set<Role> roleSet;
	
	

	public Menu() {
		roleSet = new HashSet<Role>();
	}

	@Id
	@GeneratedValue
	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menuId) {
		menu_id = menuId;
	}
	
	@Column(length=64,nullable=false)
	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menuName) {
		menu_name = menuName;
	}
	@Column(length=10)
	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parentId) {
		parent_id = parentId;
	}
	@Column(length=128)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Column(length=32)
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Column(length=10)
	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}
	@Column(length=32)
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	@ManyToMany
	@JoinTable(name="role_link_menu",joinColumns={@JoinColumn(name="fk_menu_id")},inverseJoinColumns={@JoinColumn(name="fk_role_id")})
	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
	
	

}
