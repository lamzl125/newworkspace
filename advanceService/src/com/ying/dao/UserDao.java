package com.ying.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springside.modules.orm.Page;
import org.springside.modules.orm.PropertyFilter;
import org.utils.Logs;

import push.PushExample;

import cn.jpush.api.push.PushResult;
import cn.jpush.api.utils.StringUtils;

import com.ying.app.bean.CustomerListBean;
import com.ying.app.bean.MoneyListBean;
import com.ying.app.bean.PSOrder;
import com.ying.app.bean.PSOrderList;
import com.ying.app.bean.PSOrderListBean;
import com.ying.app.bean.User;
import com.ying.app.bean.UserInfo;
import com.ying.app.req.ConfiFinishReq;
import com.ying.app.req.PseditUserInfoDeatilReq;
import com.ying.app.req.PsforgetPasswordReq;
import com.ying.app.req.PsorderDetailReq;
import com.ying.app.req.PsrecordListReq;
import com.ying.app.req.PsuerLoginReq;
import com.ying.app.res.GetWalletMoneyRes;
import com.ying.app.res.PsuserRecordRes;
import com.ying.entity.Member;
import com.ying.entity.Order;
import com.ying.entity.Tlogistics;
import com.ying.service.IMemberService;

@Repository
public class UserDao extends EntityDao implements IUserDao {

	@Autowired
	private IMemberService memberService;

