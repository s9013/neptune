requirejs.config({
    baseUrl: 'lib',
    paths: {
        jquery: 'jquery/jquery',
        bootstrap:'bootstrap/bootstrap'
    },
    shim: {
    	bootstrap: {
            deps: ['jquery'],
        },
    }
});

requirejs(['jquery','../js/main1'],function(){
	console.log('start');
});