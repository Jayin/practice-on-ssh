package com.hib.annotation.test;

import java.util.Date;

import com.hib.annotation.dao.ArticleDao;
import com.hib.annotation.dao.EassyDao;
import com.hib.annotation.entity.Article;
import com.hib.annotation.entity.ArticleType;
import com.hib.annotation.entity.Eassy;

public class TestInheritance {

	public static void main(String[] args) {
		Eassy e = new Eassy();
		e.setAuthor("Mk2");
		e.setPosttime(new Date());
		e.setText("this is a eassy");
		e.setType(ArticleType.MATH);
		
		EassyDao eassyDao = new EassyDao();
		eassyDao.add(e);
		
		Article a = new Article();
		a.setImg(new byte[]{1,1,1,1,1,});
		a.setPosttime(new Date());
		a.setText("adfasdfasdflaksdfasdjfojasflasjdflaskldfjasd");
		a.setType(ArticleType.SCIENCE);
		
		ArticleDao dao  = new ArticleDao();
		dao.add(a);
		
		
		
	}

}
