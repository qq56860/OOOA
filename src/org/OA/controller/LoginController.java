package org.lanqiao.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.biz.AdminBiz;
import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.biz.ManagerBiz;
import org.lanqiao.entity.Admin;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {

	@Resource(name = "managerBiz")
	private ManagerBiz managerBiz;

	@Resource(name = "employeeBiz")
	private EmployeeBiz employeeBiz;

	@Resource(name = "adminBiz")
	private AdminBiz adminBiz;

	@RequestMapping("/login")
	public String getall(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("RadioGroup");
		String ID = request.getParameter("id");
		String password = request.getParameter("password");
		if (ID.length() == 0 || password.length() == 0) {
			request.setAttribute("msg",
					"<script>alert('请将信息填写完整再登陆！');</script>");
			return "forward:login.jsp";
		}
		int id = Integer.parseInt(ID);
		System.out.println(account);
		if (account.equals("employee")) {
			Employee employee = employeeBiz.login(id, password);
			if (employee == null) {
				request.setAttribute("msg",
						"<script>alert('账号或密码错误！');</script>");
				// request.getRequestDispatcher("login.jsp").forward(request,
				// response);
				return "forward:login.jsp";
			} else {
				request.getSession().setAttribute("User", employee);
				// 重定向
				return "redirect:front/index.jsp";
				
			}
		} else if (account.equals("manager")) {
			Manager manager = managerBiz.login(id, password);
			if (manager == null) {
				request.setAttribute("msg",
						"<script>alert('账号或密码错误！');</script>");
				// request.getRequestDispatcher("login.jsp").forward(request,
				// response);
				return "forward:login.jsp";
			} else {
				request.getSession().setAttribute("User", manager);
				// 重定向
				return "redirect:mfront/index.jsp";
			}
		}else if (account.equals("admin")) {
			Admin admin = adminBiz.login(id, password);
			if (admin == null) {
				request.setAttribute("msg",
						"<script>alert('账号或密码错误！');</script>");
				// request.getRequestDispatcher("login.jsp").forward(request,
				// response);
				return "forward:login.jsp";
			} else {
				request.getSession().setAttribute("User", admin);
				// 重定向
				return "redirect:admin/index.jsp";
			}
		}
		
		else{
			request.setAttribute("msg", "<script>alert('请选择身份！');</script>");
			return "forward:login.jsp";
		}

	}

}
