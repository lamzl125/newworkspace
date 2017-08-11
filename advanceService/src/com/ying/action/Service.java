package com.ying.action;
	
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.springside.modules.utils.web.struts2.Struts2Utils;
import org.utils.Base64ToImageUtil;
import org.utils.DateTimeUtil;
import org.utils.Logs;
import org.utils.SmsAndEmailTools;
import org.utils.StringUtil;
import org.utils.StringUtils;
import org.utils.SysGlobals;
import org.utils.Tool;
import org.utils.OFCARD.OfCardPay;
import org.utils.SMS.HttpSender;
import sun.swing.StringUIClientPropertyKey;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
	
import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import com.taobao.api.domain.Userinfos;
import com.ying.service.IMemberService;
import com.ying.service.IUserService;
import com.ying.service.IadvanceService;
import com.ying.wx.tenpay.RequestHandler;
import com.ying.wx.tenpay.ResponseHandler;
import com.ying.wx.tenpay.client.ClientResponseHandler;
import com.ying.wx.tenpay.client.TenpayHttpClient;
import com.ying.wx.util.CommonUtil;
import com.ying.wx.util.IPUtil;
import com.ying.wx.util.XMLUtil;
import com.ying.app.bean.AddressListBean;
import com.ying.app.bean.ApplyInfoBean;
import com.ying.app.bean.ApplyMoneyInfo;
import com.ying.app.bean.ApplyYearBean;
import com.ying.app.bean.CompanyBean;
import com.ying.app.bean.CustomerListBean;
import com.ying.app.bean.CycleBean;
import com.ying.app.bean.HangyeBean;
import com.ying.app.bean.OrderDealInfo;
import com.ying.app.bean.PSOrder;
import com.ying.app.bean.PSOrderBean;
import com.ying.app.bean.PSOrderList;
import com.ying.app.bean.PSOrderListBean;

import com.ying.app.bean.User;

import com.ying.app.bean.ImageListBean;
import com.ying.app.bean.MessageBean;
import com.ying.app.bean.MoneyListBean;
import com.ying.app.bean.OrderListBean;
import com.ying.app.bean.UserInfo;
import com.ying.app.res.AboutUsRes;
import com.ying.app.res.AddressListRes;
import com.ying.app.res.ConfirmTheDeliveryInfoRes;
import com.ying.app.res.DeliverInfoRes;
import com.ying.app.res.DeliveryDetailRes;
import com.ying.app.res.GetBoundageRes;
import com.ying.app.res.GetChargeRes;
import com.ying.app.res.GetHangyeTypeRes;
import com.ying.app.res.GetLogisticsCompanyRes;
import com.ying.app.res.GetMessageListRes;
import com.ying.app.res.GetPoundageMoneyRes;
import com.ying.app.res.GetQuotaTypeRes;
import com.ying.app.res.GetWalletInfoRes;
import com.ying.app.res.GetWalletMoneyRes;
import com.ying.app.res.GetapplyMoneyRes;
import com.ying.app.res.LoginRes;
import com.ying.app.res.MerchantServiceRes;
import com.ying.app.res.MerchantWithDrawRes;
import com.ying.app.res.OrderDetailInfoRes;
import com.ying.app.res.OrderListRes;
import com.ying.app.res.PscustomerListRes;
import com.ying.app.res.PsorderListRes;
import com.ying.app.res.PsrecordListRes;
import com.ying.app.res.PsuserRecordRes;
import com.ying.app.res.SaveUserPhotoRes;

import com.ying.app.res.PsforgetPasswordRes;

import com.ying.app.res.MyApplyDataRes;
import com.ying.app.res.MyApplyOrderRes;
import com.ying.app.res.MyApplyTotalRes;

