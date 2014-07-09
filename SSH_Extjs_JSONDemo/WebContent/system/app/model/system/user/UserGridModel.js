Ext.define('ExtAppSystem.model.system.user.UserGridModel', {
    extend: 'Ext.data.Model',
    fields: [
    	 {name: 'id',mapping: 'id',type: 'int'}
        ,{name: 'userName',mapping: 'userName', type: 'string'}
        ,{name: 'password',mapping: 'password', type: 'string'}
    ]
});