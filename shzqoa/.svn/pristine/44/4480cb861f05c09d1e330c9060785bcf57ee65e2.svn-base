<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>日简历份数统计</title>
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta charset="utf-8" />
  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" /> 
  <link rel="stylesheet" href="/views/resource/css/style.css">
  <script type="text/javascript" src="/views/resource/js/jquery-1.11.0.min.js"></script>
  <script type="text/javascript" src="/views/resource/layer/layer.js"></script>
  <script type="text/javascript">
	function togetListBypage(page){
		var url = "/dayrescount/dayrescountlist.do?page="+page;
		window.location.href=url;
	}
	function tonextpageInfo(page){
		var url = "/dayrescount/dayrescountlist.do?page="+(page+1);
		window.location.href=url;
	}
	function toprevpageInfo(page){
		var url = "/dayrescount/dayrescountlist.do?page="+(page-1);
		window.location.href=url;
	}
	function topageInfo(){
		var topage = $("#topage").val();
		var url = "/dayrescount/dayrescountlist.do?page="+topage;
		window.location.href=url;
	}
	var PAGE;
	if(PAGE){
		PAGE = null;
	}
	PAGE = {
		mod:{
			main:null
		},
		init:function(){
			this.mod.main.init();
		}	
	}
	PAGE.mod.main = {
		init:function(){
			var _this = this;
			_this.bindEvent();
		},
		formatDate:function(dateStr){
			var date = null;
			if(dateStr){
				var year = dateStr.split('-')[0];
				var month = dateStr.split('-')[1];
				var day = dateStr.split('-')[2];
				date = new Date(year,parseInt(month)-1,day,0,0,0);
			}
			return date;
		},
		bindEvent:function(){
			var _this = this;
			$('#toadd').off('click').on('click',function(){
				layer.open({
		            id:'iframetest',
		            type: 2,
		            title: '添加日简历数量统计',
		            maxmin: true, //开启最大化最小化按钮
		            area: ['1000px', '500px'],
		            content: '/dayrescount/toadddayrescount.do'
				});
			});
			$('.delButClass').off('click').on('click',function(){
				var aid = $(this).closest('tr').attr('aid');
				layer.confirm('确认删除？', {
						icon:0,
						title:'温馨提示',
						btn: ['确认','取消'] //按钮
					}, function(){
						_this.deleteData(aid);
				});
			});
			$('.editButClass').off('click').on('click',function(){
				var aid = $(this).closest('tr').attr('aid');
				layer.open({
		            id:'iframetest',
		            type: 2,
		            title: '修改日简历数量统计',
		            maxmin: true, //开启最大化最小化按钮
		            area: ['1000px', '500px'],
		            content: '/dayrescount/toupdaedayrescount.do?aid='+aid
				});
			});
		},
		deleteData:function(aid){
			$.ajax({
				url:'/dayrescount/delete.do',
				data:{
					aid:aid
				},
				type:'POST',
				dataType:'json',
				cache:false,
				success:function(res){
					if(res){
						if(res.status == 0){
							layer.msg(res.msg, {icon:1,time: 1000},function(){
								window.location.reload();
							});
						}else{
							layer.alert(res.msg, {
								icon:4,
								title:'温馨提示',
								skin: 'layui-layer-molv',
								closeBtn: 0
							});
						}
					}
				}
			});
		} 
	}
	$(function(){
		PAGE.init();
	});
	</script>
 </head>
 <body>
 <jsp:include page="/views/Top.jsp"></jsp:include>
   <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>日简历份数</span></h2>
          <div class="whh_tab_bor">
              <div class="zyh_sos mb10">
                   <span>简历来源：</span>
                   <select class="whh_sel" style="width: 150px;">
                   		<option value="">请选择</option>
                   		<c:forEach var="item"  items="${resumeSourceList}" >
                           		<option value='${item.resumesourceid}' >${item.resumesourcename}</option>
                          </c:forEach>
                   </select>
                  <input type="button" class="zyh_btn" value="搜索" onclick="">&nbsp;&nbsp;
                  <input type="button" class="zyh_btn ad" value="新增" id="toadd" onclick="">
              </div>
              <table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_tab1">
                <thead>
                  <tr>
                     <th width="25%">时间</th>
                     <th width="25%">简历来源</th>
                     <th width="25%">份数</th>
                     <th>操作</th>
                 </tr>
                </thead>
                <tbody>
                	<c:forEach var="item"  items="${list}" >
                     	<tr aid="${item.id}">
		                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.recorddate}" /></td>
		                     <td>
		                     	<c:forEach var="soureitem"  items="${resumeSourceList}" >
		                     		<c:if test="${soureitem.resumesourceid==item.resumesource}">
		                     			${soureitem.resumesourcename}
		                     		</c:if>
	                          	</c:forEach>
		                     </td>
		                     <td>${item.count}</td>
		                     <td>
		                     	<a class="delButClass" href="javascript:void(0);" onclick="">删除</a>&nbsp;&nbsp;
		                     	<a class="editButClass" href="javascript:void(0);">修改</a>
		                     </td>
		                 </tr>
                    </c:forEach>
                </tbody>
              </table>
              <!-- 页码开始 -->
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
              <!-- 页码结束 -->
          </div>

       </div>
   </div>
 </body>
</html>