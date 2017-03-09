package org.lanqiao.biz;


import java.util.List;

import org.lanqiao.entity.Manager;



public interface ManagerBiz {

//登录
public Manager login(int aid,String password);

public Manager getOne(int aid);
public boolean UpdateManagerphoto(Manager m);

//根据姓名查找信息
public Manager findbyName(String name);
//查询所有
public List<Manager> fingall();
public boolean add(Manager m);
public boolean updateById(Manager m);
public boolean deleteById(int id);
public List<Manager> findall();
//修改密码
public boolean Upadtepass(int mid,String pass);
//修改基本信息
public boolean UpadteInfo(Manager m);
//修改个人简介
public boolean UpdateIndroce(int id,String info);

}