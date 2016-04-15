package com.shxt.base.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao {
	/**
	 * 描述:保存对象
	 * @param object
	 */
	public void add(Object object);
	/**
	 * 描述:更新对象
	 * @param object
	 */
	public void update(Object object);
	/**
	 * 描述:删除对象
	 * @param object
	 */
	public void delete(Object object);
	/**
	 * 通过主键ID和类型删除数据
	 * @param clazz 类型
	 * @param id 主键ID
	 */
	public void delete(Class<?> clazz,Integer id);
	/**
	 * 通过主键获取对象，使用的是session.get方式
	 * @param clazz 类型
	 * @param id 主键ID
	 * @return object 如果不存在返回null
	 */
	public Object load(Class<?> clazz,Integer id);
	
	/**
	 * 多条件的HQL查询操作，返回一个列表
	 * @param hql 
	 * @param args 
	 * @return List
	 */
	public List<?> listByHQL(String hql,Object[] args);
	/**
	 * 通过一个查询操作，返回一个列表
	 * @param hql
	 * @param arg 参数
	 * @return
	 */
	public List<?> listByHQL(String hql,Object arg);
	/**
	 * 返回一个列表
	 * @param hql
	 * @return
	 */
	public List<?> listByHQL(String hql);
	
	/**
	 * 多条件查询返回一条数据
	 * @param hql
	 * @param args
	 * @return
	 */
	public Object queryByHQL(String hql,Object[] args);
	/**
	 * 一个查询返回一条数据
	 * @param hql
	 * @param arg
	 * @return
	 */
	public Object queryByHQL(String hql,Object arg);
	/**
	 * 返回一条数据，通过hql语句
	 * @param hql
	 * @return
	 */
	public Object queryByHQL(String hql);
	/**
	 * 只能执行update和delete的hql语句，多个条件
	 * @param hql
	 * @param args
	 */
	public void updateByHQL(String hql,Object[] args);
	/**
	 * 只能执行update和delete的hql语句,执行一个属性
	 * @param hql
	 * @param arg
	 */
	public void updateByHQL(String hql,Object arg);
	/**
	 * 只能执行update和delete的hql语句
	 * @param hql
	 */
	public void updateByHQL(String hql);
	
	
	
	public List<?> listBySQL(String sql,Object[] args,Class<?> clazz,boolean isHBM);
	public List<?> listBySQL(String sql,Object arg,Class<?> clazz,boolean isHBM);
	public List<?> listBySQL(String sql,Class<?> clazz,boolean isHBM);
	
	
	public Object queryBySQL(String sql,Object[] args,Class<?> clazz,boolean isHBM);
	public Object queryBySQL(String sql,Object arg,Class<?> clazz,boolean isHBM);
	public Object queryBySQL(String sql,Class<?> clazz,boolean isHBM);
	
	public void updateBySQL(String sql,Object[] args);
	public void updateBySQL(String sql,Object arg);
	public void updateBySQL(String sql);
	
	
	public PageBean findByHQL(String hql,Object[] args,PageBean pageBean);
	public PageBean findByHQL(String hql,Object arg,PageBean pageBean);
	public PageBean findByHQL(String hql,PageBean pageBean);
	
	public PageBean findBySQL(String sql,Object[] args,PageBean pageBean,Class<?> clazz,boolean isHBM);
	public PageBean findBySQL(String sql,Object arg,PageBean pageBean,Class<?> clazz,boolean isHBM);
	public PageBean findBySQL(String sql,PageBean pageBean,Class<?> clazz,boolean isHBM);
	
	
	public List<Map<String,Object>> listBySQL(String sql,Object[] args);
	public List<Map<String,Object>> listBySQL(String sql,Object arg);
	public List<Map<String,Object>> listBySQL(String sql);
	

}
