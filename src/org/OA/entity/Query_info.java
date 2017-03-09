package org.lanqiao.entity;

import java.sql.Date;


//即时消息实体类 主要做查询屏蔽后即时消息操作 （操作视图 不能增删改）
public class Query_info {

	//消息Id
	private int infoId;
	//发送者Id
	private int infoSendId;
	//接收人Id
	private int infoReceiveId;
	//消息时间
	private Date infoDate;
	//消息内容
	private String infoContent;
	//消息状态 已读 未读等
	private String condition;
	//是否已经删除 1未删 0已删
	private int state;
	
	public Query_info() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public int getInfoSendId() {
		return infoSendId;
	}

	public void setInfoSendId(int infoSendId) {
		this.infoSendId = infoSendId;
	}

	public int getInfoReceiveId() {
		return infoReceiveId;
	}

	public void setInfoReceiveId(int infoReceiveId) {
		this.infoReceiveId = infoReceiveId;
	}

	public Date getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(Date infoDate) {
		this.infoDate = infoDate;
	}

	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
