Ext.application({
    name: 'ExtAppSystem',
    // All the paths for custom classes
    //paths: {
    //    'Ext.ux': '../../../examples/ux/'
    //},
	//Ӧ�õĸ�Ŀ¼
	appFolder : extPath + '/system/app',
	//�������õ��Ŀ��Ʋ�
    controllers: [
    	 'FrameControl'//����ϵͳUI������
    	,'SystemControl'//����ϵͳģ�������
    ],
    
    //autoCreateViewport: true//�Զ�����view/Viewport.js
    //��ǰҳ��������ִ�еĺ��� 
    launch: function() {
        //����ϵͳUI Frame
        Ext.create('ExtAppSystem.view.Frame',{id:'frame'});
    }
});
