package com.shxt.framwork.rbac.role.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;

import com.shxt.framwork.rbac.menu.model.Menu;
import com.shxt.framwork.rbac.user.model.User;
@Entity
@Table(name="web_sys_role")
public class Role implements Serializable {
	/**系统角色表的主键标识*/
	private Integer role_id;
	/**角色名称，唯一标识*/
	private String role_name;
	/**角色的简单描述，备用*/
	private String role_desc;
	/**角色的状态: 1为可用状态  2为禁用状态*/
	private String role_status = "1";
	/**角色的头像: 默认情况下提供三个头像  role1.png role2.png role3.png*/
	private String photo = "role1.png";

	private Set<User> userSet ;
	
	private Set<Menu> menuSet;
	
	public Role() {
		userSet = new HashSet<User>();
		menuSet = new HashSet<Menu>();
	}

	@Id
	@GeneratedValue
	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer roleId) {
		role_id = roleId;
	}
	@Column(length=32,nullable=false,unique=true)
	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}
	@Column(length=128)
	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String roleDesc) {
		role_desc = roleDesc;
	}
	@Column(length=1)
	public String getRole_status() {
		return role_status;
	}

	public void setRole_status(String roleStatus) {
		role_status = roleStatus;
	}
	@Column(length=32)
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@JSON(serialize=false)
	@OneToMany(mappedBy="role")
	//mappdeBy JoinColumn不能共存
	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	@JSON(serialize=false)//代表你menuSet不加入json的序列号
	@ManyToMany
	@JoinTable(name="role_link_menu",joinColumns={@JoinColumn(name="fk_role_id")},inverseJoinColumns={@JoinColumn(name="fk_menu_id")})
	public Set<Menu> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(Set<Menu> menuSet) {
		this.menuSet = menuSet;
	}
	
	
}
