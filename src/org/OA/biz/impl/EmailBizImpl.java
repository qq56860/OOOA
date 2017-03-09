package org.lanqiao.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.lanqiao.biz.EmailBiz;
import org.lanqiao.dao.impl.EmailDaoImpl;
import org.lanqiao.entity.Email;
import org.lanqiao.entity.Manager;



public class EmailBizImpl implements EmailBiz{
	
	private EmailDaoImpl emaildaoimpl;

	@Override
	public boolean AddEmail(Email email) {
		return emaildaoimpl.AddEmail(email);
	}

	@Override
	public List<Email> findByPage(int mailReceiveId) {
		
		return (List<Email>) emaildaoimpl.findByPage(mailReceiveId);
	}

	@Override
	public int getCont(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean batchDelete(String[] mids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Updateread(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override	
	public boolean AddRubbish(int id) {
		// TODO Auto-generated method stub
		return false;
	}


	public void setEmaildaoimpl(EmailDaoImpl emaildaoimpl) {
		this.emaildaoimpl = emaildaoimpl;
	}

	@Override
	public ArrayList<Email> selectAll() {
		return emaildaoimpl.selectAll();
	}

	@Override
	public List<Email> selectid(int mailSendId) {
		return emaildaoimpl.selectid(mailSendId);
	}

	@Override
	public Email findAll(int mailReceiveId) {
		return emaildaoimpl.findAll(mailReceiveId);
	}

	@Override
	public Email getOne(int mailSendId) {
		return emaildaoimpl.getOne(mailSendId);
	}

	@Override
	public Email findbytitle(String mailTitle) {
		return emaildaoimpl.findbytitle(mailTitle);
	}

	@Override
	public Manager findone(int mId) {
		return emaildaoimpl.findone(mId);
	}

	@Override
	public List<Manager> findByid(int mId) {
		return emaildaoimpl.findByid(mId);
	}

	@Override
	public Email selectbyeid(int mailId) {
		return emaildaoimpl.selectbyeid(mailId);
	}

	@Override
	public ArrayList<Manager> mselectAll() {
		return emaildaoimpl.mselectAll();
	}

	@Override
	public boolean delete(int id) {
		return emaildaoimpl.delete(id);
	}

	

	
	

}
