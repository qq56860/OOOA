package org.lanqiao.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.lanqiao.dao.EmployeeDao;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Page;
public class EmployeeDaoImpl implements EmployeeDao{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public Employee login(int aid, String password) {
		// TODO Auto-generated method stub
		String hql="from Employee where eId=? and ePassword=?";
		Query qu=sessionFactory.getCurrentSession().createQuery(hql);
		qu.setParameter(0, aid);
		qu.setParameter(1, password);

		return (Employee) qu.uniqueResult();
	}

	public Employee getOne(int eid) {
		Employee ee=(Employee) sessionFactory.getCurrentSession().get(Employee.class, eid);
		return ee;
	}


	@Override
	public boolean UpdateEmployeephoto(Employee e) {
		try {
			sessionFactory.getCurrentSession().update(e);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee findbyName(String name) {
		String hql = "from Employee where eName=?";
		Query qu=sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, name);
		return (Employee) qu.uniqueResult();
	}

	public List<Employee> fingall() {
		String hql = "from Employee";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public Employee getbyID(int id) {
		Employee employee=(Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> findByDe(int id) {
		String hql = "from Employee where department="
				+ "(select department from Manager where mId =?)";
		Query qu=sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, id);
		return (List<Employee>) qu.list();
	}

	@Override
	public List<Employee> findByCon(int id, String condition) {
		String hql ="from Employee where department=(select department from "
				+ " Manager where mId =?) and CONCAT(eName,eSex,"
				+ "department,eTel,eAddress) like '%"+condition+"%'";
		Query qu=sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, id);
		return (List<Employee>) qu.list();
	}


	@Override
	public boolean add(Employee e) {
		try {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String hql="insert into Employee (department,eIntroduce,eNation,"
				+ "eaddress,eBirth,eConstellation,eemail,ename,epassword,etel,esex,epassword,eAge) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,0)";
		Query query=session.createSQLQuery(hql);
		query.setParameter(0, e.getDepartment());
		query.setParameter(1, e.geteIntroduce());
		query.setParameter(2, e.geteNation());
		query.setParameter(3, e.geteAddress());
		query.setParameter(4, e.geteBirth());
		query.setParameter(5, e.geteConstellation());
		query.setParameter(6, e.geteEmail());
		query.setParameter(7, e.geteName());
		query.setParameter(8, e.getePassword());
		query.setParameter(9, e.geteTel());
		query.setParameter(10,e.geteSex());
		query.setParameter(11, e.getePassword());
		query.executeUpdate();
		session.getTransaction().commit();
		return true;
	} catch (HibernateException E) {
		E.printStackTrace();
		return false;
	}
	}

	@Override
	public boolean updateById(Employee e) {
		System.out.println("进入修改方法");
		try {
			String sql="update Employee set etel=?,eemail=? where eid=?";
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Query query=session.createQuery(sql);
			query.setParameter(0, e.geteTel());
			query.setParameter(1, e.geteEmail());
			query.setParameter(2, e.geteId());
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteById(int id) {
		System.out.println("进入删除方法");
		 try {	 
			String hql="delete from Employee where eid=?";
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setParameter(0, id);
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	//获得员工信息条数
	public int getCount() {
		System.out.println("进入获得信息条数的方法......");
		String hql="select count(*) from Employee";
		int count=((Long) sessionFactory
				.getCurrentSession()
				.createQuery(hql).iterate().next()).intValue();
		System.out.println("获得信息条数："+count);
		return count;
	}

	@Override
	public List<Employee> findByPage(Page page) {

		System.out.println("进入dao层分页方法：");
		Query query =sessionFactory.getCurrentSession().createQuery("from Employee");
		System.out.println("获得分页起始行数："+page.getBeginIndex());
		query.setFirstResult(page.getBeginIndex());
		query.setMaxResults(page.getEveryPage());
		System.out.println("query:"+query.list());	
		return query.list();
	}


	@Override
	public boolean updatename(int id, String password) {
		try {
			Employee e=getOne(id);
			e.setePassword(password);
			sessionFactory.getCurrentSession().update(e);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateemail(int id, String email) {
		try {
			Employee e=getOne(id);
			e.seteEmail(email);
			sessionFactory.getCurrentSession().update(e);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatesex(int id, String sex, String nation, String birth,
			String tel) {
		try {
			Employee e=getOne(id);
			e.seteSex(sex);
			e.seteNation(nation);
			e.seteBirth(birth);
			e.seteTel(tel);
			sessionFactory.getCurrentSession().update(e);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateaddress(int id, String address) {
		try {
			Employee e=getOne(id);
			e.seteAddress(address);
			sessionFactory.getCurrentSession().update(e);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatede(int id, String de, String con) {
		try {
			Employee e=getOne(id);
			e.setDepartment(de);
			e.seteConstellation(con);
			System.out.println(e.geteConstellation());
			sessionFactory.getCurrentSession().update(e);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateintro(int id, String intro) {
		try {
			Employee e=getOne(id);
			e.seteIntroduce(intro);
			sessionFactory.getCurrentSession().update(e);
			return true;
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}

}
