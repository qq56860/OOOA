package org.lanqiao.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.lanqiao.biz.PersonalBiz;
import org.lanqiao.dao.PersonalDao;
import org.lanqiao.entity.Page;
import org.lanqiao.entity.Personal;



public class PersonalBizImpl implements PersonalBiz{
	
	private PersonalDao persondao;
	

	public void setPersondao(PersonalDao persondao) {
		this.persondao = persondao;
	}
	//增加
	@Override
	public boolean add(Personal p) {
		// TODO Auto-generated method stub
		return persondao.add(p);
	}
    //获得全部的个人信息
	@Override
	public List<Personal> findByPage(Page page, int id) {
		// TODO Auto-generated method stub
		return persondao.findByPage(page, id);
	}

	@Override
	public List<Personal> findByPageConditions(Page page, int id, String conditions) {
		// TODO Auto-generated method stub
		return persondao.findByPageConditions(page, id, conditions);
	}

	@Override
	public int getConditionsCount(int id, String conditions) {
		// TODO Auto-generated method stub
		return persondao.getConditionsCount(id, conditions);
	}

	@Override
	public int getCont(int id) {
		// TODO Auto-generated method stub
		return persondao.getCont(id);
	}

	//删除
	@Override
	public boolean delete(int pid) {
		// TODO Auto-generated method stub
		return persondao.delete(pid)==1?true:false;
	}

	//修改
	@Override
	public boolean change(Personal p) {
		// TODO Auto-generated method stub
		return persondao.change(p);
	}

	@Override
	public boolean top(int pid) {
		// TODO Auto-generated method stub
		return persondao.top(pid);
	}

	@Override
	public boolean notop(int pid) {
		// TODO Auto-generated method stub
		return persondao.notop(pid);
	}
	

}
