require.config({
	baseUrl: document.querySelector('meta[name="script-base"]').getAttribute('data-base-url'),
	paths: {
//		jquery: "../vendor/jquery/jquery-1.11.1.min",
//		select2: '../vendor/select2/select2.min',
//		bootstrap: "../vendor/bootstrap/2.3.2/js/bootstrap.min",
//		datatables: "../vendor/datatables/1.7.6/jquery.datatables-1.7.6-amd",
//		uploadify: "../vendor/uploadify/jquery.uploadify.min",
//		jqueryui: '../vendor/jquery-ui/jquery-ui-1.10.0.custom.min',
//		loadmask: '../vendor/jquery-loadmask-0.4/jquery.loadmask.min',
//		plugins: '../js/helper/plugin/opps-plugins'
		layui:"../layui/layui",
	},
	 map: {
	        '*': {
	            css: '../static/requirecss/css.min.js'
	        }
	    },
	shim : {
		layui: {
            deps: [
                'layui',
                'css! ../layui/css/layui.css'
            ]
        },
	}
});


