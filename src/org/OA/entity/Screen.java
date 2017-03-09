package org.lanqiao.entity;


//消息屏蔽实体类
public class Screen {

	//屏蔽信息Id
	private int screenId;
	//消息发送者Id
	private int sendId;
	//接受者Id
	private int receiveId;
	
	public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public int getSendId() {
		return sendId;
	}

	public void setSendId(int sendId) {
		this.sendId = sendId;
	}

	public int getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}
	
	
	
}
