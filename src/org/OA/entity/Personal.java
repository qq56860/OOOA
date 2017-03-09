package org.lanqiao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="personal")
//个人通讯录实体类
public class Personal {
	@Id
	@GeneratedValue(generator="pid")
	@GenericGenerator(name="pid",strategy="identity")

	//通讯录Id
	private Integer  pId;
	//用户Id 如行政经理 普通员工
	private Integer id;
	//联系人姓名
	private String pName;
	//电话
	private String pTel;
	//地址
	private String pAddress;
	
	private Integer top;
	
	private Date toptime;
	
	public Personal(Integer pId, String pName, String pTel, String pAddress) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pTel = pTel;
		this.pAddress = pAddress;
	}
	
	

	public Personal(String pName, String pTel, String pAddress,Integer id) {
		super();
		this.id = id;
		this.pName = pName;
		this.pTel = pTel;
		this.pAddress = pAddress;
	}



	public Integer getpId() {
		return pId;
	}



	public void setpId(Integer pId) {
		this.pId = pId;
	}



	public Integer getId() {
		return id;
	}



	public Personal() {
		super();
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getpName() {
		return pName;
	}



	public void setpName(String pName) {
		this.pName = pName;
	}



	public String getpTel() {
		return pTel;
	}



	public void setpTel(String pTel) {
		this.pTel = pTel;
	}



	public String getpAddress() {
		return pAddress;
	}



	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}



	public Integer getTop() {
		return top;
	}



	public void setTop(Integer top) {
		this.top = top;
	}



	public Date getToptime() {
		return toptime;
	}



	public void setToptime(Date toptime) {
		this.toptime = toptime;
	}



}
