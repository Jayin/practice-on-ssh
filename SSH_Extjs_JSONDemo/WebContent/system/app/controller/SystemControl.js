Ext.define('ExtAppSystem.controller.SystemControl',{
	extend: 'Ext.app.Controller',

	views: [
		'system.user.UserModulePanel'
		,'system.user.UserGridPanel'
		,'system.user.UserGridPanelAddWindow'
		,'system.user.UserGridPanelEditWindow'
	],
    stores:['system.user.UserGridStore'],
    models:['system.user.UserGridModel'],
    refs: [
    	 //{ref: 'userGridPanel', selector: 'usergridpanel'}
    ],
    init: function () {
        this.control({
          	'usergridpanel button[action=add]': {
                click: this.openAddUserWindow
            },
            'usergridpanel button[action=edit]': {
                click: this.openEditUserWindow
            }
        });
    },
    openAddUserWindow:function(){
    	//销毁、重置
    	Ext.widget('useradd');
    },
    openEditUserWindow:function(){
    	if(Ext.getCmp('userGridPanel').getSelectionModel().getCount() == 0){
			Ext.MessageBox.alert("提示","请选择要修改的用户！");
    	}else{
	        var record = Ext.getCmp('userGridPanel').getSelectionModel().getSelection()[0];
	        if(record!=null){
	        	var view = Ext.widget('useredit');
	        	view.down('form').loadRecord(record);
	        }
		}
     }
});