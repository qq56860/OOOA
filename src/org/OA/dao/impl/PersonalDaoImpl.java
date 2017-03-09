package org.lanqiao.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.lanqiao.dao.PersonalDao;
import org.lanqiao.entity.Page;
import org.lanqiao.entity.Personal;

public class PersonalDaoImpl implements PersonalDao{
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//增加
	@Override
	public boolean add(Personal p) {
		try {
			sessionFactory.getCurrentSession().save(p);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	//分页查询
	@Override
	public List<Personal> findByPage(Page page, int id) {
		String hql="from Personal where id="+id+" order by top desc,toptime desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		return (ArrayList<Personal>) query.list();
	}
	
	//分页查询条件
	@Override
	public List<Personal> findByPageConditions(Page page, int id,
			String conditions) {
		String hql="from Personal where id="+id+" and CONCAT(pname,ptel,paddress) like '%"+conditions+"%' ";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		return (ArrayList<Personal>) query.list();
	}

	//获得分页查询条件页数
	@Override
	public int getConditionsCount(int id, String conditions) {
		// TODO Auto-generated method stub
		return 0;
	}
	//获取总数量
	@Override
	public int getCont(int id) {
		System.out.println("进入获得信息条数的方法......");
		String hql="select count(*) from Personal";
		int count=((Long) sessionFactory
				.getCurrentSession()
				.createQuery(hql).iterate().next()).intValue();
		System.out.println("获得信息条数："+count);
		
		return count;
	}
	//删除
	@Override
	public int delete(int pId) {
		try {
			Personal personal=(Personal)sessionFactory.getCurrentSession().get(Personal.class, pId);
			sessionFactory.getCurrentSession().delete(personal);
			return 1;
		} catch (HibernateException e) {			
			e.printStackTrace();
			return 0;
		}	
	}
	//修改
	@Override
	public boolean change(Personal p) {
		try {
			sessionFactory.getCurrentSession().update(p);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	//置顶
	@Override
	public boolean top(int pid) {
		return false;
//		String hql = "update Personal set top=1,toptime=? where pid=?";
//		Date date=new Date();
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time=format.format(date);
//		Object params[] = {time,pid};
//		return pdao.update(sql, params);
		
	}
	//取消置顶
	@Override
	public boolean notop(int pid) {
		// TODO Auto-generated method stub
		return false;
	}

}
