package org.lanqiao.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.biz.ManagerBiz;
import org.lanqiao.biz.NoticeBiz;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Notice;
import org.lanqiao.entity.Page;
import org.lanqiao.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/notice/")
public class NoticeController {
	@Resource(name="noticeBiz")
	private NoticeBiz noticeBiz;
	@Resource(name="managerBiz")
	private ManagerBiz managerBiz;
	@Resource(name = "employeeBiz")
	private EmployeeBiz employeeBiz;
	
	public void setNoticeBiz(NoticeBiz noticeBiz) {
		this.noticeBiz = noticeBiz;
	}
	@RequestMapping("findByPageM")
	public String findByPageM(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		System.out.println("进入findByPageM方法......");	
		int everyPage = 4;// 每页记录数
		int totalCount = noticeBiz.getCont();// 获取总记录数
		System.out.println("总数据记录:"+totalCount);
		String scurrentPage = request.getParameter("currentPage");
		int currentPage = 1; // 当前页，默认1
		System.out.println("当前页数scurrentPage1"+scurrentPage);
		if (scurrentPage == null) {
			currentPage = 1;// 从第一页开始访问
		} else {
			currentPage = Integer.parseInt(scurrentPage);
		}
		// 分页信息
		Page page = PageUtil.createPage(everyPage, totalCount, currentPage);
		// 分页数据信息
		List<Notice> list = noticeBiz.findByPage(page);
		request.setAttribute("page", page);
		request.setAttribute("list", list);	
		
		return "mfront/noticeList";	
	}
	@RequestMapping("findByPageE")
	public String findByPageE(HttpServletRequest request){
		System.out.println("进入findByPageE方法......");	
		int everyPage = 4;// 每页记录数
		int totalCount = noticeBiz.getCont();// 获取总记录数
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
		List<Notice> list = noticeBiz.findByPage(page);

		request.setAttribute("page", page);
		request.setAttribute("list", list);	
		return "front/noticeList";	
	}
	//修改赞
	@RequestMapping("updatezan")
	public String updatezanE(Notice notice,HttpServletRequest request,HttpServletResponse response){
		int nid=Integer.parseInt(request.getParameter("id"));
		Employee em=(Employee) request.getSession().getAttribute("User");
		String zan=noticeBiz.getOne(nid).getZan();
		zan=zan+em.geteId()+",";
		notice.setnId(nid);
		notice.setZan(zan);
		boolean boo=noticeBiz.updateZan(notice);
		if(boo){
			System.out.println("赞成功");
		}else{
			System.out.println("赞失败");
		}
		return "forward:findByPageE";
	}

	@RequestMapping("addN")
	public String addN(HttpServletRequest request){
		//request.setCharacterEncoding("utf-8");
		Notice  n= new Notice();
		n.setnTitle(request.getParameter("title"));
		n.setnSummary(request.getParameter("summary"));
		n.setnContent(request.getParameter("contents"));
		n.setIssuer(request.getParameter("nissuer"));
		System.out.println("issuer:"+request.getParameter("nissuer"));
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//long l=System.currentTimeMillis();
		//Date date =new Date(l);
		//long utildate=new Date().getTime();
		//System.out.println(utildate);
		//n.setDate(sdf.format(date));
		//java.sql.Date date= new java.sql.Date(utildate);
		//n.setDate(date);
		n.setState(1);
		n.setZan("0,");
		boolean boo = noticeBiz.add(n);
		if (boo) {
			request.setAttribute("msg", "<script>alert('添加成功！')</script>");
		} else {
			request.setAttribute("msg", "<script>alert('添加失败！')</script>");
		}
		return "forward:findByPageM";
			
	}
	@RequestMapping("addNA")
	public String addNA(HttpServletRequest request){
//		request.setCharacterEncoding("utf-8");
		Notice  n= new Notice();
		n.setnTitle(request.getParameter("title"));
		n.setnSummary(request.getParameter("summary"));
		n.setnContent(request.getParameter("contents"));
		n.setIssuer(request.getParameter("nissuer"));
		System.out.println("issuer:"+request.getParameter("nissuer"));
		//Date utildate =new java.util.GregorianCalendar().getTime();
		//java.sql.Date date=new java.sql.Date(utildate.getTime());
		//n.setDate(date);
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//long l=System.currentTimeMillis();
		//Date date =new Date(l);
		//n.setDate(sdf.format(date));
		n.setState(1);
		n.setZan("0");
		boolean boo = noticeBiz.add(n);
		if (boo) {
			request.setAttribute("msg", "<script>alert('添加成功！')</script>");
		} else {
			request.setAttribute("msg", "<script>alert('添加失败！')</script>");
		}
		return "forward:findall";
			
	}

	
	
	//先不用！！！！留着！！！
	//查找全部信息
	@RequestMapping("findall")
	public String findall(HttpServletRequest request,HttpServletResponse response){
		ArrayList<Notice> list=noticeBiz.findAll();
		request.setAttribute("notice", list);
		System.out.println(list);
		return "admin/notice";
	}
	
	//根据id查
	@RequestMapping("getbyid")
	public String getbyid(int nid,HttpServletRequest request,HttpServletResponse response){
		
		System.out.println("进入getbyid方法....");
		System.out.println("nid的值："+nid);
		Notice notice=noticeBiz.getOne(nid);
		request.setAttribute("notice", notice);
		return "admin/updateNotice";
	}
	
	@RequestMapping("updateN")
	public String update(Notice notice,HttpServletRequest request,HttpServletResponse response) {
		int nid=Integer.parseInt(request.getParameter("nid"));
		System.out.println("进入updateN");
		
		System.out.println("nid....."+nid);
		notice.setnId(nid);
		notice.setnTitle(request.getParameter("title"));
		notice.setnSummary(request.getParameter("summary"));
		notice.setnContent(request.getParameter("contents"));
		notice.setIssuer(request.getParameter("nissuer"));
		//Date utildate =new java.util.GregorianCalendar().getTime();
		//java.sql.Date date=new java.sql.Date(utildate.getTime());
		//notice.setDate(date);
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//long l=System.currentTimeMillis();
		//Date date =new Date(l);
		//notice.setDate(sdf.format(date));
		
		boolean boo=noticeBiz.update(notice);
		if(boo){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
		return "forward:findall";
	}

	
	@RequestMapping("delete")
	public String delete(int nid,HttpServletRequest request,HttpServletResponse response){
		nid=Integer.parseInt(request.getParameter("nid"));
		boolean boo=noticeBiz.delete(nid);
		if(boo){
			System.out.println("删除成功");		
		}else{
			System.out.println("删除失败");
		}
		return "forward:findall";	
	}
	
	
	
	
	
}
