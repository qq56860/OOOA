package org.lanqiao.biz.impl;

import org.lanqiao.biz.AdminBiz;
import org.lanqiao.dao.AdminDao;
import org.lanqiao.entity.Admin;

public class AdminBizImpl implements AdminBiz{

	private AdminDao admindao; 
	public void setAdmindao(AdminDao admindao) {
		this.admindao = admindao;
	}

	@Override
	public Admin login(int aid, String password) {
		return admindao.login(aid, password);
	}

	@Override
	public Admin getOne(int aid) {
		return admindao.getOne(aid);
	}

	@Override
	public boolean UpdateAdminphoto(Admin a) {
		// TODO Auto-generated method stub
		return admindao.UpdateAdminphoto(a);
	}

	@Override
	public boolean add(Admin a) {
		// TODO Auto-generated method stub
		return admindao.add(a);
	}

	@Override
	public boolean update(Admin a) {
		// TODO Auto-generated method stub
		return admindao.update(a);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return admindao.delete(id);
	}

	
	

	

}
