package com.ying.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.utils.Base64ToImageUtil;
import org.utils.DateTimeUtil;
import org.utils.Logs;
import org.utils.StringUtil;
import org.utils.StringUtils;
import org.utils.SysGlobals;
import org.utils.Tool;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.ying.app.bean.AddressListBean;
import com.ying.app.bean.ApplyInfoBean;
import com.ying.app.bean.ApplyYearBean;
import com.ying.app.bean.CompanyBean;
import com.ying.app.bean.CompanyName;
import com.ying.app.bean.CycleBean;
import com.ying.app.bean.HangyeBean;
import com.ying.app.bean.Images;
import com.ying.app.bean.MessageBean;
import com.ying.app.bean.MoneyListBean;
import com.ying.app.bean.OrderDealInfo;
import com.ying.app.bean.OrderListBean;
import com.ying.app.bean.PSOrderList;
import com.ying.app.bean.PSOrderListBean;
import com.ying.app.bean.ProvinceBoundageBean;
import com.ying.app.req.AddAddressReq;
import com.ying.app.req.ApplyMoneyReq;
import com.ying.app.req.FeedbackOptionReq;
import com.ying.app.req.GetOrderDetailReq;
import com.ying.app.req.GetapplyMoneyReq;
import com.ying.app.req.MerchantWithDrawReq;
import com.ying.app.req.OrderListReq;
import com.ying.app.req.SearchOrderInfoReq;
import com.ying.app.req.UserInfoDeatilReq;
import com.ying.app.res.AboutUsRes;
import com.ying.app.res.ConfirmTheDeliveryInfoRes;
import com.ying.app.res.DeliverInfoRes;
import com.ying.app.res.DeliveryDetailRes;
import com.ying.app.res.GetBoundageRes;
import com.ying.app.res.GetHangyeTypeRes;
import com.ying.app.res.GetPoundageMoneyRes;
import com.ying.app.res.GetWalletMoneyRes;
import com.ying.app.res.MerchantServiceRes;
import com.ying.entity.Member;
import com.ying.service.IMemberService;

@Repository
public class AdvanceDao extends EntityDao implements IadvanceDao {

	@Autowired
	private IMemberService memberService;

	// 1.0 轮播图
	@Override
	public List<CycleBean> reCycleList() {
		List<CycleBean> cycleList = new ArrayList<CycleBean>();
		try {
			String sql = "SELECT id,ad_image img_url FROM t_ad";
			cycleList = getEntityList(CycleBean.class, sql, new Object[] {});
		} catch (Exception e) {
			Logs.error(e);
		}
		return cycleList;
	}

