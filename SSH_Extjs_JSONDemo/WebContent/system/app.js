Ext.application({
    name: 'ExtAppSystem',
    // All the paths for custom classes
    //paths: {
    //    'Ext.ux': '../../../examples/ux/'
    //},
	//应用的根目录
	appFolder : extPath + '/system/app',
	//声明所用到的控制层
    controllers: [
    	 'FrameControl'//创建系统UI控制器
    	,'SystemControl'//创建系统模块控制器
    ],
    
    //autoCreateViewport: true//自动创建view/Viewport.js
    //当前页面加载完成执行的函数 
    launch: function() {
        //创建系统UI Frame
        Ext.create('ExtAppSystem.view.Frame',{id:'frame'});
    }
});
