package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Page;
import org.lanqiao.entity.Personal;

public interface PersonalDao{
	        //增加
			public boolean add(Personal p);
			//分页查询
			public List<Personal> findByPage(Page page,int id);
			//分页查询条件
			public List<Personal> findByPageConditions(Page page,int id,String conditions);
			//获得分页查询条件页数
			public int getConditionsCount(int id,String conditions);
			//获取总数量
			public int getCont(int id);
			//删除
			public int delete(int pid);
			//修改
			public boolean change(Personal p);
			//置顶
			public boolean top(int pid);
			//取消置顶
			public boolean notop(int pid);
}
