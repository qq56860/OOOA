package org.lanqiao.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.lanqiao.biz.CommonBiz;
import org.lanqiao.dao.CommonDao;
import org.lanqiao.entity.Common;
import org.lanqiao.entity.Page;



public class CommonBizImpl implements CommonBiz{

	private CommonDao commondao;
	

	public void setCommondao(CommonDao commondao) {
		this.commondao = commondao;
	}

	@Override
	public List<Common> findByPage(Page page) {
		// TODO Auto-generated method stub
		return commondao.findByPage(page);
	}

	@Override
	public int getCont() {
		// TODO Auto-generated method stub
		return commondao.getCont();
	}

	@Override
	public List<Common> findByPageConditions(Page page, String conditions) {
		// TODO Auto-generated method stub
		return commondao.findByPageConditions(page, conditions);
	}

	@Override
	public int getConditionsCount(String conditions) {
		// TODO Auto-generated method stub
		return commondao.getConditionsCount(conditions);
	}

	@Override
	public boolean update(Common c) {
		// TODO Auto-generated method stub
		return commondao.update(c);
	}

	@Override
	public boolean delete(int comid) {
		// TODO Auto-generated method stub
		return commondao.delete(comid)==1?true:false;
	}

	@Override
	public ArrayList<Common> findall() {
		// TODO Auto-generated method stub
		return commondao.findall();
	}

	@Override
	public List<Common> findByPage(Page page, int id) {
		// TODO Auto-generated method stub
		return commondao.findByPage(page, id);
	}
	

}
