<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加评价信息</title>
<link rel="stylesheet" href="/views/resource/css/style.css">
<link rel="stylesheet" href="/views/resource/css/zyh_style.css">
 <script src="/views/resource/js/jquery-1.11.0.min.js" type="text/javascript"></script>
   <script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
</head>
<body>
    <jsp:include page="/views/Top.jsp"></jsp:include>
    <form action="/PingJia/update.do" method="post">
    <input type="hidden" name="customercode" value="${customerInfo.customercode }" />
     <div class="whh_wraper">
       <div class="whh_content whh_content_border">
          <h2 class="whh_h2_bg"><span>查询结果</span></h2>
          <div class="zyh_rated_box">
              <div class="zyh_rated_shao">
                <span>
                    沟通评价：<input type="text" value="${customerInfo.comEvaluate }" id="comEvaluate" name="comEvaluate" placeholder="打出你的分数1-100" class="zyh_rated" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')"  type="text" /> 分
                	<span class="zyh_tix">1-60分一般,60-80分良好,80-100分优秀</span>
                
                </span>
                <span>
                    项目评价：<input type="text" name="proEvaluate" value="${customerInfo.proEvaluate }" placeholder="打出你的分数1-100" class="zyh_rated" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')"  type="text" /> 分
                <span class="zyh_tix">1-60分一般,60-80分良好,80-100分优秀</span>
                </span>
                <span>
                    综合评价：<input type="text" name="synEvaluate" value="${customerInfo.synEvaluate }"  placeholder="打出你的分数1-100" class="zyh_rated" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')"  type="text" /> 分
                <span class="zyh_tix">1-60分一般,60-80分良好,80-100分优秀</span>
                
                </span>
                </div>
          </div>
            <p style="text-align:center">
            <input type="submit" class="zyh_rated_btn" onclick="addPingJia()"  value="保存"/>
            </p>
       </div>
   </div>
    </form>
</body>
</html>