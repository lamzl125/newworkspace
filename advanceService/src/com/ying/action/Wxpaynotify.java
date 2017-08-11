package com.ying.action;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.utils.Logs;

//import com.ying.service.IProductService;
import com.ying.wx.util.XMLUtil;

@SuppressWarnings("serial")
public class Wxpaynotify extends MiniActionSupport{
	@Autowired
//	private IProductService shopService;
	@Override
	public String list() throws Exception {
		 HttpServletRequest request = ServletActionContext.getRequest();
	        HttpServletResponse response = ServletActionContext.getResponse();
	        response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
	        InputStream inStream = request.getInputStream();
	        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = inStream.read(buffer)) != -1) {
	            outSteam.write(buffer, 0, len);
	        }
	        System.out.println("~~~~~~~~~~~~~~~~付款成功~~~~~~~~~");
	        outSteam.close();
	        inStream.close();
	        String result  = new String(outSteam.toByteArray(),"utf-8");//获取微信调用我们notify_url的返回信息
	        Map<Object, Object> map = XMLUtil.doXMLParse(result);
	        if(map!=null){
		        for(Object keyValue : map.keySet()){
		            System.out.println("微信支付回调返回："+keyValue+"="+map.get(keyValue));
		        }
		      //获取返回参数
				String retcode = map.get("return_code").toString();
				String rescode = map.get("result_code").toString();
					
				//判断签名及结果
				if("SUCCESS".equals(retcode) && "SUCCESS".equals(rescode)) {
					System.out.println("订单查询成功");
		    //    	shopService.updateOrderState(map.get("out_trade_no").toString(), 1);
					Logs.info("修改订单状态成功");
		        	out.write(XMLUtil.setXML("SUCCESS", ""));   //告诉微信服务器，我收到信息了，不要在调用回调action了
		            System.out.println("-------------"+XMLUtil.setXML("SUCCESS", ""));
		        }
	        }
		return null;
	}
}
