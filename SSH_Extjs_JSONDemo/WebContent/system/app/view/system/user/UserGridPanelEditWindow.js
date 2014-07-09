Ext.define('ExtAppSystem.view.system.user.UserGridPanelEditWindow', {
    extend: 'Ext.window.Window',
    alias : 'widget.useredit',
    title : '修改用户信息',
    width: 620,
    height: 460,
    layout: 'fit',
    autoShow: true,
    initComponent: function() {
     this.items = [{
            xtype: 'form',
            bodyPadding: '5 5 0',
	        fieldDefaults: {
	        	msgTarget: 'side',
	            labelWidth: 75
	        },
	        defaults: {
	            anchor: '100%'
	        },
        	defaultType: 'textfield',
            items: [{
		        xtype: 'fieldset',
		        title:'基本信息',
		        items:[{
	            		layout: 'form',
	            		border:false,
	            		items:[{
		                	xtype: 'hidden',
			                name: 'id'
		                },{
		                    xtype: 'textfield',
		                    fieldLabel: '用户名',
		                    readOnly:true,
		                    
		                    name: 'userName',
		                    allowBlank: false
		                }, {
		                    xtype: 'textfield',
		                    fieldLabel: '密码',
		                    //afterLabelTextTpl: required,
		                    allowBlank: false,
		                    name: 'password'
		                }]
            		}]
         	}]
         }];

        this.buttons = [
            {
                text: '更新',
                scope: this,
                handler: this.updateUser
            },{
                text: '取消',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    },
    updateUser: function() {
    	var editWindow = this;
	    var form = this.down('form').getForm();
        if (!form.isValid()) {
            Ext.MessageBox.alert("提示","请按提示填写表格内容!");
        }else{
        	form.submit({
	            url:  extPath+'/updateUser.action',
	            success: function(form, action) {
	               Ext.MessageBox.alert("提示","更新成功!");
		    	   Ext.getCmp('userGridPanel').getStore().loadPage(1);
		    	   editWindow.hide();
	            },
	            failure: function(form, action) {
	                Ext.MessageBox.alert("提示","更新失败!");
	            }
        	});
        }
    }
});
