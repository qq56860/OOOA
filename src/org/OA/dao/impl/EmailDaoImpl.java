package org.lanqiao.dao.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.lanqiao.dao.EmailDao;
import org.lanqiao.entity.Email;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Manager;

public class EmailDaoImpl implements EmailDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean AddEmail(Email email) {
		Email e = new Email();
		e.setMailTitle(email.getMailTitle());
		e.setMailContent(email.getMailContent());
		e.setMailReceiveId(email.getMailReceiveId());
		e.setMailSendId(email.getMailSendId());
		long l=System.currentTimeMillis();
		Date date=new Date(l);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		e.setMailDate(sdf.format(date));
		
			sessionFactory.getCurrentSession().save(e);
		return true;
		
	}

	
	@Override
	public List<Email> findByPage(int mailReceiveId) {
		String hql="from Email where mailReceiveId=?";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, mailReceiveId);
		
		return (List<Email>) query.list();
		
	}
	
	

	@Override
	public int getCont(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean batchDelete(String[] mids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Updateread(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AddRubbish(int mailId) {
		Email email=(Email) sessionFactory.getCurrentSession().get(Email.class, mailId);
		email.setState(0);
		try {
			sessionFactory.getCurrentSession().update(email);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public ArrayList<Email> selectAll() {
		String hql="from Email where state=0";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (ArrayList<Email>)query.list();
	}

	@Override
	public List<Email> selectid(int mailSendId) {
		String hql="from Email where mailSendId=?";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, mailSendId);
		
		return (List<Email>)query.list();
	}
	
	
	public Email getOne(int mailSendId) {
		Email ee=(Email) sessionFactory.getCurrentSession().get(Email.class, mailSendId);
		return ee;
	}

	
	@Override
	public Email findAll(int mailReceiveId) {
		Email email=(Email) sessionFactory.getCurrentSession().get(Email.class, mailReceiveId);
		return email;
	}

	@Override
	public Email findbytitle(String mailTitle) {
		String hql = "from Email where mailTitle=?";
		Query qu=sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, mailTitle);
		return (Email) qu.uniqueResult();
	}

	@Override
	public Manager findone(int mailId) {
		String hql="from Manager where mId=(select mailSendId from Email where mailId=?)";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, mailId);
		return (Manager) query.uniqueResult();
	}

	@Override
	public List<Manager> findByid(int mId) {
		String hql="from Manager where mId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, mId);
		return query.list();
	}

	@Override
	public Email selectbyeid(int mailId) {
		Email email=(Email) sessionFactory.getCurrentSession().get(Email.class, mailId);
		return email;
	
	}
	
	public ArrayList<Manager> mselectAll() {
		String hql="from Email where state=0";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (ArrayList<Manager>)query.list();
	}
	

	public boolean delete(int id) {
		
		Email email=(Email) sessionFactory.getCurrentSession().get(Email.class, id);
		try {
			sessionFactory.getCurrentSession().delete(email);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
}
