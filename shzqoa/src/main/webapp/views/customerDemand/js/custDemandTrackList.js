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
	allotTask:function(){
		
	},
	bindEvent:function(){
		$('.editButClass').off('click').on('click',function(){
			var $tr = $(this).closest('tr');
			var id = $tr.find('td[name=Id]').text();
			layer.open({
	            id:'iframetest',
	            type: 2,
	            title: '需求跟踪',
	            maxmin: true, //开启最大化最小化按钮
	            area: ['1000px', '500px'],
	            content: '/customerDemand/trackCustomerDemand.do?Id='+id
			});
		});
		$('.getSpecificrequirement').off('click').on('click',function(){
			var $tr = $(this).closest('tr');
			var itemspereq = $tr.find('td[name=itemspereq]').text();
			var corpname = $tr.find('td[name=corpname]').text();
			layer.open({
				  type: 1,
				  title:corpname+'需求详细信息',
				  skin: 'layui-layer-rim', //加上边框
				  area: ['420px', '240px'], //宽高
				  content: itemspereq
				});
			
		});
		/*$('.getSpecificrequirement').hover(function(){
			var $tr = $(this).closest('tr');
			var itemspereq = $tr.find('td[name=itemspereq]').text();
			var corpname = $tr.find('td[name=corpname]').text();
			layer.open({
				  type: 1,
				  title:corpname+'需求详细信息',
				  skin: 'layui-layer-rim', //加上边框
				  area: ['420px', '240px'], //宽高
				  content: itemspereq
				});
	    },function(){
	    	layer.closeAll('page');
	    });*/
		
		
	}
}
$(function(){
	PAGE.init();
});