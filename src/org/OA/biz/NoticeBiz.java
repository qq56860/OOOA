package org.lanqiao.biz;

import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Notice;
import org.lanqiao.entity.Page;


public interface NoticeBiz {
	//分页查询
		public List<Notice> findByPage(Page page);
		//获取总数量
		public int getCont();
		//根据id查询
		public Notice getOne(int nid);
		//点赞
		public boolean updateZan(Notice notice);
		//查询全部
		public ArrayList<Notice> findAll();
		public boolean add(Notice n);
		public boolean update(Notice n);
		public boolean delete(int id);

}
