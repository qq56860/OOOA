package org.lanqiao.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.biz.CommonBiz;
import org.lanqiao.entity.Common;
import org.lanqiao.entity.Page;
import org.lanqiao.entity.Personal;
import org.lanqiao.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common/")
public class CommonController {

	@Resource(name="CommomBizImpl")
	private CommonBiz  commonbiz;

	public void setCommonbiz(CommonBiz commonbiz) {
		this.commonbiz = commonbiz;
	}
	//带分页的查询全部
	@RequestMapping("list")
	public String findByPage(HttpServletRequest request) throws UnsupportedEncodingException{
	request.setCharacterEncoding("utf-8");
	System.out.println("进入findByPage方法......");	
	int everyPage = 4;// 每页记录数
	int totalCount = commonbiz.getCont();// 获取总记录数
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
	List<Common> list = commonbiz.findByPage(page);

	request.setAttribute("page", page);
	request.setAttribute("list", list);	

	return "front/publicBook";	
	}
	//带分页的查询全部
	@RequestMapping("list1")
	public String findByPage1(HttpServletRequest request) throws UnsupportedEncodingException{
	request.setCharacterEncoding("utf-8");
	System.out.println("进入findByPage方法......");	
	int everyPage = 4;// 每页记录数
	int totalCount = commonbiz.getCont();// 获取总记录数
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
	List<Common> list = commonbiz.findByPage(page);

	request.setAttribute("page", page);
	request.setAttribute("list", list);	

	return "mfront/publicBook";	
	}

	//不带分页的查询全部
//		@RequestMapping("list2")
//		public String getList(HttpServletRequest request,HttpServletResponse response){
//			System.out.println("进入getList方法中");
//			ArrayList<Common> list=commonbiz.findall();
//			if(null!=list){
//				System.out.println("有"+list.size()+"条数据");
//			}else{
//				System.out.println("没有数据");
//			}
//			request.setAttribute("list", list);
//			return "admin/publicBook";
//			
//			
//		}
	//带分页的查询全部
		@RequestMapping("list2")
		public String findByPage2(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		System.out.println("进入findByPage方法......");	
		int everyPage = 4;// 每页记录数
		int totalCount = commonbiz.getCont();// 获取总记录数
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
		List<Common> list = commonbiz.findByPage(page);

		request.setAttribute("page", page);
		request.setAttribute("list", list);	

		return "admin/publicBook";	
		}
		@RequestMapping("delete")
		public String delete(HttpServletRequest request,HttpServletResponse response){
			System.out.println("进入delete");
			Common common=(Common) request.getSession().getAttribute("Common");
			Integer comId=Integer.parseInt(request.getParameter("comId"));
			System.out.println(request.getParameter("comId"));
			boolean boo=commonbiz.delete(comId);
			if(boo){
				System.out.println("删除成功");
				
			}else{
				System.out.println("删除失败");
				
			}
			return "forward:list1";
		}
		@RequestMapping("update")
		public String update(HttpServletRequest request,HttpServletResponse response) throws ParseException{
			Common common=new Common();
			common.setComName(request.getParameter("cname"));
			common.setComTel(request.getParameter("ctel"));
			common.setManagername(request.getParameter("mname"));
			common.setComId((Integer.parseInt(request.getParameter("comid"))));
			System.out.println("进入update");
			boolean boo=commonbiz.update(common);
			System.out.println(common);
			if(boo){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
			return "forward:list1";
		}

		//根据条件查询：条件是：comname,managername,comtel
		@RequestMapping("findByPageConditions")
		public String findByPageConditions(HttpServletRequest request,HttpServletResponse response){
			System.out.println("进入findByPageConditions方法中");
			Common common=(Common) request.getSession().getAttribute("Commnon");
			String condition=request.getParameter("query_text");
			
			int everyPage = 4;// 每页记录数
			int totalCount = commonbiz.getCont();// 获取总记录数
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
			List<Common> list = commonbiz.findByPageConditions(page, condition);

			request.setAttribute("page", page);
			request.setAttribute("list", list);	

			return "front/publicBook";
			
		}
		//根据条件查询：条件是：comname,managername,comtel
		@RequestMapping("findByPageConditions1")
		public String findByPageConditions1(HttpServletRequest request,HttpServletResponse response){
			System.out.println("进入findByPageConditions方法中");
			Common common=(Common) request.getSession().getAttribute("Commnon");
			String condition=request.getParameter("query_text");
			
			int everyPage = 4;// 每页记录数
			int totalCount = commonbiz.getCont();// 获取总记录数
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
			List<Common> list = commonbiz.findByPageConditions(page, condition);

			request.setAttribute("page", page);
			request.setAttribute("list", list);	

			return "mfront/publicBook";
			
		}
		//根据条件查询：条件是：comname,managername,comtel
		@RequestMapping("findByPageConditions2")
		public String findByPageConditions2(HttpServletRequest request,HttpServletResponse response){
			System.out.println("进入findByPageConditions方法中");
			Common common=(Common) request.getSession().getAttribute("Commnon");
			String condition=request.getParameter("query_text");
			
			int everyPage = 4;// 每页记录数
			int totalCount = commonbiz.getCont();// 获取总记录数
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
			List<Common> list = commonbiz.findByPageConditions(page, condition);

			request.setAttribute("page", page);
			request.setAttribute("list", list);	

			return "admin/publicBook";
			
		}


}
