<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<%@ include file="/common/jsp/taglibs.jsp"%>
<title></title>
<meta name="viewport" content="initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no,minimal-ui">
<style type="text/css">
*{ margin:0; padding:0;}
body{ font-size:16px;color: #3e3e3e; padding:8px;line-height: 1.6;   font-family:"Microsoft YaHei","微软雅黑";}
h2{}

.rich_media_inner {
    position: relative;
}
.rich_media_inner {
    background-color: #fff;
    padding-bottom: 100px;
}
.rich_media_inner {
    padding: 20px;
}
.rich_media_inner {
    font-size: 16px;
    word-wrap: break-word;
}
* {
    font-style: normal;
    margin: 0;
    padding: 0;
}
.d_zz{ border-bottom:1px dashed #ccc; padding:6px 0; margin-bottom:6px; color:#666;}
.rich_media_area_primary::before {
   
    bottom: -2px;
    content: " ";
    height: 1px;
    left: 0;
    position: absolute;
    top: auto;
    transform: scaleY(0.5);
    transform-origin: 0 0 0;
    width: 100%;
}
.rich_media_area_primary {
    background-color: #fff;
    position: relative;max-width: 740px; margin:0 auto;
}

.rich_media_title {
    border-bottom: 1px solid #e7e7eb;
    margin-bottom: 14px;
    padding-bottom: 10px;
}
.rich_media_title {
    font-size: 24px;
    font-weight: 400;
    line-height: 1.4;
    margin-bottom: 12px;
}
</style>
</head>

<body>
<div class="rich_media_area_primary" id="img-content">
     <div class="rich_media_meta_list">
              ${ab.intro}                          
     </div>
</div>                
<!-- <div class="d_zz">作者：张三  时间：2015-05-05</div> -->

</body>