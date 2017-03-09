package org.lanqiao.biz;



import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Common;
import org.lanqiao.entity.Page;
import org.lanqiao.entity.Personal;



public interface CommonBiz {
	//分页查询
	public List<Common> findByPage(Page page);
	//分页查询
	public List<Common> findByPage(Page page,int id);
	//获取总数量
	public int getCont();
	//分页查询条件
	public List<Common> findByPageConditions(Page page,String conditions);
	//获得分页查询条件页数
	public int getConditionsCount(String conditions);
	//修改
	public boolean update(Common c);
	//删除
	public boolean delete(int comid);
	//查询全部
	public ArrayList<Common> findall();
}
