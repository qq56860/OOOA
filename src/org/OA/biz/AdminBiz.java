package org.lanqiao.biz;

import org.lanqiao.entity.Admin;

public interface AdminBiz {
	
	//登录
	public Admin login(int aid,String password);
	public Admin getOne(int aid);
	public boolean UpdateAdminphoto(Admin a);
	public boolean add(Admin a);
	public boolean update(Admin a);
	public boolean delete(int id);

}
