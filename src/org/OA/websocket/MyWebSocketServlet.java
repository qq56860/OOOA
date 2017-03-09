package org.lanqiao.websocket;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.biz.ManagerBiz;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * @ClassName: MyWebSocketServlet 
 * @Description: 建立连接时创立 
 * @author mangues
 * @date 2015-7-19
 */
@SuppressWarnings("deprecation")
public class MyWebSocketServlet extends WebSocketServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getUser(HttpServletRequest request){
        String userName = (String) request.getSession().getAttribute("user");
		//Employee em = (Employee)request.getSession().getAttribute("User"); 
		//String userName = em.geteName();
		System.out.println(userName);
        if(userName==null){
            return null;
        }
        return userName;  
       // return (String) request.getAttribute("user");  
    }  
    @Override
    protected StreamInbound createWebSocketInbound(String arg0,
            HttpServletRequest request) {
    	
    	ServletContext sc=request.getServletContext();
    	ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
    	EmployeeBiz ebiz=(EmployeeBiz) ac.getBean("employeeBiz");
    	ManagerBiz mbiz=(ManagerBiz) ac.getBean("managerBiz");
    	//EmployeeDaoImpl edi=new EmployeeDaoImpl();
    	//ManagerDaoImpl mdi=new ManagerDaoImpl();
    	
    	System.out.println("用户" + request.getSession().getAttribute("user") + "登录");
        return new MyMessageInbound(this.getUser(request),ebiz,mbiz); 
    }

}