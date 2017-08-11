package com.ying.wx.util;
import java.io.IOException; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
public class IPUtil extends HttpServlet{
	 /** * * 
	  * <p>Title: [HttpServletRequest获取客户端IP方法类] </p> 
	  * * <p>Description: [HttpServletRequest获取客户端IP方法]</p> 
	  * * <p>Copyright: Copyright (c) 2013</p> 
	  * * @update [修改人] [修改时间] 
	  * * @version $Revision$ 
	  * */ 
		private static final long serialVersionUID = 1L; 
		public IPUtil() { 
			super(); 
			} 
		public void destroy() { 
			super.destroy(); 
			} 
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			doPost(request,response); 
			} 
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			String ip = getRemoteAddress(request); 
			System.out.println(ip); 
			} 
		public void init() throws ServletException { 
			
		} 
		/** * * <p>Discription:HttpServletRequest获取客户端IP方法</p> * @param request * @return * @update [修改人] [修改时间] [变更描述] */ 
		public String getRemoteAddress(HttpServletRequest request){ 
			String ip = request.getHeader("x-forwarded-for"); 
			if(ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) 
				ip = request.getHeader("Proxy-Client-IP"); 
			System.out.println(ip); 
			if(ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) 
				ip = request.getHeader("WL-Proxy-Client-IP"); 
			System.out.println(ip); 
			if(ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) 
				ip = request.getRemoteAddr(); 
			System.out.println(ip); 
			return ip; 
		} 
}
