package org.lanqiao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//管理员实体表
@Entity
@Table(name="admin")
public class Admin {
	
	//管理员Id
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private int aId;
	//管理员名字
	private String aName;
	//管理员密码
	private String aPassword;
	//管理员是否已删除 1未删 0已删 
	private int state;
	//邮箱
	private String aEmail;
	//性别
	private String aSex;
	//民族
	private String aNation;
	//出生日期
	private String aBirth;
	//联系方式
	private String aTel;
	//家庭住址
	private String aAddress;
	//职位
	private String aDepartment;
	//星座
	private String aConstellation;
	//个人简介
	private String aIntroduce;
	private String img;
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaSex() {
		return aSex;
	}

	public void setaSex(String aSex) {
		this.aSex = aSex;
	}

	public String getaNation() {
		return aNation;
	}

	public void setaNation(String aNation) {
		this.aNation = aNation;
	}

	public String getaBirth() {
		return aBirth;
	}

	public void setaBirth(String aBirth) {
		this.aBirth = aBirth;
	}

	public String getaTel() {
		return aTel;
	}

	public void setaTel(String aTel) {
		this.aTel = aTel;
	}

	public String getaAddress() {
		return aAddress;
	}

	public void setaAddress(String aAddress) {
		this.aAddress = aAddress;
	}

	public String getaDepartment() {
		return aDepartment;
	}

	public void setaDepartment(String aDepartment) {
		this.aDepartment = aDepartment;
	}

	public String getaConstellation() {
		return aConstellation;
	}

	public void setaConstellation(String aConstellation) {
		this.aConstellation = aConstellation;
	}

	public String getaIntroduce() {
		return aIntroduce;
	}

	public void setaIntroduce(String aIntroduce) {
		this.aIntroduce = aIntroduce;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String password, String email, String sex,
			String nation, String birth, String tel, String address,
			String department, String constellation, String introduce) {
		// TODO Auto-generated constructor stub
		this.aName = name;
		this.aPassword = password;
		this.aEmail = email;
		this.aSex = sex;
		this.aNation = nation;
		this.aBirth = birth;
		this.aTel = tel;
		this.aAddress = address;
		this.aDepartment = department;
		this.aConstellation = constellation;
		this.aIntroduce = introduce;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
	
}