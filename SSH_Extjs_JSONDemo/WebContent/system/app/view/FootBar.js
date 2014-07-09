Ext.define('ExtAppSystem.view.FootBar', {
	// 扩展
	extend : 'Ext.toolbar.Toolbar',
	alias : 'widget.frameToolbar',
	// 取消边框
	border : false,
	place:'footer',
	autoLoad:{
		url:extPath+"/system/data/Component.js",
		renderer:"component",
		loadMask:true
	}
});