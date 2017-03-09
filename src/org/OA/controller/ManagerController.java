package org.lanqiao.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.biz.ManagerBiz;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Manager;
import org.lanqiao.entity.Page;
import org.lanqiao.entity.Personal;
import org.lanqiao.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/manager/")
public class ManagerController {
	
	@Resource(name="managerBiz")
	private ManagerBiz managerBiz;
	
	@Resource(name = "employeeBiz")
	private EmployeeBiz employeeBiz;

	@RequestMapping("top")
	public String top(HttpServletRequest request){
		Manager mm = (Manager)request.getSession().getAttribute("User");
		String userName = mm.getmName();
		request.getSession().setAttribute("user",userName);
		//System.out.println(userName);
		List <Manager> M = managerBiz.fingall();
		List <Employee> E = employeeBiz.fingall();
		request.setAttribute("M", M);
		request.setAttribute("E", E);
		Manager m=managerBiz.getOne(mm.getmId());
		request.setAttribute("mm", m);
		if(mm.getImg()==null){
			String img = "";;
			if(mm.getmSex().equals("男")){img = "/OA/images/3.png";}
			else{ img = "/OA/images/1.png";}
			mm.setImg(img);
		}

		return "mfront/top";
	}
	
	@RequestMapping("updateindroce")
	public String updateindroce(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		boolean result;
		Manager em = (Manager)request.getSession().getAttribute("User");
		String indroce = request.getParameter("indroce");
		result = managerBiz.UpdateIndroce(em.getmId(), indroce);
		if(result){
			request.setAttribute("msg", "<script>alert('修改成功');</script>");
		}else{
			request.setAttribute("msg", "<script>alert('修改失败');</script>");
		}
		return "mfront/personalInfo";
	}
	
	@RequestMapping("updateinfo")
	public String updateinfo(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		boolean result;
		Manager em = (Manager)request.getSession().getAttribute("User");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String nation = request.getParameter("nation");
		String birth = request.getParameter("birth");
		String tel = request.getParameter("tel");
		String zhiwei = request.getParameter("zhiwei");
		String xinzuo = request.getParameter("xinzuo");
		String address = request.getParameter("address");
		em.setmEmail(email);
		em.setmSex(sex);
		em.setmNation(nation);
		em.setmBirth(birth);
		em.setmTel(tel);
		em.setDepartment(zhiwei);
		em.setmConstellation(xinzuo);
		em.setmAddress(address);
		result = managerBiz.UpadteInfo(em);
		if(result){
			request.setAttribute("msg", "<script>alert('修改成功');</script>");
		}else{
			request.setAttribute("msg", "<script>alert('修改失败');</script>");
		}
		return "mfront/personalInfo";
	}
	
	
	@RequestMapping("updatepass")
	public String updatepass(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		boolean result;
		Manager em = (Manager)request.getSession().getAttribute("User");
		String pass = request.getParameter("pass");
		result = managerBiz.Upadtepass(em.getmId(), pass);
		if(result){
			request.setAttribute("msg", "<script>alert('修改成功');</script>");
		}else{
			request.setAttribute("msg", "<script>alert('修改失败');</script>");
		}
		return "mfront/personalInfo";
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
			Manager user = managerBiz.getOne(eid);
			user.setImg("photo/" + realFileName+".jpg");
			// 修改用户信息
			System.out.println(user.getImg());
			boolean result = managerBiz.UpdateManagerphoto(user);
			// 重新绑定用户
			if(result){
				Manager e = managerBiz.getOne(eid);
				request.setAttribute("user", e);
				request.setAttribute("msg", "<script>alert('修改成功！');</script>");
			}
			else{
				request.setAttribute("msg", "<script>alert('修改失败');</script>");
			}
		}
		return "mfront/personalInfo";
	}
	
	
	

	
	
	
	
}
