package cn.com.shxt.base.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.com.shxt.util.HibernateTool;
import cn.com.shxt.util.Page;

public class BaseDao {
	
	
	public void save(Object o) {
		Session session = HibernateTool.getSession();
		Transaction ts = session.beginTransaction();
		
		session.save(o);
		
		ts.commit();
		session.close();
	}
	
	public void update(Object o) {
		Session session = HibernateTool.getSession();
		Transaction ts = session.beginTransaction();
		
		session.update(o);
		
		ts.commit();
		session.close();
	}
	
	public void delete(Object o) {
		Session session = HibernateTool.getSession();
		Transaction ts = session.beginTransaction();
		
		session.delete(o);
		
		ts.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public void delete(Class c, Serializable id) {
		Session session = HibernateTool.getSession();
		Transaction ts = session.beginTransaction();
		Object o = session.get(c, id);
		session.delete(o);
		ts.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List query(String hql) {
		Session session = HibernateTool.getSession();
		List list = session.createQuery(hql).list();
		session.close();
		return list;
	}
	
	/**
	 * 分页查询
	 * @author 韩老师
	 * @title: query
	 * @date 2015-7-25 下午07:43:55
	 * @param hql
	 * @param page
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List query(String hql,Page page ) {
		Session session = HibernateTool.getSession();
		String countSql = "select count(*) " + hql;
		
		String s = session.createQuery(countSql).list().get(0).toString();
		page.setRows(Integer.parseInt(s));//总记录数  
		
		page.pages = page.rows / page.size + (page.rows % page.size == 0 ? 0 : 1);
		
		Query query = session.createQuery(hql);
		
		query.setFirstResult((page.getIndex() - 1) * page.getSize());//第几条开始
		query.setMaxResults(page.getSize());//每页显示多少条
		
		List list = query.list();
		session.close();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Object get(Class c, Serializable id) {
		Session session = HibernateTool.getSession();
		Object o = session.get(c, id);
		session.close();
		return o;
	}
}
