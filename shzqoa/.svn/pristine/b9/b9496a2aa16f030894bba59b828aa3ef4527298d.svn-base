<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <head> 
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <title>招聘需求信息</title>
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
  <script src="/views/common/js/bootstrap.min.js"></script> 
  <script src="/views/common/js/matrix.js"></script> 
  <script src="/views/common/js/layer-v2.3/layer/layer.js"></script> 
  <script src="/views/common/js/my97/WdatePicker.js" type="text/javascript"></script>
  <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
  <style>
.widget-box{ margin-top:10px; margin-bottom:0;}
.form-actions{ text-align:center;}
.form-horizontal .control-label{width: 320px;}
.form-horizontal .controls{margin-left: 339px;}
.span11.zyh_cursor{ cursor:pointer;}
</style>
  <script type="text/javascript">  
  function saveInfo(){
	  	  var demandStatus=$("#demandStatus").val();
	  	  var otherSubsidies = $("#otherSubsidies").val();	
	  	  var fringeBenefit = $("#fringeBenefit").val();		  		  
		  var transportationAllowance = $("#transportationAllowance").val();			  
		  var accommodation = $("#accommodation").val();		  
		  var mealSupplement = $("#mealSupplement").val();		  
		  var overtimePay = $("#overtimePay").val();			  
		  var monthWage = $("#monthWage").val();		  
		  var hourlyWage = $("#hourlyWage").val();		  
		  var workArea = $("#workArea").val();	
		  var workContent = $("#workContent").val();		  
		  var workPost = $("#workPost").val();	
		  var demandId = $("#demandId").val();	
		  var factoryId = $("#factoryId").val();	
		  var dockCompany = $("#dockCompany").val();	
		  var reMark = $("#reMark").val();
		  var recruitment = $("#recruitment").val();	
		  var wageStandard = $("#wageStandard").val();	
		  var residentTeacher = $("#residentTeacher").val();	
		  var teacherEvaluate = $("#teacherEvaluate").val();	
		  var antiFeePayCycle  = $("#antiFeePayCycle").val();	
	  var data = {
			  	"demandId": demandId,"demandStatus": demandStatus,
			  	"otherSubsidies":otherSubsidies,"fringeBenefit": fringeBenefit,
			  	"transportationAllowance": transportationAllowance,"accommodation": accommodation,
				"mealSupplement": mealSupplement,"overtimePay": overtimePay,
				"monthWage": monthWage,"hourlyWage": hourlyWage,"workPost": workPost,
				"workArea": workArea,"workContent": workContent,"factoryId":factoryId,
				"dockCompany":dockCompany,"recruitment": recruitment,"wageStandard": wageStandard,
				"residentTeacher":residentTeacher,"teacherEvaluate":teacherEvaluate,
				"antiFeePayCycle":antiFeePayCycle,"reMark":reMark,
	  }
	  $(".btn-success").attr("disabled", true); 
	  $(".btn-success").css("background","#CCCCFF");
	  $.ajax({
          type: "post",
          url: "/workdemand/saveWorkDemand.do",
          data: data,
          dataType: "json",
          success: function(result){
        	  alert(result.resultMessage);
         	 if(result.success == true){
         		 var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	       		 parent.location.reload();
	       		 parent.layer.close(index);
         	 }
          }
      });
  }
  </script>
 </head>
 <body  style="background-color:#fff;">
 <div class="row-fluid">
    <div class="span6">
      <div class="widget-box">
        <div class="widget-content nopadding">
          <form action="#" method="get" class="form-horizontal">
          <input type="hidden" value="${map.demandId}" id="demandId"/>
            <div class="control-group">
              <label class="control-label">厂区：</label>
              <div class="controls">
                <select id="factoryId" class="whh_input">
               		<option value="" <c:if test="${map.factoryId==null}">selected</c:if>>请选择</option>
                    <c:forEach var="item" items="${factorylist}" varStatus="status">
	                     <option value="${item.id}" <c:if test="${map.factoryId==item.id}">selected</c:if>>${item.name}</option>
                  	</c:forEach>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">对接公司：</label>
              <div class="controls">
                <select id="dockCompany" class="whh_input">
               		<option value="" <c:if test="${map.dockCompany==null}">selected</c:if>>请选择</option>
                    <c:forEach var="item" items="${dockcompanylist}" varStatus="status">
	                     <option value="${item.id}" <c:if test="${map.dockCompany==item.id}">selected</c:if>>${item.name}</option>
                  	</c:forEach>
               	</select>
              </div>
            </div>
            
            
            <div class="control-group">
              <label class="control-label">工作岗位：</label>
              <div class="controls">
                <input type="text" placeholder="工作岗位" id="workPost" value="${map.workPost}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">工作内容：</label>
              <div class="controls">
                <input type="text" placeholder="工作内容" id="workContent" value="${map.workContent}"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">工作地点：</label>
              <div class="controls">
                <select id="workArea" class="whh_input">
               		<option value="" <c:if test="${map.workArea==null}">selected</c:if>>请选择</option>
                    <c:forEach var="item" items="${zonelist}" varStatus="status">
	                     <option value="${item.areaid}" <c:if test="${map.workArea==item.areaid}">selected</c:if>>${item.areaname}</option>
                  	</c:forEach>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">返费 :</label>
              <div class="controls">
                    <input type="text" class="" placeholder="返费" id="hourlyWage" value="${map.hourlyWage}" onkeyup='this.value=this.value.replace(/\D/gi,"")'/>
              </div>
            </div>
            
            <div class="control-group">
              <label class="control-label">月薪 :</label>
              <div class="controls">
                <input type="text" class="" placeholder="月薪" value="${map.monthWage}" id="monthWage" onkeyup='this.value=this.value.replace(/\D/gi,"")'/>
              </div>
            </div>

            <div class="control-group">
              <label class="control-label">加班费 :</label>
              <div class="controls">
                <input type="text" placeholder="加班费" value="${map.overtimePay}" id="overtimePay" onkeyup='this.value=this.value.replace(/\D/gi,"")' />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">餐补 :</label>
              <div class="controls">
                <input type="text" placeholder="餐补" value="${map.mealSupplement}" id="mealSupplement" onkeyup='this.value=this.value.replace(/\D/gi,"")'/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">住宿 :</label>
              <div class="controls">
                <input type="text" placeholder="住宿" value="${map.accommodation}" id="accommodation"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">交通补助 :</label>
              <div class="controls">
                <input type="text" placeholder="交通补助" value="${map.transportationAllowance}" id="transportationAllowance"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">福利待遇 :</label>
              <div class="controls">
              		<textarea rows="6" id="fringeBenefit">${map.fringeBenefit}</textarea>
