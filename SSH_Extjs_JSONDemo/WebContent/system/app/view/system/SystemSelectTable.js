Ext.define('ExtAppSystem.view.system.SystemSelectTable', {
	extend: 'Ext.panel.Panel',
	alias: 'widget.systemselecttable',
	collapsible: true,
	animCollapse: true,
	margins: '0 0 0 0',
	layout: 'fit',
	initComponent: function() {
		Ext.apply(this, {
			items: [{
				xtype: 'dataview',
				trackOver: true,
				store:this.store,
				cls: 'feed-list',
				itemSelector: '.feed-list-item',
				overItemCls: 'feed-list-item-hover',
				tpl: '<tpl for="."><div class="{icon}" name="{name}">{name_cn}</div></tpl>'
			}]
		});
		this.callParent(arguments);
	}
});