@Entity 声明一个类为实体bean(即一个持久化POJO类)

@table(name="tableName" ....)

实体Bean中static 和有注解@Transient 均不会被持久化(映射成一行) 

举个简单的例子
```java
@Entity
@Table(name="table_user") //指定表明,最好(必须)改为小写，win下数据库不区分大小写，linux下区分!
public class User {
	//主键 默认自动增长
	@Id
	@GeneratedValue 
	private Long id;
	//自动类型判断,不用
	private String name;
	
	// 指定约束，和列名
	@Column(unique=true,name="user_id",nullable=false)   
	private long userId;
	
	//比如密码比较密码啦，我们不保存到数据库,表对应的列也不会声场
	@Transient
	private long psw;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPsw() {
		return psw;
	}

	public void setPsw(long psw) {
		this.psw = psw;
	}
}

```

more exampel
```java
@Entity
@Table(name="article")
public class Article {
	
	@Id
	@GeneratedValue
	private Long id;
	
	//LOB(large object)是一种用于存储大对象的数据类型 
	//因为默认长度是255，太短了，一遍文章可能是2000+字，一张图片可以能10K
	@Lob 
	private String text;
	
	//一张图片可以能10K，所以用大对象来存储
	@Lob
	private byte[] img;
	
	@Column(name="post_time")
	@Temporal(TemporalType.TIMESTAMP) //时间的存储精度，默认是TIMESTAMP
	private Date posttime;
	
	@Enumerated(EnumType.ORDINAL) //集合的存储格式 默认是ORDINAL,存数字
	private ArticleType type;
	//.....getter setter
}

//test.java
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
```