### 获取数据库 session 单例模式
```java
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
```

### CURD操作
```java
	//example
	public T findById(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//get or load
		T result = (T) session.get(this.entity, id);

		session.getTransaction().commit();
		return result;
	}
```

>方法均在Session里面


### getSessionFactory().getCurrentSession和openSession的区别：
getCurrentSession是**线程安全**的，会自动回滚事物以及关闭会话，
	 <property name="current_session_context_class">thread</property>
	
openSession是**非线程安全**的，需要手工捕获异常回滚事物以及关闭会话，
	 
### session.get() or session.load()的区别
 
get和load方式是根据id取得一个记录
下边详细说一下get和load的不同，因为有些时候为了对比也会把find加进来。
* 1).从返回结果上对比：
   load方式检索不到的话会抛出org.hibernate.ObjectNotFoundException异常;get方法检索不到的话会返回null
* 2).从检索执行机制上对比： get方法和find方法都是直接从数据库中检索 而load方法的执行则比较复杂首先查找session的persistent Context中是否有缓存，如果有则直接返回 如果没有则判断是否是lazy，如果不是直接访问数据库检索，查到记录返回，查不到抛出异常 如果是lazy则需要建立代理对象，对象的initialized属性为false，target属性为null 在访问获得的代理对象的属性时,检索数据库，如果找到记录则把该记录的对象复制到代理对象的target上，并将initialized=true，如果找不到就抛出异常。

>load的时候：发生
>LazyInitializationException: could not initialize proxy - no Session	因为没有初始化代理，会话已经关闭
>必须把类配置为   <class name="Event"  load lazy="false">
