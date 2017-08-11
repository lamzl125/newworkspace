<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>录入考勤信息</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link href="/views/common/css/lanren.css" type="text/css" rel="stylesheet" />  
  <link rel="stylesheet" href="/views/common/css/bootstrap.min.css" />
  <link rel="stylesheet" href="/views/common/css/bootstrap-responsive.min.css" />
  <link rel="stylesheet" href="/views/common/css/matrix-style.css" /> <!-- 主体样式 -->
  <link rel="stylesheet" href="/views/common/css/matrix-media.css" /><!-- 侧边栏的补充样式 -->
  <link href="/views/common/font-awesome/css/font-awesome.css" rel="stylesheet" />
  <link rel="stylesheet" href="/views/common/css/zyh_style.css" />
  <link href="/views/common/css/bootstrap-table.css" rel="stylesheet" />
  <link href="/views/common/css/bootstrap-table-fixed-columns.css" rel="stylesheet" />
<link rel="stylesheet" href="/views/resource/layer/skin/layer.css">
<script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/bootstrap-table.js"></script>
  <script src="/views/common/js/bootstrap-table-fixed-columns.js"></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/jquery.validate.js"></script>
<script src="/views/resource/js/jquery.uploadify.min.js"></script>
<script src="/views/resource/js/holidaydata.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
	$(function() {
		//存放缓存，提交表单之后并清空
		  if(window.sessionStorage){
			  $('input').each(function(){
				  var name = $(this).attr('name');
				  var val = sessionStorage.getItem(name);
				  if(val){
					  if($(this).attr('type') == 'radio'){
						  $('input[name='+name+'][value='+val+']').trigger('click');
					  }else{
						  $(this).val(val);
					  }
				  }
			  });
			  $("select").each(function(){
				  var name = $(this).attr('name');
				  var val = sessionStorage.getItem(name);
				  if(val){
				 	 $(this).val(val);
				  }
		      });
			  $("input").change(function(){
		    	  var name =$(this).attr('name');
		    	  var value = $(this).val().trim();
		    	  sessionStorage.setItem(name,value);
		      });
		      $("select").change(function(){
		    	  var name =$(this).attr('name');
		    	  var value = $(this).val().trim();
		    	  sessionStorage.setItem(name,value);
		      });
		  }else{
			  alert('您的浏览器不支持缓存，请升级至最新版。');
		  }
		//
		
		
		jQuery.validator.methods.compareDate = function(value, element) {
			var curDate = new Date();
			var date = new Date(Date.parse(value));
			return value == null || value == '' || date < curDate;
		};
		$("#signupForm").validate({
			rules : {
				customerCode : {
					required : true
				},
				ifZZ : {
					required : true
				},
				xzTime : {
					required : true
				},
				xzFdTime : {
					required : true
				},
				jbHover : {
					required : true
				},
				qjTime : {
					required : true
				},
				cdTime : {
					required : true
				},
				sjTime : {
					required : true
				},
				fdTime : {
					required : true
				},
				sj : {
					 required : true
				},
				kjk : {
					required : true
				},
				kzs : {
					required : true
				},
				bxiao : {
					required : true
				},
				bxian : {
					required : true
				},
				bz : {
					required : true
				},
				kqtimeStr : {
					required : true,
					compareDate : true
				},
				syqTime : {
					required : true
				},
				syqFdTime : {
					required : true
				},
				kqSource : {
					required : true
				}
			},
			messages : {
				
				customerCode : {
					required : "请选择客户姓名"
				},
				ifZZ : {
					required : "请选择是否转正"
				},
				xzTime : {
					required : "请输入闲置出勤天数"
				},
				xzFdTime : {
					required : "请输入闲置法定出勤天数"
				},
				jbHover : {
					required : "加班小时"
				},
				qjTime : {
					required : "请假天数"
				},
				cdTime : {
					required : "迟到早退次数"
				},
				sjTime : {
					required : "入项实际出勤天数"
				},
				fdTime : {
					required : "入项法定出勤天数"
				},
				sj : {
					 required : "税金"
				},
				kjk : {
					required : "扣借款"
				},
				kzs : {
					required : "扣住宿"
				},
				bxiao : {
					required : "报销"
				},
				bxian : {
					required : "保险"
				},
				bz : {
					required : "补助"
				},
				kqtimeStr : {
					required : "考勤时间",
					compareDate : "考勤时间不能超过当前时间"
				},
				syqTime : {
					required : "试用期实际时间"
				},
				syqFdTime : {
					required : "试用期法定时间"
				},
				kqSource : {
					required : "考勤来源"
				}
			},
			submitHandler : function() {
				$("input[type='submit']").attr('disabled',true);
				$("input[type='submit']").css('background',"#CCCCFF");
				
				$.ajax({
					url : '/CustomerInfoKq/saveCustomerInfoKq.do',
					dataType : 'json',
					type : 'post',
					data : $('#signupForm').serialize(),
					success : function(result, status) {
						if (result.status == 0) {
							alert(result.msg);
							sessionStorage.clear();//清除缓存
							document.getElementById('signupForm').reset();//清空表单临时数据
						} else {
							alert(result.msg);
						}
					},
					error : function() {
						alert("添加失败！");
					}
				})
			}
		})
	});
	function showkqlist(){
		var url = "/CustomerInfoKq/customerInfoKqList.do";
		window.location.href=url;
	}
	function hideselect(){
		$("#customerCode").css("display","none"); 
		$("#customerName").css("display","block"); 
	}
	function showselect(obj){
		var textval = $(obj).val();
		$("#customerCode option").each(function(){
			var optext = $(this).text();
			if(optext.indexOf(textval)==-1){
				$(this).css("display","none");
			}else{
				$(this).css("display","block");
			}
		});
		$("#customerCode").css("display","block"); 
		$("#customerName").css("display","none"); 
	}
	
	function getlastmonth() {
		var currentYear=new Date().getFullYear();
		var currentMonth=new Date().getMonth()+1;  
		var lastMonth=new Date().getMonth();
		var currentDate=new Date().getDate();
		    var prevCurrentYear=0;
		    var prevCurrentMonth=0;
		    if(currentMonth==0){
		        prevCurrentYear=currentYear-1;
		        prevCurrentMonth=12;
		    }else{
		        prevCurrentYear=currentYear;
		        prevCurrentMonth=currentMonth-1;
		    }
		    var lastmonth=prevCurrentYear+"-"+p(prevCurrentMonth)+"-"+p(1);
		    return lastmonth;
	}
	function p(s) {
	    return s < 10 ? '0' + s: s;
	}
	$(document).ready(function(){
		var  lastmonthfirst = getlastmonth();
		$("#kqtimeStr").val(lastmonthfirst);
		var year = lastmonthfirst.substring(0,4);
		var month = lastmonthfirst.substring(5,7);		
		var daycount = getHoliday(parseInt(year),parseInt(month));
		$("#xzFdTime").val(daycount);
		$("#fdTime").val(daycount);
		$("#syqFdTime").val(daycount);
	})
	function changeyearmonth(){
		var kqtime = $("#kqtimeStr").val();
		var daycount = getHoliday(parseInt(kqtime.substring(0,4)),parseInt(kqtime.substring(5,7)));
		$("#xzFdTime").val(daycount);
		$("#fdTime").val(daycount);
		$("#syqFdTime").val(daycount);
	}
	$(document).ready(function(){
		  initMemu(5,0);
	})
