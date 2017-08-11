<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>合作公司--联系人管理</title>
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
  <script src="/views/common/js/jquery.min.js" ></script>
  <script src="/views/common/js/initMenu.js" type="text/javascript"></script>
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  
  <script src="/views/common/js/jquery.validate.js"></script>
  <style type="text/css">
  .zyh_btn{
	    width: 30px;
	    height: 30px;
	    font-size: 16px;
	    background-color: #009FE8;
	    border: none;
	    color: #fff;
	}
	.zyh_sos{
	   margin: 0 auto;
	    width: 900px;
	}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(0,2);
  })
  function addCorpProject(){
	   	  var corpCode = $("#corpCode").val().trim();
		  var ContanName = $("#ContanName").val().trim();
		  var ContTel = $("#ContTel").val().trim();
		  var ConPhone = $("#ConPhone").val();
		  var ContOfficeTel = $("#ContOfficeTel").val();
		  var QQ = $("#QQ").val();
		  var WeiXin = $("#WeiXin").val();
		  var Remark = $("#Remark").val();
		  
	  var data = {
			  	"corpCode": corpCode,
				 "ContanName":ContanName,
				 "ContTel": ContTel,
				 "ConPhone": ConPhone,
				 "ContOfficeTel": ContOfficeTel,
				 "QQ": QQ,
				 "WeiXin": WeiXin,
				 "Remark": Remark,
			/*  "corpCode": corpCode,
			 "corpProjectName":corpProjectName,
			 "starttime": starttime,
			 "endtime": endtime, */
	  }
	  $.ajax({
          type: "post",
          url: "/corpProject/savecorpcontant.do",
          data: data,
          dataType: "json",
          success: function(result){
         	 if(result.status == 0){
         		 alert(result.msg);
         		 parent.location.reload();
         	 }else{
         		 alert(result.msg);
         	 }
          }
      });
  }
  function togetListBypage(page){
	  var corpCode = $("#corpCode").val();
  	var url = "/corpProject/togetcorpcontantList.do?corpCode="+corpCode+"&page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
	  var corpCode = $("#corpCode").val();  
  	var url = "/corpProject/togetcorpcontantList.do?corpCode="+corpCode+"&page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
	  var corpCode = $("#corpCode").val();  
  	var url = "/corpProject/togetcorpcontantList.do?corpCode="+corpCode+"&page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
	  var corpCode = $("#corpCode").val();  
  	var topage = $("#topage").val();
  	var url = "/corpProject/togetcorpcontantList.do?corpCode="+corpCode+"&page="+topage;
  	window.location.href=url;
  }
  function deletecontent(Id){
	  $.ajax({
          type: "post",
          url: "/corpProject/deletecontent.do",
          data: {"Id":Id},
          dataType: "json",
          success: function(result){
         	 if(result.status == 0){
         		 alert(result.msg);
         		 parent.location.reload();
         	 }else{
         		 alert(result.msg);
         	 }
          }
      });
	 /*  var url = "/corpProject/deletecontent.do?Id="+Id;
	  	window.location.href=url; */
  }
  function openmodify(Id) {
			layer.open({
				type : 2,
				title : '修改联系人信息',
				area : [ '600px', '400px' ],
				move : false, 	
				content : [ '/corpProject/openmodify.do?Id='+Id, 'yes' ]
			});
		}
	
  </script>
  
 </head>
 <body>
<jsp:include page="/views/common/Top.jsp"></jsp:include>
<jsp:include page="/views/common/Left.jsp"></jsp:include>
<input type="hidden" id="corpCode" value="${corpcode}"/>
<div id="content">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="基本信息" class="tip-bottom"><i class="icon-home"></i>基本信息</a>
	     	<a href="" title="合作公司--联系人管理" class="current">合作公司--联系人管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>合作公司--联系人管理</h5>
          </div>
          <div class="widget-content clearfix">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th>#</th><th>联系人姓名</th><th>固定电话</th><th>手机</th><th>办公电话</th>
                  <th>QQ</th><th>微信</th><th>备注</th><th>操作</th>
                </tr>
              </thead>
              <tbody>
              	<c:if test="${fn:length(list) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有合作公司信息</td>
				    </tr>
				</c:if>
				<c:forEach var="item" begin="0" items="${list}" varStatus="status">
	                  <tr>
	                  	   <td>${status.index+1}</td>
	                  	   <td width="30%">${item.ContanName}</td>
		                   <td>${item.ContTel}</td>
		                   <td>${item.ConPhone}</td>
		                   <td>${item.ContOfficeTel}</td>
		                   <td>${item.QQ}</td>
		                   <td>${item.WeiXin}</td>
		                   <td>${item.Remark}</td>
		                   <td><input type="button" value="删除" onclick="deletecontent('${item.Id}')"/>&nbsp;<input type="button" value="修改" onclick="openmodify('${item.Id}')"/></td>
	                 </tr>
                 </c:forEach>
              </tbody>
            </table>
            <!--分页-->
            <div class="pagination alternate page_fr">
              <ul>
                <li <c:if test="${currpage==null || currpage<=1}">class="disabled"</c:if>><a href="javascript:void(0)" onclick="toprevpageInfo(${currpage})">Prev</a></li>
               	<li class="active"> <a href="javascript:void(0)" onclick="togetListBypage(${currpage})">${currpage}</a> </li>
                <c:if test="${tatalpage>=(currpage+1)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+1})">${currpage+1}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+2)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+2})">${currpage+2}</a> </li>
                </c:if>
                <c:if test="${tatalpage>=(currpage+3)}">
                	<li> <a href="javascript:void(0)" onclick="togetListBypage(${currpage+3})">${currpage+3}</a> </li>
                </c:if>
                <li><a href="javascript:void(0)" onclick="tonextpageInfo(${currpage})">Next</a></li>
              </ul>
            </div>
          </div>
          <div class="whh_tab_bor">
            <div class="zyh_sos">
                <span>联系人姓名：</span>
                <input type="text" class="whh_input" id="ContanName" placeholder="输入联系人姓名">
        		<span>固定电话： </span>
                <input type="text" class="whh_input" placeholder="请输入固定电话" id="ContTel" />
                <span>手机：</span>
               	<input type="text" class="whh_input" placeholder="请输入手机" id="ConPhone" />	
            </div>
            <div class="zyh_sos" >
                <span>办公电话：&nbsp;&nbsp;&nbsp;</span>
                <input type="text" class="whh_input" id="ContOfficeTel" placeholder="输入办公电话">
                 <span>QQ：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <input type="text" class="whh_input" id="QQ" placeholder="输入QQ">
                 <span>微信：</span>
                <input type="text" class="whh_input" id="WeiXin" placeholder="输入微信">
            </div>
            <div class="zyh_sos" >
                 <span>备注：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <input type="text" class="whh_input" id="Remark" placeholder="输入项目名称">
                <input type="button" class="zyh_btn" onclick="addCorpProject()" value="+">
            </div>
          </div>
        </div>
  </div>
</div>
</body>
</html>