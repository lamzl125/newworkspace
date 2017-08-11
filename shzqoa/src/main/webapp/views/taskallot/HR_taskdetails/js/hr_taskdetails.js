;(function($){
	$('.binding').off('click').on('click',function(){
		var taskallotid = $(this).closest('tr').attr('item');
		layer.open({
            id:'customerdetails',
            type: 2,
            title: '绑定客户',
            maxmin: true, //开启最大化最小化按钮
            area: ['893px', '500px'],
            content: '/taskallotdetails/customerdetails.do?taskallotid='+taskallotid
        });
	});
	$('.viewKH').off('click').on('click',function(){
		var taskallotid = $(this).closest('tr').attr('item');
		layer.open({
            id:'ViewList',
            name:'ViewList',
            type: 2,
            title: '客户信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['893px', '500px'],
            content: '/InterView/ViewList.do?taskallotid='+taskallotid
        });
	});
	$('.payEdit').off('click').on('click',function(){
		var id = $(this).closest('tr').attr('item');
		layer.open({
            id:'updateView',
            type: 2,
            title: '更新面试信息',
            maxmin: true, //开启最大化最小化按钮
            area: ['450px', '400px'],
            content: '/InterView/updateView.do?id='+id
        });
	});
	$('.companyView').off('click').on('click',function(){
		var $tr = $(this).closest('tr');
		var professionid = $tr.find('td:eq(3)').attr('item');
		var areaid = $tr.find('td:eq(1)').attr('item');
		var gradeid = $tr.find('td:eq(2)').attr('item');
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
	$('.redirectPage').off('click').on('click',function(){
		var customercode = $(this).attr('item');
		parent.window.location.href='/customerDatailInfo/toCustomerDatailInfo.do?customercode='+customercode;
//		var index = parent.layer.getFrameIndex('ViewList'); //先得到当前iframe层的索引
//		parent.layer.close(index); //再执行关闭   
	});
})(jQuery);