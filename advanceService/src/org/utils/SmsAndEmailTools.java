package org.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmsAndEmailTools {
	private static Map<String, String> mapCode;
	private static String sendUrl = "http://eip.yseip.com/SMS/Send.ashx";
	private static String key = "4757aa84dc5e75a4#35ebfc264006dda1#61B5198A06AD01B694428919EBFC9427";
	String mobile = "";
	private static String smtpHost="smtp.163.com";
	private static String from="qq236520@163.com";
	private static String fromUserPassword="wj520liuyan";
//	private static String from="zzlx2015@163.com";
//	private static String fromUserPassword="zzlxzzlx";
	private static String messageType="text/html;charset=gb2312";
	private static String subject="";
	private static String messageText="您的验证码是code，有效时间为120秒";
	public static void main(String[] args) throws Exception {
		//			System.out.println(sendSms("15939034410","123555"));
		sendMessage("137280409@qq.com");
	}

	/**
	 * 下发短信
	 * 
	 * @param mobile
	 * @param type 1下发短信 2下发密码
	 * @param pwd 下发密码是为密码 type=1时不用传
	 * @return
	 */
	public static boolean sendSmsCode(String mobile,int type,String pwd) {
		init();
		String code = "";
		boolean b = false;
		String log = "发送短信码:" + mobile + ",";
		try {
			if (!Tool.isMobile(mobile)) {
				Logs.info(log + "手机号码不正确");
				return b;
			}
//			if(type==1){
				code = proCode();
//				String content = "短信验证码:"+code+",欢迎注册";
				Logs.info("mobile=" + mobile + "   code=" + code);
				if(sendSms(mobile, messageText.replace("code", code))){
					mapCode.put(mobile, code);
					return true;
				}
//			}else if(type==2){
//				String content = "您的密码是:"+pwd;
//				if(sendSms(mobile, content)){
//					return true;
//				}
//			}
			
		} catch (Exception e) {
			Logs.error("下发短信异常:" + e);
		}
		return b;
	}

	/**
	 * 
	 * 检查验证码是否正确 正确则返回true
	 * 
	 * @param mobile
	 * @param smscode
	 * @return
	 */
	public static boolean checkSmsCode(String mobile, String smsCode) {
		init();
		String code=mapCode.get(mobile);
		if(code!=null && smsCode.equals(code)){
			return true;
		}
		return false;
	}

	/**
	 * 生成6位随机验证码
	 * 
	 * @return
	 */
	public static String proCode() {
		return String.valueOf(Math.random()).substring(2, 8);
	}

	/**
	 * 100 发送成功 101 验证失败 102 短信不足 103 操作失败 104 非法字符 105 内容过多 106 号码过多 107 频率过快
	 * 108 号码内容空 110 禁止频繁单条发送 112 号码错误 113 定时时间格式不对 114 账号被锁 116 禁止接口发送 117
	 * 绑定IP不正确 120 系统升级
	 * 
	 * @param mobile
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static boolean sendSms(String mobile,String content) throws Exception {
		try {
			content = URLEncoder.encode(content, "UTF-8");
			String parm = "key=" + key + "&mobile=" + mobile + "&content="
					+ content;
			String res = HttpGetPost.sendPost(sendUrl, parm);
			Logs.info("下发短信req=" + parm);
			Logs.info("下发短信res=" + res);
			if (res != null && !"".equals(res)) {
				res = res.replace("\n", "");
				// String
				// res="SuccessNum:0;MobileNum:1;SendTime:;SMSContent:;ValidNum:0;SMSSign:;State:661;";
				if(res.indexOf("SuccessNum:1")>-1){
					return true;
				}
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
	 @SuppressWarnings("static-access")
		public static boolean sendMessage(String to) throws MessagingException {  
		 //验证码 
		 String  code = proCode();
		 try {
			 init();
		        // 第一步：配置javax.mail.Session对象  
		        System.out.println("为" + smtpHost + "配置mail session对象");  
		        Properties props = new Properties();  
		        props.put("mail.smtp.host", smtpHost);  
		        props.put("mail.smtp.starttls.enable","true");//使用 STARTTLS安全连接  
		        //props.put("mail.smtp.port", "25");         //google使用465或587端口  
		        props.put("mail.smtp.auth", "true");        // 使用验证  
		        //props.put("mail.debug", "true");  
		        Session mailSession = Session.getInstance(props,new MyAuthenticator(from,fromUserPassword));  
		  
		        // 第二步：编写消息  
		        InternetAddress fromAddress = new InternetAddress(from);  
		        InternetAddress toAddress = new InternetAddress(to);  
		  
		        MimeMessage message = new MimeMessage(mailSession);  
		  
		        message.setFrom(fromAddress);  
//		        message.addRecipient(RecipientType.TO, toAddress);  
		        message.setRecipient(RecipientType.TO, toAddress);
		        
		        message.setSentDate(Calendar.getInstance().getTime());  
		        message.setSubject(subject);  
		       
				mapCode.put(to, code);
		        message.setContent(messageText.replace("code", code), messageType);  
		  
		        // 第三步：发送消息  
		        Transport transport = mailSession.getTransport("smtp");  
		        transport.connect(smtpHost,from, fromUserPassword);  
		        transport.send(message, message.getRecipients(RecipientType.TO));
		        transport.close();
		        Logs.info("发送验证码成功 to="+to+"  code="+code);
		        return true;
		} catch (Exception e) {
			Logs.info("发送验证码成功 to="+to+" code="+code);
			Logs.error("邮件发送异常："+e);
		}	
		 return false;
  }  
		  
	public static void init() {
		if (mapCode == null) {
			mapCode = new HashMap<String, String>();
		}
	}
}
