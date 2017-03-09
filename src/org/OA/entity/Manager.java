package org.lanqiao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



//行政经理实体类
@Entity
@Table(name="manager")
public class Manager {
	
	

	private String img;
	public Manager(){
		super();
	}
	public Manager(int mId,String email, String sex,
			String nation, String birth, String tel, String address,
			String department, String constellation) {
		// TODO Auto-generated constructor stub
		this.mId = mId;
		this.mEmail = email;
		this.mSex = sex;
		this.mNation = nation;
		this.mBirth = birth;
		this.mTel = tel;
		this.mAddress = address;
		this.department = department;
		this.mConstellation = constellation;
		
	}
	public Manager(String name, String password, String email, String sex,
			String nation, String birth, String tel, String address,
			String department, String constellation, String introduce) {
		// TODO Auto-generated constructor stub
		this.mName = name;
		this.mPassword = password;
		this.mEmail = email;
		this.mSex = sex;
		this.mNation = nation;
		this.mBirth = birth;
		this.mTel = tel;
		this.mAddress = address;
		this.department = department;
		this.mConstellation = constellation;
		this.introduce = introduce;
	}

	public Manager(int id, String tel, String email, String address) {
		// TODO Auto-generated constructor stub
		this.mId = id;
		this.mTel = tel;
		this.mEmail = email;
		this.mAddress = address;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	private String introduce;
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String mIntroduce) {
		this.introduce = mIntroduce;
	}
	//Id
	@Id
	@GeneratedValue(generator="mId")
	@GenericGenerator(name="mId",strategy="identity")
	private int mId;
	//密码
	private String mPassword;
	//姓名
	private String mName;
	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmSex() {
		return mSex;
	}

	public void setmSex(String mSex) {
		this.mSex = mSex;
	}

	public int getmAge() {
		return mAge;
	}

	public void setmAge(int mAge) {
		this.mAge = mAge;
	}

	public String getmTel() {
		return mTel;
	}

	public void setmTel(String mTel) {
		this.mTel = mTel;
	}

	public String getmAddress() {
		return mAddress;
	}

	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	private String mEmail;
	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail=mEmail;
	}
	//性别
	private String mSex;
	//年龄
	private int mAge;
	private String mTel;
	//地址
	private String mAddress;
	//部门
	private String department;
	private String mNation;
	//是否已删除 1未删 0已删
	private int state;
	public String getmNation() {
		return mNation;
	}

	public void setmNation(String mNation) {
		this.mNation = mNation;
	}
	
	private String mConstellation;
	private String mBirth;
	public String getmConstellation() {
		return mConstellation;
	}

	public void setmConstellation(String mConstellation) {
		this.mConstellation = mConstellation;
	}

	public String getmBirth() {
		return mBirth;
	}

	public void setmBirth(String mBirth) {
		this.mBirth = mBirth;
	}
	

}