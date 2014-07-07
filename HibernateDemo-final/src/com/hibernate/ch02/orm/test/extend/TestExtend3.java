package com.hibernate.ch02.orm.test.extend;



import com.hibernate.ch02.orm.dao.BaseDAO;
import com.hibernate.ch02.orm.entity.extend.ex3.Boat;
import com.hibernate.ch02.orm.entity.extend.ex3.Ferry;
import com.hibernate.ch02.orm.entity.extend.ex3.SailerBoat;

public class TestExtend3 {
	public static void main(String[] args) {
		BaseDAO<Object> dao = new BaseDAO<Object>();
		
	
		Boat boat = new Boat();
		boat.setBoatCode("0001");
		boat.setBoatName("Ìú´ïÄá");
		
		Ferry ferry = new Ferry();
		ferry.setBoatCode("0002");
		ferry.setBoatName("Ìú´ïÄá2");
		ferry.setFerryCode("f00001");
		
		SailerBoat sailer = new SailerBoat();
		sailer.setBoatCode("0003");
		sailer.setBoatName("Ìú´ïÄá3");
		sailer.setSailerBoatCode("s000001");
		
		
		dao.saveObject(boat);
		dao.saveObject(ferry);
		dao.saveObject(sailer);
		
		
	}
}
