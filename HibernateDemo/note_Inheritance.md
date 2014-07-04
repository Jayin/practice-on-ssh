
4种策略： 只列举2种常用 
//默认,每个层次结构一张表
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)    
```java
//父类Article

@Entity
@Table(name="article")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
public class Article {
	
	@Id
	@GeneratedValue
	private Long id;
	

	@Lob 
	private String text;
	
	@Lob
	private byte[] img;
	
	@Column(name="post_time")
	@Temporal(TemporalType.TIMESTAMP)  
	private Date posttime;
	
	@Enumerated(EnumType.ORDINAL) 
	private ArticleType type;
	//...
}

//子类 Eassy
@Entity
public class Eassy extends Article {
	
	private String author;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}

```

//TestInheritance.java
```java
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
```

最终,生成了一张article表
```xml
id  |  img  |  post_time |  text  | type | author |
........
```

========

@MappedSuperclass 
例子直接上
```java
//父类
@MappedSuperclass
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	//..。。
}

//子类
@Entity
@javax.persistence.Table(name = "dog")
public class Dog extends Animal {
	
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}

//Test.java

		Dog d = new Dog();
		d.setName("MK2");
		d.setWord("wowowo");
		
		DogDao dao = new DogDao();
		dao.add(d);
```

最终生成表：
```xml
id | name | word
```




