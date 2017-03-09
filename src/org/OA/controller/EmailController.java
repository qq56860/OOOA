package org.lanqiao.controller;

import java.io.IOException;


import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.biz.EmailBiz;
import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.biz.ManagerBiz;
import org.lanqiao.entity.Email;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import antlr.collections.List;

@Controller
@RequestMapping("/email/")
public class EmailController {
	@Resource(name="managerBiz")
	private ManagerBiz managerBiz;
	
	@Resource(name = "employeeBiz")
	private EmployeeBiz employeeBiz;
	
	@Resource(name="emailBiz")
	private EmailBiz emailBiz;

	public void setEmailBizbase(EmailBiz emailBiz) {
		this.emailBiz = emailBiz;
	}
	//收件
	@RequestMapping("receive")
	public String receive(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Email email=new Email();
		System.out.println(id);
		
		email.setMailReceiveId(id);		
		int mailReceiveId=email.getMailReceiveId();		
		java.util.List<Email> list=emailBiz.findByPage(mailReceiveId);
		Email e=emailBiz.findAll(mailReceiveId);
		e.getMailSendId();
		Employee emp=employeeBiz.getbyID(e.getMailSendId());
		
		System.out.println(emp);
		
		
			if(list!=null && emp!=null){
				request.setAttribute("emp", emp);
				request.setAttribute("list", list);
				
				return "front/inbox";
			}else{
				return "front/inbox";
			}
	
		
	}
	//发邮件
	@RequestMapping("sendd1")
	public String sendd1(HttpServletRequest request,HttpServletResponse response){

	
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		
		Integer mailReceiveId=Integer.parseInt(request.getParameter("mailReceiveId"));
		String mailTitle=request.getParameter("mailTitle");
		String mailContent=request.getParameter("mailContent");
		//System.out.println(id+"呵呵");
		
		Email email=new Email();
		
		email.setMailReceiveId(mailReceiveId);
		email.setMailTitle(mailTitle);
		email.setMailContent(mailContent);
		email.setMailSendId(id);
		System.out.println(email.getMailSendId());
		
		
		boolean boo=emailBiz.AddEmail(email);
		if(boo){
			System.out.println("发送成功");
			System.out.println(Math.random());
			return "front/sendEmail";
		}else{
			System.out.println("发送失败");
			return "login";
		}
		
		
	}
	
	//垃圾，都是垃圾
	@RequestMapping("AddRubbish")
	public String AddRubbish(HttpServletRequest request){
		
		ArrayList<Email> list=emailBiz.selectAll();
		request.setAttribute("list", list);
		return "front/dustbin";
		
		
	}
	
	//发件箱
	@RequestMapping("outfile")
	public String outfile(HttpServletRequest request){
		
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Email email=new Email();
		email.setMailSendId(id);
		java.util.List<Email> list=emailBiz.selectid(email.getMailSendId());
		System.out.println(email.getMailSendId());
		Employee emp=employeeBiz.getOne(email.getMailSendId());
		if(list!=null&&emp!=null){
			request.setAttribute("emp", emp);
			request.setAttribute("list", list);
			
			return "front/outbox";
		}else{
			return "#";
		}
	
		
	}
	
	//显示邮件内容
	@RequestMapping("showemail")
	public String showemail(HttpServletRequest request){
		
		
		String mailTitle=request.getParameter("title");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id+"呵呵");
		
