package com.ying.alipay.util;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.ying.alipay.config.AlipayConfig;
/**
 * @Description: (支付宝)
 * @author：Wangfeilong
 * @date：2015-2-4 下午03:43:13
 */
public class AlipayUtil {
	/**
		//支付宝接口使用 范例
		HttpServletResponse response = ServletActionContext.getResponse();
		Alipay alipay=new Alipay();
		//以下3个url都不能带参数，可以写action的地址, ip或域名 需要公网能访问的
		//根据自己的业务需求配置
		//支付完成同步通知页面，即展示页面
		alipay.setCall_back_url("http://netyw.vicp.cc:8091/beijin/call_back_url.jsp");
		//支付完成异步通知服务器地址，做后台处理
		alipay.setNotify_url("http://netyw.vicp.cc:8091/beijin/notify_url.jsp");
		//操作中断返回商户的地址
		alipay.setMerchant_url("http://netyw.vicp.cc:8091/beijin/index.jsp");
		
		
		//以下3个商户支付宝信息，根据商户信息更改
		//alipay.setSeller_email("zhaowei139@139.com");
		//商户的支付宝id ，即PID,2088开头
		alipay.setPartner("2088711652856371");
		//商户对应的KEY
		alipay.setKey("yikm56cod8yi4sf66mnwycj0atui5e9x");
		
		//商品订单信息详情
		//唯一的订单编号
		alipay.setOut_trade_no(WIDout_trade_no);
		//商品名称
		alipay.setSubject(WIDsubject);
		//支付金额
		alipay.setTotal_fee(String.valueOf(WIDtotal_fee));
		
		//发起支付
		AlipayUtil.pay(alipay, response);
	*/

	public static void pay(Alipay alipay,HttpServletResponse  response){
		
		try {
			if(checkParameter(alipay)){
//				throw new SysException("支付请求参数错误");
			}
			PrintWriter out = response.getWriter();
			//支付宝网关地址
			String ALIPAY_GATEWAY_NEW = "http://wappaygw.alipay.com/service/rest.htm?";

			////////////////////////////////////调用授权接口alipay.wap.trade.create.direct获取授权码token//////////////////////////////////////
			
			//返回格式
			String format = "xml";
			//必填，不需要修改
			
			//返回格式
			String v = "2.0";
			//必填，不需要修改
			
			//请求号
			String req_id = UtilDate.getOrderNum();
			//必填，须保证每次请求都是唯一
			
			//req_data详细信息
			
			//服务器异步通知页面路径
			String notify_url =alipay.getNotify_url();
			//需http://格式的完整路径，不能加?id=123这类自定义参数

			//页面跳转同步通知页面路径
			String call_back_url = alipay.getCall_back_url();
			//需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/

			//操作中断返回地址
			String merchant_url = alipay.getMerchant_url();
			//用户付款中途退出返回商户的地址。需http://格式的完整路径，不允许加?id=123这类自定义参数

			//卖家支付宝帐户
			String seller_email = new String(alipay.getSeller_email().getBytes("ISO-8859-1"),"UTF-8");
			//必填

			//商户订单号
			String out_trade_no = new String(alipay.getOut_trade_no().getBytes("ISO-8859-1"),"UTF-8");
			//商户网站订单系统中唯一订单号，必填

			//订单名称
			String subject = alipay.getSubject();
			//必填

			//付款金额
			String total_fee = new String(alipay.getTotal_fee().getBytes("ISO-8859-1"),"UTF-8");
			//必填
			
			//请求业务参数详细
			String req_dataToken = "<direct_trade_create_req><notify_url>" + notify_url + "</notify_url><call_back_url>" + call_back_url + "</call_back_url><seller_account_name>" + seller_email + "</seller_account_name><out_trade_no>" + out_trade_no + "</out_trade_no><subject>" + subject + "</subject><total_fee>" + total_fee + "</total_fee><merchant_url>" + merchant_url + "</merchant_url></direct_trade_create_req>";
			//必填
			
			//设置PID 和 KEY
			AlipayConfig.partner=new String(alipay.getPartner().getBytes("ISO-8859-1"),"UTF-8");
			AlipayConfig.key=new String(alipay.getKey().getBytes("ISO-8859-1"),"UTF-8");
			//////////////////////////////////////////////////////////////////////////////////
			
			//把请求参数打包成数组
			Map<String, String> sParaTempToken = new HashMap<String, String>();
			sParaTempToken.put("service", "alipay.wap.trade.create.direct");
			sParaTempToken.put("partner", AlipayConfig.partner);
			sParaTempToken.put("_input_charset", AlipayConfig.input_charset);
			sParaTempToken.put("sec_id", AlipayConfig.sign_type);
			sParaTempToken.put("format", format);
			sParaTempToken.put("v", v);
			sParaTempToken.put("req_id", req_id);
			sParaTempToken.put("req_data", req_dataToken);
			
			//建立请求
			String sHtmlTextToken = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW,"", "",sParaTempToken);
			//URLDECODE返回的信息
			sHtmlTextToken = URLDecoder.decode(sHtmlTextToken,AlipayConfig.input_charset);
			//获取token
			String request_token = AlipaySubmit.getRequestToken(sHtmlTextToken);
			//out.println(request_token);
			
			////////////////////////////////////根据授权码token调用交易接口alipay.wap.auth.authAndExecute//////////////////////////////////////
			
			//业务详细
			String req_data = "<auth_and_execute_req><request_token>" + request_token + "</request_token></auth_and_execute_req>";
			//必填
			
			//把请求参数打包成数组
			Map<String, String> sParaTemp = new HashMap<String, String>();
			sParaTemp.put("service", "alipay.wap.auth.authAndExecute");
			sParaTemp.put("partner", AlipayConfig.partner);
			sParaTemp.put("_input_charset", AlipayConfig.input_charset);
			sParaTemp.put("sec_id", AlipayConfig.sign_type);
			sParaTemp.put("format", format);
			sParaTemp.put("v", v);
			sParaTemp.put("req_data", req_data);
			
			//建立请求
			String sHtmlText = AlipaySubmit.buildRequest(ALIPAY_GATEWAY_NEW, sParaTemp, "get", "确认");
			out.println(sHtmlText);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static boolean checkParameter(Alipay alipay){
		boolean b = false;
		if(alipay.getCall_back_url()==null||alipay.getCall_back_url().equals("")){
			b=true;
		}
		if(alipay.getKey()==null||alipay.getKey().equals("")){
			b=true;
		}
		if(alipay.getNotify_url()==null||alipay.getNotify_url().equals("")){
			b=true;
		}
		if(alipay.getOut_trade_no()==null||alipay.getOut_trade_no().equals("")){
			b=true;
		}
		if(alipay.getPartner()==null||alipay.getPartner().equals("")){
			b=true;
		}
		if(alipay.getSeller_email()==null||alipay.getSeller_email().equals("")){
			b=true;
		}
		if(alipay.getSubject()==null||alipay.getSubject().equals("")){
			b=true;
		}
		if(!alipay.getTotal_fee().matches("-?[0-9]+.*[0-9]*")){
			b=true;
		}
		
		return b;
	}
}
