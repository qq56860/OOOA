package org.lanqiao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Manager;
import org.lanqiao.util.CreateUserXLS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/export/")
public class ExportController {
	@Resource(name = "employeeBiz")
	private EmployeeBiz employeeBiz;
	
	
	
	
	@RequestMapping("manager")
	public String manager(HttpServletRequest request,HttpServletResponse response) throws FileUploadException, IOException{
		String path = request.getSession().getServletContext().getRealPath("");
	  //把所有的路径的单斜杠替换成双斜杠 
		path = path.replace("\\","//");
	  //设置execl在服务器上的保存位置（项目根目录），可以修改路径
		CreateUserXLS xls = new CreateUserXLS(path);
	  //查询所有用户信息
	  Manager ma = (Manager)request.getSession().getAttribute("User");
	  //List<Employee> list = employeeBiz.findByDe(ma.getmId());
	  List<Employee> list=(List<Employee>)request.getSession().getAttribute("mlist");
	  //传递给集合-excel转换类
	  xls.CreateExcel(list); 
	  
	  OutputStream o = response.getOutputStream();
	  byte b[] = new byte[1024];
	  // the file to download.读取该文件
	  File fileLoad = new File(path,"employee.xls");
	
	  //指定弹出文件保存对话框信息。固定写法
	  response.setHeader("Content-disposition", "attachment;filename="+ "employee.xls");
	  // set the MIME type.
	  response.setContentType("application/vnd.ms-excel");
	  // get the file length.
	  long fileLength = fileLoad.length();
	  String length = String.valueOf(fileLength);
	  response.setHeader("Content_Length", length);
	
	  // download the file.
	  FileInputStream in = new FileInputStream(fileLoad);
	  int n = 0;
	  while ((n = in.read(b)) != -1) {
		  o.write(b, 0, n);
	  }
	  return null;
	}
}
