package cn.com.shxt.base.serv;

import java.io.Serializable;

import cn.com.shxt.base.dao.BaseDao;

/**
 * 公共的业务层
 * @author 韩老师
 * @ClassName: CommonServ
 * @Version 1.0
 * @ModifiedBy
 * @Copyright 四海兴唐
 * @date 2015-7-22 下午07:58:28
 * @description
 */
public class CommonServ {
	protected BaseDao baseDao = new BaseDao();
	
	/**
	 * 添加
	 * @author 韩老师
	 * @title: save
	 * @date 2015-7-22 下午07:59:10
	 * @param o void
	 */
	public void save(Object o) {
		baseDao.save(o);
	}
	
	/**
	 * 根据主键获取对象
	 * @author 韩老师
	 * @title: get
	 * @date 2015-7-22 下午08:00:36
	 * @param c
	 * @param id
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public Object get(Class c, Serializable id) {
		return baseDao.get(c, id);
	}
	
	/**
	 * 修改
	 * @author 韩老师
	 * @title: update
	 * @date 2015-7-22 下午08:01:56
	 * @param o void
	 */
	public void update(Object o) {
		baseDao.update(o);
	}
	
	/**
	 * 根据主键，删除对象
	 * @author 韩老师
	 * @title: delete
	 * @date 2015-7-22 下午08:02:33
	 * @param c
	 * @param id void
	 */
	@SuppressWarnings("unchecked")
	public void delete(Class c, Serializable id) {
		baseDao.delete(c, id);
	}
}
