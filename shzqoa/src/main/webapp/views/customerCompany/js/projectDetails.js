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
	projectList:[],
	init:function(){
		var _this = this;
		_this.initprojectList();
		_this.bindEditEvent();
	},
	initprojectList:function(){
		var _this = this;
		var corpCode = $('#corpCode').val();
		$.ajax({
			url:'/corpProject/queryProjectByCorpCode.do',
			data:{
				corpCode:corpCode
			},
			type:'GET',
			dataType:'json',
			cache:false,
			success:function(res){
				if(res && res.success){
					_this.projectList = res.resultData;
					_this.bindAddEvent();
				}else{
					alert('系统异常。');
				}
			}
		});
	},
	bindAddEvent:function(){
		var _this = this;
		var flag = true;
		$('.add_btn').off('click').on('click',function(){
			if(flag){
				var $td1 = $('<td><input name="settledCompany" class="td_input"/></td>');
				var $td = $('<td>');
				var $select = $('<select name="corpProjectCode" class="td_input" style="width:120px">');
				var projectList = _this.projectList;
				for(var i=0;i<projectList.length;i++){
					var obj = projectList[i];
					var $option = $('<option value="'+obj.corpprojectcode+'">'+obj.corpprojectname+'</option>');
					$select.append($option);
				}
				$td.append($select);
				var $select2 = $('<select name="settledCycle"><option value="1">月付</option><option value="2">隔月付</option><option value="3">季付</option></select>');
				var $td2 = $('<td>').append($select2);
				var $tr = $('<tr>').append($td1)
								   .append($td)
								   .append('<td><input id="d4311" name="startTime" class="td_input" style="width:85px;" onFocus="WdatePicker({maxDate:\'#F{$dp.$D(\\\'d4312\\\')}\'})" readonly/></td>')
								   .append('<td><input id="d4312" name="endTime" class="td_input" style="width:85px;" onFocus="WdatePicker({minDate:\'#F{$dp.$D(\\\'d4311\\\')}\'})" readonly/></td>')
								   .append($td2)
								   .append('<td><input name="salary" class="td_input" style="width:80px;"/></td>')
								   .append('<td><input name="servicePay" class="td_input" style="width:80px;"/></td>')
								   .append('<td><span class="btn save_btn">确认</span><span class="btn repeal_btn">取消</span></td>');
				$('#xmDetails').prepend($tr);
				flag = false;
				$tr.find('.save_btn').off('click').on('click',function(){
					_this.saveXm($tr);
					flag = true;
				});
				$tr.find('.repeal_btn').off('click').on('click',function(){
					$tr.remove();
					flag = true;
				});
			}
		});
	},
	bindEditEvent:function(){
		var _this = this;
		$('.payEdit').off('click').on('click',function(){
			var $tr = $(this).closest('tr');
			var id = $tr.attr('item');
			var settledCompany = $tr.find('td:eq(0)').text();
			var corpProjectCode = $tr.find('td:eq(1)').attr('corpProjectCode');
			var corpProjectName = $tr.find('td:eq(1)').text();
			var startTime = $tr.find('td:eq(2)').text();
			var endTime = $tr.find('td:eq(3)').text();
			var settledCycle = $tr.find('td:eq(4)').attr('settledCycle');
			var salary = $tr.find('td:eq(5)').text();
			var servicePay = $tr.find('td:eq(6)').text();
			var $td1 = $('<td><input name="settledCompany" class="td_input" value="'+settledCompany+'"/></td>');
			var $td = $('<td>');
			var $select1 = $('<select name="corpProjectCode" class="td_input" style="width:120px">');
			var projectList = _this.projectList;
			for(var i=0;i<projectList.length;i++){
				var obj = projectList[i];
				var $option = $('<option value="'+obj.corpprojectcode+'">'+obj.corpprojectname+'</option>');
				$select1.append($option);
			}
			$select1.val(corpProjectCode);
			$td.append($select1);
			var $select2 = $('<select name="settledCycle"><option value="1">月付</option><option value="2">隔月付</option><option value="3">季付</option></select>');
			$select2.val(settledCycle);
			var $td2 = $('<td>').append($select2);
			var oldHtml = $tr.html();
			$tr.empty().append($td1)
							   .append($td)
							   .append('<td><input id="d4311" name="startTime" class="td_input" style="width:85px;" onFocus="WdatePicker({maxDate:\'#F{$dp.$D(\\\'d4312\\\')}\'})" value="'+startTime+'" readonly/></td>')
							   .append('<td><input id="d4312" name="endTime" class="td_input" style="width:85px;" onFocus="WdatePicker({minDate:\'#F{$dp.$D(\\\'d4311\\\')}\'})" value="'+endTime+'" readonly/></td>')
							   .append($td2)
							   .append('<td><input name="salary" class="td_input" style="width:80px;" value="'+salary+'"/></td>')
							   .append('<td><input name="servicePay" class="td_input" style="width:80px;" value="'+servicePay+'"/></td>')
							   .append('<td><span class="btn save_btn">确认</span><span class="btn repeal_btn">取消</span></td>');
			$tr.find('.save_btn').off('click').on('click',function(){
				_this.editCommit($tr);
			});
			$tr.find('.repeal_btn').off('click').on('click',function(){
				$tr.html(oldHtml);
				_this.bindEditEvent();
			});
		});
	},
	editCommit:function($tr){
		var id = $tr.attr('item');
		var settledCompany = $tr.find('input[name="settledCompany"]').val();
		var corpProjectCode = $tr.find('select[name="corpProjectCode"]').val();
		var startTime = $tr.find('input[name="startTime"]').val();
		var endTime = $tr.find('input[name="endTime"]').val();
		var settledCycle = $tr.find('select[name="settledCycle"]').val();
		var salary = $tr.find('input[name="salary"]').val();
		var servicePay = $tr.find('input[name="servicePay"]').val();
		$.ajax({
			url:'/paydetail/update.do',
			data:{
				id:id,
				settledCompany:settledCompany,
				corpProjectCode:corpProjectCode,
				startTime:startTime,
				endTime:endTime,
				settledCycle:settledCycle,
				salary:salary,
				servicePay:servicePay
			},
			type:'POST',
			dataType:'json',
			cache:false,
			success:function(res){
				if(res){
					layer.msg(res.resultMessage, {icon:1,time: 1000},function(){
						window.location.reload();
					});
				}
			}
		});
	},
	saveXm:function($tr){
		var customerCode = $('#customerCode').val();
		var corpCode = $('#corpCode').val();
		var settledCompany = $('input[name="settledCompany"]').val();
		var corpProjectCode = $('select[name="corpProjectCode"]').val();
		var startTime = $('input[name="startTime"]').val();
		var endTime = $('input[name="endTime"]').val();
		var settledCycle = $('select[name="settledCycle"]').val();
		var salary = $('input[name="salary"]').val();
		var servicePay = $('input[name="servicePay"]').val();
		$.ajax({
			url:'/paydetail/saveXm.do',
			data:{
				customerCode:customerCode,
				corpCode:corpCode,
				settledCompany:settledCompany,
				corpProjectCode:corpProjectCode,
				startTime:startTime,
				endTime:endTime,
				settledCycle:settledCycle,
				salary:salary,
				servicePay:servicePay
			},
			type:'POST',
			dataType:'json',
			cache:false,
			success:function(res){
				if(res){
					layer.msg(res.resultMessage, {icon:1,time: 1000},function(){
						window.location.reload();
					});
				}
			}
		});
	}
}
$(function(){
	PAGE.init();
});