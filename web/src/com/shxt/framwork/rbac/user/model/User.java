package com.shxt.framwork.rbac.user.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.json.annotations.JSON;
import org.apache.struts2.json.annotations.JSONParameter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.shxt.framwork.rbac.role.model.Role;

@Entity
@Table(name="web_sys_user")
public class User implements Serializable {
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
	/**用户和角色是多对一关系*/
	private Role role;
	
	/**测试使用的工资属性*/
	private Float salary;

	public User() {
	}

	public User(Integer user_id, String user_name, Float salary) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.salary = salary;
	}


	@Id
	@GeneratedValue
	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer userId) {
		user_id = userId;
	}
	@Column(length=32,nullable=false,unique=true)
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	@Column(length=32)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=32)
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}
	@Column(length=2)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(length=32)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=15)
	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	@Column(length=18)
	public String getId_card() {
		return id_card;
	}

	public void setId_card(String idCard) {
		id_card = idCard;
	}
	@Column(length=32)
	public String getHome_page() {
		return home_page;
	}

	public void setHome_page(String homePage) {
		home_page = homePage;
	}
	
	
	@Temporal(TemporalType.DATE)
	public Date getStop_date() {
		return stop_date;
	}

	public void setStop_date(Date stopDate) {
		stop_date = stopDate;
	}
	@JSON(format="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}
	
	@Column(length=32)
	public String getCreate_name() {
		return create_name;
	}

	public void setCreate_name(String createName) {
		create_name = createName;
	}
	@Column(length=1)
	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String delFlag) {
		del_flag = delFlag;
	}
	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)//不懒加载
	@JoinColumn(name="fk_role_id")
	//<many-to-one name="role"class="Role" column="fk_role_id"/>
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	@Column(length=1)
	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String accountStatus) {
		account_status = accountStatus;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
	

}
