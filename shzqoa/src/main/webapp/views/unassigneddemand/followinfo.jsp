<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.shzqoa.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>需求详情信息</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="utf-8" />
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
<link rel="stylesheet" href="/views/resource/css/style.css">
 <link rel="stylesheet" href="/views/resource/css/uploadify.css">
<script src="/views/resource/js/jquery-1.11.0.min.js"
	type="text/javascript"></script>
<script src="/views/resource/js/jquery.uploadify.min.js"></script>
<script src="/views/resource/js/initMenu.js" type="text/javascript"></script>
<script src="/views/resource/layer/layer.js"></script>
<style type="text/css">
.whh_tab1 td {
	padding: 10px 0;
}
</style>
<script type="text/javascript">
  
  </script>
</head>
<body>
	<div class="">
		<table cellpadding="0" cellspacing="0" border="0" width="100%" class="whh_table">
			<tbody>
				<tr>
                   <td class="whh_right"><span class="xing">*</span>状态：</td>
                 </tr>
				<tr>
                   <td class="whh_right">是否发送客户：</td>
                   <td>
	                   <div class="whh_position">
	                   		<label class="whh_label"><input type="radio" name="customersex" value="0"/>是</label>
	                   		<label class="whh_label"><input type="radio" name="customersex" value="1"/>否</label>
	                   </div>
                   </td>
                   <td><label class="whh_label"><input type="text" class="whh_input" name="customerspecialities" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right">简历是否通过筛选：</td>
                   <td>
	                   <div class="whh_position">
	                   		<label class="whh_label"><input type="radio" name="customersex" value="0"/>是</label>
	                   		<label class="whh_label"><input type="radio" name="customersex" value="1"/>否</label>
	                   </div>
                   </td>
                   <td><label class="whh_label"><input type="text" class="whh_input" name="customerspecialities" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right">是否通知人员面试：</td>
                   <td>
	                   <div class="whh_position">
	                   		<label class="whh_label"><input type="radio" name="customersex" value="0"/>是</label>
	                   		<label class="whh_label"><input type="radio" name="customersex" value="1"/>否</label>
	                   </div>
                   </td>
                   <td><label class="whh_label"><input type="text" class="whh_input" name="customerspecialities" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right">面试结果：</td>
                   <td>
	                   <div class="whh_position">
	                   		<label class="whh_label"><input type="radio" name="customersex" value="0"/>未参加</label>
	                   		<label class="whh_label"><input type="radio" name="customersex" value="1"/>未通过</label>
	                   		<label class="whh_label"><input type="radio" name="customersex" value="1"/>已通过</label>
	                   </div>
                   </td>
                   <td><label class="whh_label"><input type="text" class="whh_input" name="customerspecialities" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right">是否需要复试：</td>
                   <td>
	                   <div class="whh_position">
	                   		<label class="whh_label"><input type="radio" name="customersex" value="0"/>是</label>
	                   		<label class="whh_label"><input type="radio" name="customersex" value="1"/>否</label>
	                   </div>
                   </td>
                   <td><label class="whh_label"><input type="text" class="whh_input" name="customerspecialities" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right">复试结果：</td>
                   <td>
	                   <div class="whh_position">
	                   		<label class="whh_label"><input type="radio" name="customersex" value="0"/>未参加</label>
	                   		<label class="whh_label"><input type="radio" name="customersex" value="1"/>未通过</label>
	                   		<label class="whh_label"><input type="radio" name="customersex" value="1"/>已通过</label>
	                   </div>
                   </td>
                   <td><label class="whh_label"><input type="text" class="whh_input" name="customerspecialities" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right">是否安排入项：</td>
                   <td>
	                   <div class="whh_position">
	                   		<label class="whh_label"><input type="radio" name="customersex" value="0"/>是</label>
	                   		<label class="whh_label"><input type="radio" name="customersex" value="1"/>否</label>
	                   </div>
                   </td>
                   <td><label class="whh_label"><input type="text" class="whh_input" name="customerspecialities" /></td>
                 </tr>
                 <tr>
                   <td class="whh_right"><span class="xing">*</span>截图：</td>
                   <td>
                      <div class="whh_flie_div">
                        <input type="file" class="whh_file" name="resumeupload" id="uploadFile" value=""/>
                        <input id="resumepath" name="resumepath"  style="display:none;width:400px" value="" readonly class="whh_input whh_texts"/>
                        <span>上传文件</span>
                      </div>
                   </td>
                 </tr> 
                 <tr>
                   <td class="whh_right">备注：</td>
                   <td colspan="2" >
                   		<textarea style="width:95%;" rows="3" cols=""></textarea>
                   </td>
                 </tr>
			</tbody>
		</table>
		<p style="text-align: center;">
			<a href="javascript:void(0)"
				class="whh_btn whh_btn_big mt20 whh_btn_big_or" onclick="toflow()">确定</a>
		</p>
	</div>


</body>
</html>