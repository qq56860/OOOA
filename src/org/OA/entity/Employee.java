package org.lanqiao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//普通员工实体表
@Entity
@Table(name="employee")
public class Employee {

private String img;

private String eEmail;

//员工Id
@Id
@GeneratedValue(generator="eid")
@GenericGenerator(name="eid",strategy="identity")
private int eId;
//员工密码
private String ePassword;
//员工名字
private String eName;
//员工性别
private String eSex;
//员工年龄
private int eAge;
//员工部门
private String department;
//员工电话
private String eTel;
//员工地址
private String eAddress;
//员工是否已删除 1未删 0已删 
private int state;
private String textare;
private String eNation;
private String eConstellation;
private String eBirth;
private String eIntroduce;


public Employee() {
super();
// TODO Auto-generated constructor stub
}

public Employee(String name, String password, String email, String sex,
String nation, String birth, String tel, String address,
String department, String constellation, String introduce) {
// TODO Auto-generated constructor stub
this.eName = name;
this.ePassword = password;
this.eEmail = email;
this.eSex = sex;
this.eNation = nation;
this.eBirth = birth;
this.eTel = tel;
this.eAddress = address;
this.department = department;
this.eConstellation = constellation;
this.eIntroduce = introduce;
}

public Employee(int id, String tel, String email) {
// TODO Auto-generated constructor stub
this.eId = id;
this.eTel = tel;
this.eEmail = email;
}

public String getImg() {
	return img;
}

public void setImg(String img) {
	this.img = img;
}

public String geteEmail() {
	return eEmail;
}

public void seteEmail(String eEmail) {
	this.eEmail = eEmail;
}

public int geteId() {
	return eId;
}

public void seteId(int eId) {
	this.eId = eId;
}

public String getePassword() {
	return ePassword;
}

public void setePassword(String ePassword) {
	this.ePassword = ePassword;
}

public String geteName() {
	return eName;
}

public void seteName(String eName) {
	this.eName = eName;
}

public String geteSex() {
	return eSex;
}

public void seteSex(String eSex) {
	this.eSex = eSex;
}

public int geteAge() {
	return eAge;
}

public void seteAge(int eAge) {
	this.eAge = eAge;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String geteTel() {
	return eTel;
}

public void seteTel(String eTel) {
	this.eTel = eTel;
}

public String geteAddress() {
	return eAddress;
}

public void seteAddress(String eAddress) {
	this.eAddress = eAddress;
}

public int getState() {
	return state;
}

public void setState(int state) {
	this.state = state;
}

public String getTextare() {
	return textare;
}

public void setTextare(String textare) {
	this.textare = textare;
}

public String geteNation() {
	return eNation;
}

public void seteNation(String eNation) {
	this.eNation = eNation;
}

public String geteConstellation() {
	return eConstellation;
}

public void seteConstellation(String eConstellation) {
	this.eConstellation = eConstellation;
}

public String geteBirth() {
	return eBirth;
}

public void seteBirth(String eBirth) {
	this.eBirth = eBirth;
}

public String geteIntroduce() {
	return eIntroduce;
}

public void seteIntroduce(String eIntroduce) {
	this.eIntroduce = eIntroduce;
}




}