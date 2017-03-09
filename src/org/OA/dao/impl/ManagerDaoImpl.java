package org.lanqiao.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lanqiao.dao.ManagerDao;
import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Manager;

public class ManagerDaoImpl implements ManagerDao{
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Manager login(int aid, String password) {
		String hql="from Manager where mId=? and mPassword=?";
		Query qu=sessionFactory.getCurrentSession().createQuery(hql);
		qu.setParameter(0, aid);
		qu.setParameter(1, password);
		return (Manager) qu.uniqueResult();
	}

	@Override
	public Manager getOne(int aid) {
		Manager mm=(Manager) sessionFactory.getCurrentSession().get(Manager.class, aid);
		return mm;
	}

	@Override
	public boolean UpdateManagerphoto(Manager m) {
		try {
			sessionFactory.getCurrentSession().update(m);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public Manager findbyName(String name) {
		String hql = "from Manager where mName=?";
		Query qu=sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, name);
		return (Manager) qu.uniqueResult();
	}

	@Override
	public List<Manager> fingall() {
		System.out.println("进入manager findall方法....");
		Query query=sessionFactory.getCurrentSession().createQuery("from Manager");
		System.out.println("query："+query.list());
		return query.list();
	}

	@Override
	public boolean add(Manager m) {	
		Manager mm=null;
		try {
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			String hql="insert into Manager (department,introduce,mNation,"
					+ "maddress,mBirth,mConstellation,memail,mname,mpassword,mtel,msex,mAge) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,0)";
			Query query=session.createSQLQuery(hql);
			query.setParameter(0, m.getDepartment());
			query.setParameter(1, m.getIntroduce());
			query.setParameter(2, m.getmNation());
			query.setParameter(3, m.getmAddress());
			query.setParameter(4, m.getmBirth());
			query.setParameter(5, m.getmConstellation());
			query.setParameter(6, m.getmEmail());
			query.setParameter(7, m.getmName());
			query.setParameter(8, m.getmPassword());
			query.setParameter(9, m.getmTel());
			query.setParameter(10,m.getmSex());
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	
		
	}

	@Override
	public boolean updateById(Manager m) {
		try {
			System.out.println("进入updatebyId方法...");
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			String hql="update Manager set mtel=?,memail=?,maddress=? where mid=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, m.getmTel());
			query.setParameter(1, m.getmEmail());
			query.setParameter(2, m.getmAddress());
			query.setParameter(3, m.getmId());
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
		

	@Override
	public boolean deleteById(int id) {
		try {
			
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			String hql="delete from Manager where mid=?";
			Query query=session.createSQLQuery(hql);
			query.setParameter(0, id);
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}		
	}

	@Override
	public List<Manager> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Upadtepass(int mid, String pass) {
		try {
			Manager e=getOne(mid);
			e.setmPassword(pass);
			sessionFactory.getCurrentSession().update(e);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpadteInfo(Manager m) {
		try {
			sessionFactory.getCurrentSession().update(m);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean UpdateIndroce(int id, String info) {
		try {
			Manager e=getOne(id);
			e.setIntroduce(info);
			sessionFactory.getCurrentSession().update(e);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

}
