define(['jquery'],function () {
	
	console.log('login');
	
	$('#login').on('click',function(){
		var accountVo = {
				username:'1234',
				password:'123456'
		};
		
		$.ajax({
		    type: 'POST',
		    url: 'account/login',
		    headers: {'Content-type': 'application/json;charset=UTF-8'},
		    dataType: 'json',
		    data: accountVo ,
		    success:function(data, textStatus, jqXHR){
		    	console.log(data);
		    } ,
		});
	});
	
});