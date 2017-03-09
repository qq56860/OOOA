package org.lanqiao.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lanqiao.dao.AdminDao;
import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Manager;

public class AdminDaoImpl implements AdminDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//管理员登录
	@Override
	public Admin login(int aid, String password) {
		String hql="from Admin where aId=? and aPassword=?";
		Query qu=sessionFactory.getCurrentSession().createQuery(hql);
		qu.setParameter(0, aid);
		qu.setParameter(1, password);
		return (Admin) qu.uniqueResult();
	}

	@Override
	public Admin getOne(int aid) {
		Admin aa=(Admin) sessionFactory.getCurrentSession().get(Admin.class, aid);
		return aa;
	}

	@Override
	public boolean UpdateAdminphoto(Admin a) {
		try {
			sessionFactory.getCurrentSession().update(a);
			return true;
		} catch (HibernateException e1) {
			e1.printStackTrace();
			return false;
		}

	}
	

	
	@Override
	public boolean add(Admin a) {
		Admin aa=null;
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			String hql="insert into Admin (aName,aPassword,aEmail,"
					+ "aSex,aBirth,aTel,aDepartment,aAddress,aNation,aConstellation,aIntroduce) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			Query query=session.createSQLQuery(hql);
			query.setParameter(0, a.getaName());
			query.setParameter(1, a.getaPassword());
			query.setParameter(2, a.getaEmail());
			query.setParameter(3, a.getaSex());
			query.setParameter(4, a.getaBirth());
			query.setParameter(5, a.getaTel());
			query.setParameter(6, a.getaDepartment());
			query.setParameter(7, a.getaAddress());
			query.setParameter(8, a.getaNation());
			query.setParameter(9, a.getaConstellation());
			query.setParameter(10,a.getaIntroduce());
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Admin a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
