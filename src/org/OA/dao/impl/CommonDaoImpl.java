package org.lanqiao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.lanqiao.dao.CommonDao;
import org.lanqiao.entity.Common;
import org.lanqiao.entity.Page;

public class CommonDaoImpl implements CommonDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Common> findByPage(Page page) {
		System.out.println("进入dao层分页方法：");
		Query query =sessionFactory.getCurrentSession().createQuery("from Common");
		System.out.println("获得分页起始行数："+page.getBeginIndex());
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		System.out.println("query:"+query.list());
		
		return query.list();
	}

	@Override
	public int getCont() {
		System.out.println("进入获得信息条数的方法......");
		String hql="select count(*) from Common";
		int count=((Long) sessionFactory
				.getCurrentSession()
				.createQuery(hql).iterate().next()).intValue();
		System.out.println("获得信息条数："+count);
		
		return count;
	}

	@Override
	public List<Common> findByPageConditions(Page page, String conditions) {
		String hql="from Common where CONCAT(comname,managername,comtel) like '%"+conditions+"%' ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		return (ArrayList<Common>) query.list();
	}

	@Override
	public int getConditionsCount(String conditions) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(Common c) {
		try {
			sessionFactory.getCurrentSession().update(c);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int delete(int comId) {
		try {
			Common commom=(Common)sessionFactory.getCurrentSession().get(Common.class, comId);
			sessionFactory.getCurrentSession().delete(commom);
			return 1;
		} catch (HibernateException e) {			
			e.printStackTrace();
			return 0;
		}	
	}
	

	//获得全部信息
	@Override
	public ArrayList<Common> findall() {
		String hql="from Common";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (ArrayList<Common>) query.list();
	}
	@Override
	public List<Common> findByPage(Page page, int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
