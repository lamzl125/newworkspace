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
		$('#toaddpara').off('click').on('click',function(){
			layer.open({
	            id:'iframetest',
	            type: 2,
	            title: '参数维护',
	            maxmin: true, //开启最大化最小化按钮
	            area: ['500px', '280px'],
	            content: '/basepara/toEditPara.do?addflag=1&id=0'
			});
		});
		$('.editpara').off('click').on('click',function(){
			var $tr = $(this).closest('tr');
			var id = $tr.find('td:eq(0)').text();
			layer.open({
				title:'参数',
		        type: 2,
				maxmin: true, //开启最大化最小化按钮
				area: ['500px', '360px'],
		        shadeClose: true, //点击遮罩关闭
		        content: '/basepara/toEditPara.do?id='+id+"&addflag=0",
		        btn:['关闭']
		    });
		});
		
	}
}
$(function(){
	PAGE.init();
});