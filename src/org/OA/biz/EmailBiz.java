package org.lanqiao.biz;

import java.util.ArrayList;
import java.util.List;

import org.lanqiao.entity.Email;
import org.lanqiao.entity.Manager;

public interface EmailBiz {
	//增加邮件
	public boolean AddEmail(Email email);
	//按id分页查询
	public List<Email> findByPage(int mailReceiveId);
	//查询总数
	public ArrayList<Email> selectAll();
	//获取总数量
	public int getCont(int id);
	//批量删除
	public boolean batchDelete(String[] mids);
	//标记为已读
	public boolean Updateread(int id);
	//删入垃圾箱
	public boolean AddRubbish(int id);
	public List<Email> selectid(int mailSendId);

	public Email findAll(int mailReceiveId);
	public Email getOne(int mailSendId);
	public Email findbytitle(String mailTitle);
	
	public Manager findone(int mId);
	
	public List<Manager> findByid(int mId);
	
	public Email selectbyeid(int mailId);
	public ArrayList<Manager> mselectAll();
	public boolean delete(int id);
	
	
	
	
}
