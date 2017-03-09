package org.lanqiao.biz;

import java.util.List;

import org.lanqiao.dao.EmployeeDao;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Page;



public interface EmployeeBiz {
	

//登录
public Employee login(int aid,String password);
//获取单个信息
public Employee getOne(int eid);
//修改信息
public boolean UpdateEmployeephoto(Employee e);
//根据姓名查找
public Employee findbyName(String name);
//查询所有
public List<Employee> fingall();
//按id查询
public Employee getbyID(int id);
//查询部门所有员工
public List<Employee> findByDe(int id);
//查询部门所有员工按条件
public List<Employee> findByCon(int id,String condition);
public boolean add(Employee e);
public boolean updateById(Employee e);
public boolean deleteById(int id);
public int getCount();
public List<Employee> findByPage(Page page);
//修改职工个人信息
public boolean updatename(int id,String password);
//修改邮箱
public boolean updateemail(int id,String email);
//修改性别
public boolean updatesex(int id,String sex,String nation,String birth,String tel);
//地址
public boolean updateaddress(int id,String address);
//部门
public boolean updatede(int id,String de,String con);
//个人简介
public boolean updateintro(int id,String intro);
}