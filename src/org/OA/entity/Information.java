package org.lanqiao.entity;

import java.sql.Date;

//即时消息未屏蔽前实体类 主要处理消息 做删除操作
public class Information {

	//消息Id
	private int infoId;
	//发送者Id
	private int infoSendId;
	//接受者Id
	private int infoReceiveId;
	//消息发送时间
	private Date infoDate;
	//内容
	private String infoContent;
	//状态 已读 未读等
	private String condition;
	//是否已经删除 1未删除 0删除
	private int state;
	
	public Information() {
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
