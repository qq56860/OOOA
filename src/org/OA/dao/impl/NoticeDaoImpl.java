package org.lanqiao.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lanqiao.dao.NoticeDao;
import org.lanqiao.entity.Notice;
import org.lanqiao.entity.Page;

public class NoticeDaoImpl implements NoticeDao{

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//根据页面显示公告信息
	@Override
	public List<Notice> findByPage(Page page) {
		System.out.println("进入dao层分页方法：");
		Query query =sessionFactory.getCurrentSession().createQuery("from Notice order by date desc");
		System.out.println("获得分页起始行数："+page.getBeginIndex());
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		System.out.println("query:"+query.list());
		return query.list();
	}

	//获取总数量
	public int getCont() {
		System.out.println("进入获得信息条数的方法......");
		String hql="select count(*) from Notice";
		int count=((Long) sessionFactory
				.getCurrentSession()
				.createQuery(hql).iterate().next()).intValue();
		System.out.println("获得信息条数："+count);
		
		return count;
	}

	//查看单挑公告全部信息
	public Notice getOne(int nid) {
		Notice notice =(Notice)sessionFactory.getCurrentSession().get(Notice.class, nid);
		return notice;
	}

	//点赞！！！修改赞信息
		public boolean updateZan(Notice notice) {
			try {
					
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				String hql="update Notice set zan=?,state=? where nid=?";
				Query query=session.createQuery(hql);
				query.setParameter(0, notice.getZan());
				query.setParameter(1, notice.getState()+1);
				query.setParameter(2, notice.getnId());
				query.executeUpdate();
				session.getTransaction().commit();
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			
		}



		
		
	//查看所有公告信息
	public ArrayList<Notice> findAll() {
		String hql="from Notice order by date desc";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return (ArrayList<Notice>) query.list();
	}

	//发布公告？
	public boolean add(Notice n) {
		Notice notice=new Notice();
		try {
			
			sessionFactory.getCurrentSession().save(n);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	//修改公告
		@Override
		public boolean update(Notice n) {
			try {
				System.out.println("进入update方法...");
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				String hql="update Notice set ntitle=?,nsummary=?,ncontent=?,date=?,issuer=? where nid=?";
				Query query=session.createQuery(hql);
				query.setParameter(0, n.getnTitle());
				query.setParameter(1, n.getnSummary());
				query.setParameter(2, n.getnContent());
				query.setParameter(3, n.getDate());
				query.setParameter(4, n.getIssuer());
				query.setParameter(5, n.getnId());
				
				System.out.println("nid:+++++++"+n.getnId());
				System.out.println("ntitle++++"+n.getnTitle());
				System.out.println("nContent++++"+n.getnContent());
				query.executeUpdate();
				session.getTransaction().commit();
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			
		}


	//删除公告
	public boolean delete(int id) {
		try {
				
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			String hql="delete from notice where nid=?";
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


	


}
