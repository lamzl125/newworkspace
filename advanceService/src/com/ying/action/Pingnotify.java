/**
 * 
 */
package com.ying.action;

import java.io.BufferedReader; 
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.utils.Logs;

import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Event;
import com.pingplusplus.model.Webhooks;
import com.ying.service.IadvanceService;

@SuppressWarnings("serial")
public class Pingnotify extends MiniActionSupport{	
	@Autowired
	private IadvanceService appointService;
	/* (non-Javadoc)
	 * @see com.ying.action.MiniActionSupport#list()
	 */
	@Override
	public String list() throws Exception {

		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取头部所有信息
        Enumeration headerNames = request.getHeaderNames();
		try {
			while (headerNames.hasMoreElements()) {
	            String key = (String) headerNames.nextElement();
	            String value = request.getHeader(key);
	            System.out.println(key+" "+value);
		    }
			// 获得 http body 内容
	        BufferedReader reader = request.getReader();
	        StringBuffer buffer = new StringBuffer();
	        String string;
	        while ((string = reader.readLine()) != null) {
	            buffer.append(string);
	        }
	        reader.close();
	        // 解析异步通知数据
	        Event event = Webhooks.eventParse(buffer.toString());
	        Charge event_charge = (Charge)Webhooks.getObject(buffer.toString());
		        	
		    //订单号
		    String out_trade_no = event_charge.getOrderNo();
		    if ("charge.succeeded".equals(event.getType())) {
//				if(appointService.saveBuyMoney1(out_trade_no)){
//		          	Logs.info("修改订单成功"+out_trade_no+"成功");
//		        }
	        } else if ("refund.succeeded".equals(event.getType())) {
	            response.setStatus(200);
	        } else {
	            response.setStatus(500);
	        }
		} catch (Exception e) {
			Logs.error("回调处理异常");
			Logs.error(e);
		}
		return null;
	}
	
	
}
