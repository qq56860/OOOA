package org.lanqiao.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



//邮件实体类
@Entity
@Table(name="email")
public class Email {
	
	//Id
	@Id
	@GeneratedValue(generator="mailId")
	@GenericGenerator(name="mailId",strategy="identity")
	private Integer mailId;
	//标题
	private String mailTitle;
	//内容
	private String mailContent;
	//发送时间
	private String mailDate;
	//发送人
	private Integer mailSendId;
	//接收人
	private Integer mailReceiveId;
	//邮件阅读状态 已读 未读等
	private String conditions;
	//邮件是否删除  1未删 0删除到垃圾箱 垃圾箱删除直接删除
	private Integer state;
	//附件
	private String file;
	
	
	public Email(String mailTitle, String mailContent, String mailDate,
			int mailSendId, int mailReceiveId, String file) {
		super();
		this.mailTitle = mailTitle;
		this.mailContent = mailContent;
		this.mailDate = mailDate;
		this.mailSendId = mailSendId;
		this.mailReceiveId = mailReceiveId;
		
		this.file = file;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	public String getMailTitle() {
		return mailTitle;
	}

	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

	public String getMailContent() {
		return mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	
	

	

	public String getMailDate() {
		return mailDate;
	}

	public void setMailDate(String mailDate) {
		this.mailDate = mailDate;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getMailId() {
		return mailId;
	}

	public void setMailId(Integer mailId) {
		this.mailId = mailId;
	}

	public Integer getMailSendId() {
		return mailSendId;
	}

	public void setMailSendId(Integer mailSendId) {
		this.mailSendId = mailSendId;
	}

	public Integer getMailReceiveId() {
		return mailReceiveId;
	}

	public void setMailReceiveId(Integer mailReceiveId) {
		this.mailReceiveId = mailReceiveId;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String condition) {
		this.conditions = condition;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	

	
}
