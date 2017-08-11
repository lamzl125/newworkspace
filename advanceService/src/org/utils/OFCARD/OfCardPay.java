package org.utils.OFCARD;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.utils.DateTimeUtil;
import org.utils.SysGlobals;

public class OfCardPay {
	
	/**
	 * 手机充值
	 * @param telphone  手机号码
	 * @param money     充值金额
	 * @return
	 */
	public static Map<String,Object> phonePay(String telphone,String money){
		Map<String,Object> map=new HashMap<String,Object>();
		//传参
        String userid=SysGlobals.getInstance().getProperty("userid");
        String userpws= MD5Util.digest(SysGlobals.getInstance().getProperty("userpws"), "GBK").toLowerCase();

        //参数值为140101（快充）或者 170101（慢充）
        String cardid="140101";

        //要充值的金额
        String cardnum=money;
        Date dd=new Date();
        String dateStr=DateTimeUtil.dateFormat("yyyyMMddHHmmss", dd);
        //随机字符串
        String code=((int)((Math.random()*9+1)*100))+"";
        //外部订单号，唯一性
        String sporder_id=dateStr+code;
        
        //格式：年月日时分秒 如：20141119112450
        String sporder_time=dateStr;

        //要充值的手机号码
        String game_userid=telphone;

        //该参数将异步返回充值结果，若不填写该地址，则不会回调
        String ret_url="";

        //版本号固定值
        String version="6.0";

        //若cardid=170101，需要加上下面的参数，不传该值默认为24
        String mctype="";

        //默认的秘钥是OFCARD，可联系商务修改，若已经修改过的，请使用修改过的。
        String keystr = SysGlobals.getInstance().getProperty("keystr");

        String md5_str_param = userid+userpws+cardid+cardnum+sporder_id+sporder_time+game_userid+keystr;
        String md5_str = MD5Util.digest(md5_str_param,"gbk").toUpperCase();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("userid="+userid+"&");
        stringBuffer.append("userpws="+userpws+"&");
        stringBuffer.append("cardid="+cardid+"&");
        stringBuffer.append("cardnum="+cardnum+"&");
        stringBuffer.append("mctype="+mctype+"&");
        stringBuffer.append("sporder_id="+sporder_id+"&");
        stringBuffer.append("sporder_time="+sporder_time+"&");
        stringBuffer.append("game_userid="+game_userid+"&");
        stringBuffer.append("md5_str="+md5_str+"&");
        stringBuffer.append("ret_url="+ret_url+"&");
        stringBuffer.append("version="+version);

        String param = stringBuffer.toString();
        String url="http://"+userid+".api2.ofpay.com/onlineorder.do";
        int readTimeout=10000;
        int connectTimeout=10000;

        try{
            String result = HttpClientUtil.sendGetRequest(url,param,readTimeout,connectTimeout);

            //解析欧飞返回的xml文件
            Document document = DocumentHelper.parseText(result);
            Element root = document.getRootElement();
            String retcode = root.element("retcode").getText();
            String err_msg = root.element("err_msg").getText();
            map.put("code", retcode);
            map.put("msg", err_msg);
            if("1".equals(retcode)){
                String orderid= root.element("orderid").getText();
                String cardids =root.element("cardid").getText();
                String cardnums =root.element("cardnum").getText();
                String ordercash =root.element("ordercash").getText();
                String cardname =root.element("cardname").getText();
                String sporder_ids =root.element("sporder_id").getText();
                String game_userids =root.element("game_userid").getText();
                String game_state =root.element("game_state").getText();
                
                System.out.println("--------------话费充值成功-----------");
                //输出返回的xml结果
                System.out.println(retcode);
                System.out.println(err_msg);
                System.out.println(orderid);
                System.out.println(cardids);
                System.out.println(cardnums);
                System.out.println(ordercash);
                System.out.println(cardname);
                System.out.println(sporder_ids);
                System.out.println(game_userids);
                System.out.println(game_state);
                System.out.println("--------------话费充值结束-----------");
            }else {
            	System.out.println("--------------话费充值失败-----------");
                System.out.println(retcode);
                System.out.println(err_msg);
                System.out.println("--------------话费充值结束-----------");
            }

        }catch (Exception e) {
        	e.printStackTrace();
        }
        return map;
	}
	/**
	 * Q币充值
	 * @param qqnum  QQ号码
	 * @param count  数量
	 * @return
	 */
	public static Map<String,Object> QQPay(String qqnum,String count){
		Map<String,Object> map=new HashMap<String,Object>();
		//传参
        String userid=SysGlobals.getInstance().getProperty("userid");
        String userpws= MD5Util.digest(SysGlobals.getInstance().getProperty("userpws"), "GBK").toLowerCase();

        //Q币商品码 任意充
        String cardid="220612";

        //要充值的数量
        String cardnum=count;
        Date dd=new Date();
        String dateStr=DateTimeUtil.dateFormat("yyyyMMddHHmmss", dd);
        //随机字符串
        String code=((int)((Math.random()*9+1)*100))+"";
        //外部订单号，唯一性
        String sporder_id=dateStr+code;
        
        //格式：年月日时分秒 如：20141119112450
        String sporder_time=dateStr;

        //要充值的qq账户
        String game_userid=qqnum;

        //该参数将异步返回充值结果，若不填写该地址，则不会回调
        String ret_url="";

        //版本号固定值
        String version="6.0";

        //若cardid=170101，需要加上下面的参数，不传该值默认为24
        String mctype="";
      //默认的秘钥是OFCARD，可联系商务修改，若已经修改过的，请使用修改过的。
        String keystr = SysGlobals.getInstance().getProperty("keystr");

        String md5_str_param = userid+userpws+cardid+cardnum+sporder_id+sporder_time+game_userid+keystr;
        String md5_str = MD5Util.digest(md5_str_param,"gbk").toUpperCase();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("userid="+userid+"&");
        stringBuffer.append("userpws="+userpws+"&");
        stringBuffer.append("cardid="+cardid+"&");
        stringBuffer.append("cardnum="+cardnum+"&");
        stringBuffer.append("sporder_id="+sporder_id+"&");
        stringBuffer.append("sporder_time="+sporder_time+"&");
        stringBuffer.append("game_userid="+game_userid+"&");
        stringBuffer.append("md5_str="+md5_str+"&");
        stringBuffer.append("ret_url="+ret_url+"&");
        stringBuffer.append("version="+version);

        String param = stringBuffer.toString();
        String url="http://"+userid+".api2.ofpay.com/onlineorder.do";
        int readTimeout=10000;
        int connectTimeout=10000;

        try{
            String result = HttpClientUtil.sendGetRequest(url,param,readTimeout,connectTimeout);

            //解析欧飞返回的xml文件
            Document document = DocumentHelper.parseText(result);
            Element root = document.getRootElement();
            String retcode = root.element("retcode").getText();
            String err_msg = root.element("err_msg").getText();
            map.put("code", retcode);
            map.put("msg", err_msg);
            if("1".equals(retcode)){
                String orderid= root.element("orderid").getText();
                String cardids =root.element("cardid").getText();
                String cardnums =root.element("cardnum").getText();
                String ordercash =root.element("ordercash").getText();
                String cardname =root.element("cardname").getText();
                String sporder_ids =root.element("sporder_id").getText();
                String game_userids =root.element("game_userid").getText();
                
                System.out.println("--------------Q币充值成功-----------");
                //输出返回的xml结果
                System.out.println(retcode);
                System.out.println(err_msg);
                System.out.println(orderid);
                System.out.println(cardids);
                System.out.println(cardnums);
                System.out.println(ordercash);
                System.out.println(cardname);
                System.out.println(sporder_ids);
                System.out.println(game_userids);
                System.out.println("--------------Q币充值结束-----------");
            }else {
            	System.out.println("--------------Q币充值失败-----------");
                System.out.println(retcode);
                System.out.println(err_msg);
                System.out.println("--------------Q币充值结束-----------");
            }

        }catch (Exception e) {
        	e.printStackTrace();
        }
        return map;
	}
	/**
	 * 支付宝充值
	 * @param alinum 接收支付码的手机号
	 * @param money  金额
	 * @return
	 */
	public static Map<String,Object> aliPay(String alinum,String money){
		Map<String,Object> map=new HashMap<String,Object>();
		//传参
        String userid=SysGlobals.getInstance().getProperty("userid");
        String userpws= MD5Util.digest(SysGlobals.getInstance().getProperty("userpws"), "GBK").toLowerCase();

        // 6102800(充值码)这个是短信收充值码，这个充值码到官网，自己充到支付宝账户，这种可体现
        // 6102100(支付宝卡直充) 这种类似礼品卡，不可体现只可购物。这个是充到支付宝卡里面，账号就是你支付宝账号
        String cardid="6102800";

        //固定值
        String cardnum="1";
        Date dd=new Date();
        String dateStr=DateTimeUtil.dateFormat("yyyyMMddHHmmss", dd);
        //随机字符串
        String code=((int)((Math.random()*9+1)*100))+"";
        //外部订单号，唯一性
        String sporder_id=dateStr+code;
        
        //格式：年月日时分秒 如：20141119112450
        String sporder_time=dateStr;

        //接收充值码的手机号码
        String game_userid=alinum;
        
        //充值金额保留一位小数
        String actprice=money;

        //该参数将异步返回充值结果，若不填写该地址，则不会回调
        String ret_url="";

        //版本号固定值
        String version="6.0";
      //默认的秘钥是OFCARD，可联系商务修改，若已经修改过的，请使用修改过的。
        String keystr = SysGlobals.getInstance().getProperty("keystr");

        String md5_str_param = userid+userpws+cardid+cardnum+sporder_id+sporder_time+game_userid+keystr;
        String md5_str = MD5Util.digest(md5_str_param,"gbk").toUpperCase();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("userid="+userid+"&");
        stringBuffer.append("userpws="+userpws+"&");
        stringBuffer.append("cardid="+cardid+"&");
        stringBuffer.append("cardnum="+cardnum+"&");
        stringBuffer.append("sporder_id="+sporder_id+"&");
        stringBuffer.append("sporder_time="+sporder_time+"&");
        stringBuffer.append("game_userid="+game_userid+"&");
        stringBuffer.append("actprice="+actprice+"&");
        stringBuffer.append("md5_str="+md5_str+"&");
        stringBuffer.append("ret_url="+ret_url+"&");
        stringBuffer.append("version="+version);

        String param = stringBuffer.toString();
        String url="http://"+userid+".api2.ofpay.com/onlineorder.do";
        int readTimeout=10000;
        int connectTimeout=10000;

        try{
            String result = HttpClientUtil.sendGetRequest(url,param,readTimeout,connectTimeout);

            //解析欧飞返回的xml文件
            Document document = DocumentHelper.parseText(result);
            Element root = document.getRootElement();
            String retcode = root.element("retcode").getText();
            String err_msg = root.element("err_msg").getText();
            map.put("code", retcode);
            map.put("msg", err_msg);
            if("1".equals(retcode)){
                String orderid= root.element("orderid").getText();
                String cardids =root.element("cardid").getText();
                String cardnums =root.element("cardnum").getText();
                String ordercash =root.element("ordercash").getText();
                String cardname =root.element("cardname").getText();
                String sporder_ids =root.element("sporder_id").getText();
                String game_userids =root.element("game_userid").getText();
                
                System.out.println("--------------支付宝充值成功-----------");
                //输出返回的xml结果
                System.out.println(retcode);
                System.out.println(err_msg);
                System.out.println(orderid);
                System.out.println(cardids);
                System.out.println(cardnums);
                System.out.println(ordercash);
                System.out.println(cardname);
                System.out.println(sporder_ids);
                System.out.println(game_userids);
                System.out.println("--------------支付宝充值结束-----------");
            }else {
            	System.out.println("--------------支付宝充值失败-----------");
                System.out.println(retcode);
                System.out.println(err_msg);
                System.out.println("--------------支付宝充值结束-----------");
            }

        }catch (Exception e) {
        	e.printStackTrace();
        }
        return map;
	}
}