import com.ying.app.res.ReCycleListRes;
import com.ying.app.res.RegisterRes;
import com.ying.entity.Member;
import com.ying.app.req.*;
import com.ying.app.res.Res;
	
	@SuppressWarnings("serial")
	public class Service extends MiniActionSupport{
	@Autowired
	@Qualifier("memberService")
	private IMemberService memberService;	
	@Autowired
	private IadvanceService advanceService;
	@Autowired
	private IUserService userService;
	
	private File file; 						// 上传的文件
	private String fileFileName; 			// 文件名称
	
	private ApplyMoneyReq certificate = new ApplyMoneyReq();   //4.0申请额度
	
	@Override
	public String list() throws Exception {
		String reqJson = Struts2Utils.getParameter("json");
		String resJson = "";
		try {
			// 识别消息
			Logs.info("收:" + reqJson);
			
			Res res = new Res();
			String cmd = Struts2Utils.getParameter("cmd");
			
			if(cmd != null && cmd.equals("applyMoney")){                      //4.0申请额度
				res.setResultNote("申请提交失败");
				String rootPath = getGlobals().get("userImgPath");
				List<ImageListBean> images = new ArrayList<ImageListBean>();
				if (certificate.getCertificateImages() != null) {
					for(int i = 0; i < certificate.getCertificateImages().length; i++){		
						ImageListBean tk=new ImageListBean();
						fileFileName=StringUtils.randomString(12)+".png";
						File savefile = new File(new File(rootPath),fileFileName);
						if (!savefile.getParentFile().exists())
							savefile.getParentFile().mkdirs();
						FileUtils.copyFile(certificate.getCertificateImages()[i], savefile);
						tk.setImageStr(fileFileName);
						images.add(tk);
					}
					certificate.setImages(images);
				}
				if (!StringUtils.isEmpty(certificate.getIdCardUp())) {
					String url = Base64ToImageUtil.GenerateImage(certificate.getIdCardUp(),SysGlobals.getInstance().getProperty("userImgPath"));
					if (!StringUtils.isEmpty(url)) {
						certificate.setIdCardUp(url);
					}
				}	
				if (!StringUtils.isEmpty(certificate.getIdCardDown())) {
					String urlDown = Base64ToImageUtil.GenerateImage(certificate.getIdCardDown(),SysGlobals.getInstance().getProperty("userImgPath"));
					if (!StringUtils.isEmpty(urlDown)) {
						certificate.setIdCardDown(urlDown);
					}
				}	
				if (!StringUtils.isEmpty(certificate.getIdCardHand())) {
					String urlHand = Base64ToImageUtil.GenerateImage(certificate.getIdCardHand(),SysGlobals.getInstance().getProperty("userImgPath"));
					if (!StringUtils.isEmpty(urlHand)) {
						certificate.setIdCardHand(urlHand);
					}
				}	
				try {
					Member m = new Member();
					m = memberService.queryByUid(certificate.getUid());
					if (m.getId() == null) {
						res.setResultNote("用户未登录");
					}else if ("0".equals(m.getStatue())) {
						res.setResultNote("用户已被禁用");
					}else if(advanceService.applyMoney(certificate)){
						res.setResultNote("申请提交成功");
						res.setResult("0");						
					}
				} catch (Exception e) {
					Logs.error(e);
				}
			}else{
				JSONObject obj = JSONObject.parseObject(reqJson);
				String parms = "";
				if (obj.getJSONObject("param") != null) {
					parms = obj.getJSONObject("param").toString();
				}
				//-----------------------------------用户的端接口开始-----------------------------------
				if (obj.getString("cmd").equals("userRegister")) {                 //1.0用户注册
					parms=obj.toString();
					RegisterReq req = JSONObject.parseObject(parms, RegisterReq.class);
					res=codec(req);
				} else if (obj.getString("cmd").equals("userLogin")) {                 //1.1 用户登录
					parms = obj.toString();
					LoginReq req = JSONObject.parseObject(parms, LoginReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("thirdLogin")) {             //1.2 第三方登陆（QQ，微信）
					parms = obj.toString();
					AuthloginReq req = JSONObject.parseObject(parms, AuthloginReq.class);   
					res = codec(req);
				} else if (obj.getString("cmd").equals("forgetPassword")) {          //1.3 找回密码
					parms = obj.toString();
					GetPasswordReq req = JSONObject.parseObject(parms, GetPasswordReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("reCycleList")) {          //2.0 轮播图
					parms = obj.toString();
					GetPasswordReq req = JSONObject.parseObject(parms, GetPasswordReq.class);
					res = codec1(req);
				} else if (obj.getString("cmd").equals("confirmTheDeliveryInfo")) {                //2.1 确认发货
					parms=obj.toString();          
					GetOrderDetailReq req = JSONObject.parseObject(parms,GetOrderDetailReq.class);
					res=codec(req);
				} else if (obj.getString("cmd").equals("confirmTheDeliveryDetail")) {                //2.2 确认发货订单的详情页
					parms=obj.toString();          
					DeliveryDetailReq req = JSONObject.parseObject(parms,DeliveryDetailReq.class);
					res=codec(req);
				} else if (obj.getString("cmd").equals("addAddress")) {          //2.3 添加/编辑发货/收货地址
					parms = obj.toString();
					AddAddressReq req = JSONObject.parseObject(parms, AddAddressReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("handleAdress")) {          //2.5 删除地址
					parms = obj.toString();
					HandleAdressReq req = JSONObject.parseObject(parms, HandleAdressReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("getWalletMoney")) {          //4.2我的账户金额
					parms = obj.toString();
					GetPasswordReq req = JSONObject.parseObject(parms, GetPasswordReq.class);
					res = codec2(req);
				} else if (obj.getString("cmd").equals("servicecode")) {          //1.6 绑定服务码
					parms = obj.toString();
					ServiceCodeReq req = JSONObject.parseObject(parms, ServiceCodeReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("getWalletInfo")) {          //4.3收支明细
					parms = obj.toString();
					GetMessageListReq req = JSONObject.parseObject(parms, GetMessageListReq.class);
					res = codec1(req);
				} else if (obj.getString("cmd").equals("merchantWithDraw")) {          //4.4 提现
					parms = obj.toString();
					MerchantWithDrawReq req = JSONObject.parseObject(parms, MerchantWithDrawReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("getMessageList")) {          //4.5 消息列表
					parms = obj.toString();
					GetMessageListReq req = JSONObject.parseObject(parms, GetMessageListReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("getUserDeatilInfo")) {          //4.7获取个人信息
					parms = obj.toString();
					ServiceCodeReq req = JSONObject.parseObject(parms, ServiceCodeReq.class);
					res = codec1(req);
				} else if (obj.getString("cmd").equals("commitUserInfoDeatil")) {          //4.8保存个人信息
					parms = obj.toString();
					UserInfoDeatilReq req = JSONObject.parseObject(parms, UserInfoDeatilReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("saveUserPhoto")) {              //补：保存用户头像
					parms = obj.toString();
					SaveUserPhotoReq req = JSONObject.parseObject(parms, SaveUserPhotoReq.class);   
					res = codec(req);
				} else if (obj.getString("cmd").equals("getSendAdressListInfo")) {              //1.9 我的发货地址列表
					parms = obj.toString();
					SaveUserPhotoReq req = JSONObject.parseObject(parms, SaveUserPhotoReq.class);   
					res = codec1(req);
				} else if (obj.getString("cmd").equals("aboutUs")) {                //4.0 关于我们
					parms=obj.toString();          
					FeedbackOptionReq req = JSONObject.parseObject(parms,FeedbackOptionReq.class);
					res=codec1(req);
				} else if (obj.getString("cmd").equals("feedbackOption")) {              //4.1 意见反馈
					parms = obj.toString();
					FeedbackOptionReq req = JSONObject.parseObject(parms, FeedbackOptionReq.class);   
					res = codec(req);
				} else if (obj.getString("cmd").equals("merchantService")) {                //4.2 客服电话
					parms=obj.toString();          
					FeedbackOptionReq req = JSONObject.parseObject(parms,FeedbackOptionReq.class);
					res=codec2(req);
				} else if (obj.getString("cmd").equals("getPoundageMoney")) {                //1.获取根据送货地址获取手续费
					parms=obj.toString();          
					GetPoundageMoneyReq req = JSONObject.parseObject(parms,GetPoundageMoneyReq.class);
					res=codec(req);
				} else if (obj.getString("cmd").equals("getLogisticsCompany")) {                //2.获取物流公司
					parms=obj.toString();          
					GetPoundageMoneyReq req = JSONObject.parseObject(parms,GetPoundageMoneyReq.class);
					res=codec1(req);
				} else if (obj.getString("cmd").equals("getProvincePoundageMoney")) {                //4.获取省内外手续费
					parms=obj.toString();          
					GetPoundageMoneyReq req = JSONObject.parseObject(parms,GetPoundageMoneyReq.class);
					res=codec2(req);
				} else if (obj.getString("cmd").equals("getapplyMoney")) {                //4.1.0 获取用户申请资料
					parms=obj.toString();          
					GetapplyMoneyReq req = JSONObject.parseObject(parms,GetapplyMoneyReq.class);
					res=codec(req);
				} else if (obj.getString("cmd").equals("myApplyTotal")) {                //4.1.1 获取信用，垫付，剩余额度
					parms=obj.toString();          
					GetapplyMoneyReq req = JSONObject.parseObject(parms,GetapplyMoneyReq.class);
					res=codec1(req);
				} else if (obj.getString("cmd").equals("myApplyData")) {                //4.1.2 获取日期
					parms=obj.toString();          
					GetapplyMoneyReq req = JSONObject.parseObject(parms,GetapplyMoneyReq.class);
					res=codec2(req);
				} else if (obj.getString("cmd").equals("myApplyOrder")) {                //4.1.3 根据年份查询查询订单列表
					parms=obj.toString();          
					GetapplyMoneyReq req = JSONObject.parseObject(parms,GetapplyMoneyReq.class);
					res=codec3(req);
				} else if (obj.getString("cmd").equals("orderList")) {                //3.0订单列表界面
					parms=obj.toString();          
					OrderListReq req = JSONObject.parseObject(parms,OrderListReq.class);
					res=codec(req);
				} else if (obj.getString("cmd").equals("searchOrderInfo")) {                //3.3订单查询
					parms=obj.toString();          
					SearchOrderInfoReq req = JSONObject.parseObject(parms,SearchOrderInfoReq.class);
					res=codec(req);
				} else if (obj.getString("cmd").equals("orderDetailInfo")) {                //3.1详细的订单详情
					parms=obj.toString();          
					SearchOrderInfoReq req = JSONObject.parseObject(parms,SearchOrderInfoReq.class);
					res=codec1(req);
				} else if (obj.getString("cmd").equals("deliverInfo")) {                //3.2配送信息
					parms=obj.toString();          
					SearchOrderInfoReq req = JSONObject.parseObject(parms,SearchOrderInfoReq.class);
					res=codec2(req);
				} else if (obj.getString("cmd").equals("getHangyeType")) {                //5.获取用户行业类别
					parms=obj.toString();          
					SearchOrderInfoReq req = JSONObject.parseObject(parms,SearchOrderInfoReq.class);
					res=codec3(req);
				} else if (obj.getString("cmd").equals("getQuotaType")) {                //6.获取用户的申请额度的状态
					parms=obj.toString();          
					SearchOrderInfoReq req = JSONObject.parseObject(parms,SearchOrderInfoReq.class);
					res=codec4(req);
				} else if (obj.getString("cmd").equals("getTanType")) {                //7.将用户的弹窗状态改为1不弹窗
					parms=obj.toString();          
					SearchOrderInfoReq req = JSONObject.parseObject(parms,SearchOrderInfoReq.class);
					res=codec5(req);
				} 
				
				//-----------------------------------用户的端接口结束-----------------------------------
				
				
				
				
				//--------------------------------物流垫付配送端接口------------------------------------------
				else if (obj.getString("cmd").equals("psuserLogin")) { 			//1.1 用户登录
					parms = obj.toString();
					PsuerLoginReq req = JSONObject.parseObject(parms,PsuerLoginReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("psuserRecord")) { 			//1.1.0 获取个人记录
					parms = obj.toString();
					PsuerRecordReq req = JSONObject.parseObject(parms,PsuerRecordReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("psforgetPassword")) { 			//1.1找回密码
					parms = obj.toString();
					PsforgetPasswordReq req = JSONObject.parseObject(parms,PsforgetPasswordReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("psgetUserInfoDeatil")) { 			//3.2 获取个人信息
					parms = obj.toString();
					PsgetUserInfoDeatilReq req = JSONObject.parseObject(parms,PsgetUserInfoDeatilReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("pseditUserInfoDeatil")) { 			//3.3修改个人用户信息
					parms = obj.toString();
					PseditUserInfoDeatilReq req = JSONObject.parseObject(parms,PseditUserInfoDeatilReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("pssaveUserIcon")) { 			//3.4修改头像
					parms = obj.toString();
					SaveUserIconReq req = JSONObject.parseObject(parms,SaveUserIconReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("pspaiOrder")) { 			//3.5派件
					parms = obj.toString();
					SaveUserIconReq req = JSONObject.parseObject(parms,SaveUserIconReq.class);
					res = codec1(req);
				} else if (obj.getString("cmd").equals("psorderList")) { 			//2.0订单列表（首页）
					parms = obj.toString();
					PsorderListReq req = JSONObject.parseObject(parms,PsorderListReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("psrecordList")) { 			//2.0订单列表（我的）
					parms = obj.toString();
					PsrecordListReq req = JSONObject.parseObject(parms,PsrecordListReq.class);
					res = codec(req);
				} else if (obj.getString("cmd").equals("psdeleteOrderId")) { 			//2.0删除订单
					parms = obj.toString();
					SaveUserIconReq req = JSONObject.parseObject(parms,SaveUserIconReq.class);
					res = codec2(req);
				} else if (obj.getString("cmd").equals("pscustomerList")) { 			//3.1我的客户
					parms = obj.toString();
					SaveUserIconReq req = JSONObject.parseObject(parms,SaveUserIconReq.class);
					res = codec3(req);
				} else if (obj.getString("cmd").equals("psorderDetailInfoRevive")) {                //2.1订单详情-揽件
					parms=obj.toString();          
					PsorderDetailReq req = JSONObject.parseObject(parms,PsorderDetailReq.class);
					res=codec(req);
				} else if (obj.getString("cmd").equals("psorderDetailInfoConfiFinish")) {                //2.2订单详情-确认完成和退款
					parms=obj.toString();          
					ConfiFinishReq req = JSONObject.parseObject(parms,ConfiFinishReq.class);
					res=codec(req);
				} 
			}
			
			resJson = JSONObject.toJSONStringWithDateFormat(res, "yyyy-MM-dd",SerializerFeature.WriteDateUseDateFormat);
			resJson = resJson.replace("null", "");
			Logs.info("发:" + resJson);
		} catch (Exception e) {
			resJson = JSONObject.toJSONString(new Res());
			Logs.error("请求处理异常：reqJson=" + reqJson + "\n" + e);
			}
			Struts2Utils.renderText(resJson);
			return null;
		}
	
	//1.0用户注册
	private Res codec(RegisterReq req) {
		Res res = new Res();
		res.setResultNote("注册失败");
		try {
			if (StringUtils.isEmpty(req.getPhoneNum())) {
				res.setResultNote("手机号码不能为空");
				return res;
			}
			Long id=getMemberId(req.getPhoneNum());
			if(id!=null && id>0L){
				res.setResultNote("该手机号码已存在");
				return res;
			}
			Member m = new Member();
			if (Tool.isMobile(req.getPhoneNum())) {
				m.setPhoneNum(req.getPhoneNum());
			}
			m.setRecommendedCode(req.getRecommendedCode());
			m.setServiceCode(req.getServiceCode());
			m.setPassword(req.getPassword());
			m = memberService.saveMem(m);
			if (m != null) {
				res.setResult("0");
				res.setResultNote("注册成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	
	
	//1.1用户登录
	private Res codec(LoginReq req) {
		LoginRes res = new LoginRes();
		res.setResultNote("登录失败");
		try {
			if (StringUtils.isEmpty(req.getPhoneNum())) {
				res.setResultNote("用户名不能为空");
				return res;
			}
			Member m = memberService.queryByMobielOrEmail(req.getPhoneNum());
			if (m.getId() == null) {
				res.setResultNote("用户名不存在");
				return res;
			}
			if (!req.getPassword().equals(m.getPassword())){
				res.setResultNote("密码不正确");
				return res;
			}	
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			m.setToken(req.getToken());
			Member mm = memberService.saveMem(m);
			if (req.getPassword().equals(m.getPassword())) {
				res.setResultNote("登录成功");
				res.setResult("0");
				UserInfo u = new UserInfo();
				u.setUid(m.getId());
				u.setUserName(m.getUserName()+"");
				u.setPhoneNum(m.getPhoneNum()+"");
				u.setUserIcon(m.getUserIcon()+"");
				res.setUserInfo(u);
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	

	//1.2 第三方登陆（微信）
	private Res codec(AuthloginReq req) {
		LoginRes res = new LoginRes();
		res.setResultNote("登录失败");
		try {
			if (StringUtils.isEmpty(req.getThirdUid())) {
				res.setResultNote("用户名不能为空");
				return res;
			}
			Member m = getMember(req.getThirdUid());
			if(m.getId() == null){
				m=new Member();
				m.setThirdUid(req.getThirdUid());
				m.setUserName(req.getNickName());
				m.setPassword("");
				m.setPhoneNum("");
				m.setToken(req.getToken());
				m.setUserIcon(req.getUsericon());
				m = memberService.saveMem(m);
				if(m.getId() > 0){
					Member mb = memberService.saveMem(m);
					if (mb != null) {
						res.setResult("0");
						res.setResultNote("登录成功");
						UserInfo u = new UserInfo();
						u.setUid(m.getId());
						u.setUserName(m.getUserName()+"");
						u.setPhoneNum(m.getPhoneNum()+"");
						u.setUserIcon(m.getUserIcon()+"");
						res.setUserInfo(u);
					}
					return res;
				}
			}else{
				m.setUserName(req.getNickName());
				m.setUserIcon(req.getUsericon());
				m.setToken(req.getToken());
				m = memberService.saveMem(m);
				if (m.getStatue()==0) {
					res.setResultNote("用户已被禁用");
					return res;
				}
				if(m.getId() > 0){
					Member mb = memberService.saveMem(m);
					if (mb != null) {
						res.setResult("0");
						res.setResultNote("登录成功");
						UserInfo u = new UserInfo();
						u.setUid(m.getId());
						u.setUserName(m.getUserName()+"");
						u.setPhoneNum(m.getPhoneNum()+"");
						u.setUserIcon(m.getUserIcon()+"");
						res.setUserInfo(u);
					}
					return res;
				}
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}	
	

	//1.3 找回密码
	private Res codec(GetPasswordReq req) {
		Res res = new Res();
		try {
			if (StringUtils.isEmpty(req.getPhoneNum())) {
				res.setResultNote("用户名不能为空");
				return res;
			}
			if (StringUtils.isEmpty(req.getPassword())) {
				res.setResultNote("新密码不能为空");
				return res;
			}
			Member m = memberService.queryByMobielOrEmail(req.getPhoneNum());
			if (m.getId() == null) {
				res.setResultNote("用户名不存在");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if (memberService.upPwd(m, req.getPassword())) {
				res.setResult("0");
				res.setResultNote("重置密码成功");
			} else {
				res.setResult("1");
				res.setResultNote("重置密码失败");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}	
	
	
	//1.0 轮播图
	private Res codec1(GetPasswordReq req) {
		ReCycleListRes res = new ReCycleListRes();
		try {
			List<CycleBean> cycleList=advanceService.reCycleList();
			if (cycleList!=null) {
				res.setCycleList(cycleList);
				res.setResult("0");
				res.setResultNote("获取轮播图成功");
			} else {
				res.setResult("1");
				res.setResultNote("获取轮播图失败");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}	
	
	
	//1.2我的账户金额
	private Res codec2(GetPasswordReq req) {
		GetWalletMoneyRes res = new GetWalletMoneyRes();
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			String balance=advanceService.getWalletMoney(req.getUid());
			String text = advanceService.getText(req.getUid());
			if (balance!=null) {
				res.setBalance(balance);
				res.setText(text);
				res.setResult("0");
				res.setResultNote("获我的账户金额成功");
			} else {
				res.setResult("1");
				res.setResultNote("获我的账户金额失败");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}	
	
	
	//1.3 添加/编辑发货/收货地址
	private Res codec(AddAddressReq req) {
		Res res = new Res();
		res.setResultNote("失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if(advanceService.addAddress(req)){
				res.setResult("0");
				res.setResultNote("成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//1.5 删除地址
	private Res codec(HandleAdressReq req) {
		Res res = new Res();
		res.setResultNote("删除地址失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if(advanceService.handleAdress(req.getReceiverid())){
				res.setResult("0");
				res.setResultNote("删除地址成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//1.6 绑定服务码
	private Res codec(ServiceCodeReq req) {
		Res res = new Res();
		res.setResultNote("失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if (m.getServictime()!=null && !"".equals(m.getServiceCode())) {
				if(new Date().getTime()>m.getServictime().getTime()){
					if(advanceService.servicecode(req.getServiceCode(),req.getUid())){
						res.setResult("0");
						res.setResultNote("绑定服务码成功");
					}
				}else {
					res.setResultNote("需要三个月之后才可以修改服务码！");
				}
			}else {
				if(advanceService.servicecode(req.getServiceCode(),req.getUid())){
					res.setResult("0");
					res.setResultNote("绑定服务码成功");
				}
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//4.3收支明细
	private Res codec1(GetMessageListReq req) {
		GetWalletInfoRes res = new GetWalletInfoRes();
		res.setResult("1");
		res.setResultNote("获取收入明细列表失败");
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		Page<MoneyListBean> page = new Page<MoneyListBean>(10);                             
		page.setPageNo(Integer.parseInt(req.getNowPage()));
		page.setOrder(Page.DESC);
		try {
			List<MoneyListBean> moneyList = new ArrayList<MoneyListBean>();
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			page=advanceService.getWalletInfo(page, filters,req.getUid());
			if(page != null && page.getResult().size() > 0){
				for(int i=0;i<page.getResult().size();i++){
					MoneyListBean pb = new MoneyListBean();
					pb.setMoneySoure(page.getResult().get(i).getMoneySoure()+"");
					pb.setMoneyNum(page.getResult().get(i).getMoneyNum()+"");
					pb.setMoneyTime(DateTimeUtil.dateConvtoFmt(page.getResult().get(i).getAdtime(),"yyyy-MM-dd HH:mm:ss"));
					page.getResult().get(i).setAdtime(null);
					moneyList.add(pb);
				}
				res.setMoneyList(moneyList);
			}else {
				res.setTotalPage(Long.valueOf(1));
				res.setResultNote("内容为空");
				res.setResult("0");		
			}
			if(page.getTotalPages()>0){
				res.setTotalPage(page.getTotalPages());	
			}
			res.setResultNote("获取收入明细列表成功");
			res.setResult("0");		
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//4.5 消息列表
	private Res codec(GetMessageListReq req) {
		GetMessageListRes res = new GetMessageListRes();
		res.setResult("1");
		res.setResultNote("获取消息列表失败");
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		Page<MessageBean> page = new Page<MessageBean>(10);                             
		page.setPageNo(Integer.parseInt(req.getNowPage()));
		page.setOrder(Page.DESC);
		try {
			List<MessageBean> messageList = new ArrayList<MessageBean>();
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			page=advanceService.getMessageList(page, filters,req.getUid());
			if(page != null && page.getResult().size() > 0){
				for(int i=0;i<page.getResult().size();i++){
					MessageBean pb = new MessageBean();
					pb.setMessageId(page.getResult().get(i).getMessageId()+"");
					pb.setMessageTitle(page.getResult().get(i).getMessageTitle()+"");
					pb.setMessageTime(DateTimeUtil.dateConvtoFmt(page.getResult().get(i).getAdtime(),"yyyy-MM-dd HH:mm:ss"));
					page.getResult().get(i).setAdtime(null);
					pb.setMessageContent(page.getResult().get(i).getMessageContent()+"");
					messageList.add(pb);
				}
				res.setMessageList(messageList);
			}else {
				res.setTotalPage(Long.valueOf(1));
				res.setResultNote("内容为空");
				res.setResult("0");		
			}
			if(page.getTotalPages()>0){
				res.setTotalPage(page.getTotalPages());	
			}
			res.setResultNote("获取消息列表成功");
			res.setResult("0");		
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//1.7获取个人信息
	private Res codec1(ServiceCodeReq req) {
		LoginRes res = new LoginRes();
		res.setResultNote("获取个人信息失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if (m!=null) {
				UserInfo u = new UserInfo();
				u.setUserIcon(m.getUserIcon()+"");
				u.setUserName(m.getUserName()+"");
				u.setUserAddress(m.getUserAddress()+"");
				res.setUserInfo(u);
				res.setResult("0");
				res.setResultNote("获取个人信息成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//1.8保存个人信息
	private Res codec(UserInfoDeatilReq req) {
		LoginRes res = new LoginRes();
		res.setResultNote("保存个人信息失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if(advanceService.commitUserInfoDeatil(req)){
				res.setResult("0");
				res.setResultNote("保存个人信息成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//补：保存用户头像
	private Res codec(SaveUserPhotoReq req) {
		SaveUserPhotoRes res = new SaveUserPhotoRes();
		res.setResultNote("修改头像失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if (!StringUtils.isEmpty(req.getImgUrl())) {
				String url = Base64ToImageUtil.GenerateImage(req.getImgUrl(),
						SysGlobals.getInstance().getProperty("userImgPath"));
				if (!StringUtils.isEmpty(url)) {
					m.setUserIcon(url);
				}
				if (advanceService.saveUserPhoto(req.getUid(),m.getUserIcon())) {
					res.setUserIcon(m.getUserIcon()+"");
					res.setResult("0");
					res.setResultNote("修改头像成功");
				} else {
					res.setResultNote("修改头像失败");
				}
			}else {
				res.setResult("1");
				res.setResultNote("头像不能为空");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	
	
	//1.9 我的发货地址列表
	private Res codec1(SaveUserPhotoReq req) {
		AddressListRes res = new AddressListRes();
		try {
			List<AddressListBean> addressList = advanceService.getSendAdressListInfo(req.getUid());
			if (addressList!=null) {
				res.setAddressList(addressList);
				res.setResult("0");
				res.setResultNote("我的发货地址列表成功");
			} else {
				res.setResult("1");
				res.setResultNote("我的发货地址列表失败");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}	
	
	
	//2.1 意见反馈
	private Res codec(FeedbackOptionReq req) {
		LoginRes res = new LoginRes();
		res.setResultNote("意见反馈失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if(advanceService.feedbackOption(req)){
				res.setResult("0");
				res.setResultNote("意见反馈成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//2.0 关于我们
	private Res codec1(FeedbackOptionReq req) {
		AboutUsRes res = new AboutUsRes();
		res.setResultNote("获取失败！");
		try {
			String aboutUrl=advanceService.aboutUs(req.getType());
			if(aboutUrl!=null){
				aboutUrl=SysGlobals.getInstance().getProperty("userIconBaseUrl")+"/"+aboutUrl;
				res.setAboutUrl(aboutUrl);
				res.setResult("0");
				res.setResultNote("获取成功！");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}	
	
	
	//2.2 客服电话
	private Res codec2(FeedbackOptionReq req) {
		MerchantServiceRes res = new MerchantServiceRes();
		res.setResultNote("获取客服电话失败！");
		try {
			String nationalPhone=advanceService.merchantService();
			if(nationalPhone!=null){
				res.setNationalPhone(nationalPhone);
				res.setResult("0");
				res.setResultNote("获取客服电话成功！");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//1.获取手续费接口
	private Res codec(GetPoundageMoneyReq req) {
		GetPoundageMoneyRes res = new GetPoundageMoneyRes();
		res.setResultNote("获取手续费失败！");
		try {
			String poundage=advanceService.getPoundageMoney(req.getProviceCode(),req.getAdvances());
			if(poundage!=null){
				res.setPoundage(poundage);
				res.setResult("0");
				res.setResultNote("获取手续费成功！");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//2.获取物流公司
	private Res codec1(GetPoundageMoneyReq req) {
		GetLogisticsCompanyRes res = new GetLogisticsCompanyRes();
		res.setResultNote("获取物流公司失败！");
		try {
			List<CompanyBean> companyInfoList = advanceService.getLogisticsCompany(req.getAreaCode());
			if(companyInfoList!=null){
				res.setCompanyInfoList(companyInfoList);
				res.setResult("0");
				res.setResultNote("获取物流公司成功！");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//4.获取省内外手续费
	private Res codec2(GetPoundageMoneyReq req) {
		GetBoundageRes res = new GetBoundageRes();
		res.setResultNote("获取手续费失败！");
		try {
			res=advanceService.getBoundage();
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//1.1 确认发货
	private Res codec(GetOrderDetailReq req) {
		ConfirmTheDeliveryInfoRes res = new ConfirmTheDeliveryInfoRes();
		res.setResultNote("发货失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			String orderId = advanceService.confirmTheDeliveryInfo(req);
			if(orderId!=null){
				res.setOrderId(orderId);
				res.setResult("0");
				res.setResultNote("发货成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//2.2 确认发货订单的详情页
	private Res codec(DeliveryDetailReq req) {
		DeliveryDetailRes res = new DeliveryDetailRes();
		res.setResultNote("获取订单详情失败");
		try {
			res=advanceService.confirmTheDeliveryDetail(req.getOrderId());
			if(res!=null){
				res.setResult("0");
				res.setResultNote("获取订单详情成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	

	
	//4.1.0 获取用户申请资料
	private Res codec(GetapplyMoneyReq req) {
		GetapplyMoneyRes res = new GetapplyMoneyRes();
		ApplyInfoBean applyInfo = new ApplyInfoBean();
		res.setResultNote("获取用户申请资料失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			applyInfo=advanceService.getapplyMoney(req.getUid());
			if(applyInfo!=null){
				res.setStatus(applyInfo.getStatus());
				res.setApplyInfo(applyInfo);
				res.setResult("0");
				res.setResultNote("获取用户申请资料成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	
	//4.1.1 获取信用，垫付，剩余额度
	private Res codec1(GetapplyMoneyReq req) {
		MyApplyTotalRes res = new MyApplyTotalRes();
		res.setResultNote("获取信用额度失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if(m!=null){
				ApplyMoneyInfo applyMoneyInfo = new ApplyMoneyInfo();
				Double credit=Double.valueOf(m.getQuota());
				Double remaining=Double.valueOf(m.getQuotaRemaining());
				Double advances=credit-remaining;
				applyMoneyInfo.setCredit(credit+"");	//信用额度
				applyMoneyInfo.setAdvances(advances+"");	//垫付金额
				applyMoneyInfo.setRemaining(remaining+"");	//剩余额度
				res.setApplyMoneyInfo(applyMoneyInfo);
				res.setResult("0");
				res.setResultNote("获取信用额度成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//4.1.2 获取日期
	private Res codec2(GetapplyMoneyReq req) {
		MyApplyDataRes res = new MyApplyDataRes();
		res.setResultNote("获取日期失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			List<ApplyYearBean> applyYear=advanceService.myApplyData(req.getUid());
			if(applyYear!=null && applyYear.size()>0){
				res.setApplyYear(applyYear);
				res.setResult("0");
				res.setResultNote("获取日期成功");
			}else {
				res.setResult("0");
				res.setResultNote("内容为成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//4.4 提现
	private Res codec(MerchantWithDrawReq req) {
		MerchantWithDrawRes res = new MerchantWithDrawRes();
		res.setResultNote("提现申请提交失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if(Double.valueOf(m.getBalance())<Double.valueOf(req.getMoney())){
				res.setResultNote("余额不足");
				return res;
			}
			String dmoney = advanceService.merchantWithDraw(req);
			if(dmoney!=null){
				m = memberService.queryByUid(req.getUid());
				res.setBalance(dmoney+"");
				res.setMoney(req.getMoney()+"");
			    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        Calendar c = Calendar.getInstance();
		        c.add(Calendar.DAY_OF_MONTH, 1);
		        res.setMerChatExpectDate(sf.format(c.getTime()));
				res.setResult("0");
				res.setResultNote("提现申请提交成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//4.1.3 根据年份查询查询订单列表
	private Res codec3(GetapplyMoneyReq req) {
		MyApplyOrderRes res = new MyApplyOrderRes();
		res.setResult("1");
		res.setResultNote("查询订单列表失败");
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		Page<OrderListBean> page = new Page<OrderListBean>(10);                             
		page.setPageNo(Integer.parseInt(req.getNowPage()));
		page.setOrder(Page.DESC);
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			List<OrderListBean> orderList = new ArrayList<OrderListBean>();
			page=advanceService.myApplyOrder(page, filters,req);
			if(page != null && page.getResult().size() > 0){
				for(int i=0;i<page.getResult().size();i++){
					OrderListBean pb = new OrderListBean();
					pb.setOrderNumer(page.getResult().get(i).getOrderNumer()+"");
					pb.setDeliverName(page.getResult().get(i).getDeliverName()+"");
					pb.setDeliverMoney(page.getResult().get(i).getDeliverMoney()+"");
					pb.setDeliverBalance(page.getResult().get(i).getDeliverBalance()+"");
					pb.setDeliverTime(page.getResult().get(i).getDeliverTime()+"");
					pb.setReceiptName(page.getResult().get(i).getReceiptName()+"");
					pb.setReceiptMoney(page.getResult().get(i).getReceiptMoney()+"");
					pb.setReceiptBalance(page.getResult().get(i).getReceiptBalance()+"");
					pb.setReceiptTime(page.getResult().get(i).getReceiptTime()+"");
					page.getResult().get(i).setAdtime(null);
					orderList.add(pb);
				}
				res.setOrderList(orderList);
			}else {
				res.setTotalPage(Long.valueOf(1));
				res.setResultNote("内容为空");
				res.setResult("0");		
			}
			if(page.getTotalPages()>0){
				res.setTotalPage(page.getTotalPages());	
			}
			res.setResultNote("查询订单列表成功");
			res.setResult("0");		
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//3.0订单列表界面
	private Res codec(OrderListReq req) {
		OrderListRes res = new OrderListRes();
		res.setResult("1");
		res.setResultNote("查询订单列表失败");
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		Page<PSOrderList> page = new Page<PSOrderList>(10);                             
		page.setPageNo(Integer.parseInt(req.getNowPage()));
		page.setOrder(Page.DESC);
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			List<PSOrderList> orderList = new ArrayList<PSOrderList>();
			page=advanceService.orderList(page, filters,req);
			if(page != null && page.getResult().size() > 0){
				for(int i=0;i<page.getResult().size();i++){
					PSOrderList pb = new PSOrderList();
					pb.setOrderNumber(page.getResult().get(i).getOrderNumber()+"");
					pb.setDateTime(DateTimeUtil.dateConvtoFmt(page.getResult().get(i).getAdtime(),"yyyy-MM-dd HH:mm:ss"));
					pb.setSenderAddress(page.getResult().get(i).getSenderAddress()+"");
					pb.setSenderName(page.getResult().get(i).getSenderName()+"");
					pb.setSenderTel(page.getResult().get(i).getSenderTel()+"");
					pb.setReciverAddress(page.getResult().get(i).getReciverAddress()+"");
					pb.setReciverName(page.getResult().get(i).getReciverName()+"");
					pb.setReciverTel(page.getResult().get(i).getReciverTel()+"");
					pb.setLogisticsCost(page.getResult().get(i).getLogisticsCost()+"");
					pb.setCollectionDelivery(page.getResult().get(i).getCollectionDelivery()+"");
					pb.setOrderState(page.getResult().get(i).getOrderState()+"");
					orderList.add(pb);
				}
				res.setOrderList(orderList);
			}else {
				res.setTotalPage(Long.valueOf(1));
				res.setResultNote("内容为空");
				res.setResult("0");		
			}
			if(page.getTotalPages()>0){
				res.setTotalPage(page.getTotalPages());	
			}
			res.setResultNote("查询订单列表成功");
			res.setResult("0");		
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//3.3订单搜索
	private Res codec(SearchOrderInfoReq req) {
		OrderListRes res = new OrderListRes();
		res.setResult("1");
		res.setResultNote("搜索订单列表失败");
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		Page<PSOrderList> page = new Page<PSOrderList>(10);                             
		page.setPageNo(Integer.parseInt(req.getNowPage()));
		page.setOrder(Page.DESC);
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			List<PSOrderList> orderList = new ArrayList<PSOrderList>();
			page=advanceService.searchOrderInfo(page, filters,req);
			if(page != null && page.getResult().size() > 0){
				for(int i=0;i<page.getResult().size();i++){
					PSOrderList pb = new PSOrderList();
					pb.setOrderNumber(page.getResult().get(i).getOrderNumber()+"");
					pb.setDateTime(DateTimeUtil.dateConvtoFmt(page.getResult().get(i).getAdtime(),"yyyy-MM-dd HH:mm:ss"));
					pb.setSenderAddress(page.getResult().get(i).getSenderAddress()+"");
					pb.setSenderName(page.getResult().get(i).getSenderName()+"");
					pb.setSenderTel(page.getResult().get(i).getSenderTel()+"");
					pb.setReciverAddress(page.getResult().get(i).getReciverAddress()+"");
					pb.setReciverName(page.getResult().get(i).getReciverName()+"");
					pb.setReciverTel(page.getResult().get(i).getReciverTel()+"");
					pb.setLogisticsCost(page.getResult().get(i).getLogisticsCost()+"");
					pb.setCollectionDelivery(page.getResult().get(i).getCollectionDelivery()+"");
					pb.setOrderState(page.getResult().get(i).getOrderState()+"");
					orderList.add(pb);
				}
				res.setOrderList(orderList);
			}else {
				res.setTotalPage(Long.valueOf(1));
				res.setResultNote("内容为空");
				res.setResult("0");		
			}
			if(page.getTotalPages()>0){
				res.setTotalPage(page.getTotalPages());	
			}
			res.setResultNote("搜索订单列表成功");
			res.setResult("0");		
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	
	//3.1	获取订单详情
	private Res codec1(SearchOrderInfoReq req) {
		OrderDetailInfoRes res = new OrderDetailInfoRes();
		OrderDealInfo orderDealInfo = new OrderDealInfo();
		res.setResultNote("获取订单详情失败");
		try {
			orderDealInfo=advanceService.orderDetailInfo(req.getOrderId());
			if(orderDealInfo!=null){
				res.setOrderDealInfo(orderDealInfo);
				res.setResult("0");
				res.setResultNote("获取订单详情成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//3.2 配送信息
	private Res codec2(SearchOrderInfoReq req) {
		DeliverInfoRes res = new DeliverInfoRes();
		res.setResultNote("获取配送信息失败");
		try {
			String nationalPhone=advanceService.merchantService();
			res=advanceService.deliverInfo(req.getOrderId());
			if(res!=null){
				res.setNationalPhone(nationalPhone);
				res.setResult("0");
				res.setResultNote("获取配送信息成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	

	//5.获取用户行业类别
	private Res codec3(SearchOrderInfoReq req) {
		GetHangyeTypeRes res = new GetHangyeTypeRes();
		res.setResultNote("获取用户行业类别失败");
		try {
			res=advanceService.getHangyeType();
			if(res!=null){
				res.setResult("0");
				res.setResultNote("获取用户行业类别成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//6.获取用户的申请额度的状态
	private Res codec4(SearchOrderInfoReq req) {
		GetQuotaTypeRes res = new GetQuotaTypeRes();
		res.setResultNote("获取用户的申请额度的状态失败");
		try {
			Member m = memberService.queryByUid(req.getUid());
			if (m.getId() != null) {
				if ("1".equals(m.getStatus())) {
					res.setQuotaType("0");
				}else {
					res.setQuotaType("1");
				}
				res.setQuota(m.getQuota());
				res.setTanType(m.getTanType());
				res.setResult("0");
				res.setResultNote("获取用户的申请额度的状态成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//7.将用户的弹窗状态改为1不弹窗
	private Res codec5(SearchOrderInfoReq req) {
		Res res = new Res();
		res.setResultNote("修改状态失败");
		try {
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			if (m.getId() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (m.getStatue()==0) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if (advanceService.getTanType(req.getUid())) {
				res.setResult("0");
				res.setResultNote("修改状态成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//配送端开始----------------------------------------------------------------------
	//1.0 登录
	private Res codec(PsuerLoginReq req) {
		LoginRes res = new LoginRes();
		res.setResultNote("登录失败");
		try {
			if (StringUtils.isEmpty(req.getPhoneNum())) {
				res.setResultNote("用户名不能为空");
				return res;
			}
			User u = userService.queryByMobielOrEmail(req.getPhoneNum());
			if (u.getUid() == null) {
				res.setResultNote("用户名不存在");
				return res;
			}
			if (!req.getPassword().equals(u.getPassword())){
				res.setResultNote("密码不正确");
				return res;
			}	
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if (req.getPassword().equals(u.getPassword())) {
				userService.saveSubmitInfo(req);
				res.setResultNote("登录成功");
				res.setResult("0");
				UserInfo us = new UserInfo();
				us.setUid(u.getUid());
				us.setUserName(u.getUserName()+"");
				us.setUserIcon(u.getUserIcon()+"");
				us.setPhoneNum(u.getPhoneNum()+"");
				us.setRecommendedCode(u.getRecommendNum()+"");
				res.setUserInfo(us);
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	
	//1.1.0 获取个人记录
	private Res codec(PsuerRecordReq req) {
		PsuserRecordRes res = new PsuserRecordRes();
		res.setResultNote("获取个人记录失败");
		try {
			User u = userService.queryByUserId(req.getUid());
			if (u.getUid() == null) {
				res.setResultNote("用户名不存在");
				return res;
			}
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			res=userService.psuserRecord(req.getUid());
			if (res!=null) {
				res.setUserName(u.getUserName()+"");
				res.setUserIcon(u.getUserIcon()+"");
				res.setResult("0");
				res.setResultNote("获取个人记录成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	
	
	//1.1找回密码
	private Res codec(PsforgetPasswordReq req) {
		Res res = new Res();
		res.setResultNote("登录失败");
		try {
			if (StringUtils.isEmpty(req.getPhoneNum())) {
				res.setResultNote("用户名不能为空");
				return res;
			}
			User u = userService.queryByMobielOrEmail(req.getPhoneNum());
			if (u.getUid() == null) {
				res.setResultNote("用户名不存在");
				return res;
			}
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if(userService.updatepassword(req.getPhoneNum(),req.getPassword())){
				res.setResult("0");
				res.setResultNote("修改成功");
				return res;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	

	//3.2 获取个人信息 ****
	private Res codec(PsgetUserInfoDeatilReq req) {
		PsforgetPasswordRes res = new PsforgetPasswordRes();
		res.setResultNote("登录失败");
		try {
			User u = userService.queryByUserId(req.getUid());
			if (u.getUid() == null) {
				res.setResultNote("用户名不存在");
				return res;
			}
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			res.setUserIcon(u.getUserIcon()+"");
			res.setUserName(u.getUserName()+"");
			res.setUserTel(u.getPhoneNum()+"");
			res.setResult("0");
			res.setResultNote("获取个人信息成功");
			return res;
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}

	//3.3修改个人用户信息
	private Res codec(PseditUserInfoDeatilReq req) {
		Res res = new Res();
		res.setResultNote("登录失败");
		try {
			User u = userService.queryByUserId(req.getUid());
			if (u.getUid() == null) {
				res.setResultNote("用户名不存在");
				return res;
			}
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if(userService.updateinfo(req)){
				res.setResult("0");
				res.setResultNote("修改成功");
				return res;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	
	
	
	
	
	
	//3.4修改头像
	private Res codec(SaveUserIconReq req) {
		PsforgetPasswordRes res = new PsforgetPasswordRes();
		res.setResultNote("修改头像失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			User u = userService.queryByUserId(req.getUid());
			if (u.getUid() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if (!StringUtils.isEmpty(req.getImgUrl())){
				String url = Base64ToImageUtil.GenerateImage(req.getImgUrl(),
						SysGlobals.getInstance().getProperty("userImgPath"));
				if (!StringUtils.isEmpty(url)) {
					u.setUserIcon(url);
				}
				if (userService.saveUserIcon(req.getUid(),u.getUserIcon())) {
					res.setResult("0");
					res.setResultNote("修改头像成功");
				} else {
					res.setResultNote("修改头像失败");
				}
			}else{
				res.setResult("1");
				res.setResultNote("头像不能为空");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	
	
	//3.5 派件
	private Res codec1(SaveUserIconReq req) {
		Res res = new Res();
		res.setResultNote("派件失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			User u = userService.queryByUserId(req.getUid());
			if (u.getUid() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if (userService.paiOrder(req.getOrderId(),req.getUid())) {
				res.setResult("0");
				res.setResultNote("派件成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	
	
	//2.0订单列表（首页）
	private Res codec(PsorderListReq req) {
		PsorderListRes res = new PsorderListRes();
		res.setResult("1");
		res.setResultNote("获取订单列表失败");
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		Page<PSOrderListBean> page = new Page<PSOrderListBean>(10);                             
		page.setPageNo(Integer.parseInt(req.getNowPage()));
		page.setOrder(Page.DESC);
		try {
			List<PSOrderList> messageList = new ArrayList<PSOrderList>();
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			User u = userService.queryByUserId(req.getUid());
			if (u.getUid() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			page=userService.psorderList(page, filters,u.getLogistics(),req.getType(),u.getLogName());
			if(page != null && page.getResult().size() > 0){
				for(int i=0;i<page.getResult().size();i++){
					PSOrderList pb = new PSOrderList();
					pb.setCollectionDelivery(page.getResult().get(i).getCollectionDelivery()+"");
					if ("4".equals(page.getResult().get(i).getOrderState())) {
						pb.setDateTime(DateTimeUtil.dateConvtoFmt(page.getResult().get(i).getDeliverTime(),"yyyy-MM-dd HH:mm:ss"));
					}else {
						pb.setDateTime(DateTimeUtil.dateConvtoFmt(page.getResult().get(i).getDateTime(),"yyyy-MM-dd HH:mm:ss"));
					}
					pb.setLogisticsCost(page.getResult().get(i).getLogisticsCost()+"");
					pb.setOrderNumber(page.getResult().get(i).getOrderNumber()+"");
					pb.setOrderState(page.getResult().get(i).getOrderState()+"");
					pb.setReciverAddress(page.getResult().get(i).getReciverAddress()+"");
					pb.setReciverName(page.getResult().get(i).getReciverName()+"");
					pb.setReciverTel(page.getResult().get(i).getReciverTel()+"");
					pb.setSenderAddress(page.getResult().get(i).getSenderAddress()+"");
					pb.setSenderName(page.getResult().get(i).getSenderName()+"");
					pb.setSenderTel(page.getResult().get(i).getSenderTel()+"");
					messageList.add(pb);
				}
				res.setOrderList(messageList);
			}else {
				res.setTotalPage(Long.valueOf(1));
				res.setResultNote("内容为空");
				res.setResult("0");		
			}
			if(page.getTotalPages()>0){
				res.setTotalPage(page.getTotalPages());	
			}
			res.setResultNote("获取订单列表成功");
			res.setResult("0");		
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}

	
	//2.0 订单列表（我的）
	private Res codec(PsrecordListReq req) {
		PsrecordListRes res = new PsrecordListRes();
		res.setResult("1");
		res.setResultNote("获取我的订单列表失败");
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		Page<PSOrder> page = new Page<PSOrder>(3);                             
		page.setPageNo(Integer.parseInt(req.getNowPage()));
		page.setOrder(Page.DESC);
		try {
			List<PSOrderBean> messageList = new ArrayList<PSOrderBean>();
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			User u = userService.queryByUserId(req.getUid());
			if (u.getUid() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			page=userService.psrecordList(page, filters,u.getUid(),req.getType());
			if(page != null && page.getResult().size() > 0){
				for(int i=0;i<page.getResult().size();i++){
					PSOrderBean a=new PSOrderBean();
					List<PSOrderListBean> b=new ArrayList<PSOrderListBean>();
					List<PSOrderList> c=new ArrayList<PSOrderList>();
					a.setOrderdate(DateTimeUtil.dateConvtoFmt(page.getResult().get(i).getOrderdate(),"yyyy-MM-dd"));
					b=userService.psorderListinfo(a.getOrderdate(),req);
					if(b!=null&&b.size()>0){
						for(int x=0;x<b.size();x++){
						PSOrderList pb = new PSOrderList();
						pb.setCollectionDelivery(b.get(x).getCollectionDelivery()+"");
						pb.setDateTime(DateTimeUtil.dateConvtoFmt(b.get(x).getDateTime(),"yyyy-MM-dd HH:mm:ss"));
						pb.setLogisticsCost(b.get(x).getLogisticsCost()+"");
						pb.setOrderNumber(b.get(x).getOrderNumber()+"");
						pb.setOrderState(b.get(x).getOrderState()+"");
						pb.setReciverAddress(b.get(x).getReciverAddress()+"");
						pb.setReciverName(b.get(x).getReciverName()+"");
						pb.setReciverTel(b.get(x).getReciverTel()+"");
						pb.setSenderAddress(b.get(x).getSenderAddress()+"");
						pb.setSenderName(b.get(x).getSenderName()+"");
						pb.setSenderTel(b.get(x).getSenderTel()+"");
						c.add(pb);
						a.setOrderList(c);
						}
					}
					messageList.add(a);
				}
				res.setOrder(messageList);
			}else {
				res.setTotalPage(Long.valueOf(1));
				res.setResultNote("内容为空");
				res.setResult("0");		
			}
			if(page.getTotalPages()>0){
				res.setTotalPage(page.getTotalPages());	
			}
			res.setResultNote("我的订单列表成功");
			res.setResult("0");		
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//2.0 删除订单
	private Res codec2(SaveUserIconReq req) {
		Res res = new Res();
		res.setResultNote("删除订单失败");
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			User u = userService.queryByUserId(req.getUid());
			if (u.getUid() == null) {
				res.setResultNote("用户未登录");
				return res;
			}
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			if (userService.psdeleteOrderId(req.getOrderId())) {
				res.setResult("0");
				res.setResultNote("删除订单成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	

	
	//3.1 我的客户
	private Res codec3(SaveUserIconReq req) {
		PscustomerListRes res = new PscustomerListRes();
		res.setResult("1");
		res.setResultNote("获取我的客户失败");
		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
		Page<CustomerListBean> page = new Page<CustomerListBean>(10);                             
		page.setPageNo(Integer.parseInt(req.getNowPage()));
		page.setOrder(Page.DESC);
		try {
			if (StringUtils.isEmpty(req.getUid())) {
				res.setResultNote("用户未登录");
				return res;
			}
			User u = userService.queryByUserId(req.getUid());
			if (u.getUid() == null) {
				res.setResultNote("用户名不存在");
				return res;
			}
			if (u.getState()==1) {
				res.setResultNote("用户已被禁用");
				return res;
			}
			List<CustomerListBean> customerList = new ArrayList<CustomerListBean>();
			page=userService.pscustomerList(page, filters,u.getRecommendNum());
			if(page != null && page.getResult().size() > 0){
				for(int i=0;i<page.getResult().size();i++){
					CustomerListBean pb = new CustomerListBean();
					pb.setCustomerId(page.getResult().get(i).getCustomerId()+"");
					pb.setName(page.getResult().get(i).getName()+"");
					pb.setArea(page.getResult().get(i).getArea()+"");
					pb.setImg(page.getResult().get(i).getImg()+"");
					pb.setRegisterTime(DateTimeUtil.dateConvtoFmt(page.getResult().get(i).getAdtime(),"yyyy-MM-dd HH:mm:ss"));
					page.getResult().get(i).setAdtime(null);
					customerList.add(pb);
				}
				res.setCustomerList(customerList);
			}else {
				res.setTotalPage(Long.valueOf(1));
				res.setResultNote("内容为空");
				res.setResult("0");		
			}
			if(page.getTotalPages()>0){
				res.setTotalPage(page.getTotalPages());	
			}
			res.setResultNote("获取我的客户成功");
			res.setResult("0");		
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//2.1订单详情-揽件
	private Res codec(PsorderDetailReq req) {
		Res res = new Res();
		res.setResultNote("揽件失败");
		try {
			if(userService.psorderDetailInfoRevive(req)){
				res.setResult("0");
				res.setResultNote("揽件成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	//2.2订单详情-确认完成和退款
	private Res codec(ConfiFinishReq req) {
		Res res = new Res();
		res.setResultNote("操作失败");
		try {
			if(userService.psorderDetailInfoConfiFinish(req)){
				res.setResult("0");
				res.setResultNote("操作成功");
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;		
	}
	
	
	
	
	
	
	
	
	
	
	private Res codec(GetChargeReq req) {
		HttpServletRequest request = ServletActionContext.getRequest();
		IPUtil it=new IPUtil();
		GetChargeRes res = new GetChargeRes();
		   Charge charge = null;
	
		Pingpp.apiKey = "sk_live_v5mPOKKSi9e95qznrH4q5CCG";  
		res.setResult("1");
		res.setResultNote("请求失败");
		try {
		    String ip=it.getRemoteAddress(request);
	        Map<String, Object> chargeMap = new HashMap<String, Object>();
	        chargeMap.put("amount", req.getAmount());
	        chargeMap.put("currency", "cny");
	        chargeMap.put("subject", req.getBody());
	        chargeMap.put("body", req.getBody());
	        chargeMap.put("order_no", req.getOrdernum());
	        chargeMap.put("channel", req.getChannel());
	        chargeMap.put("client_ip",ip);
	        Map<String, String> app = new HashMap<String, String>();
	        app.put("id","app_8CeHKSHmHOSCnP0i");
	        chargeMap.put("app", app);
	        
	        //发起交易请求
			charge = Charge.create(chargeMap);
			System.out.println(charge);
			res.setCharge(charge);
			res.setResult("0");
			res.setResultNote("请求成功");
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}
	
		
	
	/**
	 * 获取用户id
	 * 
	 * @param userName
	 * @return
	 */
	public Long getMemberId(String phone) {
		Member m = new Member();
		m = memberService.queryByMobielOrEmail(phone);
		if (m != null && m.getId()!=null) {
			return m.getId();
		}
		return 0L;
	}
	
	/**
	 * 获取用户
	 * 
	 * @param userName
	 * @return
	 */
		public Member getMember(String userName) {
			Member m = new Member();
			m = memberService.queryByMobielOrEmail(userName);
			return m;
		}
		public File getFile() {
			return file;
		}
		public void setFile(File file) {
			this.file = file;
		}
		public String getFileFileName() {
			return fileFileName;
		}
		public void setFileFileName(String fileFileName) {
			this.fileFileName = fileFileName;
		}

		public ApplyMoneyReq getCertificate() {
			return certificate;
		}

		public void setCertificate(ApplyMoneyReq certificate) {
			this.certificate = certificate;
		}
		
		
		
	}
