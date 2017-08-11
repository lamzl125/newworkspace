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
	formatDateStr:function(dateStr){
		// 2016-06-16
		var dateArr = dateStr.split('-');
		var date = new Date(dateArr[0],parseInt(dateArr[1])-1,dateArr[2],0,0,0);
		return date.getTime();
	},
	bindEvent:function(){
		var _this = this;
		$('.addTask').off('click').on('click',function(){
			var usercode = $.trim($('#user').val());
			var realname = $.trim($('#user').find("option:selected").text());
			var starttime = $.trim($('#starttime').val());
			var endtime = $.trim($('#endtime').val());
			var allotnum = $.trim($('#allotnum').val());//验证空值并验证是否为数字
			if(!usercode){
				layer.tips('此项为必填项', '#user');return;
			}
			if(!starttime){
				layer.tips('此项为必填项', '#starttime');return;
			}
			if(!endtime){
				layer.tips('此项为必填项', '#endtime');return;
			}
			if(!allotnum){
				layer.tips('此项为必填项', '#allotnum');return;
			}else if(!$.isNumeric(allotnum)){
				layer.tips('此项只能为数字', '#allotnum');return;
			}
			if(_this.checkIsAdd(usercode)){
				layer.msg('该员工已经添加过任务',{time:1000});return;
			}
			$('#allotdetails').append('<tr item="'+usercode+'">'+
					'<td item="'+usercode+'">'+realname+'</td>'+
					'<td item="'+starttime+'">'+starttime+'</td>'+
					'<td item="'+endtime+'">'+endtime+'</td>'+
					'<td item="'+parseInt(allotnum)+'">'+parseInt(allotnum)+'</td>'+
					'<td><a href="javascript:void(0);" class="removeTask">移除</a></td>'+
					'</tr>');
			$('.removeTask').off('click').on('click',function(){
				$(this).closest('tr').remove();
			});
		});
		$('.allotTask').off('click').on('click',function(){
			var allotTaskData = [];
			$('#allotdetails').find('tr').each(function(){
				var usercode = $(this).find('td:eq(0)').attr('item');
				var starttime = $(this).find('td:eq(1)').attr('item');
				var endtime = $(this).find('td:eq(2)').attr('item');
				var allotnum = $(this).find('td:eq(3)').attr('item');
				allotTaskData.push({
					userid:usercode,
					starttime:_this.formatDateStr(starttime),
					endtime:_this.formatDateStr(endtime),
					allotnum:allotnum
				})
			});
			if($('#allotdetails').find('tr').length==0){
				 layer.alert("请添加分配任务！",{
					 title:'温馨提示'
				 });return;
			}
			var taskData = $('#taskData').val();
			$.ajax({
				url:'/taskallot/allotTask.do',
				data:{
					taskData:taskData,
					allotTaskData:JSON.stringify(allotTaskData)
				},
				type:'POST',
				dataType:'json',
				cache:false,
				success:function(res){
					layer.alert(res.resultMessage,{
						title:'温馨提示'
					});
				}
			});
		});
	},
	checkIsAdd:function(usercode){
		if($('#allotdetails').find('tr[item="'+usercode+'"]').length>0){
			return true;
		}
		return false;
	}
}
$(function(){
	PAGE.init();
});