	@Override
	public User queryByMobielOrEmail(String str) {
		User res = new User();
		String sql = "";
		try {
			sql = "select t.id uid,t.name user_name,t.icon user_icon,t.password,t.loginname phone_num,t.recommendnum recommend_num  from sys_user t where loginname="
					+ str;
			res = getEntity(User.class, sql, new Object[] {});
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}

	@Override
	public User queryByUserId(String str) {
		User res = new User();
		String sql = "";
		try {
			sql = "select t.id uid,t.name user_name,t.icon user_icon,t.password,t.loginname phone_num,t.recommendnum recommend_num,t.logistics,t.log_name  from sys_user t where id="
					+ str;
			res = getEntity(User.class, sql, new Object[] {});
		} catch (Exception e) {
			Logs.error(e);
		}
		return res;
	}

	@Override
	public void saveSubmitInfo(PsuerLoginReq req) {
		try {
			String sql = "UPDATE sys_user SET token=? WHERE id=? ";
			getJt().update(sql,
					new Object[] { req.getToken(), req.getPhoneNum() });
		} catch (Exception e) {
			Logs.error(e);
		}
	}

	@Override
	public boolean updatephone(PsforgetPasswordReq req) {
		try {
			String sql = "UPDATE sys_user SET loginname=? WHERE loginname=? ";
			getJt().update(sql,
					new Object[] { req.getPassword(), req.getPhoneNum() });
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	@Override
	public boolean upPhoneNum(User u, String phoneNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upPwd(User u, String newPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateinfo(PseditUserInfoDeatilReq req) {
		try {
			if (req.getUserName() != null && !"".equals(req.getUserName())) {
				String sql = "UPDATE sys_user SET name=? WHERE id=? ";
				getJt().update(sql,
						new Object[] { req.getUserName(), req.getUid() });
			}
			if (req.getUserTel() != null && !"".equals(req.getUserTel())) {
				String sql = "UPDATE sys_user SET loginname=? WHERE id=? ";
				getJt().update(sql,
						new Object[] { req.getUserTel(), req.getUid() });
			}
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	@Override
	public boolean saveUserIcon(String uid, String icon) {
		try {
			String sql = "UPDATE sys_user SET icon=? WHERE id=? ";
			getJt().update(sql, new Object[] { icon, uid });
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	@Override
	public boolean updatepassword(String phone, String password) {
		try {
			String sql = "UPDATE sys_user SET password=? WHERE loginname=? ";
			getJt().update(sql, new Object[] { password, phone });
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 2.0订单列表（首页）
	@Override
	public Page<PSOrderListBean> psorderList(Page<PSOrderListBean> page,
			List<PropertyFilter> filters, String logistics, String type,
			String logName) {
		String sql = "";
		try {
			if (type != null && type.equals("1")) {
				sql = "SELECT t.order_num order_number,t.adtime date_time,t.deliver_time,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,"
						+ "t.pay_goods collection_delivery,t.status order_state from "
						+ "t_order t where t.log_name='"
						+ logName
						+ "' AND t.logistics_company_name='"
						+ logistics
						+ "' AND t.status!=6 order by adtime desc";
				getPage(PSOrderListBean.class, sql, page, filters);
			} else if (type != null && type.equals("2")) {
				sql = "SELECT t.order_num order_number,t.adtime date_time,t.deliver_time,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,"
						+ "t.pay_goods collection_delivery,t.status order_state from "
						+ "t_order t where t.log_name='"
						+ logName
						+ "' AND t.logistics_company_name='"
						+ logistics
						+ "' AND t.status!=6 AND t.status=1 order by adtime desc";
				getPage(PSOrderListBean.class, sql, page, filters);
			} else if (type != null && type.equals("3")) {
				sql = "SELECT t.order_num order_number,t.adtime date_time,t.deliver_time,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,"
						+ "t.pay_goods collection_delivery,t.status order_state from "
						+ "t_order t where t.log_name='"
						+ logName
						+ "' AND t.logistics_company_name='"
						+ logistics
						+ "' AND t.status in (2,4) order by adtime desc";
				getPage(PSOrderListBean.class, sql, page, filters);
			} else if (type != null && type.equals("4")) {
				sql = "SELECT t.order_num order_number,t.adtime date_time,t.deliver_time,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,"
						+ "t.pay_goods collection_delivery,t.status order_state from "
						+ "t_order t where t.log_name='"
						+ logName
						+ "' AND t.logistics_company_name='"
						+ logistics
						+ "' AND t.status='3' order by adtime desc";
				getPage(PSOrderListBean.class, sql, page, filters);
			} else if (type != null && type.equals("5")) {
				sql = "SELECT t.order_num order_number,t.adtime date_time,t.deliver_time,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,"
						+ "t.pay_goods collection_delivery,t.status order_state from "
						+ "t_order t where t.log_name='"
						+ logName
						+ "' AND t.logistics_company_name='"
						+ logistics
						+ "' AND t.status='5' order by adtime desc";
				getPage(PSOrderListBean.class, sql, page, filters);
			}
			if (page.getResult() != null && page.getResult().size() > 0) {
				return page;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 2.0订单列表（我的） 先查询时间
	@Override
	public Page<PSOrder> psrecordList(Page<PSOrder> page,
			List<PropertyFilter> filters, Long uid, String type) {
		String sql = "";
		try {
			if (type != null && type.equals("1")) {
				sql = "SELECT t.adtime orderdate from t_order t WHERE t.revive_uid="
						+ uid + " AND t.status!=6 order by adtime desc";
			} else if (type != null && type.equals("2")) {
				sql = "SELECT t.adtime orderdate from t_order t WHERE t.send_uid="
						+ uid + " AND t.status!=6 order by adtime desc";
			} else if (type != null && type.equals("3")) {
				sql = "SELECT t.adtime orderdate from t_order t WHERE (t.revive_uid="
						+ uid
						+ " or t.send_uid="
						+ uid
						+ ") AND t.status=3 order by adtime desc";
			} else if (type != null && type.equals("4")) {
				sql = "SELECT t.adtime orderdate from t_order t WHERE (t.revive_uid="
						+ uid
						+ " or t.send_uid="
						+ uid
						+ ") AND t.status=5 order by adtime desc";
			}
			getPage(PSOrder.class, sql, page, filters);
			if (page.getResult() != null && page.getResult().size() > 0) {
				return page;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 2.0订单列表（我的） 根据时间列表查询数据
	@Override
	public List<PSOrderListBean> psorderListinfo(String date,
			PsrecordListReq req) {
		List<PSOrderListBean> list = new ArrayList<PSOrderListBean>();
		String sql = "";
		try {
			if (req.getType() != null && req.getType().equals("1")) {
				sql = "SELECT t.id order_i_d,t.order_num order_number,t.adtime date_time,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,"
						+ "t.pay_goods collection_delivery,t.status order_state from t_order t "
						+ "WHERE t.revive_uid='"
						+ req.getUid()
						+ "' "
						+ "AND t.adtime LIKE '%" + date + "%'";
				list = getEntityList(PSOrderListBean.class, sql,
						new Object[] {});
			} else if (req.getType() != null && req.getType().equals("2")) {
				sql = "SELECT t.id order_i_d,t.order_num order_number,t.adtime date_time,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,"
						+ "t.pay_goods collection_delivery,t.status order_state from t_order t "
						+ "WHERE t.send_uid='"
						+ req.getUid()
						+ "' "
						+ "AND t.adtime LIKE '%" + date + "%'";
				list = getEntityList(PSOrderListBean.class, sql,
						new Object[] {});
			} else if (req.getType() != null && req.getType().equals("3")) {
				sql = "SELECT t.id order_i_d,t.order_num order_number,t.adtime date_time,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,"
						+ "t.pay_goods collection_delivery,t.status order_state from t_order t "
						+ "WHERE (t.revive_uid="
						+ req.getUid()
						+ " or t.send_uid='"
						+ req.getUid()
						+ "') AND t.status=3 "
						+ "AND t.adtime LIKE '%"
						+ date
						+ "%'";
				list = getEntityList(PSOrderListBean.class, sql,
						new Object[] {});
			} else if (req.getType() != null && req.getType().equals("4")) {
				sql = "SELECT t.id order_i_d,t.order_num order_number,t.adtime date_time,t.sender_address,t.sender_name,t.sender_tel,"
						+ "t.reciver_address,t.reciver_name,t.reciver_tel,t.logistics_cost,"
						+ "t.pay_goods collection_delivery,t.status order_state from t_order t "
						+ "WHERE (t.revive_uid="
						+ req.getUid()
						+ " or t.send_uid='"
						+ req.getUid()
						+ "') AND t.status=5 "
						+ "AND t.adtime LIKE '%"
						+ date
						+ "%'";
				list = getEntityList(PSOrderListBean.class, sql,
						new Object[] {});
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return list;
	}

	// 3.5 派件
	@Override
	public boolean paiOrder(String orderId, String uid) {
		try {
			String sql = "UPDATE t_order SET status=?,send_uid=?,deliver_time=? WHERE order_num=? ";
			getJt().update(sql, new Object[] { 4, uid, new Date(), orderId });
			Order order = getOrder(orderId);
			Member m = memberService.queryByUid(order.getUid());
			// 消息记录
			String sql4 = "insert into t_sysmsg (uid,message_title,message_content,adtime)value(?,?,?,?)";
			getJt().update(
					sql4,
					new Object[] { order.getUid(), "订单派件",
							"您的订单" + order.getOrderNum() + "已开始派件", new Date() });
			// 推送--派件
			Logs.info("=========消息推送：");
			String title = "发货e宝";
			String text = "您的订单:" + order.getOrderNum() + ",正在派件中，请注意查收！";
			String token;
			if (!StringUtils.isEmpty(m.getToken())) {
				token = m.getToken();
				Logs.info("用户[" + m.getId() + "]的token值是：" + token);
				try {
					PushResult result = new PushExample().registerTitle(title,
							text, token);
					Logs.warn(result.toString());
				} catch (Exception e) {
					Logs.warn("推送失败!");
				}
			} else {
				Logs.warn("获取token值失败!");
			}
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 2.0删除订单
	@Override
	public boolean psdeleteOrderId(String orderId) {
		try {
			String sql = "UPDATE t_order SET status=? WHERE order_num=? ";
			getJt().update(sql, new Object[] { 6, orderId });
			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 1.1.0 获取个人记录
	@Override
	public PsuserRecordRes psuserRecord(String uid) {
		PsuserRecordRes res = new PsuserRecordRes();
		try {
			String sql1 = "SELECT count(*) from t_order t WHERE t.revive_uid="
					+ uid;
			int reviveNum = getJt().queryForInt(sql1);
			if (reviveNum > 0) {
				res.setReviveNum(reviveNum + "");
			} else {
				res.setReviveNum("0");
			}
			String sql2 = "SELECT count(*) from t_order t WHERE t.send_uid="
					+ uid;
			int sendNum = getJt().queryForInt(sql2);
			if (sendNum > 0) {
				res.setSendNum(sendNum + "");
			} else {
				res.setSendNum("0");
			}
			String sql3 = "SELECT count(*) from t_order t WHERE (t.revive_uid="
					+ uid + " or t.send_uid=" + uid + ") AND t.status=3";
			int finishNum = getJt().queryForInt(sql3);
			if (finishNum > 0) {
				res.setFinishNum(finishNum + "");
			} else {
				res.setFinishNum("0");
			}
			String sql4 = "SELECT count(*) from t_order t WHERE (t.revive_uid="
					+ uid + " or t.send_uid=" + uid + ") AND t.status=5";
			int chargebackNum = getJt().queryForInt(sql4);
			if (chargebackNum > 0) {
				res.setChargebackNum(chargebackNum + "");
			} else {
				res.setChargebackNum("0");
			}
			return res;
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}

	// 3.1 我的客户
	@Override
	public Page<CustomerListBean> pscustomerList(Page<CustomerListBean> page,
			List<PropertyFilter> filters, String uid) {
		try {
			String sql = "SELECT id customer_id,user_name name,adtime,user_address area,user_icon img FROM t_member WHERE recommended_code="
					+ uid;
			getPage(CustomerListBean.class, sql, page, filters);
			if (page.getResult() != null && page.getResult().size() > 0) {
				return page;
			}
		} catch (Exception e) {
			Logs.error(e);
		}
		return null;
	}


	//2.1订单详情-揽件
		@Override
		public boolean psorderDetailInfoRevive(PsorderDetailReq req) {
			try{		
				String sql="UPDATE t_order SET status=?,revive_uid=?,logistics_order=?,logistics_cost=? WHERE order_num=? ";
				getJt().update(sql,new Object[]{2,req.getUid(),req.getOrderNumber(),req.getPayTotal(),req.getOrderId()});
				//揽件成功之后     修改发件人的用户余额    为当前余额加上垫付金额
				//根据订单号查询订单的数据
				Order order = getOrder(req.getOrderId());
				Member m = null;
				m= memberService.queryByUid(order.getUid());
				if ("1".equals(order.getAdvances())) {
					Double blance = Double.valueOf(m.getBalance());	//用户当前余额
					Double paymentAmount = Double.valueOf(order.getPaymentAmount());	//平台垫付的金额
					Double money=blance+paymentAmount;
					String sql2="UPDATE t_member SET balance=? WHERE id = "+order.getUid();
					getJt().update(sql2,new Object[]{money+""});
					//插入金额变动记录到  明细表t_member_detaile
					String sql5="insert into t_member_detaile (uid,type,money,adtime)value(?,?,?,?)";
					getJt().update(sql5,new Object[]{req.getUid(),1,paymentAmount+"",new Date()});
				}
				// 推送-揽件
				Logs.info("=========消息推送：");
				String title = "发货e宝";
				String text = "您的订单:" + order.getOrderNum() + "已经揽件，请等待配送员上门取货！";
				String token;
				if (!StringUtils.isEmpty(m.getToken())) {
					token = m.getToken();
					Logs.info("用户[" + m.getId() + "]的token值是：" + token);
					try {
						PushResult result = new PushExample().registerTitle(title,
								text, token);
						Logs.warn(result.toString());
					} catch (Exception e) {
						Logs.warn("推送失败!");
					}
				} else {
					Logs.warn("获取token值失败!");
				}
				
				return true;
			}catch(Exception e){
				Logs.error(e);
			}
			return false;
		}
	
	// 2.2订单详情-确认完成和退款
	@Override
	public boolean psorderDetailInfoConfiFinish(ConfiFinishReq req) {
		try {

			String title = "发货e宝";
			String token;
			String text;
			// 根据订单号查询订单的数据
			Order order = getOrder(req.getOrderId());
			// 查询物流公司信息
			String sql3 = "SELECT * from t_logistics WHERE log_name ='"
					+ order.getLogisticsCompanyName() + "'";
			Tlogistics tlog = getEntity(Tlogistics.class, sql3, new Object[] {});
			Member m = memberService.queryByUid(order.getUid());
			// 无论订单成功还是失败 都返还用户的垫付额度 原来的额度加上该订单垫付的额度
			Double remaining = Double.valueOf(order.getPaymentAmount())
					+ Double.valueOf(m.getQuotaRemaining());
			String sql = "UPDATE t_member SET quota_remaining=? WHERE id=? ";
			getJt().update(sql, new Object[] { remaining + "", order.getUid() });
			if ("0".equals(req.getType())) {// 送货成功
				text="您的订单:"+order.getOrderNum()+"已送货成功";
				// 如果是扫码付款 钱到了平台 就直接修改订单状态 生成用户的消费记录 扣除尾款的手续费后 给用户加上尾款
				// 修改状态为已完成
				String sql1 = "UPDATE t_order SET status=?,pay_type=?,refundtime=? WHERE order_num=? ";
				getJt().update(
						sql1,
						new Object[] { 3, req.getChannel(), new Date(),
								req.getOrderId() });
				// 扣除尾款的手续费后 给用户加上尾款
				Double weiMoney = Double.valueOf(order.getPayGoods())
						- Double.valueOf(order.getPaymentAmount())
						- Double.valueOf(order.getPoundage());
				Double balance = Double.valueOf(m.getBalance()) + weiMoney;
				String sql2 = "UPDATE t_member SET balance=? WHERE id=? ";
				getJt().update(sql2,
						new Object[] { balance + "", order.getUid() });
				// 生成用户的消费记录
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("uid", order.getUid());
				pa.put("type", 3);
				pa.put("money", weiMoney + "");
				pa.put("adtime", new Date());
				Long id = insert(pa, "t_member_detaile");
				if ("2".equals(req.getChannel())) {// 其他支付
					// 如果是其他支付 钱在物流公司 从物流公司扣除全部的货款
					Double wuliuMoney = Double.valueOf(tlog.getBalance())
							- Double.valueOf(order.getPayGoods());
					String sql4 = "UPDATE t_logistics SET balance=? WHERE id=? ";
					getJt().update(sql4,
							new Object[] { wuliuMoney + "", tlog.getId() });
					// 插入物流消费记录到t_logistics_money表
					Map<String, Object> pp = new HashMap<String, Object>();
					pp.put("log_id", tlog.getId());
					pp.put("type", 1);
					pp.put("money", order.getPayGoods() + "");
					pp.put("adtime", new Date());
					Long ids = insert(pp, "t_logistics_money");
				}
				// 消息记录
				String sql4 = "insert into t_sysmsg (uid,message_title,message_content,adtime)value(?,?,?,?)";
				getJt().update(
						sql4,
						new Object[] { order.getUid(), "订单完成",
								"您的订单" + order.getOrderNum() + "已成功送达",
								new Date() });
			} else {
				// 推送
				text="您的订单:"+order.getOrderNum()+"对方拒绝签收，正在返件！原因是:"+req.getRefundDes();
				// 退货 添加用户明细表 判断用户是否选择 算出双倍的手续费和对应的物流费 从用户表中扣除 如果垫付还要扣除垫付的金额
				// 修改状态为已退货
				String sql2 = "UPDATE t_order SET status=?,refundtime=?,refund_des=? WHERE order_num=? ";
				getJt().update(
						sql2,
						new Object[] { 5, new Date(), req.getRefundDes(),
								req.getOrderId() });
				// 生成用户的消费记录
				// Double wuliuMoney=0.0;
				// if ("1".equals(order.getHisPay())) {//物流费自付 退款扣除回来的物流费
				// wuliuMoney = Double.valueOf(order.getLogisticsCost());
				// }else if ("2".equals(order.getHisPay())) {//物流费到付 退款扣除来回的物流费
				// wuliuMoney = Double.valueOf(order.getLogisticsCost())*2;
				// }
				Double kouMoney = Double.valueOf(order.getPaymentAmount())
						+ Double.valueOf(order.getPoundage()) * 2;
				Double weiMoney = Double.valueOf(m.getBalance()) - kouMoney;
				String sql1 = "UPDATE t_member SET balance=? WHERE id=? ";
				getJt().update(sql1,
						new Object[] { weiMoney + "", order.getUid() });
				// 修改订单中的手续费为双倍的手续费
				String sql5 = "UPDATE t_order SET poundage=? WHERE id=? ";
				Double poundage = Double.valueOf(order.getPoundage()) * 2;
				getJt().update(sql5,
						new Object[] { poundage + "", req.getOrderId() });
				Map<String, Object> pa = new HashMap<String, Object>();
				pa.put("uid", order.getUid());
				pa.put("type", 2);
				pa.put("money", weiMoney + "");
				pa.put("adtime", new Date());
				Long id = insert(pa, "t_member_detaile");
				// 消息记录
				String sql4 = "insert into t_sysmsg (uid,message_title,message_content,adtime)value(?,?,?,?)";
				getJt().update(
						sql4,
						new Object[] {
								order.getUid(),
								"订单退货",
								"您的订单" + order.getOrderNum()
										+ "对方拒绝签收，正在返件！原因是："
										+ req.getRefundDes(), new Date() });
			}
			// 推送

			if (!StringUtils.isEmpty(m.getToken())) {
				token = m.getToken();
				Logs.info("用户[" + m.getId() + "]的token值是：" + token);
				try {
					PushResult result = new PushExample().registerTitle(title,
							text, token);
					Logs.warn(result.toString());
				} catch (Exception e) {
					Logs.warn("推送失败!");
				}
			} else {
				Logs.warn("获取token值失败!");
			}

			return true;
		} catch (Exception e) {
			Logs.error(e);
		}
		return false;
	}

	// 根据订单号查询订单数据
	@Override
	public Order getOrder(String orderId) {
		Order order = new Order();
		try {
			String sql = "SELECT * from t_order WHERE order_num ='" + orderId
					+ "'";
			order = getEntity(Order.class, sql, new Object[] {});
			return order;
		} catch (Exception e) {
			Logs.error(e);
		}
		return order;
	}

}
