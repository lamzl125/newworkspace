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
	corporatepartner:[],
	init:function(){
		var _this = this;
		_this.initCorporatepartner();
		_this.bindViewEvent();
	},
	initCorporatepartner:function(){
		var _this = this;
		$.ajax({
			url:'/Corporatepartner/queryAll.do',
			data:null,
			type:'GET',
			dataType:'json',
			cache:false,
			success:function(res){
				if(res && res.success){
					_this.corporatepartner = res.resultData;
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
				var $td = $('<td>');
				var $select = $('<select name="corpCode">');
				var corporatepartner = _this.corporatepartner;
				for(var i=0;i<corporatepartner.length;i++){
					var obj = corporatepartner[i];
					var $option = $('<option value="'+obj.corpCode+'">'+obj.corpName+'</option>');
					$select.append($option);
				}
				$td.append($select);
				var $tr = $('<tr>').append($td).append('<td></td><td></td><td><span class="btn save_btn">确认</span><span class="btn repeal_btn">取消</span></td>');
				$('#wpDetails').prepend($tr);
				flag = false;
				$tr.find('.save_btn').off('click').on('click',function(){
					_this.saveWp($tr);
					flag = true;
				});
				$tr.find('.repeal_btn').off('click').on('click',function(){
					$tr.remove();
					flag = true;
				});
			}
		});
	},
	bindViewEvent:function(){
		$('#wpDetails').find('.viewBtn').off('click').on('click',function(){
			var corpCode = $(this).attr('corpCode');
			var cid = $('#cid').val();
			document.location.href="/paydetail/queryAllByParams.do?customerCode="+cid+"&corpCode="+corpCode;
		});
	},
	saveWp:function($tr){
		console.info($tr);
		var corpCode = $tr.find('select[name="corpCode"]').val();
		var cid = $('#cid').val();
		$.ajax({
			url:'/paydetail/saveWp.do',
			data:{
				CustomerCode:cid,
				corpCode:corpCode
			},
			type:'GET',
			dataType:'json',
			cache:false,
			success:function(res){
				if(res && res.success){
					alert(res.resultMessage);
					window.location.reload();
				}else{
					alert("添加失败。");
				}
			}
		});
	}
}








$(function(){
	PAGE.init();
});