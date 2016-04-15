package cn.com.shxt.modual.student.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import cn.com.shxt.base.controller.BaseAction;
import cn.com.shxt.modual.student.serv.StudentServ;
import cn.com.shxt.po.Hobby;
import cn.com.shxt.po.StuType;
import cn.com.shxt.po.Student;
import cn.com.shxt.util.Common;

import com.opensymphony.xwork2.ActionContext;

public class StudentAction extends BaseAction{

	private static final long serialVersionUID = 2857151857920608522L;
	
	private StudentServ studentServ = new StudentServ();
	
	/**学生对象*/
	private Student stu;
	/**学生集合*/
	private List<Student> stuList;
	/**爱好集合*/
	private List<Hobby> hobbyList;
	/**类别集合*/
	private List<StuType> stuTypeList;
	
	private File photo;
	private String photoFileName;
	
//	private List keys
//	private String[] keys
	private String keys;//1,2
	
	
	public String login() {
		System.out.println(1);
		if(!studentServ.login(stu)) {
			url = "login.jsp";
			return REDIRECT_JSP;
		}
		
		//保存对象
		System.out.println(2);
		//保存id
		ActionContext.getContext().getSession().put("id", stu.getId());
		System.out.println(3);
		url = "index.jsp";
		return REDIRECT_JSP;
	}
	
	/**
	 * 添加学生
	 * @author 韩老师
	 * @title: add
	 * @date 2015-7-22 下午07:21:29
	 * @return String
	 */
	public String add() {
//		System.out.println(stu.getName());
		if(photo != null) {
			try {
				String newName = Common.upload(photo, photoFileName);
				stu.setPhoto(newName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		studentServ.save(stu);
		
		url = "success.jsp";
		return SUCCESS;
	}
	
	
	/**
	 * 查看学生
	 * @author 韩老师
	 * @title: sel
	 * @date 2015-7-22 下午07:39:00
	 * @return String
	 */
	public String sel() {
		page.setSize(5);
		
		stuList = studentServ.selStudent(page);
		url = "student/sel_student.jsp";
		return SUCCESS;
	}
	
	/**
	 * 显示修改页面
	 * @author 韩老师
	 * @title: updateShow
	 * @date 2015-7-22 下午07:43:57
	 * @return String
	 */
	public String updateShow() {
		stu = (Student)studentServ.get(Student.class ,id);
		hobbyList = studentServ.selHobby();
		stuTypeList = studentServ.selType();
		keys = studentServ.getHobbyByStu(id);
		
		url = "student/update_student.jsp";
		return SUCCESS;
	}
	
	/**
	 * 修改学生，执行操作
	 * @author 韩老师
	 * @title: update
	 * @date 2015-7-25 下午06:46:38
	 * @return String
	 */
	public String update() {
		if(photo != null) {
			try {
				String newName = Common.upload(photo, photoFileName);
				stu.setPhoto(newName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		studentServ.updateStudent(stu, keys);
		
		url = "stu_sel";
		return REDIRECT_ACTION;
	}
	
	public String delete() {
		studentServ.delete(Student.class, id);
		url = "stu_sel";
		return REDIRECT_ACTION;
	}
	
	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public List<Hobby> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<Hobby> hobbyList) {
		this.hobbyList = hobbyList;
	}
	public String getKeys() {
		return keys;
	}
	public void setKeys(String keys) {
		this.keys = keys;
	}

	public List<StuType> getStuTypeList() {
		return stuTypeList;
	}

	public void setStuTypeList(List<StuType> stuTypeList) {
		this.stuTypeList = stuTypeList;
	}
	
	
	
	
	
}
