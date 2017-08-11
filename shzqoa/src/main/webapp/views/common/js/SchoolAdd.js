$(function(){
  /*添加*/
  $(".btn_add").click(function(){
  	var $thisitem=$(this).attr("item");
  	var $tbodyhtml=$(this).parents(".widget-box").find(".table tbody");
  	/*学校信息*/
    var $tdhtml1="<tr><td></td>";
    var $tdhtml2="<td><span></span><p class='Wide100'><input type='text' class='Wide87 thisinput' val='' /></p></td>";
    var $tdhtml3="<td><span></span><p class='Wide100'><input type='text' class='Wide87 thisinput' val='' /></p></td>";
    var $tdhtml4="<td><span></span><p class='Wide100'><select style='width:100px;' class='thisinput'> <option>A</option><option>B</option><option>C</option><option>D</option></select></p></td>";
    var $tdhtml5="<td><span></span><p class='Wide100'><input type='text' class='Wide87 thisinput' val='' /></p></td>";
    var $tdhtml6="<td><span></span><p class='Wide100'><input type='text' class='Wide87 thisinput' val='' /></p></td>";
    var $tdhtml7="<td><button type='submit' class='btn btn-warning btn-mini btn-edit'>保存</button>&nbsp;&nbsp;<button type='submit' class='btn btn-mini btn-danger zyh_delete'>删除</button>";   
    var $tdhtml8="</td></tr>";   
    var $tdhtml=$tdhtml1+$tdhtml2+$tdhtml3+$tdhtml4+$tdhtml5+$tdhtml6+$tdhtml7+$tdhtml8;
    /*学校院系信息*/
    var $2tdhtml=$tdhtml1+$tdhtml2+$tdhtml3+$tdhtml7+$tdhtml8;
    if($thisitem=="1"){/*如果等于1，使用$tdhtml字符串*/
      $tbodyhtml.prepend($tdhtml);
      bindEvent();	
    }
    else{/*如果等于2，使用$2tdhtml字符串*/
      $tbodyhtml.prepend($2tdhtml);
      bindEvent();
    }
  })
  /*删除*/
  bindEvent();
  function bindEvent(){
  	/*删除*/
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
     /*院系信息修改*/
	 $(".btn-edit").bind('click',function(){
	  	var $thistext=$(this).html();
	  	var $this=$(this);
	  	if($thistext=='修改'){
	  		$this.html('保存');
	  		$this.parents('tr').find('td span').hide();
	  		$this.parents('tr').find('td p').show();
	  		$(this).parents("tr").find("td").each(function(index,element){
	  			if(index==1){
	  				var inputele = $(this).find(".thisinput").attr("disabled", true);
	  				$(this).find(".thisinput").val($(this).find(".thisinput").parents('p').prev('span').html());
	  			}else if(index==2){
	  				$(this).find(".thisinput").val($(this).find(".thisinput").parents('p').prev('span').html());
	  				$(this).find(".thisinput").attr("readonly","true");
	  				$(this).find(".thisinput").bind('click',function(){
	  					WdatePicker();
	  				});
	  			}else if(index==3){
	  				var inputele = $(this).find(".thisinput").css("display", "none");
	  				$(this).find("p").append("<select style='width:100px;' class='thisinput'> <option>A</option><option>B</option><option>C</option><option>D</option></select>");
	  			}else{
	  				$(this).find(".thisinput").val($(this).find(".thisinput").parents('p').prev('span').html());
	  			}
	  		})
	  	}
	  	else if($thistext=='保存'){
	  		$this.html('修改');
	  		$this.parents('tr').find('td span').show();
	  		$this.parents('tr').find('td p').hide();
	  		$(this).parents("tr").find("td").each(function(index,element){
	  			$(this).find("span").html($(this).find("span").next('p').find('.thisinput').val());
	  		})
	  	}
	 })
	 
	 //专业修改
	  $(".mojarbtn-edit").bind('click',function(){
	  	var $thistext=$(this).html();
	  	var $this=$(this);
	  	if($thistext=='修改'){
	  		$this.html('保存');
	  		$this.parents('tr').find('td span').hide();
	  		$this.parents('tr').find('td p').show();
	  		$(this).parents("tr").find("td").each(function(index,element){
  				$(this).find("input").val($(this).find("input").parents('p').prev('span').html());
	  		})
	  	}
	  	else if($thistext=='保存'){
	  		$this.html('修改');
	  		$this.parents('tr').find('td span').show();
	  		$this.parents('tr').find('td p').hide();
	  		$(this).parents("tr").find("td").each(function(index,element){
	  			$(this).find("span").html($(this).find("span").next('p').find('input').val());
	  		})
	  	}
	 })
  }
  /*学校资料修改*/
  $(".btn-save").bind('click',function(){
  	var $thistext=$(this).html();
  	var $this=$(this);
  	var $thisspan=$this.parents('.widget-box').find('.Schnews');
  	var $thisinput=$this.parents('.widget-box').find('.widget-content').find(".thisinput");
  	if($thistext=='修改'){
  		$this.html('保存');
  		$thisspan.hide();
  		$thisinput.removeClass("thisnone");
  		$(".widget-content p").each(function(index,element){
  			$(this).find(".thisinput").val($(this).find(".thisinput").prev('.Schnews').html());
  		})
  	}
  	else if($thistext=='保存'){
  		$this.html('修改');
  		$thisspan.show();
  		$thisinput.addClass("thisnone");
  		$(".widget-content p").each(function(index,element){
  			$(this).find(".Schnews").html($(this).find(".Schnews").next('.thisinput').val());
  		})
  	}
  })
})

