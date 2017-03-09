package org.lanqiao.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.biz.ManagerBiz;
import org.lanqiao.biz.ScheduleBiz;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Manager;
import org.lanqiao.entity.Schedule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping
public class ScheduleController {

	@Resource(name = "employeeBiz")
	private EmployeeBiz employeeBiz;
	@Resource(name="managerBiz")
	private ManagerBiz managerBiz;
	
	@Resource(name = "scheduleBiz")
	private ScheduleBiz scheduleBiz;
	
	@RequestMapping("read")
	public String read(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		String schContent=request.getParameter("schContent");
		System.out.println(schContent);
		
		
		Date date = null;
		Date date2 = null;
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  

		date = (Date) sdf.parse(request.getParameter("startdt"));
		date2 = (Date) sdf.parse(request.getParameter("enddt"));
		
		Employee em = (Employee)request.getSession().getAttribute("User");
		Integer id = em.geteId();
		
		System.out.println("id"+id);
		Schedule sc=new Schedule();
		
		sc.setId(id);
		sc.setStartdt(date);
		sc.setEnddt(date2);
		sc.setSchContent(schContent);
		scheduleBiz.add(sc);
		System.out.println("添加成功");
        	return "forward:front/scheduleMa.jsp";
	}
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,HttpServletResponse response){
		
		int id=Integer.parseInt(request.getParameter("schid"));
		System.out.println(id);
		scheduleBiz.delete(id);
		return "redirect:front/scheduleMa.jsp";
	
	}
	/*@RequestMapping("xianshi")
	public String xianshi(HttpServletRequest request,HttpServletResponse response){
		
		Employee em = (Employee)request.getSession().getAttribute("User");
		
		System.out.println(em.geteId());
		int is=em.geteId();
		Schedule list = (Schedule) scheduleBiz.queryAll(is);
		
		request.getSession().setAttribute("slist", list);
		return "redirect:front/scheduleMa.jsp";
	}*/

	
	@RequestMapping("read2")
	public String read2(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		String schContent=request.getParameter("schContent");
		System.out.println(schContent);
		
		Date date = null;
		Date date2 = null;
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");  

		date = (Date) sdf.parse(request.getParameter("startdt"));
		date2 = (Date) sdf.parse(request.getParameter("enddt"));
		
		Manager ma=(Manager) request.getSession().getAttribute("User");
		int id1 =ma.getmId();
		System.out.println("id"+id1);
		Schedule sc=new Schedule();
		
		sc.setId(id1);
		sc.setStartdt(date);
		sc.setEnddt(date2);
		sc.setSchContent(schContent);
		scheduleBiz.add(sc);
		System.out.println("添加成功");
        	return "forward:mfront/scheduleMa.jsp";
	}
	
	@RequestMapping("delete2")
	public String delete2(HttpServletRequest request,HttpServletResponse response){
		
		int id=Integer.parseInt(request.getParameter("schid"));
		System.out.println(id);
		scheduleBiz.delete(id);
		return "redirect:mfront/scheduleMa.jsp";
	
	}
	
}
