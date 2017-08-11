package com.ying.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.utils.Logs;

//import com.ying.service.IProductService;

@SuppressWarnings("serial")
public class Paynotify extends MiniActionSupport{	
	@Autowired
//	private IProductService shopService;
	/**
	 * 支付宝异步通知
	 * @author WJS
	 * @version 创建时间：2015-5-11 上午10:02:33
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	@RequestMapping(value = "/payNotify")
//	public String doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
				//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
				//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
				params.put(name, valueStr);
				Logs.info("支付宝返回参数"+name+"=="+valueStr);
			}
			//商户订单号
			String out_trade_no = params.get("out_trade_no");
			//交易状态
			String trade_status = params.get("trade_status");
			if (trade_status.equals("TRADE_SUCCESS")){
	//			shopService.updateOrderState(out_trade_no, 1);
				Logs.info("修改订单成功");
				out.println("success");	//请不要修改或删除
			}else if(trade_status.equals("TRADE_FINISHED")){
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
	/**
	 * 4位数
	 * @return
	 */
	public String random4(){
		return String.valueOf(Math.random()).substring(2, 6);
	}
	@RequestMapping(value = "/merchant")
	public String merchant(){
		return "order/order-pay-fail";
	}
	
	
}