<%--                 <input type="text" placeholder="福利待遇" value="${map.fringeBenefit}" id="fringeBenefit"/> --%>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">录取短信 :</label>
              <div class="controls">
              	<textarea rows="6" id="otherSubsidies">${map.otherSubsidies}</textarea>
<%--                 <input type="text" placeholder="录取短信" value="${map.otherSubsidies}" id="otherSubsidies"/> --%>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">夜班情况 :</label>
              <div class="controls">
              	<textarea rows="6" id="reMark">${map.reMark}</textarea>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">状态 :</label>
              <div class="controls">
                <select id="demandStatus" class="whh_input">
               		<option value="" <c:if test="${map.demandStatus==null}">selected</c:if>>请选择</option>
               		<option value="1" <c:if test="${map.demandStatus==1}">selected</c:if>>正常</option>
               		<option value="2" <c:if test="${map.demandStatus==2}">selected</c:if>>关闭</option>
               	</select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">招聘简章 :</label>
              <div class="controls">
              	<textarea rows="6" id="recruitment">${map.recruitment}</textarea>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">薪资标准:</label>
              <div class="controls">
              	<textarea rows="6" id="wageStandard">${map.wageStandard}</textarea>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">驻厂老师 :</label>
              <div class="controls">
                <input type="text" placeholder="驻厂老师" value="${map.residentTeacher}" id="residentTeacher"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">驻厂老师评价:</label>
              <div class="controls">
              	<textarea rows="6" id="teacherEvaluate">${map.teacherEvaluate}</textarea>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">返费周期:</label>
              <div class="controls">
                    <input type="text" class="" placeholder="返费周期" id="antiFeePayCycle" value="${map.antiFeePayCycle == null?0:map.antiFeePayCycle}" onkeyup='this.value=this.value.replace(/\D/gi,"")'/>
              </div>
            </div>
            <div class="form-actions">
              <button type="button" class="btn btn-success" onclick="saveInfo()">提交</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
 </body>
</html>