	// 1.2我的账户金额
	@Override
	public String getWalletMoney(String uid) {
		GetWalletMoneyRes res = new GetWalletMoneyRes();
		String sql = null;
		try {
			sql = "select balance from t_member where id=" + uid;
			res = getEntity(GetWalletMoneyRes.class, sql, new Object[] {});
			if (res.getBalance() != null) {
				return res.getBalance();
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 1.2.1用户所需要支付的手续费
	@Override
	public String getText(String uid) {
		GetWalletMoneyRes res = new GetWalletMoneyRes();
		String sql = null;
		try {
			sql = "select text from sys_dictionary where id=64";
			res = getEntity(GetWalletMoneyRes.class, sql, new Object[] {});
			if (res.getText() != null) {
				return res.getText();
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 1.3 添加/编辑发货/收货地址
	@Override
	public boolean addAddress(AddAddressReq req) {
		try {
			// 如果用户要将新地址设置为默认地址
			if ("1".equals(req.getIsDefault())) {
				// 将已有的地址全部改为非默认
				try {
					String sql2 = "UPDATE t_member_address t SET t.is_default=0 WHERE t.uid = "
							+ req.getUid();
					getJt().update(sql2, new Object[] {});
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			if ("".equals(req.getSendId()) || req.getSendId() == null) {// 为添加地址
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("uid", req.getUid());
				pa.put("name", req.getName());
				pa.put("tel", req.getTel());
				pa.put("post_code", req.getPostCode());
				pa.put("detail_address", req.getDetailAddress());
				pa.put("is_default", req.getIsDefault());
				pa.put("province", req.getProvinceCode());
				pa.put("city", req.getCityCode());
				pa.put("town", req.getAreaCode());
				pa.put("adtime", new Date());
				Long id = insert(pa, "t_member_address");
				return true;
			} else {// 修改地址
				String s = "update t_member_address set uid=?,name=?,tel=?,post_code=?,detail_address=?,is_default=?,adtime=? where id=?";
				getJt().update(
						s,
						new Object[] { req.getUid(), req.getName(),
								req.getTel(), req.getPostCode(),
								req.getDetailAddress(), req.getIsDefault(),
								new Date(), req.getSendId() });
				return true;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 1.5 删除地址
	@Override
	public boolean handleAdress(String receiverid) {
		String sql = "";
		try {
			sql = " DELETE FROM t_member_address WHERE id=" + receiverid;
			getJt().update(sql, new Object[] {});
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 1.6 绑定服务码
	@Override
	public boolean servicecode(String serviceCode, String uid) {
		String sql = "";
		try {
			sql = "update t_member set service_code=?,servictime=? where id=?";
			getJt().update(sql, new Object[] { serviceCode, new Date(), uid });
			
			//存储服务码下次可修改时间
			try {
				String sql2="update t_member set servictime=DATE_ADD(servictime,INTERVAL 3 month) where id="+uid;
				getJt().update(sql2,new Object[]{});
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 1.8保存个人信息
	@Override
	public boolean commitUserInfoDeatil(UserInfoDeatilReq req) {
		String sql = "";
		try {
			if (req.getUserName() != null && !"".equals(req.getUserName())) {
				sql = "update t_member set user_name=? where id=?";
				getJt().update(sql,
						new Object[] { req.getUserName(), req.getUid() });
			}
			if (req.getUserAddress() != null
					&& !"".equals(req.getUserAddress())) {
				sql = "update t_member set user_address=? where id=?";
				getJt().update(sql,
						new Object[] { req.getUserAddress(), req.getUid() });
			}
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 补：保存用户头像
	@Override
	public boolean saveUserPhoto(String uid, String usericon) {
		String sql = "";
		try {
			sql = "update t_member set user_icon=? where id=?";
			getJt().update(sql, new Object[] { usericon, uid });
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 1.9 我的发货地址列表
	@Override
	public List<AddressListBean> getSendAdressListInfo(String uid) {
		List<AddressListBean> addressList = new ArrayList<AddressListBean>();
		try {
			String sql = "SELECT id send_id,is_default send_selected,"
					+ "name send_name,tel send_phone,detail_address send_detail_address,"
					+ "post_code send_postcode,province province_code,city city_code,town area_code "
					+ "FROM t_member_address WHERE uid=" + uid
					+ " order by adtime desc";
			addressList = getEntityList(AddressListBean.class, sql,
					new Object[] {});
		} catch (Exception e) {
			Logs.error(e);
		}
		return addressList;
	}

	// 2.1 意见反馈
	@Override
	public boolean feedbackOption(FeedbackOptionReq req) {
		try {
			Map<String, Object> pa = new HashMap<String, Object>();
			pa.put("uid", req.getUid());
			pa.put("title", req.getContentTitle());
			pa.put("content", req.getContent());
			pa.put("adtime", new Date());
			Long id = insert(pa, "t_suggest");
			if (id > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 2.0 关于我们
	@Override
	public String aboutUs(String type) {
		AboutUsRes res = new AboutUsRes();
		String sql = null;
		try {
			sql = "select description about_url from t_aboutus where type="
					+ type;
			res = getEntity(AboutUsRes.class, sql, new Object[] {});
			if (res.getAboutUrl() != null) {
				return res.getAboutUrl();
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 2.2 客服电话
	@Override
	public String merchantService() {
		MerchantServiceRes res = new MerchantServiceRes();
		String sql = null;
		try {
			sql = "select text national_phone from sys_dictionary where dictionarytype_id=7";
			res = getEntity(MerchantServiceRes.class, sql, new Object[] {});
			if (res.getNationalPhone() != null) {
				return res.getNationalPhone();
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 1.获取手续费接口
	@Override
	public String getPoundageMoney(String proviceCode, String advances) {
		GetPoundageMoneyRes res = new GetPoundageMoneyRes();
		String sql = null;
		try {
			if ("1".equals(advances)) {
				if ("河南省".equals(proviceCode)) {
					// 选择垫付 收货地址是省内的 就获取省内的手续费
					sql = "select text poundage from sys_dictionary where dictionarytype_id=3";
				} else {
					sql = "select text poundage from sys_dictionary where dictionarytype_id=4";
				}
			} else {
				if ("河南省".equals(proviceCode)) {
					// 选择不垫付 收货地址是省内的 就获取省内的手续费
					sql = "select text poundage from sys_dictionary where dictionarytype_id=5";
				} else {
					sql = "select text poundage from sys_dictionary where dictionarytype_id=6";
				}
			}
			res = getEntity(GetPoundageMoneyRes.class, sql, new Object[] {});
			if (res.getPoundage() != null) {
				return res.getPoundage();
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 2.获取物流公司
	@Override
	public List<CompanyBean> getLogisticsCompany(String areaCode) {
		List<CompanyBean> companyInfoList = new ArrayList<CompanyBean>(); // 物流公司
		List<CompanyName> companyList = new ArrayList<CompanyName>(); // 物流公司站点
		try {
			String sql = "SELECT t.id,t.log_name name "
					+ "FROM t_logistics_address s "
					+ "LEFT JOIN t_logistics t ON t.id=s.log_id WHERE s.town LIKE '%"
					+ areaCode + "%'";
			companyInfoList = getEntityList(CompanyBean.class, sql,
					new Object[] {});
			if (companyInfoList != null && companyInfoList.size() > 0) {
				for (int i = 0; i < companyInfoList.size(); i++) {
					String sql1 = "SELECT s.log_name comname FROM "
							+ "t_logistics_address s WHERE  s.town LIKE '%"
							+ areaCode + "%' and s.log_id = "
							+ companyInfoList.get(i).getId();
					companyList = getEntityList(CompanyName.class, sql1,
							new Object[] {});
					companyInfoList.get(i).setCompanyList(companyList);
				}
				return companyInfoList;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 1.获取手续费接口
	@Override
	public GetBoundageRes getBoundage() {
		GetBoundageRes res = new GetBoundageRes();
		List<ProvinceBoundageBean> boundList = new ArrayList<ProvinceBoundageBean>();
		String sql = null;
		try {
			sql = "select text boundage from sys_dictionary where dictionarytype_id=3 "
					+ "UNION "
					+ "select text boundage from sys_dictionary where dictionarytype_id=4 "
					+ "UNION "
					+ "select text boundage from sys_dictionary where dictionarytype_id=5 "
					+ "UNION "
					+ "select text boundage from sys_dictionary where dictionarytype_id=6";
			boundList = getEntityList(ProvinceBoundageBean.class, sql,
					new Object[] {});
			if (boundList != null && boundList.size() > 0) {
				res.setPayInProvinceBoundage(boundList.get(0).getBoundage()
						+ "");
				res.setPayOutProvinceBoundage(boundList.get(1).getBoundage()
						+ "");
				res.setNoPayInProvinceBoundage(boundList.get(2).getBoundage()
						+ "");
				res.setNoPayOutProvinceBoundage(boundList.get(3).getBoundage()
						+ "");
			}
			res.setResult("0");
			res.setResultNote("获取手续费成功！");
			return res;
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}

	// 1.1 确认发货
	@Override
	public String confirmTheDeliveryInfo(GetOrderDetailReq req) {
		String ordernum = StringUtil.getOrderNo(); // 生成订单号
		try {
			Map<String, Object> pa = new HashMap<String, Object>();
			pa.put("uid", req.getUid());
			pa.put("order_num", ordernum);
			pa.put("status", 1);
			pa.put("sender_address", req.getSenderAddress());
			pa.put("sender_name", req.getSenderName());
			pa.put("sender_tel", req.getSenderTel());
			pa.put("sender_post_code", req.getSenderPostCode());
			pa.put("sender_city_code", req.getSenderCityCode());
			pa.put("reciver_address", req.getReciverAddress());
			pa.put("reciver_name", req.getReciverName());
			pa.put("reciver_tel", req.getReciverTel());
			pa.put("reciver_post_code", req.getReciverPostCode());
			pa.put("reciver_city_code", req.getReciverPostCode());
			pa.put("goods", req.getGoods());
			pa.put("volume", req.getVolume());
			pa.put("weight", req.getWeight());
			pa.put("pay_goods", req.getPayGoods());
			pa.put("payment_amount", req.getPaymentAmount());
			pa.put("poundage", req.getPoundage());
			pa.put("logistics_collecting", req.getLogisticsCollecting());
			pa.put("advances", req.getAdvances());
			pa.put("logistics_company_name", req.getLogisticsCompanyName());
			pa.put("log_name", req.getComname());
			pa.put("logistics_order", req.getLogisticsOrder());
			pa.put("his_pay", req.getHisPay());
			pa.put("adtime", new Date());
			pa.put("adtime_year", new Date().getYear() + 1900);
			Long id = insert(pa, "t_order");
			if (id > 0) {
				Member m = new Member();
				m = memberService.queryByUid(req.getUid());
				if ("1".equals(req.getAdvances())) {// 平台垫付 需要给用户加上垫付 的金额
					Double blance = Double.valueOf(m.getBalance()); // 用户当前余额
					Double paymentAmount = Double.valueOf(req
							.getPaymentAmount()); // 平台垫付的金额
					// String money=blance+paymentAmount+"";
					// String
					// sql2="UPDATE t_member SET balance=? WHERE id = "+req.getUid();
					// getJt().update(sql2,new Object[]{money});

					Double quotaRemaining = Double.valueOf(m
							.getQuotaRemaining()); // 用户当前可用信用额度
					// 如果是垫付 需要暂时扣除用户的额度
					String sql3 = "UPDATE t_member SET quota_remaining=? WHERE id = "
							+ req.getUid();
					getJt().update(sql3,
							new Object[] { quotaRemaining - paymentAmount });

					// 修改订单中用户该订单垫付后 当前剩余的信信用额度
					String sql4 = "UPDATE t_order SET quota_remaining=? WHERE id = "
							+ id;
					getJt().update(sql4,
							new Object[] { quotaRemaining - paymentAmount });

					// 插入金额变动记录到 明细表t_member_detaile
					// String
					// sql5="insert into t_member_detaile (uid,type,money,adtime)value(?,?,?,?)";
					// getJt().update(sql5,new
					// Object[]{req.getUid(),1,req.getPaymentAmount(),new
					// Date()});
					return ordernum;
				}else {
					return ordernum;
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 2.2 确认发货订单的详情页
	@Override
	public DeliveryDetailRes confirmTheDeliveryDetail(String orderId) {
		DeliveryDetailRes res = new DeliveryDetailRes();
		String sql = null;
		try {
			sql = "select * from t_order where order_num=" + orderId;
			res = getEntity(DeliveryDetailRes.class, sql, new Object[] {});
			if (res != null) {
				res.setSenderAddress(res.getSenderAddress() + "");
				res.setSenderName(res.getSenderName() + "");
				res.setSenderTel(res.getSenderTel() + "");
				res.setSenderPostCode(res.getSenderPostCode() + "");
				res.setReciverAddress(res.getReciverAddress() + "");
				res.setReciverName(res.getReciverName() + "");
				res.setReciverTel(res.getReciverTel() + "");
				res.setReciverPostCode(res.getReciverPostCode() + "");
				res.setGoods(res.getGoods() + "");
				res.setVolume(res.getVolume() + "");
				res.setWeight(res.getWeight() + "");
				res.setPayGoods(res.getPayGoods() + "");
				res.setPaymentAmount(res.getPaymentAmount() + "");
				res.setPoundage(res.getPoundage() + "");
				res.setLogisticsCollecting(res.getLogisticsCollecting() + "");
				res.setLogisticsCompanyName(res.getLogisticsCompanyName() + "");
				res.setLogisticsOrder(res.getLogisticsOrder() + "");
				res.setHisPay(res.getHisPay() + "");
				res.setOrderNumber(res.getOrderNum() + "");
				res.setOrderNum(null);
				res.setOrderTime(DateTimeUtil.dateConvtoFmt(res.getAdtime(),
						"yyyy-MM-dd HH:mm:ss"));
				res.setAdtime(null);
				res.setResult("0");
				res.setResultNote("获取手续费成功！");
				return res;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}

	// 4.0申请额度
	@Override
	public boolean applyMoney(ApplyMoneyReq req) {
		String imagesql = null;
		try {
			// 保存内容之前要先删除之前的申请数据
			String sql = "DELETE FROM t_member_quota WHERE uid=" + req.getUid();
			getJt().update(sql, new Object[] {});

			Map<String, Object> pa = new HashMap<String, Object>();
			pa.put("uid", req.getUid());
			pa.put("status", 0);
			pa.put("name", req.getName());
			pa.put("company", req.getCompany());
			pa.put("company_address", req.getCompanyAddress());
			pa.put("address", req.getAddress());
			pa.put("tel", req.getTel());
			pa.put("import_tel", req.getImportTel());
			pa.put("regiter_time", req.getRegiterTime());
			pa.put("professional", req.getProfessional());
			pa.put("turnover_year", req.getTurnoverYear());
			pa.put("send_numer", req.getSendNumer());
			pa.put("id_card_up", req.getIdCardUp());
			pa.put("id_card_down", req.getIdCardDown());
			pa.put("id_card_hand", req.getIdCardHand());
			pa.put("supplement", req.getSupplement());
			pa.put("adtime", new Date());
			Long id = insert(pa, "t_member_quota");
			if (id > 0) {
				// 保存证件图片之前要先清除之前的图片
				String sql1 = "DELETE FROM t_image WHERE type=0 AND access_id="
						+ req.getUid();
				getJt().update(sql1, new Object[] {});

				if (req.getImages().size() > 0) {
					for (int i = 0; i < req.getImages().size(); i++) {
						imagesql = "insert into t_image (type,access_id,image,adtime)value(?,?,?,?)";
						getJt().update(
								imagesql,
								new Object[] { 0, req.getUid(),
										req.getImages().get(i).getImageStr(),
										new Date() });
					}
				}
			} else {
				return false;
			}
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 4.1.0 获取用户申请资料
	@Override
	public ApplyInfoBean getapplyMoney(String uid) {
		ApplyInfoBean applyInfo = new ApplyInfoBean();
		List<Images> certificateImages = new ArrayList<Images>(); // 图片
		try {
			String sql = "SELECT * FROM t_member_quota WHERE uid=" + uid;
			applyInfo = getEntity(ApplyInfoBean.class, sql, new Object[] {});
			if (applyInfo != null) {
				// 查询对应的证件照片
				String sql1 = "SELECT image FROM t_image WHERE type=0 and access_id="
						+ uid;
				certificateImages = getEntityList(Images.class, sql1,
						new Object[] {});
				applyInfo.setCertificateImages(certificateImages);
				return applyInfo;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 4.5 消息列表
	@Override
	public Page<MessageBean> getMessageList(Page<MessageBean> page,
			List<PropertyFilter> filters, String uid) {
		try {
			String sql = "SELECT id message_id,message_title,message_content,adtime FROM t_sysmsg WHERE uid="
					+ uid + " order by adtime desc";
			getPage(MessageBean.class, sql, page, filters);
			if (page.getResult() != null && page.getResult().size() > 0) {
				return page;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 4.3收支明细
	@Override
	public Page<MoneyListBean> getWalletInfo(Page<MoneyListBean> page,
			List<PropertyFilter> filters, String uid) {
		try {
			String sql = "SELECT type money_soure,money money_num,adtime FROM t_member_detaile WHERE uid="
					+ uid + " order by adtime desc";
			getPage(MoneyListBean.class, sql, page, filters);
			if (page.getResult() != null && page.getResult().size() > 0) {
				return page;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 4.4 提现
	@Override
	public String merchantWithDraw(MerchantWithDrawReq req) {
		ProvinceBoundageBean probean = new ProvinceBoundageBean();
		try{
			String sql = "select text boundage from sys_dictionary where dictionarytype_id=8 ";
			probean = getEntity(ProvinceBoundageBean.class, sql, new Object[] {});
			//提现手续费
			Double shouxu = 0.0;
			if (probean!=null) {
				shouxu = Double.valueOf(probean.getBoundage());
			}
			// 提现成功后需要暂时减去用户的账户余额
			Member m = new Member();
			m = memberService.queryByUid(req.getUid());
			Double amoney = Double.valueOf(req.getMoney())*shouxu*0.01;	//用该扣除的手续费
			Double money = Double.valueOf(m.getBalance()) - amoney;//用户当前的余额
			Double dmoney = Double.valueOf(req.getMoney()) - amoney;//到账金额
			Map<String, Object> pa=new HashMap<String, Object>();
			pa.put("uid", req.getUid()); 	
			pa.put("money", req.getMoney()); 	
			pa.put("dmoney", dmoney+""); 	
			pa.put("smoney", amoney+""); 	
			pa.put("card_num", req.getAccount()); 	
			pa.put("bank_name", req.getBankName()); 	
			pa.put("real_name", req.getRealName()); 	
			pa.put("type", req.getType()); 	
			pa.put("is_ok", 0); 	
			pa.put("adtime", new Date());
			Long id = insert(pa, "t_tixian");
			if (id > 0) {
				String sql3 = "UPDATE t_member SET balance=? WHERE id = " + req.getUid();
				getJt().update(sql3, new Object[] { money + "" });
				return dmoney+"";
			} else {
				return null;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 4.1.2 获取日期
	@Override
	public List<ApplyYearBean> myApplyData(String uid) {
		List<ApplyYearBean> applyYear = new ArrayList<ApplyYearBean>();
		String sql = null;
		try {
			sql = "SELECT DATE_FORMAT(adtime, '%Y') year FROM t_order WHERE uid="
					+ uid + " GROUP BY year ORDER BY year DESC";
			applyYear = getEntityList(ApplyYearBean.class, sql, new Object[] {});
			if (applyYear != null && applyYear.size() > 0) {
				return applyYear;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 4.1.3 根据年份查询查询订单列表
	@Override
	public Page<OrderListBean> myApplyOrder(Page<OrderListBean> page,
			List<PropertyFilter> filters, GetapplyMoneyReq req) {
		try {
			String sql = "SELECT order_num order_numer,status,adtime,refundtime,"
					+ "payment_amount money,quota_remaining balance from t_order WHERE "
					+ "uid="
					+ req.getUid()
					+ " and adtime_year = "
					+ req.getYear();
			getPage(OrderListBean.class, sql, page, filters);
			if (page.getResult() != null && page.getResult().size() > 0) {
				for (int i = 0; i < page.getResult().size(); i++) {
					if (page.getResult().get(i).getStatus() == 3) {
						page.getResult().get(i).setDeliverName("发货");
						page.getResult()
								.get(i)
								.setDeliverMoney(
										page.getResult().get(i).getMoney() + "");
						page.getResult()
								.get(i)
								.setDeliverBalance(
										page.getResult().get(i).getBalance()
												+ "");
						page.getResult()
								.get(i)
								.setDeliverTime(
										DateTimeUtil.dateConvtoFmt(
												page.getResult().get(i)
														.getAdtime(),
												"yyyy-MM-dd HH:mm:ss"));
						page.getResult().get(i).setReceiptName("发货成功");
						page.getResult()
								.get(i)
								.setReceiptMoney(
										page.getResult().get(i).getMoney() + "");
						// 货物送达之后 垫付金额不变 额度变为当时的额度加上垫付的金额
						Double balance = Double.valueOf(page.getResult().get(i)
								.getMoney())
								+ Double.valueOf(page.getResult().get(i)
										.getBalance());
						page.getResult().get(i).setReceiptBalance(balance + "");
						page.getResult()
								.get(i)
								.setReceiptTime(
										DateTimeUtil.dateConvtoFmt(page
												.getResult().get(i)
												.getRefundtime(),
												"yyyy-MM-dd HH:mm:ss"));
					} else if (page.getResult().get(i).getStatus() == 5) {
						page.getResult().get(i).setDeliverName("发货");
						page.getResult()
								.get(i)
								.setDeliverMoney(
										page.getResult().get(i).getMoney() + "");
						page.getResult()
								.get(i)
								.setDeliverBalance(
										page.getResult().get(i).getBalance()
												+ "");
						page.getResult()
								.get(i)
								.setDeliverTime(
										DateTimeUtil.dateConvtoFmt(
												page.getResult().get(i)
														.getAdtime(),
												"yyyy-MM-dd HH:mm:ss"));
						page.getResult().get(i).setReceiptName("发货失败");
						page.getResult()
								.get(i)
								.setReceiptMoney(
										page.getResult().get(i).getMoney() + "");
						// 货物送达之后 垫付金额不变 额度变为当时的额度加上垫付的金额
						Double balance = Double.valueOf(page.getResult().get(i)
								.getMoney())
								+ Double.valueOf(page.getResult().get(i)
										.getBalance());
						page.getResult().get(i).setReceiptBalance(balance + "");
						page.getResult()
								.get(i)
								.setReceiptTime(
										DateTimeUtil.dateConvtoFmt(page
												.getResult().get(i)
												.getRefundtime(),
												"yyyy-MM-dd HH:mm:ss"));
					} else {
						page.getResult().get(i).setDeliverName("发货");
						page.getResult()
								.get(i)
								.setDeliverMoney(
										page.getResult().get(i).getMoney() + "");
						page.getResult()
								.get(i)
								.setDeliverBalance(
										page.getResult().get(i).getBalance()
												+ "");
						page.getResult()
								.get(i)
								.setDeliverTime(
										DateTimeUtil.dateConvtoFmt(
												page.getResult().get(i)
														.getAdtime(),
												"yyyy-MM-dd HH:mm:ss"));
						page.getResult().get(i).setReceiptName("");
						page.getResult().get(i).setReceiptMoney("");
						page.getResult().get(i).setReceiptBalance("");
						page.getResult().get(i).setReceiptTime("");
					}
					page.getResult().get(i).setMoney(null);
					page.getResult().get(i).setBalance(null);
					page.getResult().get(i).setStatus(null);
					page.getResult().get(i).setAdtime(null);
					page.getResult().get(i).setRefundtime(null);
				}
				return page;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 3.0订单列表界面
	@Override
	public Page<PSOrderList> orderList(Page<PSOrderList> page,
			List<PropertyFilter> filters, OrderListReq req) {
		String sql = "";
		try {
			if (req.getType() != null && req.getType().equals("1")) {
				sql = "SELECT t.order_num order_number,t.adtime,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,"
						+ "t.logistics_cost,t.pay_goods collection_delivery,t.status order_state from t_order t where t.uid='"
						+ req.getUid()
						+ "' AND t.status!='6'  order by adtime desc";
			} else if (req.getType() != null && req.getType().equals("2")) {
				sql = "SELECT t.order_num order_number,t.adtime,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,t.pay_goods collection_delivery,t.status order_state from t_order t where t.uid='"
						+ req.getUid()
						+ "' AND t.status='1'  order by adtime desc";
			} else if (req.getType() != null && req.getType().equals("3")) {
				sql = "SELECT t.order_num order_number,t.adtime,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,t.pay_goods collection_delivery,t.status order_state from t_order t where t.uid='"
						+ req.getUid()
						+ "' AND t.status in (2,4)  order by adtime desc";
			} else if (req.getType() != null && req.getType().equals("4")) {
				sql = "SELECT t.order_num order_number,t.adtime,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,t.pay_goods collection_delivery,t.status order_state from t_order t where t.uid='"
						+ req.getUid()
						+ "' AND t.status='3'  order by adtime desc";
			} else if (req.getType() != null && req.getType().equals("5")) {
				sql = "SELECT t.order_num order_number,t.adtime,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,t.pay_goods collection_delivery,t.status order_state from t_order t where t.uid='"
						+ req.getUid()
						+ "' AND t.status='5'  order by adtime desc";
			}
			getPage(PSOrderList.class, sql, page, filters);
			if (page.getResult() != null && page.getResult().size() > 0) {
				return page;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 3.3订单查询
	@Override
	public Page<PSOrderList> searchOrderInfo(Page<PSOrderList> page,
			List<PropertyFilter> filters, SearchOrderInfoReq req) {
		String sql = "";
		try {
			sql = "SELECT t.order_num order_number,t.adtime,t.sender_address,t.sender_name,t.sender_tel,"
					+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,"
					+ "t.pay_goods collection_delivery,"
					+ "t.status order_state from t_order t "
					+ "where (t.order_num='"+ req.getKeywords()+ "' OR "
					+ "t.logistics_order='"+ req.getKeywords()+ "' OR "
					+ "t.sender_tel='"+ req.getKeywords()+ "' OR "
					+ "t.reciver_tel='"+ req.getKeywords()+"') and t.status!=6 order by adtime desc";
			getPage(PSOrderList.class, sql, page, filters);
			if (page.getResult() != null && page.getResult().size() > 0) {
				return page;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 3.1详细的订单详情
	@Override
	public OrderDealInfo orderDetailInfo(String orderId) {
		OrderDealInfo orderDealInfo = new OrderDealInfo();
		String sql = null;
		try {
			sql = "SELECT order_num order_number,status distribution_state,sender_name,sender_tel sender_phone,sender_address,"
					+ "sender_post_code,reciver_name,reciver_tel reciver_phone,reciver_address,reciver_post_code,"
					+ "goods,volume,weight,pay_goods,logistics_collecting,advances,logistics_company_name,logistics_order,"
					+ "pay_goods pay_instead_receiving,logistics_cost pay_logistics,poundage,payment_amount,"
					+ "his_pay,adtime,deliver_time dtime,refundtime rtime FROM t_order WHERE order_num='"
					+ orderId + "'";
			orderDealInfo = getEntity(OrderDealInfo.class, sql, new Object[] {});
			if (orderDealInfo != null) {
				if (orderDealInfo.getAdtime() != null) {
					orderDealInfo.setPayTime(DateTimeUtil.dateConvtoFmt(
							orderDealInfo.getAdtime(), "yyyy-MM-dd HH:mm:ss"));
				}
				if (orderDealInfo.getDtime() != null) {
					orderDealInfo.setDeliverTime(DateTimeUtil.dateConvtoFmt(
							orderDealInfo.getDtime(), "yyyy-MM-dd HH:mm:ss"));
				}
				if (orderDealInfo.getRtime() != null) {
					orderDealInfo.setReciveTime(DateTimeUtil.dateConvtoFmt(
							orderDealInfo.getRtime(), "yyyy-MM-dd HH:mm:ss"));
				}
				// 如果订单已完成
				if ("3".equals(orderDealInfo.getDistributionState())) {
					Double yuMoney = Double
							.valueOf(orderDealInfo.getPayGoods())
							- Double.valueOf(orderDealInfo.getPaymentAmount())
							- Double.valueOf(orderDealInfo.getPoundage());
					orderDealInfo.setYuMoney(yuMoney + "");
					orderDealInfo.setTuiMoney("0");
				} else if ("5".equals(orderDealInfo.getDistributionState())) {
					Double tuiMoney = Double.valueOf(orderDealInfo
							.getPaymentAmount())
							+ Double.valueOf(orderDealInfo.getPoundage()) * 2;
					orderDealInfo.setTuiMoney(tuiMoney + "");
					orderDealInfo.setYuMoney("0");
				} else {
					orderDealInfo.setYuMoney("0");
					orderDealInfo.setTuiMoney("0");
				}
				orderDealInfo.setAdtime(null);
				orderDealInfo.setDtime(null);
				orderDealInfo.setRtime(null);
				return orderDealInfo;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 3.2 配送信息
	@Override
	public DeliverInfoRes deliverInfo(String orderId) {
		DeliverInfoRes res = new DeliverInfoRes();
		String sql = null;
		try {
			sql = "SELECT order_num order_number,t.adtime,t.deliver_time dtime,t.refundtime rtime,"
					+ "t.sender_city_code song_address,t.reciver_city_code shou_address,"
					+ "u.name distribution_name,u.loginname distribution_iphone,t.status order_state "
					+ "FROM t_order t "
					+ "LEFT JOIN sys_user u ON u.id=t.send_uid "
					+ "WHERE t.order_num='" + orderId + "'";
			res = getEntity(DeliverInfoRes.class, sql, new Object[] {});
			if (res != null) {
				if (res.getAdtime() != null) {
					res.setAdTime(DateTimeUtil.dateConvtoFmt(res.getAdtime(),
							"yyyy-MM-dd HH:mm:ss"));
				}
				if (res.getDtime() != null) {
					res.setDistributionTime(DateTimeUtil.dateConvtoFmt(
							res.getDtime(), "yyyy-MM-dd HH:mm:ss"));
				}
				if (res.getRtime() != null) {
					res.setEndTime(DateTimeUtil.dateConvtoFmt(res.getRtime(),
							"yyyy-MM-dd HH:mm:ss"));
				}
				res.setAdtime(null);
				res.setDtime(null);
				res.setRtime(null);
				return res;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}

	// 5.获取用户行业类别
	@Override
	public GetHangyeTypeRes getHangyeType() {
		GetHangyeTypeRes res = new GetHangyeTypeRes();
		List<HangyeBean> HangyeList = new ArrayList<HangyeBean>();
		String sql = null;
		try {
			sql = "SELECT name FROM t_hangye_type";
			HangyeList = getEntityList(HangyeBean.class, sql, new Object[] {});
			if (HangyeList != null && HangyeList.size() > 0) {
				res.setHangyeList(HangyeList);
				return res;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}

	// 7.将用户的弹窗状态改为1不弹窗
	@Override
	public boolean getTanType(String uid) {
		try {
			String sql3 = "UPDATE t_member SET tan_type=1 WHERE id = " + uid;
			getJt().update(sql3, new Object[] {});
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

}
