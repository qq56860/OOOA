package org.lanqiao.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.lanqiao.biz.NoticeBiz;
import org.lanqiao.dao.NoticeDao;
import org.lanqiao.entity.Notice;
import org.lanqiao.entity.Page;



public class NoticeBizImpl implements NoticeBiz{
	private NoticeDao noticedao;
	
	
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}

	//
	public List<Notice>findByPage(Page page) {
		return noticedao.findByPage(page);
	}

	//获得数量
	public int getCont() {
		return noticedao.getCont();
	}

	//查看单挑公告全部信息
	public Notice getOne(int nid) {
		return noticedao.getOne(nid);
	}

	//查看所有公告信息
	public ArrayList<Notice> findAll() {
		return noticedao.findAll();
	}

	//发布公告
	public boolean add(Notice n) {
		return noticedao.add(n);
	}

	//修改公告
	public boolean update(Notice n) {
		return noticedao.update(n);
	}

	//删除公告
	public boolean delete(int id) {
		return noticedao.delete(id);
	}

	//点赞！！！修改赞信息
	public boolean updateZan(Notice notice) {
		return noticedao.updateZan(notice);
	}

}
