package com.hib.dao;


import com.hib.dao.base.IBaseDao;

public interface IEventDao<Event> extends IBaseDao<Event>{
	//定义 IEventDao 的特定业务逻辑
	public void deleteAll();
}

	 