		Email em=emailBiz.findbytitle(mailTitle);
		//Email email=(Email) emailBiz.getOne(eid);
		Employee emp=employeeBiz.getOne(id);
		if(em!=null&&emp!=null){
			request.setAttribute("em", em);
			request.setAttribute("emp", emp);
			//request.setAttribute("email", email);
			
			return "front/message";
		}else{
			return "#";
		}
		
		
		
	}
	
	/*//直接删除不解释
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		
		
		}
		
	}*/
	//m收件箱
	@RequestMapping("msend")
	public String msend(HttpServletRequest request){
		
		Integer mId=Integer.parseInt(request.getParameter("id"));
		
		java.util.List<Email> list=emailBiz.findByPage(mId);
		
		request.setAttribute("list", list);
		
		return "mfront/inbox";
	}
	
	
	//m发件箱
	@RequestMapping("sendd")
	public String sendd(HttpServletRequest request,HttpServletResponse response){

		
		Integer id=Integer.parseInt(request.getParameter("id"));
		
		
		Integer mailReceiveId=Integer.parseInt(request.getParameter("mailReceiveId"));
		String mailTitle=request.getParameter("mailTitle");
		String mailContent=request.getParameter("mailContent");
		//System.out.println(id+"呵呵");
		
		Email email=new Email();
		
		email.setMailReceiveId(mailReceiveId);
		email.setMailTitle(mailTitle);
		email.setMailContent(mailContent);
		email.setMailSendId(id);
		System.out.println(email.getMailSendId());
		
		
		boolean boo=emailBiz.AddEmail(email);
		if(boo){
			System.out.println("发送成功");
			System.out.println(Math.random());
			return "mfront/sendEmail";
		}else{
			System.out.println("发送失败");
			return "login";
		}
		
		
	}
	
	//m垃圾箱
	@RequestMapping("AddRubbis")
	public String AddRubbis(HttpServletRequest request){
		
		ArrayList<Manager> list=emailBiz.mselectAll();
		request.setAttribute("list", list);
		return "mfront/dustbin";
		
		
	}
	
	@RequestMapping("mshowemail")
	public String mshowemail(HttpServletRequest request){
		
		
		String mailTitle=request.getParameter("title");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id+"呵呵");
		
		Email em=emailBiz.findbytitle(mailTitle);
		//Email email=(Email) emailBiz.getOne(eid);
		Manager manager=managerBiz.getOne(id);
				
		if(em!=null&&manager!=null){
			request.setAttribute("em", em);
			request.setAttribute("manager", manager);
			//request.setAttribute("email", email);
			
			return "mfront/message";
		}else{
			return "#";
		}
		
		
		
	}
	
	@RequestMapping("edelete")
	public String edelete(HttpServletRequest request){
		Integer id=Integer.parseInt(request.getParameter("id"));		
		Integer mailId=Integer.parseInt(request.getParameter("mailid"));
		System.out.println(mailId);
		boolean boo=emailBiz.delete(mailId);
		
		request.setAttribute("id", id);
		return "forward:receive";
		
	}
	
	@RequestMapping("Aedelete")
	public String Aedelete(HttpServletRequest request){
		Integer id=Integer.parseInt(request.getParameter("id"));		
		Integer mailId=Integer.parseInt(request.getParameter("mailid"));
		System.out.println(mailId);
		boolean boo=emailBiz.delete(mailId);
		
		request.setAttribute("id", id);
		return "forward:AddRubbish";
		
	}
	
	
	@RequestMapping("outedelete")
	public String outedelete(HttpServletRequest request){
		Integer id=Integer.parseInt(request.getParameter("id"));		
		Integer mailId=Integer.parseInt(request.getParameter("mailid"));
		System.out.println(mailId);
		boolean boo=emailBiz.delete(mailId);
		
		request.setAttribute("id", id);
		return "forward:outfile";
		
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request){
		Integer id=Integer.parseInt(request.getParameter("id"));		
		Integer mailId=Integer.parseInt(request.getParameter("mailid"));
		System.out.println(mailId);
		boolean boo=emailBiz.delete(mailId);
		
		request.setAttribute("id", id);
		return "forward:msend";
		
	}
	
	@RequestMapping("Adelete")
	public String Adelete(HttpServletRequest request){
		Integer id=Integer.parseInt(request.getParameter("id"));		
		Integer mailId=Integer.parseInt(request.getParameter("mailid"));
		System.out.println(mailId);
		boolean boo=emailBiz.delete(mailId);
		
		request.setAttribute("id", id);
		return "forward:AddRubbis";
		
	}
	
	
	
	
}
