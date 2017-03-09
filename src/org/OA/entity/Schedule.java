package org.lanqiao.entity;




import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="schedule")
//日程实体类
public class Schedule {

	@Id
	@GeneratedValue(generator="schId")
	@GenericGenerator(name="schId",strategy="identity")
	//日程Id
	private Integer schId;
	//添加该日程的用户Id
	private int id;
	//日程的内容
	private String schContent;
	//日程的开始时间
	private Date startdt;
	//日程的结束时间
	private Date enddt;
	
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule(Integer id, String schContent, Date startdt, Date enddt) {
		super();
		this.id = id;
		this.schContent = schContent;
		this.startdt = startdt;
		this.enddt = enddt;
	}

	public Integer getSchId() {
		return schId;
	}

	public void setSchId(Integer schId) {
		this.schId = schId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchContent() {
		return schContent;
	}

	public void setSchContent(String schContent) {
		this.schContent = schContent;
	}

	public Date getStartdt() {
		return startdt;
	}

	public void setStartdt(Date startdt) {
		this.startdt = startdt;
	}

	public Date getEnddt() {
		return enddt;
	}

	public void setEnddt(Date enddt) {
		this.enddt = enddt;
	}

	
	
	
}
