$(function(){
 $('.zyh_delete').bind('click', function(){
        var $Thistr=$(this).parents("tr");
        layer.confirm('是否删除这条信息？', {
            btn: ['删除','取消'] //按钮
          }, function(){
            $Thistr.hide();
            layer.msg('已删除', {icon: 1});
          }, function(){
            layer.msg('您已取消', {
              time: 1000, //1s后自动关闭
            });
        })
     })
})

