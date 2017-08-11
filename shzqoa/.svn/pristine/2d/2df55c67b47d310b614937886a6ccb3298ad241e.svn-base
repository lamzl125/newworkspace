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
		var flag = true;
		$('.layer_tj').off('click').on('click',function(){
			$('.back').trigger('click');
			$('tr.active').removeClass('active');
			var areaHtml=$("select.allArea").html();
			var resumeHtml=$("select.allResume").html();
			if(flag){
				var $td1 = $('<td><input id="account" style="width:90px;"/></td>');
				var $td2 = $('<td><select id="accountCity">'+areaHtml+'</select></td>');
				var $td3 = $('<td><select id="resumeResource">'+resumeHtml+'</select></td>');
				var $td4 = $('<td><input id="strarttime" type="text" style="width:85px;" readOnly onFocus="WdatePicker({maxDate:\'#F{$dp.$D(\\\'endtime\\\')}\'})"/></td>');
				var $td5 = $('<td><input id="endtime" type="text" style="width:85px;" readOnly onFocus="WdatePicker({minDate:\'#F{$dp.$D(\\\'strarttime\\\')}\'})"/></td>');
				var $td6 = $('<td><input id="quantity" style="width:40px;"/>');
				var $td7 = $('<td><a href="javascript:void(0);" class="save">确认</a> <a href="javascript:void(0);" class="back">取消</a></td>');
				var $tr = $('<tr>').append($td1).append($td2).append($td3).append($td4).append($td5).append($td6).append($td7).addClass('active');
				$('#zh_body').prepend($tr);
				flag = false;
				$tr.find('.save').off('click').on('click',function(){
					//保存功能  如：_this.save();
					flag = true;
					_this.save($tr);
				});
				$tr.find('.back').off('click').on('click',function(){
					$tr.remove();
					flag = true;
				});
			}
		});
		
		$('.zh_edit').off('click').on('click',function(){
			var areaHtml=$("select.allArea").html();
			var resumeHtml=$("select.allResume").html();
			$('.back').trigger('click');
			$('tr.active').removeClass('active');
			var $tr = $(this).closest('tr');
			
			var cityid=$tr.find('td:eq(1)').text();
			var re=new RegExp(">"+cityid,"g");
		    var newstr=areaHtml.replace(re,"selected=\"selected\">"+cityid);
			
		    var resumeid=$tr.find('td:eq(2)').text();
		    var reg=new RegExp(">"+resumeid,"g");
		    var resumestr=resumeHtml.replace(reg,"selected=\"selected\">"+resumeid);
			
			var zh = $tr.find('td:eq(0)').text();
			var startTime = $tr.find('td:eq(3)').text();
			var endTime = $tr.find('td:eq(4)').text();
			var city=$tr.find('td:eq(1)').text();
			var num = $tr.find('td:eq(5)').text();
			var $td1 = $('<td><input id="account" style="width:90px;" value="'+zh+'"/></td>');
			var $td2 = $('<td><select id="accountCity">'+newstr+'</select></td>');
			var $td3 = $('<td><select id="resumeResource">'+resumestr+'</select></td>');
			var $td4 = $('<td><input id="strarttime" type="text" style="width:85px;" readOnly onFocus="WdatePicker({maxDate:\'#F{$dp.$D(\\\'endtime\\\')}\'})" value="'+startTime+'" class="input_disabled" disabled/></td>');
			var $td5 = $('<td><input id="endtime" type="text" style="width:85px;" readOnly onFocus="WdatePicker({minDate:\'#F{$dp.$D(\\\'strarttime\\\')}\'})" value="'+endTime+'"/></td>');
			var $td6 = $('<td><input id="quantity" style="width:40px;" value="'+num+'"/>');
			var $td7 = $('<td><a href="javascript:void(0);" class="save">确认</a> <a href="javascript:void(0);" class="back">取消</a></td>');
			var oldHtml = $tr.html();
			var $new_tr = $tr.empty().append($td1).append($td2).append($td3).append($td4).append($td5).append($td6).append($td7).addClass('active');
			$tr.find('.save').off('click').on('click',function(){
				//保存功能  如：_this.save();
				_this.save($new_tr);
			});
			$tr.find('.back').off('click').on('click',function(){
				$tr.html(oldHtml).removeClass('active');
				_this.bindEvent();
			});
		});
		
		$('.zh_delete').off('click').on('click',function(){
			var aid = $(this).closest('tr').attr('aid');
			layer.confirm('确认删除？', {
					icon:0,
					title:'温馨提示',
					btn: ['确认','取消'] //按钮
				}, function(){
					_this.deleteData(aid);
			});
		});
	},
	save:function($tr){
		var _this = this;
		var aid = $.trim($tr.attr('aid') || '');
		var account = $.trim($('#account').val());
		var accountCity =$.trim($("#accountCity").find("option:selected").val());
		var strarttime = $.trim($('#strarttime').val());
		var endtime = $.trim($('#endtime').val());
		var quantity = $.trim($('#quantity').val());
		var resumesourceid = $.trim($("#resumeResource").find("option:selected").val());
		if(!account){
			layer.tips('此项为必填', '#account');return;
		}
		if(!strarttime){
			layer.tips('此项为必填', '#strarttime');return;
		}
		if(!endtime){
			layer.tips('此项为必填', '#endtime');return;
		}
		if(!quantity){
			layer.tips('此项为必填', '#quantity');return;
		}
		if(!accountCity){
			layer.tips('此项为必填', '#accountCity');return;
		}
		if(!resumesourceid){
			layer.tips('此项为必填', '#resumesourceid');return;
		}
		$.ajax({
			url:'/account/save.do',
			data:{
				aid:aid,
				account:account,
				strarttime:_this.formatDate(strarttime),
				endtime:_this.formatDate(endtime),
				accountCity:accountCity,
				quantity:quantity,
				resumesourceid:resumesourceid
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
	deleteData:function(aid){
		$.ajax({
			url:'/account/delete.do',
			data:{
				aid:aid
			},
			type:'POST',
			dataType:'json',
			cache:false,
			success:function(res){
				if(res){
					if(res.resultData == -1){
						layer.alert(res.resultMessage, {
							icon:4,
							title:'温馨提示',
							skin: 'layui-layer-molv',
							closeBtn: 0
						});
					}else{
						layer.msg(res.resultMessage, {icon:1,time: 1000},function(){
							window.location.reload();
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