package org.lanqiao.biz.impl;

import java.util.List;

import org.lanqiao.biz.ManagerBiz;
import org.lanqiao.dao.ManagerDao;
import org.lanqiao.entity.Manager;



public class ManagerBizImpl implements ManagerBiz{
	
	private ManagerDao managerdao;
	public void setManagerdao(ManagerDao managerdao) {
		this.managerdao = managerdao;
	}

	@Override
	public Manager login(int aid, String password) {
		return managerdao.login(aid, password);
	}

	@Override
	public Manager getOne(int aid) {
		return managerdao.getOne(aid);
	}

	@Override
	public boolean UpdateManagerphoto(Manager m) {
		return managerdao.UpdateManagerphoto(m);
	}

	@Override
	public Manager findbyName(String name) {
		// TODO Auto-generated method stub
		return managerdao.findbyName(name);
	}

	@Override
	public List<Manager> fingall() {
		System.out.println("managerdao.findall():"+managerdao.findall());
		return managerdao.fingall();
	}

	@Override
	public boolean add(Manager m) {
		return managerdao.add(m);
	}

	@Override
	public boolean updateById(Manager m) {
		return managerdao.updateById(m);
	}

	@Override
	public boolean deleteById(int id) {
		return managerdao.deleteById(id);
	}

	@Override
	public List<Manager> findall() {
		System.out.println("managerdao.findall():"+managerdao.findall());
		return managerdao.fingall();
	}

	@Override
	public boolean Upadtepass(int mid, String pass) {
		// TODO Auto-generated method stub
		return managerdao.Upadtepass(mid, pass);
	}

	@Override
	public boolean UpadteInfo(Manager m) {
		// TODO Auto-generated method stub
		return managerdao.UpadteInfo(m);
	}

	@Override
	public boolean UpdateIndroce(int id, String info) {
		// TODO Auto-generated method stub
		return managerdao.UpdateIndroce(id, info);
	}

}