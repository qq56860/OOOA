package org.lanqiao.websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;















import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;
import org.lanqiao.biz.EmployeeBiz;
import org.lanqiao.biz.ManagerBiz;
import org.lanqiao.biz.impl.EmployeeBizImpl;
import org.lanqiao.dao.impl.EmployeeDaoImpl;
import org.lanqiao.dao.impl.ManagerDaoImpl;
import org.lanqiao.entity.Employee;
import org.lanqiao.entity.Manager;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@SuppressWarnings("deprecation")
public class MyMessageInbound extends MessageInbound { 
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    
	private String name;
	private EmployeeBiz ebiz;
	private ManagerBiz mbiz;
    public MyMessageInbound() {
        super();
    }

    public MyMessageInbound(String name,EmployeeBiz ebiz,ManagerBiz mbiz) {
        super();
        this.name = name;
        this.ebiz=ebiz;
        this.mbiz=mbiz;
    }
    
    @Override  
    protected void onBinaryMessage(ByteBuffer arg0) throws IOException {  
        // TODO Auto-generated method stub 
          
    }  
  
    @Override  
    protected void onTextMessage(CharBuffer msg) throws IOException { 
    	//用户所发消息处理后的map
        HashMap<String,String> messageMap = MessageUtil.getMessage(msg);    //处理消息类
        //上线用户集合类map
        HashMap<String, MessageInbound> userMsgMap = InitServlet.getSocketList();

        String fromName = messageMap.get("fromName");    //消息来自人 的userId
        String toName = messageMap.get("toName");         //消息发往人的 userId
        //获取头像
        Employee ee = ebiz.findbyName(fromName);
        Manager mm = mbiz.findbyName(fromName);
        //Employee ee=edi.findbyName(toName);
        //Manager mm=mdi.findbyName(toName);
        String img = null;
        if(mm==null){
        	if(ee.getImg()==null){
        		if(ee.geteSex().equals("男")){img = "/OOOA/images/3.png";}
        		else{
        			img = "/OOOA/images/1.png";
        		}
        	}
        	else{
        		img = ee.getImg();
        	}
        }
        System.out.println("11");
        //获取该用户
        MessageInbound messageInbound = userMsgMap.get(toName);    //在仓库中取出发往人的MessageInbound
        MessageInbound messageFromInbound = userMsgMap.get(fromName);
        if(toName.equals("群聊")){
        	System.out.println("群聊");
        	 Iterator<Map.Entry<String, MessageInbound>> iterator = userMsgMap.entrySet().iterator();
        	 WsOutbound outbound;
             WsOutbound outFromBound = messageFromInbound.getWsOutbound();
             String time = DATE_FORMAT.format(new Date());
             String content = messageMap.get("content");  //获取消息内容
             String msgContentString = "<li class='am-comments am-comment-flip'><a href='javascript:void(0)' ><img src='"+img
             		+ "' class='am-comment-avatar' width='48' height='48'/></a><div class='am-comment-main'><header class='am-comment-hd'>"
             		+ "<div class='am-comment-meta'><a href='javascript:void(0)' class='am-comment-author'>"+fromName+"</a> <time>"
             		+time+"</time></div></header><div class='am-comment-bd'>"+ content+"</div></div></li>";   //构造发送的消息
             String ReturnmsgContentString = "<li class='am-comments'><a href='javascript:void(0)' ><img src='"+img
             		+ "' class='am-comment-avatar' width='48' height='48'/></a><div class='am-comment-main'><header class='am-comment-hd'>"
             		+ "<div class='am-comment-meta'><a href='javascript:void(0)' class='am-comment-author'>"+fromName+"</a> <time>"
             		+time+"</time></div></header><div class='am-comment-bd'>"+ content+"</div></div></li>"; 

             //发出去内容
             CharBuffer toMsg =  CharBuffer.wrap(ReturnmsgContentString.toCharArray());
             CharBuffer fromMsg =  CharBuffer.wrap(msgContentString.toCharArray());

             outFromBound.writeTextMessage(fromMsg);
             outFromBound.flush();
             while (iterator.hasNext()) {
            		Entry<String, MessageInbound> entry = iterator.next();
            		messageInbound = entry.getValue();
            		if(messageInbound!=messageFromInbound){
            			outbound = messageInbound.getWsOutbound(); 
            			outbound.writeTextMessage(toMsg); 
            			outbound.flush();
            		}
            }
        }else{
        	if(messageInbound!=null && messageFromInbound!=null){     //如果发往人 存在进行操作
                WsOutbound outbound = messageInbound.getWsOutbound(); 
                System.out.println("单聊");
                WsOutbound outFromBound = messageFromInbound.getWsOutbound();
                String time = DATE_FORMAT.format(new Date());
                String content = messageMap.get("content");  //获取消息内容
                String msgContentString = "<li class='am-comments am-comment-flip'><a href='javascript:void(0)' ><img src='"+img
                		+ "' class='am-comment-avatar' width='48' height='48'/></a><div class='am-comment-main'><header class='am-comment-hd'>"
                		+ "<div class='am-comment-meta'><a href='javascript:void(0)' class='am-comment-author'>"+fromName+"</a> <time>"
                		+time+"</time></div></header><div class='am-comment-bd'>"+ content+"</div></div></li>";   //构造发送的消息
                String ReturnmsgContentString = "<li class='am-comments'><a href='javascript:void(0)' ><img src='"+img
                		+ "' class='am-comment-avatar' width='48' height='48'/></a><div class='am-comment-main'><header class='am-comment-hd'>"
                		+ "<div class='am-comment-meta'><a href='javascript:void(0)' class='am-comment-author'>"+fromName+"</a> <time>"
                		+time+"</time></div></header><div class='am-comment-bd'>"+ content+"</div></div></li>"; 

                //发出去内容
                CharBuffer toMsg =  CharBuffer.wrap(ReturnmsgContentString.toCharArray());
                CharBuffer fromMsg =  CharBuffer.wrap(msgContentString.toCharArray());

                outFromBound.writeTextMessage(fromMsg);
                outbound.writeTextMessage(toMsg);  //
                outFromBound.flush();
                outbound.flush();
            }
        }
        	
        }
        
        
      /*  for (MessageInbound messageInbound : InitServlet.getSocketList()) {  
            CharBuffer buffer = CharBuffer.wrap(msg);  
            WsOutbound outbound = messageInbound.getWsOutbound();  
            outbound.writeTextMessage(buffer);  
            outbound.flush();  
        }  */
          
//    }  
  
    @Override  
    protected void onClose(int status) { 
        InitServlet.getSocketList().remove(this.name);  
        super.onClose(status);  
        System.out.println("关闭");
    }  
  
    @Override  
    protected void onOpen(WsOutbound outbound) {
        super.onOpen(outbound);  
        //登录的用户注册进去
        if(name!=null){
            InitServlet.getSocketList().put(name, this);
            System.out.println(InitServlet.getSocketList().size()+"人上线");
        }
//        InitServlet.getSocketList().add(this); 
        System.out.println("打开");
    }  
      
    @Override
    public int getReadTimeout() {
        return 0;
    }  
      
}