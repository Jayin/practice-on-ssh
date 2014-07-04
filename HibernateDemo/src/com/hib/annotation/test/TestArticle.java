package com.hib.annotation.test;

import java.util.Date;

import com.hib.annotation.dao.ArticleDao;
import com.hib.annotation.entity.Article;
import com.hib.annotation.entity.ArticleType;

public class TestArticle {
	
	public void add(){
		Article a = new Article();
		a.setImg(new byte[]{1,1,1,1,1,});
		a.setPosttime(new Date());
		a.setText("adfasdfasdflaksdfasdjfojasflasjdflaskldfjasd");
		a.setType(ArticleType.MATH);
		
		ArticleDao dao  = new ArticleDao();
		dao.add(a);
	}

	public static void main(String[] args) {
		TestArticle t = new TestArticle();
		t.add();
	}
}
