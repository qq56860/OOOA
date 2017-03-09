package org.lanqiao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="common")
//公共通讯录实体类
public class Common {
	@Id
	@GeneratedValue(generator="comid")
	@GenericGenerator(name="comid",strategy="identity")
	
	//Id
	private Integer comId;
	//姓名
	private String comName;
	//经理名字
	private String managername;
	//电话
	private String comTel;
	
	private Integer top;
	
	private Date toptime;
	
	public Common() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Common(Integer id, String cName, String cmName, String cTel) {
		// TODO Auto-generated constructor stub
		this.comId = id;
		this.comName = cName;
		this.managername = cmName;
		this.comTel = cTel;
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

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComTel() {
		return comTel;
	}

	public void setComTel(String comTel) {
		this.comTel = comTel;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	
	
	

}
