package org.lanqiao.biz.impl;

import java.util.List;

import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.dao.EmployeeDao;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Page;



public class EmployeeBizImpl implements EmployeeBiz{
	
	private EmployeeDao employeedao;
	

	public void setEmployeedao(EmployeeDao employeedao) {
		this.employeedao = employeedao;
	}

	@Override
	public Employee login(int aid, String password) {
		// TODO Auto-generated method stub
		return employeedao.login(aid, password);
	}

	@Override
	public Employee getOne(int eid) {
		return employeedao.getOne(eid);
	}

	@Override
	public boolean UpdateEmployeephoto(Employee e) {
		// TODO Auto-generated method stub
		return employeedao.UpdateEmployeephoto(e);
	}

	@Override
	public Employee findbyName(String name) {
		// TODO Auto-generated method stub
		return employeedao.findbyName(name);
	}

	@Override
	public List<Employee> fingall() {
		return employeedao.fingall();
	}

	@Override
	public Employee getbyID(int id) {
		return employeedao.getbyID(id);
	}

	@Override
	public List<Employee> findByDe(int id) {
		// TODO Auto-generated method stub
		return employeedao.findByDe(id);
	}

	@Override
	public List<Employee> findByCon(int id, String condition) {
		// TODO Auto-generated method stub
		return employeedao.findByCon(id, condition);
	}

	@Override
	public boolean add(Employee e) {
		return employeedao.add(e);
	}

	@Override
	public boolean updateById(Employee e) {
		return employeedao.updateById(e);
	}

	@Override
	public boolean deleteById(int id) {
		return employeedao.deleteById(id);
	}

	@Override
	public int getCount() {
		return employeedao.getCount();
	}

	@Override
	public List<Employee> findByPage(Page page) {

		return employeedao.findByPage(page);
	}

	@Override
	public boolean updatename(int id, String password) {
		// TODO Auto-generated method stub
		return employeedao.updatename(id, password);
	}

	@Override
	public boolean updateemail(int id, String email) {
		// TODO Auto-generated method stub
		return employeedao.updateemail(id, email);
	}

	@Override
	public boolean updatesex(int id, String sex, String nation, String birth, String tel) {
		// TODO Auto-generated method stub
		return employeedao.updatesex(id, sex, nation, birth, tel);
	}

	@Override
	public boolean updateaddress(int id, String address) {
		// TODO Auto-generated method stub
		return employeedao.updateaddress(id, address);
	}

	@Override
	public boolean updatede(int id, String de, String con) {
		// TODO Auto-generated method stub
		return employeedao.updatede(id, de, con);
	}

	@Override
	public boolean updateintro(int id, String intro) {
		// TODO Auto-generated method stub
		return employeedao.updateintro(id, intro);
	}


}