</script>




<style>
.uploadify-button {
	border: none !important;
}


.whh_texts {
	position: absolute;
	left: 105px;
	top: 0;
	z-index: 1;
	height: 28px;
}

.whh_tab_bor {
	width: 560px;
	padding: 20px;
	margin: 0 auto;
}
</style>
</head>
<body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="考勤管理" class="tip-bottom"><i class="icon-home"></i>考勤管理</a>
	     	<a href="" title="录入考勤" class="current">录入考勤</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>录入考勤</h5>
          </div>
          <div class="widget-content clearfix">
             <form name="signupForm" method="post" id="signupForm" class="form-inline">
			       <div class="whh_content whh_content_border">
			          <div class="whh_tab_bor">
			              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
			                <tbody>
			                  	<tr>
				                   <td width="40%" class="whh_right">选择人员：</td>
				                   <td>
				                   		<input type="text" class="whh_input" id="customerName" name="customerName" onfocus="hideselect()" onblur="showselect(this)"/>
										<select class="whh_sel" id="customerCode" name="customerCode" style="display:none;" ondblclick="hideselect()">
											<option value="">--请选择--</option>
											<c:forEach items="${customerInfos }" var="info">
												<option value="${info.customercode }" <c:if test="${info.customercode==cuskq.customerCode }">selected</c:if>>${info.customername }</option>
											</c:forEach>
										</select>
				                   </td>
			               		</tr>
				                <tr>   
				                   <td class="whh_right"><span class="xing">*</span>考勤开始时间：</td>
				                   <td>
					                   <label class="whh_label"><input type="text"
										class="whh_input" placeholder="请输入考勤开始时间" name="kqtimeStr"
										id="kqtimeStr" onclick="WdatePicker()"
										onblur="$(this).trigger('change')" onchange="changeyearmonth()"></label>
				                   </td>
				                 </tr>
				                 <tr>
									<td class="whh_right"><span class="xing">*</span>考勤来源：</td>
									<td><select class="whh_sel" name="kqSource">
											<option value="">--请选择--</option>
											<option value=1 <c:if test="${1==cuskq.kqSource }">selected</c:if>>项上人员自己</option>
											<option value=2 <c:if test="${2==cuskq.kqSource }">selected</c:if>>公司客户</option>
									</select></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>是否转正：</td>
									<td><select class="whh_sel" name="ifZZ">
											<option value="">--请选择--</option>
											<option value=1 <c:if test="${1==cuskq.ifZZ }">selected</c:if>>已转正</option>
											<option value=2 <c:if test="${2==cuskq.ifZZ }">selected</c:if>>未转正</option>
											<option value=3 <c:if test="${3==cuskq.ifZZ }">selected</c:if>>本月转正</option>
									</select></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>闲置出勤天数：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入出勤天数" name="xzTime" id="xzTime" value="0" <%-- value=${cuskq.xzTime } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>闲置法定出勤天数：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入出勤天数" name="xzFdTime" id="xzFdTime" <%-- value=${cuskq.xzFdTime } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>加班小时：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入小时数" id="jbHover" name="jbHover" <%-- value=${cuskq.jbHover } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>请假天数：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入天数" name="qjTime" id="qjTime" <%-- value=${cuskq.qjTime } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>迟到早退天数：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入天数" name="cdTime" id="cdTime" value="0" <%-- value=${cuskq.cdTime } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>入项实际出勤天数：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入天数" name="sjTime" id="sjTime"  <%-- value=${cuskq.sjTime } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>入项法定出勤天数：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入天数" name="fdTime" id="fdTime" <%-- value=${cuskq.fdTime } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>税金：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入金额" name="sj" id="sj" <%--  value=${cuskq.sj } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>扣借款：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入金额" name="kjk" id="kjk" value="0" <%-- value=${cuskq.kjk } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>扣住宿：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入金额" id="kzs" name="kzs" value="0" <%-- value=${cuskq.kzs } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>报销：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入金额" name="bxiao" id="bxiao" value="0" <%-- value=${cuskq.bxiao } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>保险：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入金额" name="bxian" id="bxian" <%-- value=${cuskq.bxian } --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>补助：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入金额" id="bz" name="bz" <%-- value=${cuskq.bz }  --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>试用期实际工作时间：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入天数" id="syqTime" name="syqTime" value="0" <%-- value=${cuskq.syqTime }  --%>></label></td>
								</tr>
								<tr>
									<td class="whh_right"><span class="xing">*</span>试用期法定工作时间：</td>
									<td><label class="whh_label"><input type="text"
											class="whh_input" placeholder="请输入天数" id="syqFdTime" name="syqFdTime" <%-- value=${cuskq.syqFdTime } --%> ></label></td>
								</tr>
			                </tbody>
			              </table>
			              
			              <p style="text-align: center;">
								<input type="submit"
									class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="保存">
									<input type="button"
									class="whh_btn whh_btn_big mt20 whh_btn_big_blue" value="考勤列表"  onclick="showkqlist();">
						  </p>
			          </div>
			       </div>
			   </form>
          </div>
        </div>
  </div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$(".zyh_buxian").click(function() {
			$(".xuqiu").toggle();
		});
	});
</script>
</body>
</html>