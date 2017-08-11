<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>参数管理</title>
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
  <script type="text/javascript" src="/views/baseParameter/js/para.js"></script>
  <style type="text/css" rel="stylesheet">
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
	    width: 1000px;
	}
	.whh_input{width:170px;}
  </style>
  <script type="text/javascript">
  $(document).ready(function(){
	  initMemu(0,9);
  })
  function togetListBypage(page){
  	var url = "/basepara/parasList.do?page="+page;
  	window.location.href=url;
  }
  function tonextpageInfo(page){
  	var url = "/basepara/parasList.do?page="+(page+1);
  	window.location.href=url;
  }
  function toprevpageInfo(page){
  	var url = "/basepara/parasList.do?page="+(page-1);
  	window.location.href=url;
  }
  function topageInfo(){
  	var topage = $("#topage").val();
  	var url = "/basepara/parasList.do?page="+topage;
  	window.location.href=url;
  }
  
  function searchByCon(){
	  var parakindid = $("#parakindid").val().trim();
// 	  var searchid = $("#searchid").val().trim();
	  var searchname = $("#searchname").val().trim();
	  var url = "/basepara/parasList.do?searchid=0&searchname="+searchname+"&parakindid="+parakindid;
  		window.location.href=url;
  }
  function delInfoById(id){
	  $.ajax({
          type: "post",
          url: "/basepara/delparaById.do",
          data: {"id":id,},
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
  </script>
  
 </head>
 <body style="background: #fff; ">
 <input type="hidden" id="parakindid" value="${parakindid}">
	<div id="content-header">
	    <div id="breadcrumb"> 
	    	<a href="index.html" title="基本信息" class="tip-bottom"><i class="icon-home"></i>基本信息</a>
	     	<a href="" title="参数管理" class="current">参数管理</a>
	    </div>
	</div> 
	<div class="container-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>参数管理</h5>
            <button type="submit" class="btn btn-mini btn-success btn_fr layer_tj" id="toaddpara">添加</button>
          </div>
          <div class="widget-content clearfix">
            <!--查询条件-begin-->
            <div class="widget-search">
            	<span> 参数名称： </span> 
				<input type="text" class="zyh_txt whh_input"  id="searchname"  value=${searchname}> 
				<input type="button" class="searchButClass" value="搜索" onclick="searchByCon()">
            </div>
            <!--查询条件-end-->
            <table class="table table-bordered table-striped with-check">
              <thead>
                  <tr>
                     <th style="display:none;">参数ID</th>
                     <th>参数种类</th>
                     <th>参数名称</th>
                     <th>顺序</th>
                     <th>操作</th>
                 </tr>
                </thead>
                <tbody>
                <c:if test="${fn:length(list) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有参数信息</td>
				    </tr>
				</c:if>
	                <c:forEach var="item" begin="0" items="${list}" varStatus="status">
		                  <tr>
			                   <td style="display:none;"><a href="javascript:void(0);" onclick="toEdit('${item.id}')">${item.id}</a></td>
			                   <td>
			                   		<c:forEach items="${paraKindlsit}" var="parakinditem">
		                           		<c:if test="${parakinditem.parakindid==item.parakindid}">${parakinditem.parakindname}</c:if>
			                        </c:forEach>
			                   </td>
			                   <td>${item.name}</td>
			                   <td>${item.orderindex}</td>
			                   <td>
			                   		<a class="delButClass" href="javascript:void(0);" onclick="delInfoById(${item.id})">删除</a>
			                   		<a class="editButClass editpara" href="javascript:void(0);" >修改</a>
							   </td>
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
        </div>
  </div>
 
 
 
 
 
  <%--  <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>参数管理</span></h2>
          <div class="whh_tab_bor">
          	<div class="zyh_sos">
					<span> 参数名称： </span> 
					<input type="text" class="zyh_txt whh_input"  id="searchname"  value=${searchname}> 
					<input type="button" class="searchButClass" value="搜索" onclick="searchByCon()">
					<input type="button" class="searchButClass" id="toaddpara" value="新增" >
				</div>
       
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1" style="margin-top:10px;">
                <thead>
                  <tr>
                     <th style="display:none;">参数ID</th>
                     <th>参数种类</th>
                     <th>参数名称</th>
                     <th>顺序</th>
                     <th>操作</th>
                 </tr>
                </thead>
                <tbody>
                <c:if test="${fn:length(list) == 0}">
					<tr>
						<td colspan="12" style="text-align: center">没有参数信息</td>
				    </tr>
				</c:if>
	                <c:forEach var="item" begin="0" items="${list}" varStatus="status">
		                  <tr>
			                   <td style="display:none;"><a href="javascript:void(0);" onclick="toEdit('${item.id}')">${item.id}</a></td>
			                   <td>
			                   		<c:forEach items="${paraKindlsit}" var="parakinditem">
		                           		<c:if test="${parakinditem.parakindid==item.parakindid}">${parakinditem.parakindname}</c:if>
			                        </c:forEach>
			                   </td>
			                   <td>${item.name}</td>
			                   <td>${item.orderindex}</td>
			                   <td>
			                   		<a class="delButClass" href="javascript:void(0);" onclick="delInfoById(${item.id})">删除</a>
			                   		<a class="editButClass editpara" href="javascript:void(0);" >修改</a>
							   </td>
		                 </tr>
	                 </c:forEach>
                </tbody>
              </table>
              <!-- 页码部分-->
                <div class="od_pages clearfix">
                <div class="travels_diary_page">
                	<c:if test="${tatalpage>1 && currpage != 1}">
                		<span class="prev_page" onclick="toprevpageInfo(${currpage})"><em></em></span>
                	</c:if>
                  <c:if  test="${tatalpage<=3}">
	                  <c:forEach var="item" begin="1" end="${tatalpage}" varStatus="status">
	                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
	                  </c:forEach>
                  </c:if>
                  <c:if  test="${tatalpage>3}">
                  		<c:if test="${currpage>=3}">
                  			<c:if test="${currpage==tatalpage}">
                  				<c:forEach var="item" begin="${currpage-2}" end="${currpage}" varStatus="status">
			                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
			                    </c:forEach>
                  			</c:if>
                  			<c:if test="${currpage!=tatalpage}">
                  				<c:forEach var="item" begin="${currpage-1}" end="${currpage+1}" varStatus="status">
			                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
			                    </c:forEach>
                  			</c:if>
                  			
                  		</c:if>
                  		<c:if test="${currpage<3}">
	                  		<c:forEach var="item" begin="1" end="3" varStatus="status">
		                  		<a href="javascript:void(0);" class="<c:if test='${currpage==item}'>curr</c:if>" onclick="togetListBypage(${item})">${item}</a>
		                    </c:forEach>
	                    </c:if>
	                    <c:if test="${currpage != tatalpage}">
	                    	<span class="ellipsis">...</span>
	                    </c:if>
                  		
                  </c:if>
				  <c:if test="${tatalpage>1}">
				  		<c:if test="${currpage < tatalpage}">
				  			<span class="next_page" onclick="tonextpageInfo(${currpage})">下一页</span>
				  		</c:if>
	                  <span class="reach_desc">到</span>
	                  <input type="text" id="topage">
	                  <span class="confirm_btn" onclick="topageInfo()">确定</span>
				  </c:if>
                  
                </div>
              </div> 
          </div>

       </div>
   </div> --%>

 </body>
</html>