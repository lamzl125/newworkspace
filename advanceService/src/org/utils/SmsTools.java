package org.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class SmsTools {
	private static Map<String, String> mapCode;
	private static String sendUrl = "http://eip.yseip.com/SMS/Send.ashx";
	private static String key = "b9887c5ebb23ebb294acab183ecf0769";
	String mobile = "";

	public static void main(String[] args) throws Exception {
		try {
			System.out.println(sendSms("15939034410","123555"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
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
			if(type==1){
				code = proCode();
				String content = "短信验证码:"+code+",欢迎注册";
				Logs.info("mobile=" + mobile + "   code=" + code);
				if(sendSms(mobile, content)){
					mapCode.put(mobile, code);
					return true;
				}
			}else if(type==2){
				String content = "您的密码是:"+pwd;
				if(sendSms(mobile, content)){
					return true;
				}
			}
			
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
		return true;
	}

	public static void init() {
		if (mapCode == null) {
			mapCode = new HashMap<String, String>();
		}
	}
}
