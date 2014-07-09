Ext.define('ExtAppSystem.view.system.user.UserModulePanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.userModulePanel',
	
    requires: ['Ext.toolbar.Toolbar'],
    autoScroll: true,
    border: false,
  	layout: {
        type: 'fit'
    },
    initComponent: function() {
        Ext.apply(this, {
            items: [{xtype:'usergridpanel'}]
        });

        this.callParent(arguments);
    }
});
