Ext.define('ExtAppSystem.store.system.user.UserGridStore', {
	extend : 'Ext.data.Store',
	alias : 'widget.usergridstore',
	pageSize:30,
	model:'ExtAppSystem.model.system.user.UserGridModel',
	autoLoad:false,
    proxy: {
        type: 'ajax',
        url : extPath+'/findAllUsers.action',
        actionMethods : {
			read : 'POST'
		},
        reader: {
            type: 'json',
            root: 'userLists',
            totalProperty:'total'
        }
    }
});