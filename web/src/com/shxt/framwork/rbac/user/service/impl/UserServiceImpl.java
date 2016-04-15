package com.shxt.framwork.rbac.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shxt.base.dao.BaseDaoImpl;
import com.shxt.base.dao.IBaseDao;
import com.shxt.base.dao.PageBean;
import com.shxt.framwork.rbac.user.dto.UserDTO;
import com.shxt.framwork.rbac.user.model.User;
import com.shxt.framwork.rbac.user.service.IUserService;

@Service(value="userService")
public class UserServiceImpl implements IUserService {
	
	private IBaseDao baseDao;
	@Autowired
	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public User login(User user) {
		String hql = "from User u where u.account=? and u.password=?";
		
		return (User) this.baseDao.queryByHQL(hql, new Object[]{user.getAccount().trim(),user.getPassword().trim()});
	}

	public PageBean find(PageBean pageBean) {
		
		String hql = "from User";
		
		return this.baseDao.findByHQL(hql, pageBean);
		
		
	}

}
