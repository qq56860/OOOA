package org.lanqiao.biz.impl;

import java.util.List;

import org.lanqiao.biz.ScheduleBiz;
import org.lanqiao.dao.AdminDao;
import org.lanqiao.dao.ScheduleDao;
import org.lanqiao.dao.impl.ScheduleDaoImpl;
import org.lanqiao.entity.Schedule;




public class ScheduleBizImpl implements ScheduleBiz {

	private ScheduleDao scheduledao; 
	public void setScheduledao(ScheduleDao scheduledao) {
		this.scheduledao = scheduledao;
	}
	@Override
	public List<Schedule> queryAll(int id) {
		return scheduledao.queryAll(id);
	}

	@Override
	public void add(Schedule s) {
		// TODO Auto-generated method stub
		scheduledao.add(s);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return scheduledao.delete(id);
	}

	

}
