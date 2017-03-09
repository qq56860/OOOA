package org.lanqiao.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.lanqiao.biz.AdminBiz;
import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.biz.ManagerBiz;
import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Manager;
import org.lanqiao.entity.Page;
import org.lanqiao.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Resource(name = "adminBiz")
	private AdminBiz adminBiz;

	@Resource(name = "managerBiz")
	private ManagerBiz managerBiz;
	
	@Resource(name = "employeeBiz")
	private EmployeeBiz employeeBiz;


	
	
	@RequestMapping("ppp")
	public String personalinfo(HttpServletRequest request){
		System.out.println("进入personalInfo 方法....");
		Admin admin = (Admin)request.getSession().getAttribute("User");
		Admin u  = (Admin)request.getAttribute("user");
		Admin a = adminBiz.getOne(admin.getaId());
		if(u==null)
		{
			if(a.getImg()==null){
			String img = "";;
			if(a.getaSex().equals("男")){img = "/OA/images/3.png";}
			else{ img = "/OA/images/1.png";}
			a.setImg(img);
			}
			request.setAttribute("user", a);	
		}else{
			request.setAttribute("user", u);	
		}
		return "admin/personalInfo";
			
	}
	
	@RequestMapping("findEall")
	public String findEall(HttpServletRequest request){
			int everyPage = 5;// 每页记录数
			int totalCount = employeeBiz.getCount();// 获取总记录数
			// 点击链接重新获取当前页
			String scurrentPage = request.getParameter("currentPage");
			int currentPage = 1; // 当前页，默认1
			if (scurrentPage == null) {
				currentPage = 1;// 从第一页开始访问
			} else {
				currentPage = Integer.parseInt(scurrentPage);
			}
			// 分页信息
			Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
			// 分页数据信息
			System.out.println("1");
			List<Employee> list = employeeBiz.findByPage(page);
			request.setAttribute("page", page);
			request.setAttribute("e", list);
			// 转发到userlist.jsp
			return "admin/employee";
	
	}
	
	
	@RequestMapping("managerfff")
	public String massagerfindAll(HttpServletRequest request){
		System.out.println("进入managerfff方法......");
		List<Manager> m=managerBiz.fingall();
		request.setAttribute("m", m);
		return "admin/manager";
		
	}
	
	
	@RequestMapping("updateM")
	public String updateM(Manager m ,HttpServletRequest request){
		m.setmTel(request.getParameter("mtel"));
		m.setmEmail(request.getParameter("memail"));
		m.setmAddress(request.getParameter("maddress"));
		m.setmId(Integer.parseInt(request.getParameter("id")));
		System.out.println("tel："+request.getParameter("mTel"));
		boolean boo=managerBiz.updateById(m);
		
		if(boo){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		return "forward:managerfff";
	}
	
	@RequestMapping("deleteM")
	public String delete(int id,HttpServletRequest request,HttpServletResponse response){
		Integer nid=Integer.parseInt(request.getParameter("id"));
		boolean boo=managerBiz.deleteById(nid);
		if(boo){
			System.out.println("删除成功");		
		}else{
			System.out.println("删除失败");
		}
		return "forward:managerfff";	
	}
	
	@RequestMapping("addM")
	public String addM(HttpServletRequest request){
		Manager m=new Manager();
		m.setDepartment(request.getParameter("department"));
		m.setIntroduce(request.getParameter("introduce"));
		m.setmNation(request.getParameter("nation"));
		m.setmAddress(request.getParameter("address"));
		m.setmBirth(request.getParameter("birth"));
		m.setmConstellation(request.getParameter("constellation"));
		m.setmEmail(request.getParameter("email"));
		m.setmName(request.getParameter("name"));
		m.setmPassword(request.getParameter("password"));
		m.setmTel(request.getParameter("tel"));
		m.setmSex(request.getParameter("sex"));
//		m.setmAge(0);
		boolean boo=managerBiz.add(m);
		if(boo){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		return "forward:managerfff";
	}
	
	@RequestMapping("addA")
	public String addA(Admin a,HttpServletRequest request){
		a.setaAddress(request.getParameter("address"));
		a.setaBirth(request.getParameter("birth"));
		a.setaConstellation(request.getParameter("constellation"));
		a.setaDepartment(request.getParameter("department"));
		a.setaEmail(request.getParameter("email"));
		a.setaIntroduce(request.getParameter("introduce"));
		a.setaName(request.getParameter("name"));
		a.setaNation(request.getParameter("nation"));
		a.setaPassword(request.getParameter("password"));
		a.setaSex(request.getParameter("sex"));
		a.setaTel(request.getParameter("tel"));
//		m.setmAge(0);
		boolean boo=adminBiz.add(a);
		if(boo){
			System.out.println("添加成功");
			request.setAttribute("msg","<script type='text/javascript'>alert('添加成功');</script>");
		}else{
			System.out.println("添加失败");
		}
		return "admin/main";
	}
	
	
	
	@RequestMapping("photo")
	public String photo(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		int eid = Integer.parseInt(request.getParameter("aid"));
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
					Admin user = adminBiz.getOne(eid);
					user.setImg("photo/" + realFileName+".jpg");
					// 修改用户信息
					System.out.println(user.getImg());
					boolean result = adminBiz.UpdateAdminphoto(user);
					// 重新绑定用户
					if(result){
						Admin e = adminBiz.getOne(eid);
						request.setAttribute("user", e);
						request.setAttribute("msg", "<script>alert('修改成功！');</script>");
					}
					else{
						request.setAttribute("msg", "<script>alert('修改失败');</script>");
					}
					//request.getRequestDispatcher("front/personalInfo.jsp").forward(request, response);
					
				}
			return "admin/personalInfo";
	}
	
	
	
	
	
		//员工的修改：
		@RequestMapping("updateEmp")
	 	public String updateE(Employee e,HttpServletRequest request){
			System.out.println("进入修改员工方法......");
			Integer id=Integer.parseInt(request.getParameter("id"));
			System.out.println("id......."+id);
			String eTel=request.getParameter("etel");
			System.out.println("etel...."+eTel);
			String eEmail=request.getParameter("eemail");
			System.out.println("eEmail....."+eEmail);
			e.seteId(id);
			e.seteTel(eTel);
			e.seteEmail(eEmail);
			boolean boo=employeeBiz.updateById(e);
			if(boo){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
			return "forward:findEall";
		}

		//删除员工信息
		@RequestMapping("deleteEmp")
		public String deleteE(int id,HttpServletRequest request){
			System.out.println("进入删除员工方法......");
			boolean boo=employeeBiz.deleteById(id);
			if(boo){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
			return "forward:findEall";
		}
		
		@RequestMapping("addE")
		public String addE(Employee e,HttpServletRequest request){
			System.out.println("进入添加员工方法.....");
			e.seteName(request.getParameter("name"));
			e.setePassword(request.getParameter("password"));
			e.seteEmail(request.getParameter("email"));
			e.seteSex(request.getParameter("sex"));
			e.seteNation(request.getParameter("nation"));
			e.seteBirth(request.getParameter("birth"));
			e.seteTel(request.getParameter("tel"));
			e.seteAddress(request.getParameter("address"));
			e.setDepartment(request.getParameter("department"));
			e.seteConstellation("constellation");
			e.seteIntroduce(request.getParameter("introduce"));
			boolean boo=employeeBiz.add(e);
			return "forward:findEall";
		}
		
		
}
