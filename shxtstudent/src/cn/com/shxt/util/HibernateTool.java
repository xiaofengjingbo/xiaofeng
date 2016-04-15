package cn.com.shxt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTool {
	private static SessionFactory cf;
	
	static{
		Configuration cfg = new Configuration().configure();
		cf = cfg.buildSessionFactory();//重量级
	}
	
	public static Session getSession() {
		
		Session session = cf.openSession();
		return session;
	}
		
}
