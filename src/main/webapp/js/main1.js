define(['jquery','bootstrap'],function () {
	
	console.log('login');
	
	
		$.ajax({
		    type: 'POST',
		    url: 'account/getCurrentUserInfo',
		    contentType : 'application/json',  
		    dataType: 'json',
		    success:function(data, textStatus, jqXHR){
		    	console.log(data);
		    	$('#userId').html(data.id);
		    } ,
		});

	
});