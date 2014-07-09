Ext.define('ExtAppSystem.store.system.SystemSelectTableStore', {
    extend: 'Ext.data.Store',
	alias: 'widget.systemselecttablestore',
    model: 'ExtAppSystem.model.SelectTableModel',
	autoLoad:true,
    data: [
        {id:'1',name: 'user',name_cn: '用户角色', icon: 'feed-list-item'}
        ,{id:'2',name: 'role',name_cn: '角色资源', icon: 'feed-list-item'}
    ]
});
