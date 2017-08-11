;(function($){
	$('.showuser').off('click').on('click',function(){
		var opertcode = $(this).closest('tr').attr('item');
		var taskid = $(this).closest('tr').attr('taskid');
		layer.open({
            id:'customerdetails',
            type: 2,
            title: '提交简历',
            maxmin: true, //开启最大化最小化按钮
            area: ['893px', '500px'],
            content: '/selectbyOprecode.do?taskid='+taskid+'&opertcode='+opertcode
        });
	});
	$('.showinter').off('click').on('click',function(){
		var taskid = $(this).closest('tr').attr('taskid');
		var opertcode = $(this).closest('tr').attr('item');
		layer.open({
            id:'ViewList',
            type: 2,
            title: '面试人员',
            maxmin: true, //开启最大化最小化按钮
            area: ['893px', '500px'],
            content: '/seltCusBytask.do?taskid='+taskid+'&opertcode='+opertcode
        });
	});
	$('.showsenter').off('click').on('click',function(){
		var opertcode = $(this).closest('tr').attr('item');
		var taskid = $(this).closest('tr').attr('taskid');
		var isentry=1;
		layer.open({
            id:'updateView',
            type: 2,
            title: '入职人员',
            maxmin: true, //开启最大化最小化按钮
            area: ['893px', '500px'],
            content:'/seltCusBytask.do?taskid='+taskid+'&opertcode='+opertcode+'&isentry='+isentry
        });
	});
})(jQuery);