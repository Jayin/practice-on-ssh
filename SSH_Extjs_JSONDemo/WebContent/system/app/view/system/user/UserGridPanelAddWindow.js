Ext.define('ExtAppSystem.view.system.user.UserGridPanelAddWindow', {
    extend: 'Ext.window.Window',
    alias : 'widget.useradd',
    title : '添加用户信息',
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
		                    xtype: 'textfield',
		                    fieldLabel: '用户名',
		                    //afterLabelTextTpl: required
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
                text: '保存',
                scope: this,
                handler: this.saveUser
            },{
                text: '取消',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    },
    saveUser: function() {
    	var addWindow = this;
	    var form = this.down('form').getForm();
        if (!form.isValid()) {
            Ext.MessageBox.alert("提示","请按提示填写表格内容!");
        }else{
        	form.submit({
	            url:  extPath+'/addUser.action',
	            success: function(form, action) {
	               Ext.MessageBox.alert("提示","保存成功!");
		    	   Ext.getCmp('userGridPanel').getStore().loadPage(1);
		    	   addWindow.hide();
	            },
	            failure: function(form, action) {
	                Ext.MessageBox.alert("提示","保存失败!用户编号或用户名已存在!");
	            }
        	});
        }
    }
});
