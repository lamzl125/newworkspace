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
		$('#toadd').off('click').on('click',function(){
			layer.open({
	            id:'iframetest',
	            type: 2,
	            title: '参数种类',
	            maxmin: true, //开启最大化最小化按钮
	            area: ['550px', '232px'],
	            content: '/views/baseParameter/EditParameterKind.jsp?addflag=1'
			});
		});
		$('.editparakind').off('click').on('click',function(){
			var $tr = $(this).closest('tr');
			var id = $tr.find('td:eq(0)').text();
			layer.open({
				title:'参数种类',
		        type: 2,
				maxmin: true, //开启最大化最小化按钮
				area: ['580px', '300px'],
		        shadeClose: true, //点击遮罩关闭
		        content: '/basepara/toEditInfo.do?id='+id,
		        btn:['关闭']
		    });
		});
		$('.getparas').off('click').on('click',function(){
			var $tr = $(this).closest('tr');
			var id = $tr.find('td:eq(0)').text();
			layer.open({
				title:'参数',
		        type: 2,
				maxmin: true, //开启最大化最小化按钮
		        area: ['1100px', '600px'],
		        shadeClose: true, //点击遮罩关闭
		        content: '/basepara/parasList.do?parakindid='+id,
		        btn:['关闭']
		    });
		});
	}
}
$(function(){
	PAGE.init();
});