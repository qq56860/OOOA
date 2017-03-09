package org.lanqiao.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//公告实体类
@Entity
@Table(name="notice")
public class Notice {
	
	@Id
	//@Basic(optional=false)
	@GeneratedValue(generator="nId")
	@GenericGenerator(name="nId",strategy="identity")
	//公告Id
	private int nId;
	//标题
	private String nTitle;
	//公告时间
	private Date date;
	//作者
	private String author;
	//摘要
	private String nSummary;
	//内容
	private String nContent;
	//是否已删除 1未删 0已删
	private int state;
	
	private String issuer;
    
	private String zan;
	
	public String getZan() {
		return zan;
	}

	public void setZan(String zan) {
		this.zan = zan;
	}

	public String getIssuer() {
		return issuer;
		}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(int id, String title, String summary, String content,
			String nissuer) {
		// TODO Auto-generated constructor stub
		this.nId = id;
		this.nTitle = title;
		this.nSummary = summary;
		this.nContent = content;
		this.issuer = nissuer;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getnSummary() {
		return nSummary;
	}

	public void setnSummary(String nSummary) {
		this.nSummary = nSummary;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	

}
