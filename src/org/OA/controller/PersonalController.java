package org.lanqiao.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.biz.PersonalBiz;
import org.lanqiao.entity.Common;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Page;
import org.lanqiao.entity.Personal;
import org.lanqiao.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal/")
public class PersonalController {
	@Resource(name="PersonalBizImpl")
	private PersonalBiz personalbiz;

	public void setPersonalbiz(PersonalBiz personalbiz) {
		this.personalbiz = personalbiz;
	}
	@RequestMapping("delete")
	public String delete(HttpServletRequest request,HttpServletResponse response){
		System.out.println("进入delete");
		Personal personal=(Personal) request.getSession().getAttribute("Personal");
		Integer pId=Integer.parseInt(request.getParameter("pId"));
		System.out.println(request.getParameter("pId"));
		boolean boo=personalbiz.delete(pId);
		if(boo){
			System.out.println("删除成功");
			
		}else{
			System.out.println("删除失败");
			
		}
		return "forward:list1";
	}
	@RequestMapping("update")
	public String update(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		Personal personal=new Personal();
		personal.setpAddress(request.getParameter("paddress"));
		personal.setpName(request.getParameter("pname"));
		personal.setpTel(request.getParameter("ptel"));
		personal.setId((Integer.parseInt(request.getParameter("id"))));
		personal.setpId((Integer.parseInt(request.getParameter("pid"))));
		System.out.println("进入update");
		boolean boo=personalbiz.change(personal);
		System.out.println(personal);
		if(boo){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		return "forward:list1";
	}

	@RequestMapping("add")
	public String add(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		Personal personal=new Personal();
		System.out.println(request.getParameter("id"));
		personal.setpAddress(request.getParameter("paddress"));
		personal.setpName(request.getParameter("pname"));
		personal.setpTel(request.getParameter("ptel"));
		personal.setId((Integer.parseInt(request.getParameter("id"))));

		boolean boo=personalbiz.add(personal);
		if(boo){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
		return "forward:list1";
	}
	//带分页的查询全部
		@RequestMapping("list")
		public String findByPage(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		System.out.println("进入findByPage方法......");	
		Integer id=Integer.parseInt(request.getParameter("id"));
		int everyPage = 4;// 每页记录数
		int totalCount = personalbiz.getCont(id);// 获取总记录数
		System.out.println("总数据记录："+totalCount);
		String scurrentPage = request.getParameter("currentPage");
		int currentPage = 1; // 当前页，默认1
		System.out.println("当前页数scurrentPage"+scurrentPage);
		if (scurrentPage == null) {
		currentPage = 1;// 从第一页开始访问
		} else {
		currentPage = Integer.parseInt(scurrentPage);
		}
		// 分页信息
		Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
		// 分页数据信息
		List<Personal> list = personalbiz.findByPage(page, id);

		request.setAttribute("page", page);
		request.setAttribute("list", list);	

		return "front/personalBook";	
		}
		@RequestMapping("findByPageConditions")
		public String findByPageConditions(HttpServletRequest request,HttpServletResponse response){
			System.out.println("进入findByPageConditions方法中");
			Personal person=(Personal) request.getSession().getAttribute("Personal");
			String condition=request.getParameter("query_text");
			Integer id=Integer.parseInt(request.getParameter("id"));
			int everyPage = 4;// 每页记录数
			int totalCount = personalbiz.getCont(id);// 获取总记录数
			System.out.println("总数据记录："+totalCount);
			String scurrentPage = request.getParameter("currentPage");
			int currentPage = 1; // 当前页，默认1
			System.out.println("当前页数scurrentPage"+scurrentPage);
			if (scurrentPage == null) {
			currentPage = 1;// 从第一页开始访问
			} else {
			currentPage = Integer.parseInt(scurrentPage);
			}
			// 分页信息
			Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
			// 分页数据信息
			List<Personal> list = personalbiz.findByPageConditions(page, id, condition);

			request.setAttribute("page", page);
			request.setAttribute("list", list);	

			return "front/personalBook";
			
		}
		//带分页的查询全部
				@RequestMapping("list1")
				public String findByPage1(HttpServletRequest request) throws UnsupportedEncodingException{
				request.setCharacterEncoding("utf-8");
				System.out.println("进入findByPage方法......");	
				Personal personal=new Personal();
				Integer id=Integer.parseInt(request.getParameter("id"));
				int everyPage = 4;// 每页记录数
				int totalCount = personalbiz.getCont(id);// 获取总记录数
				System.out.println("总数据记录："+totalCount);
				String scurrentPage = request.getParameter("currentPage");
				int currentPage = 1; // 当前页，默认1
				System.out.println("当前页数scurrentPage"+scurrentPage);
				if (scurrentPage == null) {
				currentPage = 1;// 从第一页开始访问
				} else {
				currentPage = Integer.parseInt(scurrentPage);
				}
				// 分页信息
				Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
				// 分页数据信息
				List<Personal> list = personalbiz.findByPage(page, id);

				request.setAttribute("page", page);
				request.setAttribute("list", list);	

				return "front/personalBookMa";	
				}
				@RequestMapping("findByPageConditions1")
				public String findByPageConditions1(HttpServletRequest request,HttpServletResponse response){
					System.out.println("进入findByPageConditions方法中");
					Personal person=(Personal) request.getSession().getAttribute("Personal");
					String condition=request.getParameter("query_text");
					Integer id=Integer.parseInt(request.getParameter("id"));
					int everyPage = 4;// 每页记录数
					int totalCount = personalbiz.getCont(id);// 获取总记录数
					System.out.println("总数据记录："+totalCount);
					String scurrentPage = request.getParameter("currentPage");
					int currentPage = 1; // 当前页，默认1
					System.out.println("当前页数scurrentPage"+scurrentPage);
					if (scurrentPage == null) {
					currentPage = 1;// 从第一页开始访问
					} else {
					currentPage = Integer.parseInt(scurrentPage);
					}
					// 分页信息
					Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
					// 分页数据信息
					List<Personal> list = personalbiz.findByPageConditions(page, id, condition);

					request.setAttribute("page", page);
					request.setAttribute("list", list);	

					return "front/personalBookMa";
					
				}
				//带分页的查询全部
				@RequestMapping("list2")
				public String findByPage2(HttpServletRequest request) throws UnsupportedEncodingException{
				request.setCharacterEncoding("utf-8");
				System.out.println("进入findByPage方法......");	
				Integer id=Integer.parseInt(request.getParameter("id"));
				int everyPage = 4;// 每页记录数
				int totalCount = personalbiz.getCont(id);// 获取总记录数
				System.out.println("总数据记录："+totalCount);
				String scurrentPage = request.getParameter("currentPage");
				int currentPage = 1; // 当前页，默认1
				System.out.println("当前页数scurrentPage"+scurrentPage);
				if (scurrentPage == null) {
				currentPage = 1;// 从第一页开始访问
				} else {
				currentPage = Integer.parseInt(scurrentPage);
				}
				// 分页信息
				Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
				// 分页数据信息
				List<Personal> list = personalbiz.findByPage(page, id);

				request.setAttribute("page", page);
				request.setAttribute("list", list);	

				return "mfront/personalBook";	
				}
				@RequestMapping("findByPageConditions2")
				public String findByPageConditions2(HttpServletRequest request,HttpServletResponse response){
					System.out.println("进入findByPageConditions方法中");
					Personal person=(Personal) request.getSession().getAttribute("Personal");
					String condition=request.getParameter("query_text");
					Integer id=Integer.parseInt(request.getParameter("id"));
					int everyPage = 4;// 每页记录数
					int totalCount = personalbiz.getCont(id);// 获取总记录数
					System.out.println("总数据记录："+totalCount);
					String scurrentPage = request.getParameter("currentPage");
					int currentPage = 1; // 当前页，默认1
					System.out.println("当前页数scurrentPage"+scurrentPage);
					if (scurrentPage == null) {
					currentPage = 1;// 从第一页开始访问
					} else {
					currentPage = Integer.parseInt(scurrentPage);
					}
					// 分页信息
					Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
					// 分页数据信息
					List<Personal> list = personalbiz.findByPageConditions(page, id, condition);

					request.setAttribute("page", page);
					request.setAttribute("list", list);	

					return "mfront/personalBook";
					
				}
				//带分页的查询全部
				@RequestMapping("list3")
				public String findByPage3(HttpServletRequest request) throws UnsupportedEncodingException{
				request.setCharacterEncoding("utf-8");
				System.out.println("进入findByPage方法......");	
				Integer id=Integer.parseInt(request.getParameter("id"));
				int everyPage = 4;// 每页记录数
				int totalCount = personalbiz.getCont(id);// 获取总记录数
				System.out.println("总数据记录："+totalCount);
				String scurrentPage = request.getParameter("currentPage");
				int currentPage = 1; // 当前页，默认1
				System.out.println("当前页数scurrentPage"+scurrentPage);
				if (scurrentPage == null) {
				currentPage = 1;// 从第一页开始访问
				} else {
				currentPage = Integer.parseInt(scurrentPage);
				}
				// 分页信息
				Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
				// 分页数据信息
				List<Personal> list = personalbiz.findByPage(page, id);

				request.setAttribute("page", page);
				request.setAttribute("list", list);	

				return "mfront/personalBookMa";	
				}
				@RequestMapping("findByPageConditions3")
				public String findByPageConditions3(HttpServletRequest request,HttpServletResponse response){
					System.out.println("进入findByPageConditions方法中");
					Personal person=(Personal) request.getSession().getAttribute("Personal");
					String condition=request.getParameter("query_text");
					Integer id=Integer.parseInt(request.getParameter("id"));
					int everyPage = 4;// 每页记录数
					int totalCount = personalbiz.getCont(id);// 获取总记录数
					System.out.println("总数据记录："+totalCount);
					String scurrentPage = request.getParameter("currentPage");
					int currentPage = 1; // 当前页，默认1
					System.out.println("当前页数scurrentPage"+scurrentPage);
					if (scurrentPage == null) {
					currentPage = 1;// 从第一页开始访问
					} else {
					currentPage = Integer.parseInt(scurrentPage);
					}
					// 分页信息
					Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
					// 分页数据信息
					List<Personal> list = personalbiz.findByPageConditions(page, id, condition);

					request.setAttribute("page", page);
					request.setAttribute("list", list);	

					return "mfront/personalBookMa";
					
				}
				@RequestMapping("delete1")
				public String delete1(HttpServletRequest request,HttpServletResponse response){
					System.out.println("进入delete1");
					Personal personal=(Personal) request.getSession().getAttribute("Personal");
					Integer pId=Integer.parseInt(request.getParameter("pId"));
					System.out.println(request.getParameter("pId"));
					boolean boo=personalbiz.delete(pId);
					if(boo){
						System.out.println("删除成功");
						
					}else{
						System.out.println("删除失败");
						
					}
					return "forward:list3";
				}
				@RequestMapping("add1")
				public String add1(HttpServletRequest request,HttpServletResponse response) throws ParseException{
					Personal personal=new Personal();
					System.out.println(request.getParameter("id"));
					personal.setpAddress(request.getParameter("paddress"));
					personal.setpName(request.getParameter("pname"));
					personal.setpTel(request.getParameter("ptel"));
					personal.setId((Integer.parseInt(request.getParameter("id"))));

					boolean boo=personalbiz.add(personal);
					if(boo){
						System.out.println("添加成功");
					}else{
						System.out.println("添加失败");
					}
					return "forward:list3";
				}
				@RequestMapping("update1")
				public String update1(HttpServletRequest request,HttpServletResponse response) throws ParseException{
					Personal personal=new Personal();
					personal.setpAddress(request.getParameter("paddress"));
					personal.setpName(request.getParameter("pname"));
					personal.setpTel(request.getParameter("ptel"));
					personal.setId((Integer.parseInt(request.getParameter("id"))));
					personal.setpId((Integer.parseInt(request.getParameter("pid"))));
					System.out.println("进入update");
					boolean boo=personalbiz.change(personal);
					System.out.println(personal);
					if(boo){
						System.out.println("修改成功");
					}else{
						System.out.println("修改失败");
					}
					return "forward:list3";
				}
}
