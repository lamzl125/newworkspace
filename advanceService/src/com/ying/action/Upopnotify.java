/**
 * 
 */
package com.ying.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.utils.Logs;

import sun.rmi.runtime.Log;

/** 
 * @ClassName: Upopnotify 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author luwenjie 
 * @date 2015-12-10 下午5:37:42 
 * @version 1.0 
 */
@SuppressWarnings("serial")
public class Upopnotify extends MiniActionSupport{

	/* (non-Javadoc)
	 * @see com.ying.action.MiniActionSupport#list()
	 */
	@Override
	public String list() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			
			
			//获取支付宝POST过来反馈信息
			Map<String,String> params = new HashMap<String,String>();
			Map requestParams = request.getParameterMap();
			for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String[] values = (String[]) requestParams.get(name);
				String valueStr = "";
				for (int i = 0; i < values.length; i++) {
					valueStr = (i == values.length - 1) ? valueStr + values[i]
							: valueStr + values[i] + ",";
				}
			
				params.put(name, valueStr);
				
			}
		
			//交易状态
			   String transStatus = request.getParameter("respCode");// 交易状态  
			if (null != transStatus && transStatus.equals("00")){
	//			shopService.updateOrderState(out_trade_no, 1);
				Logs.info("支付成功");
				out.println("success");	//请不要修改或删除
			}else{
				out.println("fail");	
			} 
		} catch (Exception e) {
			Logs.error("回调处理异常");
			Logs.error(e);
		}
		return null;
	}

}
