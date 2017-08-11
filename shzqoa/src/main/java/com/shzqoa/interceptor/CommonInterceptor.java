package com.shzqoa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shzqoa.model.User;
import com.shzqoa.util.HttpRequestDeviceUtils;

public class CommonInterceptor extends HandlerInterceptorAdapter {
	  
    private final Logger log = Logger.getLogger(CommonInterceptor.class);  
      
    
    
    @Override    
    public void afterCompletion(HttpServletRequest request,    
            HttpServletResponse response, Object handler, Exception ex)    
            throws Exception {    
        log.info("=CommonInterceptor.afterCompletion()=");    
    } 
    
    
    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;
        log.info("==============拦截器开始================");
        String requestUri = request.getRequestURI();  
        String contextPath = request.getContextPath();  
        String url = requestUri.substring(contextPath.length());  
      
      log.info("requestUri:"+requestUri);    
      log.info("url:"+url);    
      
      
      flag = HttpRequestDeviceUtils.isMobileDevice(request);
      if(!flag){
    	  User user =  (User)request.getSession().getAttribute("user");   
          if(user == null){  
              log.info("Interceptor拦截到未登录");  
              request.getRequestDispatcher("/login.jsp").forward(request, response);  
              flag = false;  
          }else  
        	  flag = true;  
      }
	return flag;
      
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

}
