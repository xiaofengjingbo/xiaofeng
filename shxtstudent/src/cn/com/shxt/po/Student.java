package cn.com.shxt.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student {
	private Integer id;
	private String name;
	private String address;
	private String password;
	private Date birthday;
	private String photo;
	/**学生类别*/
	private StuType stuType;
	
	private Set<Hobby> hobbies = new HashSet<Hobby>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Set<Hobby> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}
	public StuType getStuType() {
		return stuType;
	}
	public void setStuType(StuType stuType) {
		this.stuType = stuType;
	}
	
	
	
}
