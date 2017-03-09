package org.lanqiao.controller;


import java.util.Date;  
import java.util.List;

import javax.annotation.Resource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.entity.Employee;

import org.apache.commons.fileupload.FileUploadException;
import org.lanqiao.biz.ManagerBiz;
import org.lanqiao.entity.Manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller

@RequestMapping("/employee/")

public class EmployeeController {

	@Resource(name = "employeeBiz")
	private EmployeeBiz employeeBiz;
	@Resource(name="managerBiz")
	private ManagerBiz managerBiz;
	 	
	@RequestMapping("top")
	public String top(HttpServletRequest request){
		Employee employee = (Employee)request.getSession().getAttribute("User");
		String userName = employee.geteName();
		request.getSession().setAttribute("user",userName);
		//System.out.println(userName);
		List <Manager> M = managerBiz.fingall();
		List <Employee> E = employeeBiz.fingall();
		request.setAttribute("M", M);
		request.setAttribute("E", E);
		Employee ee = employeeBiz.getOne(employee.geteId());
		request.setAttribute("ee",ee);
		if(ee.getImg()==null){
			String img = "";;
			if(ee.geteSex().equals("男")){img = "/OA/images/3.png";}
			else{ img = "/OA/images/1.png";}
			ee.setImg(img);
		}
		return "front/top";

}
	@RequestMapping("findByCon")
	public String findByCon(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		String con = request.getParameter("query_text");
		Manager ma = (Manager)request.getSession().getAttribute("User");
		List<Employee> list = employeeBiz.findByCon(ma.getmId(), con);
		if(list!=null){
			request.getSession().setAttribute("mlist", list);
			//request.getRequestDispatcher("mfront/employee.jsp").forward(request, response);			
		}else{
			request.setAttribute("msg", "<script>alert('没有员工信息');</script>");
			//request.getRequestDispatcher("mfront/employee.jsp").forward(request, response);
		}
		return "mfront/employee";
	}
	
	@RequestMapping("findByDe")
	public String findByDe(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		Manager ma = (Manager)request.getSession().getAttribute("User");
		List<Employee> list = employeeBiz.findByDe(ma.getmId());
		if(list!=null){
			request.getSession().setAttribute("mlist", list);
			//request.getRequestDispatcher("mfront/employee.jsp").forward(request, response);			
		}else{
			request.setAttribute("msg", "<script>alert('没有员工信息');</script>");
			//request.getRequestDispatcher("mfront/employee.jsp").forward(request, response);
		}
		return "mfront/employee";
	}
	
	@RequestMapping("changeintro")
	public String changeintro(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		boolean result;
		Employee em = (Employee)request.getSession().getAttribute("User");
		String intro = request.getParameter("intro");
		System.out.println(em.geteId()+" "+intro);
		result = employeeBiz.updateintro(em.geteId(), intro);
		if(result){
			request.setAttribute("msg", "<script>alert('修改成功');</script>");
		}else{
			request.setAttribute("msg", "<script>alert('修改失败');</script>");
		}
		return "front/personalInfo";
	}
	
	@RequestMapping("changeede")
	public String changeede(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		boolean result;
		System.out.println("1");
		Employee em = (Employee)request.getSession().getAttribute("User");
		String de = request.getParameter("de");
		String con = request.getParameter("con");
		result = employeeBiz.updatede(em.geteId(), de, con);
		if(result){
			request.setAttribute("msg", "<script>alert('修改成功');</script>");
		}else{
			request.setAttribute("msg", "<script>alert('修改失败');</script>");
		}
		return "front/personalInfo";
	}
	
	@RequestMapping("changeaddress")
	public String changeaddress(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		boolean result;
		Employee em = (Employee)request.getSession().getAttribute("User");
		String address = request.getParameter("address");
		System.out.println(em.geteId()+" "+address);
		result = employeeBiz.updateaddress(em.geteId(), address);
		if(result){
			request.setAttribute("msg", "<script>alert('修改成功');</script>");
		}else{
			request.setAttribute("msg", "<script>alert('修改失败');</script>");
		}
		return "front/personalInfo";
	}
	
	@RequestMapping("changesex")
	public String changesex(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		boolean result;
		Employee em = (Employee)request.getSession().getAttribute("User");
		String sex = request.getParameter("sex");
		String nation = request.getParameter("nation");
		String birth = request.getParameter("birth");
		String tel = request.getParameter("tel");
		result = employeeBiz.updatesex(em.geteId(), sex, nation, birth, tel);
		if(result){
			request.setAttribute("msg", "<script>alert('修改成功');</script>");
		}else{
			request.setAttribute("msg", "<script>alert('修改失败');</script>");
		}
		return "front/personalInfo";
	}
	
	@RequestMapping("changemail")
	public String changemail(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		boolean result;
		Employee em = (Employee)request.getSession().getAttribute("User");
		String email = request.getParameter("email");
		System.out.println(em.geteId()+" "+email);
		result = employeeBiz.updateemail(em.geteId(), email);
		if(result){
			request.setAttribute("msg", "<script>alert('修改成功');</script>");
		}else{
			request.setAttribute("msg", "<script>alert('修改失败');</script>");
		}
		return "front/personalInfo";
	}
	
	@RequestMapping("changename")
	public String changename(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		boolean result;
		Employee em = (Employee)request.getSession().getAttribute("User");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(em.geteId()+" "+password);
		result = employeeBiz.updatename(em.geteId(), password);
		if(result){
			request.setAttribute("msg", "<script>alert('修改成功');</script>");
		}else{
			request.setAttribute("msg", "<script>alert('修改失败');</script>");
		}
		return "front/personalInfo";
	}
	
	
	@RequestMapping("photo")
	public String photo(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		int eid = Integer.parseInt(request.getParameter("eid"));
		InputStream ifs= file.getInputStream();
	    String realDir = request.getSession().getServletContext()
				.getRealPath("");
	    System.out.println(realDir);
	    String state = "success";
		long realFileName= new Date().getTime();
	    
	    FileOutputStream fos=new FileOutputStream(realDir+"\\photo\\"+realFileName+".jpg");
	    byte [] bytes=new byte[1024];

		while(ifs.read(bytes)!=-1){
			fos.write(bytes);
		}
		
		fos.close();
		ifs.close();
	   
				if(state.equals("success")){
					// 保存filePath/realFileName到数据库
					Employee user = employeeBiz.getOne(eid);
					user.setImg("photo/" + realFileName+".jpg");
					// 修改用户信息
					System.out.println(user.getImg());
					boolean result = employeeBiz.UpdateEmployeephoto(user);
					// 重新绑定用户
					if(result){
						Employee e = employeeBiz.getOne(eid);
						request.setAttribute("user", e);
						request.setAttribute("msg", "<script>alert('修改成功！');</script>");
					}
					else{
						request.setAttribute("msg", "<script>alert('修改失败');</script>");
					}
					//request.getRequestDispatcher("front/personalInfo.jsp").forward(request, response);
					
				}
			return "front/personalInfo";
	}
}
