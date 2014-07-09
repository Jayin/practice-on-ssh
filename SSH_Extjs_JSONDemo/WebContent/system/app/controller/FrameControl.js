/**
 * 框架控制层
 */
Ext.define('ExtAppSystem.controller.FrameControl',{
	extend: 'Ext.app.Controller',

	views: [
		//框架
		'Frame'
		,'FootBar'
		//Model
		,'system.SystemSelectTable'
    ],
    stores:[
    	//Model
    	'system.SystemSelectTableStore'
    ],
    models:[    	
    	//Model
    	'SelectTableModel'
    
    ],
    refs: [
    	{ref: 'frame',selector: 'frame'}
		//Model:getSystemSelectTableStore()
		,{ref: 'systemSelectTableStore', selector: 'systemselecttablestore',autoCreate: true, xtype:'systemselecttablestore'}
        ,{ref: 'systemSelectTableDataView', selector: 'systemselecttable dataview'}
      
    ],
    init: function () {
        this.control({
            //框架加载完成后执行操作
        	'viewport':{
        		afterrender : this.initFrameUI
        	},
        	//系统accordion菜单点击事件绑定
        	'viewport > panel > panel > panel > dataview' :{
        		selectionchange : this.selectionChangeAction
        	},
        	//退出系统
        	'viewport > panel > toolbar[place=footer] button[action=logoutSystemAction]' :{
        		click : this.logoutSystemAction
        	},
        	//修改密码
        	'viewport > panel > toolbar[place=footer] button[action=userUpdatePassWord]' :{
        		click : this.userUpdatePassWord
        	}
        });
    },
    onLaunch: function() {
    	//加载select table的dataview
        this.getSystemSelectTableDataView().bindStore(this.getSystemSelectTableStore());
      
    },
    //初始化框架UI
    initFrameUI:function(){
    	//添加顶部工具面板
    	this.getFrame().getComponent('frame_south').add(Ext.create('ExtAppSystem.view.FootBar',{id:'frame_footbar'}));
    },
    //系统accordion菜单点击事件
    selectionChangeAction:function(selmodel, selection){
    	var selected = selection[0];
        if(selected){
        	//if(resources.indexOf(selected.data.name) != -1){
				//定义面板编号前缀
				var modulePanelTabId = selected.data.name+'ModulePanel';
				var moduleGridPanelId = selected.data.name+'GridPanel';
				//获得tabpanel对象
				var system_frame_center = Ext.getCmp('systemframe_center');
				//通过编号获得面板
				var tab = system_frame_center.getComponent(modulePanelTabId);
				
				if(!tab){//添加
					tab = system_frame_center.add({
						xtype:modulePanelTabId,
						title:selected.data.name_cn,
						id:modulePanelTabId,
						closable:true,
						//moduleId:selected.data.name
						iconCls:selected.data.icon
					});
					if(Ext.getCmp(moduleGridPanelId)){
						Ext.getCmp(moduleGridPanelId).getStore().load();
					}
				}
				system_frame_center.setActiveTab(tab);
				
				if(Ext.getCmp('resourceTreePanel')){
					Ext.getCmp('resourceTreePanel').expandAll();
				}
			//}else{
			//	Ext.MessageBox.alert("提示", "您没有使用权限！");
		//	}
        }
    },
    logoutSystemAction:function(){
		Ext.MessageBox.confirm("请确认","确定要退出系统吗?",function(button,text){
			if(button=="yes"){
		    	Ext.Ajax.request({
					url: 'j_spring_security_logout',
					success: function(response){
						location.href = 'showLogin.action';
					}
				});
			}
		});
    },
    userUpdatePassWord:function(){
		Ext.widget('userUpdatePasswordWindow');
    }
    
});