package com.hibernate.ch02.orm.test.one2many;

import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.one2many.Soldier;
import com.hibernate.ch02.orm.entity.one2many.Troop;


public class TestTroopDAO {
	public static void main(String[] args)
	{
		BaseDAO<Object> dao = new BaseDAO<Object>();
		
		Troop troop = new Troop();
		troop.setTroopCode("001");
		troop.setTroopName("珠海边防部队军营");
		
		Soldier soldier1 = new Soldier();
		soldier1.setSoldierCode("001");
		soldier1.setSoldierName("陈强");
		
		Soldier soldier2 = new Soldier();
		soldier2.setSoldierCode("002");
		soldier2.setSoldierName("李俊材");
		
		
		
		troop.getSoldiers().add(soldier1);
		troop.getSoldiers().add(soldier2);
		
		//soldier1.setTroop(troop);
		//soldier2.setTroop(troop);
		
		dao.saveObject(troop);
		
	}
}
