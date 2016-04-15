package cn.com.shxt.modual.student.serv;

import java.util.List;

import cn.com.shxt.base.serv.CommonServ;
import cn.com.shxt.po.Student;

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
public class StudentServRemark extends CommonServ{
	
//	/**
//	 * 添加学生
//	 * @author 韩老师
//	 * @title: addStudent
//	 * @date 2015-7-22 下午07:33:41
//	 * @param s void
//	 */
//	public void addStudent(Student s) {
//		baseDao.save(s);
//	}
	
	/**
	 * 查看学生
	 * @author 韩老师
	 * @title: selStudent
	 * @date 2015-7-22 下午07:40:34
	 * @return List<Student>
	 */
	@SuppressWarnings("unchecked")
	public List<Student> selStudent() {
		return baseDao.query("from Student");
	}
	
//	/**
//	 * 根据id，获取学生对象
//	 * @author 韩老师
//	 * @title: getStudent
//	 * @date 2015-7-22 下午07:47:27
//	 * @param id
//	 * @return Student
//	 */
//	public Student getStudent(Integer id) {
//		return (Student)baseDao.get(Student.class, id);
//	}
	
	
//	/**
//	 * 修改学生
//	 * @author 韩老师
//	 * @title: updateStudent
//	 * @date 2015-7-22 下午07:50:52
//	 * @param s void
//	 */
//	public void updateStudent(Student s) {
//		baseDao.update(s);
//	}
	
//	/**
//	 * 删除学生
//	 * @author 韩老师
//	 * @title: deleteStudent
//	 * @date 2015-7-22 下午07:57:01
//	 * @param id void
//	 */
//	public void deleteStudent(Integer id){
//		baseDao.delete(Student.class, id);
//	}
	
}
