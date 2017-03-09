package org.lanqiao.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.lanqiao.dao.ScheduleDao;
import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Schedule;

public class ScheduleDaoImpl implements ScheduleDao{

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	public List<Schedule> queryAll(int id) {
		System.out.println("abc"+id);
		String hql= "from Schedule where id=? ";
		Query qu=sessionFactory.getCurrentSession().createQuery(hql);
		qu.setParameter(0, id);
		return qu.list();
	}

	@Override
	public void add(Schedule s) {
		
		
	    sessionFactory.getCurrentSession().save(s);  
		
	    
	}

	@Override
	public boolean delete(int id) {
		String hql = "delete from Schedule where schid =?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);  
	    query.setInteger(0, id);
		/*User user=(User) sessionFactory.getCurrentSession().get(User.class, id);
		sessionFactory.getCurrentSession().delete(user);
		*/ 
	    return  query.executeUpdate()>0;
	}

}
