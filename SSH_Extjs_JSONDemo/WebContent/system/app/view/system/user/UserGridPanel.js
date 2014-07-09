Ext.define('ExtAppSystem.view.system.user.UserGridPanel', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.usergridpanel',
	id:'userGridPanel',
    requires: [
    	 'Ext.toolbar.Toolbar'
    ],
    initComponent: function() {
        Ext.apply(this, {
				store: 'system.user.UserGridStore',
		        columnLines: true,
		        selModel: Ext.create('Ext.selection.CheckboxModel'),
		        columns: [
			         {text     : 'id', width    : 97,sortable : true,dataIndex: 'id'}
			        ,{text     : 'User Name', width    : 97,sortable : true,dataIndex: 'userName'}
			        ,{text     : 'Password',width    : 97, sortable : true, dataIndex: 'password'}
		        ],
		        dockedItems: [{
					xtype: 'toolbar',
					items: [{
                    text: '用户编号',
                    id: 'userGridPanelQueryConditionMenu',
                    iconCls: 'application_form_magnify',
                    menu: {
                        items: [
                        	 {text: '用户编号',checked: true,group: 'queryCondition',handler:this.setSeachText}
                        	,{text: '用户名',checked: false,group: 'queryCondition',handler:this.setSeachText}
                      	]
                    }
                },{
	                 xtype: 'textfield',
	                 name: 'searchField',
	                 id:'userGridPanelSearchField',
	                 hideLabel: true,
	                 width: 200
	            },'-',{
		                iconCls: 'icon-seach',
		                text: '查询',
		                scope: this,
		                handler: this.toSecrch
		            },'-',{
		                iconCls: 'icon-more-seach',
		                text: '高级查询',
		                scope: this,
		                handler: this.moreSecrch
		            },'-',{
		                iconCls: 'drop-add',
		                text: '添加',
		                action: 'add'
		            },'-',{
		                iconCls: 'icon-update',
		                text: '修改',
		                action: 'edit'
		            },'-',{
		                iconCls: 'icon-delete',
		                text: '删除',
		                //scope: this//,
		                handler:this.deleteAction
		            }]
		        }],
		   		bbar: Ext.create('Ext.PagingToolbar', {
		   			id:'userGridPanelToolbar',
		            store: 'system.user.UserGridStore',
		            displayInfo: true,
		            displayMsg: '显示 {0} - {1} 共 {2} 条记录',
		            emptyMsg: "没有数据显示"//,
		            //items:[]//添加下拉列表选择每次现实的记录数 10.20.30
		        }),
		        title: '用户列表',
		        viewConfig: {
		            stripeRows: true
		        }
        });

        this.callParent(arguments);
    },
    setSeachText: function(item) {
		Ext.getCmp('userGridPanelQueryConditionMenu').setText(item.text);
    },
    toSecrch:function(item) {
		var secrchParamet = Ext.getCmp('userGridPanelQueryConditionMenu').getText();
		var secrchValue = Ext.getCmp('userGridPanelSearchField').getValue();

    	if(secrchValue!=null){
			if (secrchParamet ==  '用户编号') {
				Ext.apply(this.getStore().proxy.extraParams,{
					'userQueryConditionDTO.userId': "",
					'userQueryConditionDTO.userCode': secrchValue,
					'userQueryConditionDTO.userName': ""
				
				});
			}else if (secrchParamet ==  '用户名') {
				Ext.apply(this.getStore().proxy.extraParams,{
					'userQueryConditionDTO.userId': "",
					'userQueryConditionDTO.userCode': "",
					'userQueryConditionDTO.userName': secrchValue
				});
			}
		}else{
			Ext.apply(this.getStore().proxy.extraParams,{
				'userQueryConditionDTO.userId': "",
				'userQueryConditionDTO.userCode': "",
				'userQueryConditionDTO.userName': ""
			});
		}
	    //this.getStore().load({params: { start: 0,page:1,limit: 10 }});
	    this.getStore().loadPage(1);
    },
    moreSecrch: function(btn) {
       var userGridPanel  = this;
       var moreSecrchWindow = Ext.create('Ext.window.Window', {
            width: 280,
            height: 60,
	        minWidth: 280,
	        minHeight: 210,
	        layout: 'fit',
            title: '高级查询',
            items:[{
		        xtype: 'form',
		        frame: true,
		        bodyPadding: '5 5 0',
		        width: 350,
		        fieldDefaults: {
		        	autoFitErrors: false,
		            msgTarget: 'side',
		            labelWidth: 80
		        },
		        defaultType: 'textfield',

		        items: [{
		            fieldLabel: '用户编号',
		            name: 'userCode'
		        },{
		            fieldLabel: '用户名',
		            name: 'userName'
		        }]
		    }],
		    dockedItems: [{
	            xtype: 'toolbar',
	            dock: 'bottom',
	            ui: 'footer',
	            layout: {
	                pack: 'center'
	            },
	            items: [{
	                minWidth: 80,
	                text: '查询',
	                handler: function(){
						var moreSecrchForm = moreSecrchWindow.down('form');
            			Ext.apply(userGridPanel.getStore().proxy.extraParams,{
            				'userQueryConditionDTO.userId': "",
            				'userQueryConditionDTO.userCode': moreSecrchForm.getForm().findField('userCode').getValue(),
							'userQueryConditionDTO.userName': moreSecrchForm.getForm().findField('userName').getValue()
						});
					    userGridPanel.getStore().loadPage(1);
						moreSecrchWindow.hide();
                	}
	            },{
	                minWidth: 80,
	                text: '取消',
	                handler: function(){
	                	moreSecrchWindow.hide();
	                }
	            }]
        	}]
        });
        moreSecrchWindow.show();        
    },
   
    deleteAction:function() {
    	var thisGrid= Ext.getCmp('userGridPanel');
		var data = thisGrid.getSelectionModel().getSelection();
		var dataCount = thisGrid.getSelectionModel().getCount();
		if(dataCount == 0){
			Ext.MessageBox.alert("提示","请选择要删除的信息！");
		}else{
			Ext.MessageBox.confirm("请确认","数据删除后无法还原,确定要删除吗?",function(button,text){
				if(button=="yes"){
					var ids =[];
					Ext.Array.each(data,function(record){
						var userId = record.get('id');
						//if(record.get('userType') != 'SYSTEM'){
							if(userId){
								ids.push(userId);
							}
						//}
					});
					alert(ids.length);
					if(ids.length>0){
						Ext.Ajax.request({
							url: extPath+'/deleteUser.action',
							params: {
								userIds : ids
							},
							method:'POST',
							success: function(response,opts){
								Ext.MessageBox.alert("提示","删除成功！");
								thisGrid.getStore().loadPage(1);
							},
							failure: function(){
							    Ext.MessageBox.alert("提示","删除失败！");
							}
						});
					}else{
						Ext.MessageBox.alert("提示","系统内置用户不可删除！");
					}
				}
			});
		}
    },
    
    userStatusRender: function(value) {
	    var result;
	    switch (value) {
	    	case 'NORMAL':
	    		result = '<span style="color:green">正常</span>';
	            break;
	        case 'UNNORMAL':
	        	result = '<span style="color:red">异常</span>';
	            break;
	    }
	    return result;
    },
    	
    userTypeRender: function(value) {
	    var result;
	    switch (value) {
	    	case 'SYSTEM':
	    		result = '<span style="color:blue">系统内置用户</span>';
	            break;
	        case 'STAFF':
	        	result = '<span style="color:green">员工用户</span>';
	            break;
	        case 'OTHERS':
	        	result = '<span style="color:red">其他用户</span>';
	            break;
	            
	    }
	    return result;
    }
});
