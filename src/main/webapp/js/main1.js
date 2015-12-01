define(['jquery','bootstrap'],function () {
	
	console.log('login');
	
		// 获取登入用户信息
		$.ajax({
		    type: 'POST',
		    url: 'account/getCurrentUserInfo',
		    contentType : 'application/json',  
		    dataType: 'json',
		    success:function(data, textStatus, jqXHR){
		    	console.log(data);
		    	$('#userId').html(data.username);
		    } ,
		});

		// 获取朋友列表
		$.ajax({
		    type: 'POST',
		    url: 'friend/getFriends',
		    contentType : 'application/json',  
		    dataType: 'json',
		    success:function(data, textStatus, jqXHR){
		    	console.log('friends');
		    	console.log(data);
		    	$('#home').html(JSON.stringify(data));
		    } ,
		});
	
		
		
		// 获取自己的动态
		$('.nav li:eq(1)').on('click',function(){
			$.ajax({
			    type: 'POST',
			    url: 'friend/getMyDynamic',
			    contentType : 'application/json',  
			    dataType: 'json',
			    success:function(data, textStatus, jqXHR){
			    	console.log('我的动态');
			    	console.log(data);
			    	$('#profile').html(JSON.stringify(data));
			    } ,
			});
		});
		
		
		// 获取别人的动态
		$('.nav li:eq(2)').on('click',function(){
			$.ajax({
			    type: 'POST',
			    url: 'friend/getDynamic',
			    contentType : 'application/json',  
			    dataType: 'json',
			    success:function(data, textStatus, jqXHR){
			    	console.log('动态');
			    	console.log(data);
			    	$('#dongtai').html(JSON.stringify(data));
			    } ,
			});
		});
		
		
});