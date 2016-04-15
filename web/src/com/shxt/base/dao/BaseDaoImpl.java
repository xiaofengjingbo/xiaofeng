package com.shxt.base.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shxt.base.utils.AliasToBeanResultTransformer;
import com.shxt.base.utils.HibernateUtils;

@Repository(value="baseDao")
public class BaseDaoImpl implements IBaseDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(Object object) {
		getSession().save(object);
	}

	public void update(Object object) {

		getSession().update(object);

	}

	public void delete(Object object) {

		getSession().delete(object);

	}

	public void delete(Class<?> clazz, Integer id) {

		getSession().delete(getSession().get(clazz, id));

	}

	public Object load(Class<?> clazz, Integer id) {

		return getSession().load(clazz, id);
	}

	public List<?> listByHQL(String hql, Object[] args) {

		Query query = getSession().createQuery(hql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}

		return query.list();

	}

	public List<?> listByHQL(String hql, Object arg) {
		return this.listByHQL(hql, new Object[] { arg });
	}

	public List<?> listByHQL(String hql) {
		return this.listByHQL(hql, null);
	}

	public Object queryByHQL(String hql, Object[] args) {

		Query query = getSession().createQuery(hql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}

		return query.uniqueResult();

	}

	public Object queryByHQL(String hql, Object arg) {
		return this.queryByHQL(hql, new Object[] { arg });
	}

	public Object queryByHQL(String hql) {
		return this.queryByHQL(hql, null);
	}

	public void updateByHQL(String hql, Object[] args) {

		Query query = getSession().createQuery(hql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}

		query.executeUpdate();

	}

	public void updateByHQL(String hql, Object arg) {
		this.updateByHQL(hql, new Object[] { arg });

	}

	public void updateByHQL(String hql) {
		this.updateByHQL(hql, null);

	}

	public List<?> listBySQL(String sql, Object[] args, Class<?> clazz,
			boolean isHBM) {

		SQLQuery query = getSession().createSQLQuery(sql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}

		if (isHBM) {// 持久化类
			query.addEntity(clazz);
		} else {// DTO
			query.setResultTransformer(new AliasToBeanResultTransformer(clazz));
		}

		return query.list();

	}

	public List<?> listBySQL(String sql, Object arg, Class<?> clazz,
			boolean isHBM) {

		return this.listBySQL(sql, new Object[] { arg }, clazz, isHBM);
	}

	public List<?> listBySQL(String sql, Class<?> clazz, boolean isHBM) {
		return this.listBySQL(sql, null, clazz, isHBM);
	}

	public Object queryBySQL(String sql, Object[] args, Class<?> clazz,
			boolean isHBM) {

		SQLQuery query = getSession().createSQLQuery(sql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}

		if (isHBM) {// 持久化类
			query.addEntity(clazz);
		} else {// DTO
			query.setResultTransformer(new AliasToBeanResultTransformer(clazz));
		}

		return query.uniqueResult();

	}

	public Object queryBySQL(String sql, Object arg, Class<?> clazz,
			boolean isHBM) {
		return this.queryBySQL(sql, new Object[] { arg }, clazz, isHBM);
	}

	public Object queryBySQL(String sql, Class<?> clazz, boolean isHBM) {
		return this.queryBySQL(sql, null, clazz, isHBM);
	}

	public void updateBySQL(String sql, Object[] args) {

		SQLQuery query = getSession().createSQLQuery(sql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}

		query.executeUpdate();

	}

	public void updateBySQL(String sql, Object arg) {
		this.updateBySQL(sql, new Object[] { arg });

	}

	public void updateBySQL(String sql) {
		this.updateBySQL(sql, null);

	}

	public PageBean findByHQL(String hql, Object[] args, PageBean pageBean) {
		Query query = getSession().createQuery(hql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}

		// 设置分页
		query.setFirstResult(
				(pageBean.getPageNow() - 1) * pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize());

		// 返回结果集
		pageBean.setDatas(query.list());

		// 获取总记录数
		String count_hql = this.getCountHQL(hql);
		Query count_query = getSession().createQuery(count_hql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				count_query.setParameter(i, args[i]);
			}
		}

		Long totalCount = (Long) count_query.uniqueResult();
		//
		pageBean.setTotalCount(totalCount);
		//
		Long totalPages = totalCount % pageBean.getPageSize() == 0 ? totalCount
				/ pageBean.getPageSize() : totalCount / pageBean.getPageSize()
				+ 1;
		pageBean.setTotalPages(totalPages);

		return pageBean;
	}

	private String getCountHQL(String hql) {
		String str = hql.substring(0, hql.toLowerCase().indexOf("from"));
		String count_hql = "";
		if (str.trim().length() == 0) {// from User
			count_hql = "select count(*) " + hql;
		} else {// select u from User
			count_hql = hql.replace(str, "select count(*) ");
		}

		return count_hql;
	}

	public PageBean findByHQL(String hql, Object arg, PageBean pageBean) {
		return this.findByHQL(hql, new Object[] { arg }, pageBean);
	}

	public PageBean findByHQL(String hql, PageBean pageBean) {
		return this.findByHQL(hql, null, pageBean);
	}

	private String getCountSQL(String sql) {
		String str = sql.substring(0, sql.toLowerCase().indexOf("from"));
		String count_sql = sql.replace(str, "select count(*) ");

		return count_sql;
	}

	public PageBean findBySQL(String sql, Object[] args, PageBean pageBean,
			Class<?> clazz, boolean isHBM) {
		SQLQuery query = getSession().createSQLQuery(sql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}
		if (isHBM) {// 持久化类
			query.addEntity(clazz);
		} else {// DTO
			query.setResultTransformer(new AliasToBeanResultTransformer(clazz));
		}

		// 设置分页
		query.setFirstResult(
				(pageBean.getPageNow() - 1) * pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize());

		// 返回结果集
		pageBean.setDatas(query.list());

		// 获取总记录数
		String count_sql = this.getCountSQL(sql);
		SQLQuery count_query = getSession().createSQLQuery(count_sql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				count_query.setParameter(i, args[i]);
			}
		}

		BigInteger totalCount1 = (BigInteger) count_query.uniqueResult();
		Long totalCount = totalCount1.longValue();
		//
		pageBean.setTotalCount(totalCount);
		//
		Long totalPages = totalCount % pageBean.getPageSize() == 0 ? totalCount
				/ pageBean.getPageSize() : totalCount / pageBean.getPageSize()
				+ 1;
		pageBean.setTotalPages(totalPages);

		return pageBean;
	}

	public PageBean findBySQL(String sql, Object arg, PageBean pageBean,
			Class<?> clazz, boolean isHBM) {
		return this
				.findBySQL(sql, new Object[] { arg }, pageBean, clazz, isHBM);
	}

	public PageBean findBySQL(String sql, PageBean pageBean, Class<?> clazz,
			boolean isHBM) {
		return this.findBySQL(sql, null, pageBean, clazz, isHBM);
	}

	public List<Map<String, Object>> listBySQL(String sql, Object[] args) {

		SQLQuery query = getSession().createSQLQuery(sql);
		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				query.setParameter(i, args[i]);
			}
		}

		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

		return query.list();

	}

	public List<Map<String, Object>> listBySQL(String sql, Object arg) {
		return this.listBySQL(sql, new Object[] { arg });
	}

	public List<Map<String, Object>> listBySQL(String sql) {
		return this.listBySQL(sql, null);
	}

}
