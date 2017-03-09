package org.lanqiao.entity;

//即时聊天联系人实体类 包含员工、总经理
public class Contacts {

	//id
	private int cId;
	//姓名
	private String cName;
	//性别
	private String cSex;
	//年龄
	private int cAge;
	//电话
	private String cTel;
	//地址
	private String cAddress;
	//头像
	private String img;
	//聊天状态：在线 离线 等
	private String condition;
	//是否已删除 1未删 0已删
	private int state;
	
	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcSex() {
		return cSex;
	}

	public void setcSex(String cSex) {
		this.cSex = cSex;
	}

	public int getcAge() {
		return cAge;
	}

	public void setcAge(int cAge) {
		this.cAge = cAge;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
