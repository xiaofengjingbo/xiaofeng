package cn.com.shxt.modual.student.serv;

import java.util.List;

import cn.com.shxt.base.serv.CommonServ;
import cn.com.shxt.po.Hobby;
import cn.com.shxt.po.StuType;
import cn.com.shxt.po.Student;
import cn.com.shxt.util.Common;
import cn.com.shxt.util.Page;

/**
 * 学生业务层
 * @author 韩老师
 * @ClassName: StudentServ
 * @Version 1.0
 * @ModifiedBy
 * @Copyright 四海兴唐
 * @date 2015-7-22 下午07:32:17
 * @description
 */
public class StudentServ extends CommonServ{
	
	/**
	 * 查看学生
	 * @author 韩老师
	 * @title: selStudent
	 * @date 2015-7-22 下午07:40:34
	 * @return List<Student>
	 */
	@SuppressWarnings("unchecked")
	public List<Student> selStudent(Page page) {
		return baseDao.query("from Student", page);
	}
	
	/**
	 * 判断登录是否成功
	 * @author 韩老师
	 * @title: login
	 * @date 2015-7-23 下午07:24:01
	 * @param s
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean login(Student s) {
		List<Student> list = baseDao.query("from Student s where s.name = '" + s.getName() + "'");
		if(list.isEmpty()) {
			return false;
		}
		
		if(!s.getPassword().equals(list.get(0).getPassword())) {
			return false;
		}
		
		s.setId(list.get(0).getId());//把数据库中的id，放到action中的学生对象里
		return true;
	}
	
	public void updateStudent2222(Student s) {
		Student dataStu = (Student)baseDao.get(Student.class, s.getId());
		
		dataStu.setName(s.getName());
		dataStu.setAddress(s.getAddress());
		dataStu.setBirthday(s.getBirthday());
		dataStu.setPhoto(s.getPhoto());
		
		baseDao.update(dataStu);
	}
	
	@SuppressWarnings("unchecked")
	public void updateStudent(Student s, String keys) {
		//1 2
		List<Hobby> list = baseDao.query("from Hobby h where h.id in(" + keys + ")");
		s.getHobbies().addAll(list);
		baseDao.update(s);
	}
	
	/**
	 * 查询类别
	 * @author 韩老师
	 * @title: selType
	 * @date 2015-7-25 下午08:13:07
	 * @return List<StuType>
	 */
	@SuppressWarnings("unchecked")
	public List<StuType> selType() {
		return baseDao.query("from StuType");
	}
	
	/**
	 *  根据学生id获取爱好id
	 * @author 韩老师
	 * @title: getHobbyByStu
	 * @date 2015-7-25 下午07:25:27
	 * @param id
	 * @return String
	 */
	@SuppressWarnings("unchecked")
	public String getHobbyByStu(Integer id) {
		List<Integer> list = baseDao.query("select h.id from Student s join s.hobbies h where s.id = " + id);
		return Common.listToString(list);
	}
	
	/**
	 * 查看爱好
	 * @author 韩老师
	 * @title: selHobby
	 * @date 2015-7-25 下午07:08:43
	 * @return List<Hobby>
	 */
	@SuppressWarnings("unchecked")
	public List<Hobby> selHobby() {
		return baseDao.query("from Hobby h order by h.id");
	}
}
