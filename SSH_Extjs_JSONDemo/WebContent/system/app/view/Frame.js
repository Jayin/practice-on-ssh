/**
 * 后台框架文件
 */
Ext.define('ExtAppSystem.view.Frame', {//命名规范：ExtAppSystem为工程的命名空间（即为该例子工程的example），Frame（首字母大写的为JS文件名）[若里面都为小写的就为其下的目录名]
	id : 'frame',//命名规范：为定义的组件名称小写，若多单词就已首字母小写驼峰式命名
	alias : 'widget.frame',
	extend : 'Ext.container.Viewport',
	requires: [
		'Ext.tip.QuickTipManager',
    	'Ext.menu.*'
    ],
	layout : 'border',
	items : [{
		id : 'frame_south',
		region : 'north',
		layout : 'fit',
		border : false,
		height : 30
	},{
		id : 'frame_center',
		region : 'center',
		border : false,
		layout:'border',
		items:[{
			xtype:'panel',
			title:'System',
			region:'west',
			id:'systemframe_centerframe',
			width:200,
			padding : '5 3 5 5',
			split : true,
			collapsible : true,
			layout : 'accordion',
			items:[
				{xtype:'systemselecttable', iconCls:'application_side_list',title:'系统管理模块'}
				,{xtype:'panel', iconCls:'application_side_list',title:'自定义模块'}
			]
		},{
			xtype:'tabpanel',
			region:'center',
			id:'systemframe_center',
			padding : '5 5 5 0',
			layout : 'fit',
			activeTab:0,
			items:[]
		},{
			//简历窗口最小化区域
			xtype:'panel',
			hidden:true,
			region:'south',
			id:'systemframe_south',
			layout : 'column'
		}]
	},{
		id : 'frame_north',
		region : 'south',
		layout : 'fit',
		height : 25,
		border : false,
		title: '<center>©2013 AsiaSoft Services Limited</center>'
	}]
});