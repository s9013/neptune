define(['jquery'],function () {
	
	console.log('login');
	
	$('#login').on('click',function(){
		var accountVo = {
				username:'1235',
				password:'123456'
		};
		
		$.ajax({
		    type: 'POST',
		    url: 'account/login',
		    contentType : 'application/json',  
		    dataType: 'json',
		    data: JSON.stringify(accountVo) ,
		    success:function(data, textStatus, jqXHR){
		    	console.log(data);
		    } ,
		});
	});
	
});