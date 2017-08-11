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
		$('#dfp').find('input[type="checkbox"]').off('click').on('click',function(){
			if(this.checked){
				$(this).closest('tr').addClass('selected');
			}else{
				$(this).closest('tr').removeClass('selected');
			}
		});
		$('#allotTask').off('click').on('click',function(){
			var taskData = [];
			if($('#dfp').find('tr.selected').length>0){
				$('#dfp').find('tr.selected').each(function(){
					var professionid = $(this).find('td:eq(1)').attr('item');
					var areaid = $(this).find('td:eq(2)').attr('item');
					var gradeid = $(this).find('td:eq(3)').attr('item');
					var demandnum = $(this).find('td:eq(4)').attr('item');
					taskData.push({
						professionid:professionid,
						areaid:areaid,
						gradeid:gradeid,
						demandnum:demandnum
					});
				});
				layer.open({
		            id:'iframetest',
		            type: 2,
		            title: '任务分配',
		            maxmin: true, //开启最大化最小化按钮
		            area: ['893px', '500px'],
		            content: '/taskallot/allotdetails.do?taskData='+encodeURIComponent(JSON.stringify(taskData))
		        });
			}else{
				layer.alert('请先选择任务', {
				  icon: 0,
				  skin: 'layer-ext-moon'
				})
			}
		});
		$('.allotView').off('click').on('click',function(){
			var $tr = $(this).closest('tr');
			var professionid = $tr.find('td:eq(1)').attr('item');
			var areaid = $tr.find('td:eq(2)').attr('item');
			var gradeid = $tr.find('td:eq(3)').attr('item');
			var demandnum = $tr.find('td:eq(4)').attr('item');
			layer.open({
	            id:'iframetest',
	            type: 2,
	            title: '任务查询',
	            maxmin: true, //开启最大化最小化按钮
	            area: ['700px', '400px'],
	            content: '/taskallot/taskdetails.do?professionid='+professionid+'&areaid='+areaid+'&gradeid='+gradeid+'&demandnum='+demandnum,
	            btn:['关闭']
			});
		});
		$('.companyView').off('click').on('click',function(){
			var $tr = $(this).closest('tr');
			var professionid = $tr.find('td:eq(1)').attr('item');
			var areaid = $tr.find('td:eq(2)').attr('item');
			var gradeid = $tr.find('td:eq(3)').attr('item');
			layer.open({
	            id:'iframetest',
	            type: 2,
	            title: '公司需求详情',
	            maxmin: true, //开启最大化最小化按钮
	            area: ['600px', '400px'],
	            content: '/taskallot/companyDemand.do?professionid='+professionid+'&areaid='+areaid+'&gradeid='+gradeid,
	            btn:['关闭']
			});
		});
	}
}
$(function(){
	PAGE.init();
});