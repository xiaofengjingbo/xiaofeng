package com.shxt.framwork.rbac.user.dto;

import java.util.Date;

public class UserDTO {
	/**系统用户主键标识*/
	private Integer user_id;
	/**账号信息*/
	private String account;
	/**密码：可以增加MD5加密*/
	private String password;
	/**姓名*/
	private String user_name;
	/**性别有三种: "男" "女" "未知"*/
	private String sex;
	/**电子邮件*/
	private String email;
	/**联系方式*/
	private String telphone;
	/**身份证号码*/
	private String id_card;
	/**设置右侧显示的页面*/
	private String home_page = "content.jsp";
	/**用户状态：1为可用 2为禁用 3为删除*/
	private String account_status = "1";
	/**禁用的截至日期*/
	private Date stop_date ;
	/**用户创建的日期*/
	private Date create_date = new Date();
	/**用户是谁创建的*/
	private String create_name ;
	/**是否允许删除的标识，1为都运行，2为不允许进行删除*/
	private String del_flag = "1";
	/**测试使用的工资属性*/
	private Float salary;
	
	private Integer fk_role_id;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getHome_page() {
		return home_page;
	}
	public void setHome_page(String home_page) {
		this.home_page = home_page;
	}
	public String getAccount_status() {
		return account_status;
	}
	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
	public Date getStop_date() {
		return stop_date;
	}
	public void setStop_date(Date stop_date) {
		this.stop_date = stop_date;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	public String getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Integer getFk_role_id() {
		return fk_role_id;
	}
	public void setFk_role_id(Integer fk_role_id) {
		this.fk_role_id = fk_role_id;
	}
}
