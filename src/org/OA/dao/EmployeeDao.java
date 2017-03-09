package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Page;

public interface EmployeeDao{
	
	public Employee login(int aid,String password);
	
	public Employee getOne(int eid);
	
	public boolean UpdateEmployeephoto(Employee e);
	
	public Employee findbyName(String name);
	
	public List<Employee> fingall();
	
	public Employee getbyID(int id);
	
	public List<Employee> findByDe(int id);
	
	public List<Employee> findByCon(int id,String condition);
	public boolean add(Employee e);
	public boolean updateById(Employee e);
	public boolean deleteById(int id);
	public int getCount();
	public List<Employee> findByPage(Page page);
	
	public boolean updatename(int id,String password);
	
	public boolean updateemail(int id,String email);
	
	public boolean updatesex(int id,String sex,String nation,String birth,String tel);
	
	public boolean updateaddress(int id,String address);
	
	public boolean updatede(int id,String de,String con);
	
	public boolean updateintro(int id,String intro);
}
