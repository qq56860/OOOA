package org.lanqiao.biz;

import java.util.List;

import org.lanqiao.entity.Schedule;

public interface ScheduleBiz {

	//查询所有日程
	public List<Schedule> queryAll(int id);
		
	//添加日程
	public void add(Schedule s);
	
	//删除日程
	public boolean delete(int id);
}
