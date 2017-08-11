package com.shzqoa.interceptor;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shzqoa.util.HttpRequestDeviceUtils;

public class HttpReqeustDeviceInterceptor extends HandlerInterceptorAdapter {
	  
    private final Logger log = Logger.getLogger(HttpReqeustDeviceInterceptor.class);  
    //用jasckson做Map的序列化  
    private final ObjectMapper objectMapper = new ObjectMapper();  
    // 使用Spring的HttpMessageConvert输出信息  
    private final StringHttpMessageConverter mConverter = new StringHttpMessageConverter();  
    // 输出的media type 可以换成application json   
    private final MediaType mMediaType = new MediaType("text", "plain", Charset.forName("UTF-8"));  
    {  
        //因为用了StringHttpMessageConverter Response默认会有一大堆的Accept-Charset 不要打  
        mConverter.setWriteAcceptCharset(false);  
    } 
      
    @Override    
    public void afterCompletion(HttpServletRequest request,    
            HttpServletResponse response, Object handler, Exception ex)    
            throws Exception {    
        log.info("==HttpReqeustDeviceInterceptor.ִafterCompletion()==");    
    } 
    
    
    
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	return super.preHandle(request, response, handler);
    }
 
    @Override    
    public void postHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler,    
            ModelAndView modelAndView) throws Exception {     
        log.info("==============判断是否是手机端开始================");  
        boolean falg = HttpRequestDeviceUtils.isMobileDevice(request);
        if(falg){
        	log.info("手机端请求");  
        	response.setContentType("application/json");
        	if(modelAndView != null){  
        		String viewName = modelAndView.getViewName();  
                Map<String, Object> model = new HashMap<String, Object>(modelAndView.getModelMap().size(), 1);  
                for(Entry<String,Object> entry : modelAndView.getModelMap().entrySet()) {  
                    // spring会向ModelAndView中写入BindResult 这样的对象是不能序列化的...  
                    if(entry.getKey().startsWith("org.springframework.validation")) {  
                        continue;  
                    }  
                    model.put(entry.getKey(), entry.getValue());  
                }  
                model.put("OLD_VIEW_NAME", viewName); 
                model.put("code", 0);
                model.put("msg", "OK");
                final HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);  
                mConverter.write(objectMapper.writeValueAsString(model), mMediaType, outputMessage);  
                modelAndView.clear();  
                log.info(model);
                ServletOutputStream out = response.getOutputStream();
                out.print(model.toString());
				out.flush();
				out.close();
            } 
        }
        log.info("==============判断是否是手机端结束================");
    }    

}
