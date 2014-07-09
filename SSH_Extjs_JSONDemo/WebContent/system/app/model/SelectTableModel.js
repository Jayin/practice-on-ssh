Ext.define('ExtAppSystem.model.SelectTableModel', {
    extend: 'Ext.data.Model',
    proxy: {
        type: 'memory'
    },
    fields: [
        {name: 'id', type: 'string'},
        {name: 'name', type: 'string'},
        {name: 'name_cn', type: 'string'},
        {name: 'icon',  type: 'string'}
    ]
});