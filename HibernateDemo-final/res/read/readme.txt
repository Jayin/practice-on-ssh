一.hibernate
Hibernate是一个对象关系映射框架，对JDBC进行了轻量级的对象封装，
程序员可以使用对象编程思维来操纵数据库，完成数据持久化。
http://www.hibernate.org/

1.在软件开发领域,模型用来表示真实世界的实体.

	概念模型(分析阶段):现实中事物的属性和行为
	逻辑模型/域模型(设计阶段):代码中对象的属性和方法
	物理模型/数据模型(实现阶段):数据库中表与列


2.三种模型的关系
				  		(分析阶段)
				       	概念模型
			_______________|________________
			|	         对象-关系映射(ORM)	   |
(设计阶段)逻辑模型/域模型<------------->物理模型/数据模型(实现阶段)	
		面向对象					             面向关系
		
3.实体之间的关联关系:
	OneToOne(1对1)
	OneToMany(1对多)/ManyToOne(多对1)
	ManyToMany(多对多)

4.关系模型概念:
本质就是一张二维表.
       数据库	                         概念模型
	表	---------- 实体
	字段	---------- 属性
	记录   ---------- 实例
	视图
	索引
	主键:1.唯一性2.不能为空3.不可修改. 代理主键:不具有业务逻辑含义.MySQL中:Auto_incerament(自动增长主键),uniqueidentify(唯一主键).
	触发器/存储过程
	
5.表的完整性
	实体的完整性(唯一性)
	参照完整性	 (主表与子表数据的一致性)
	域的完整性	 (类型与约束的检查)
	用户自定义的完整性(用户字定义的约束)
	
6.ORM:
	对象-关系映射（Object/Relation Mapping，简称ORM），是随着面向对象的软件开发方法发展而产生的。
		面向对象的开发方法是当今企业级应用开发环境中的主流开发方法，关系数据库是企业级应用环境中永久存放数据的主流数据存储系统。
	对象和关系数据是业务实体的两种表现形式，业务实体在内存中表现为对象，在数据库中表现为关系数据。
	内存中的对象之间存在关联和继承关系，而在数据库中，关系数据无法直接表达多对多关联和继承关系。
	因此，对象-关系映射(ORM)系统一般以中间件的形式存在，主要实现程序对象到关系数据库数据的映射。

		面向对象是从软件工程基本原则(如耦合、聚合、封装)的基础上发展起来的，而关系数据库则是从数学理论发展而来的，两套理论存在显著的区别。
	为了解决这个不匹配的现象,对象关系映射技术应运而生。

		让我们从O/R开始。字母O起源于"对象"(Object),而R则来自于"关系"(Relational)。几乎所有的程序里面，都存在对象和关系数据库。
	在业务逻辑层和用户界面层中，我们是面向对象的。当对象信息发生变化的时候，我们需要把对象的信息保存在关系数据库中。

		当你开发一个应用程序的时候(不使用O/R Mapping),你可能会写不少数据访问层的代码，用来从数据库保存，删除，读取对象信息，等等。
	你在DAL中写了很多的方法来读取对象数据，改变状态对象等等任务。而这些代码写起来总是重复的。
	
		如果打开你最近的程序，看看DAL代码，你肯定会看到很多近似的通用的模式。我们以保存对象的方法为例，你传入一个对象，
	为SqlCommand对象添加SqlParameter，把所有属性和对象对应，设置SqlCommand的CommandText属性为存储过程，
	然后运行SqlCommand。对于每个对象都要重复的写这些代码。
	除此之外，还有更好的办法吗？有，引入一个O/R Mapping。实质上，一个O/R Mapping会为你生成DAL。与其自己写DAL代码，
	不如用O/R Mapping。你用O/R Mapping保存，删除，读取对象，O/R Mapping负责生成SQL，你只需要关心对象就好。

	对象关系映射成功运用在不同的面向对象持久层产品中，如:Hibernate,iBatis,TopLink,Torque,OJB,Castor JDO, TJDO等。
	
一般的ORM包括以下四部分：
	一个对持久类对象进行CRUD操作的API；
	一个语言或API用来规定与类和类属性相关的查询；
	一个规定mapping metadata的工具；
	一种技术可以让ORM的实现同事务对象一起进行dirty checking, lazy association fetching以及其他的优化操作。

7.第一个Hibernate Demo
	hibernate.cfg.xml：
		hbm2ddl.auto：hibernate影射到生成操纵表结构语言属性讲解
			create:启动的时候会先drop,再create.
			create-drop:也表示创建,在系统关闭前执行drop.
			update:这个操作会在启动的时候去检查schema是否一致，如果不一致会做schema更新。（schema为数据库对象的集合）
			validate:启动时验证现有的schema与你配置的hibernate是否一致，如果不一致则抛出异常,并不做更新。
8.介绍Hibernate主要接口
9.实现一个简单的例子
	1.引入核心jar包，注意log4j及slf4j,slf4j-log4j的版本问题
	2.引入配置文件：hibernate.cfg.xml/hibernate.properties,log4j.properties
	3.开始编写第一个HelloWorld
		1）编写实体类      (EntityBean/JavaBean)
		2）编写映射文件(ClassName.hbm.xml)
		3）编写配置文件
		4）编写持久层DAO
		5）编写测试类Test(Service)		
	
10.实现原理：
	1).Configuration加载hibernate.cfg.xml文件
	2).生成SessionFactory
	3).加载对象-关系映射文件 *.hbm.xml
	4).创建session对象
	5).调用session API操纵对象
	6).根据Dialect生成和数据库相关的SQL语句
   	*7).对JDBC封装,执行SQL脚本

11.主要实现技术：
	1.DOM解析XML文件/基于注解
	2.反射机制：照镜子，可以看清楚自己各个部位。
		JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
		对于任意一个对象，都能够调用它的任意一个方法和属性；
		这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
		Java反射机制主要提供了以下功能： 
			在运行时判断任意一个对象所属的类；在运行时构造任意一个类的对象；
			在运行时判断任意一个类所具有的成员变量和方法；
			在运行时调用任意一个对象的方法；生成动态代理。

12.Hibernate对象三种状态
	Transient瞬时状态：数据库中没有对应的数据，id没有纳入session的管理，没有持久化标识（id）,随时都有可能被垃圾回收。
	Persist持久化状态：数据库中有对应的数据，id有纳入session的管理,特点：属性与数据库中字段保持一致。
	Detached托管状态/游离状态:没有纳入session管理，但数据在数据库中存在。

	save用例：瞬时，持久，托管三种状态的转换：用new,set为瞬时状态,用session的save方法时为持久状态，当session关闭后变为游状态。
	查看com.hibernate.dao.EventDAO例子 及 记忆Hibernate对象三种状态.png图

13.getCurrentSession()与openSession()区别：
	1)getCurrentSession()创建的session会绑定到当前线程，而openSession()不会。
	2)getCurrentSession()在事务提交或事务回滚后会自动关闭session,而OpenSession()需要在finally内手工关闭。
	在getCurrentSession()本地事物（JDBC事务）时候需要配置：
	<property name="current_session_context_class">thread</property>
	在getCurrentSession()全局事物（JTA事务）时候需要配置：
	<property name="current_session_context_class">jta</property>
	3)getCurrentSession()使用当前session,openSession()新建一个session.

14.使用getCurrentSession()的优点：
	1)非常适合web程序，并发管理十分容易，session由线程产生，而且能够保证一个线程总是只有一个session.
	2)资源回收变得轻松。session将在commit()或者rollback()后自动释放，无须再写finally语句。
	3)事务管理十分直观，一般来说在业务层或者service层的方法前后用上面的三个语句包住，就可以让该方法的原子性得到保证。
	4)由于3)的方式应用十分普遍，用spring AOP对service层进行事务控制就更简单了，上面三行代码甚至都不必写。




15.设计一个持久层的基类重用CURD的代码实现优化
	session API实现CRUD操作
		session.save(Object):
			方法用于从数据库中创建与Java对象对应的记录。
			当前对象为持久化状态时，执行save方法，则会执行update语句。
			当前对象为瞬时状态时，执行save方法，则会执行insert语句,从瞬时状态装换为持久化状态。

		session.delete(Object)
			方法用于从数据库中删除与Java对象对应的记录。
			如果传入的参数是持久化对象，Session就计划执行一个delete语句。
			如果传入的参数是游离对象，先使游离对象被Session关联，使它变为持久化对象，然后计划执行一个delete语句。
			值得注意的是，Session只有在清理缓存的时候的才执行delete语句。
			此外，只有当调用Session的close()方法时，才会从Session的缓存中删除该对象。
			果希望删除多个对象，可以使用另一种重载形式的delete()方法：
			session.delete("from Customer as c where c.id>8"); 

		session.update(Object)
			方法用于从数据库中更新与Java对象对应的记录。
			把Object对象重新加入到Session的缓存中，使它变为持久化对象。
			1)Session只有在清理缓存的时候才会执行update语句，并且在执行时才会把Object对象当前的属性值组装到update语句中。
			因此，即使程序中多次修改了Object对象的属性，在清理缓存时只会执行一次update语句。
			2)只要通过update()方法使游离对象被一个Session关联，即使没有修改Object对象的任何属性，
			Session在清理缓存时也会执行由update()方法计划的update语句。
			3)如果希望Session仅仅当修改了Customer对象的属性时，才执行update语句，可以把映射文件中<class>元素的select-before-update设为true，该属性默认值为false:
        		<class name="Customer" table="CUSTOMERS" selecet-before-update="true">
			如果按以上方式修改了Customer.hbm.xml文件，当Session清理缓存时，会先执行一条select语句：
        		select * from CUSTOMERS where ID=1;
			然后比较Customer对象的属性是否和从数据库中检索出来的记录一致，只有在不一致的情况下，才执行update语句。
			应用根据实际情况来决定是否应该把select-before-update设为true。
			如果Java对象的属性不会经常变化，可以把select-before-update属性设为true，避免Session执行不必要的update语句，
			这样会提高应用程序的性能。如果需要经常修改Java对象的属性，就没必要把这个属性设为true，
			因为它会导致在执行update语句之前，执行一条多余的select语句。

		session.get()/session.load()的区别:
			get和load方式是根据id取得一个记录
			下边详细说一下get和load的不同，因为有些时候为了对比也会把find加进来。
			1).从返回结果上对比：
			load方式检索不到的话会抛出org.hibernate.ObjectNotFoundException异常
			get方法检索不到的话会返回null

			2).从检索执行机制上对比： get方法和find方法都是直接从数据库中检索 而load方法的执行则比较复杂首先查找session的persistent Context中是否有缓存，
			如果有则直接返回 如果没有则判断是否是lazy，如果不是直接访问数据库检索，查到记录返回，查不到抛出异常 如果是lazy则需要建立代理对象，
			对象的initialized属性为false，target属性为null 在访问获得的代理对象的属性时,检索数据库，如果找到记录则把该记录的对象复制到代理对象的target上，
			并将initialized=true，如果找不到就抛出异常。

			3).根本区别说明
			 如果你使用load方法，hibernate认为该id对应的对象（数据库记录）在数据库中是一定存在的，所以它可以放心的使用，它可以放心的使用代理来 延迟加载该对象。
			 在用到对象中的其他属性数据时才查询数据库，但是万一数据库中不存在该记录，那没办法，只能抛异常。所说的load方法抛异常是指在使用 该对象的数据时，
			 数据库中不存在该数据时抛异常，而不是在创建这个对象时(注意：这就是由于“延迟加载”在作怪)。

			由于session中的缓存对于hibernate来说是个相当廉价的资源，所以在load时会先查一下session缓存看看该id对应的对象是否存在，不存在则创建代理。
			所以如果你知道该id在数据库中一定有对应记录存在就可以使用load方法来实现延迟加载。

			对于get方法，hibernate会确认一下该id对应的数据是否存在，首先在session缓存中查找，然后在二级缓存中查找，还没有就查数据库，数据库中没有就返回null。

			对于load和get方法返回类型：虽然好多书中都这么说：“get()永远只返回实体类”，但实际上这是不正确的，get方法如果在 session缓存中找到了该id对应的对象，
			如果刚好该对象前面是被代理过的，如被load方法使用过，或者被其他关联对象延迟加载过，那么返回的还是 原先的代理对象，而不是实体类对象，
			如果该代理对象还没有加载实体数据（就是id以外的其他属性数据），那么它会查询二级缓存或者数据库来加载数据，但是 返回的还是代理对象，只不过已经加载了实体数据。

			get方法首先查询session缓存，没有的话查询二级缓存，最后查询数据库；
			load方法创建时首先查询session缓存，没有就创建代理，实际使用数据时才查询二级缓存和数据库。

			4).简单总结
			总之对于get和load的根本区别，一句话，
			hibernate对于load方法认为该数据在数据库中一定存在，可以放心的使用代理来延迟加载，如果在使用过程中发现了问题，只能抛异常；
			而对于get方法，尝试要获取到真实的数据，获取失败则返回null。
		
		session.saveOrUpdate()/session.merge()的区别:
			1)saveOrUpdate(Object):瞬时状态变为持久状态的时候，不确定主键是否冲突，推荐使用。
			如果数据库中有该记录，则无条件执行update，如果不存在该记录，则执行insert操作。
			2)merge(Object)：返回一个持久化对象，而实参Object本身还是托管状态，如果数据库中有该记录，则更新该记录，如果不存在该记录，则执行insert操作。
			区别：
			1)merge是把我们提供的对象转变为托管状态，saveOrUpdate则是为我们提供的对象变为一个持久化对象。
			2)merge后的对象不会纳入session的管理，再次查询该对象还是会从数据库中取。
			saveOrUpdate后的对象会纳入session的管理，对象的状态会跟数据库同步。再次查询该对象会从session中取。
		
		session.createQuery/session.find区别：
			1)createQuery仅仅是生成一个Query的对象  同时初始化查询缓存。但是实际的queryString并没有提交到数据库。
			就这点来看这是和find的最大视觉区别 而find方法执行后会将查询请求提交到数据库。 
			而createQuery进行.iterate()或者.list()后才提交查询。
		 	2)两者最大的本质不同在于createQuery()操作可以进行.iterate()来延迟加载数据结果集，这在数据量很大的时候是非常必要的。
		 	而find直接一次性返回了List格式的结果集  通常来讲在小数据量精确查询的时候比较受欢迎。
	
16.主键生产策略:
	1)Assigned手动分配数据库主键增长方式.assigned数据库主键增长方式，主键必须是手动分配的，如果不分配，就出错了。
	2)hilo主键生成方式:使用高低位算法生成主键,高低位算法使用一个高位值和一个低位值,然后把算法得到的两个值拼接起来作为数据库的唯一主键.
	这种方式需要额外的数据库表和字段提供高位来源.能保证同一个数据库中主键的唯一性,但不能够保证多个数据库之间主键的唯一性.该生成方式由
	hibernate维护,所以hilo方式与底层数据库无关,但不应该手动修改该算法使用的表值.否则会引起主键重复的异常.
	3)Increment主键自动增长的方式:要求底层数据库支持Sequence.
	如:Oracle,DB2等,需要在映射文件中加入,Increment标志符的设置.
	特点:由hibernate本身维护,适用于所有的数据库,不适合多进程并发更新数据库,适合单一进程数据库,不能用于群集环境.
	4)Identity(常用):根据当前底层数据库,来支持自动增长,不同的数据库用不用的主键增长方式.
	特点:与底层数据库有关,使用于MySQL,DB2,MSSQL Server,采用数据库生成主键,用于为Long,short,int类型生成唯一标识.
	该方式在Oracle中你自己添加自增字段,需要设置sequence,Identity无须Hibernate和用户干涉,使用较为方便,但不便于不同数据库之间移植程序.
	5)sequence:Oracle,DB2.等数据库主键生成方式.由数据库来维护这个sequence序列，保证每次取到唯一的值。
	6)native(常用):主键生成方式会根据不同的数据库自动选择Identity，sequence，hilo生成方式。特点：根据不同底层数据库采用不同的映射方式，因此便于程序的移植，项目中
	如果使用到了多个数据库时，可以使用该方式。
	7)uuid(常用):使用128位算法生成主键，能够保证网络环境下主键唯一性，也能够保证在不同数据库及不同服务器下主键的唯一性。特点：能够保证数据库中主键唯1性，
	生成主键较占用比多的存放空间。查找的时候要相对慢些，因为串的查找要比数字的查找慢.
 

二.ORM:学习使用注解JPA规范Annotation
关联关系:将关联关系映射到数据库，关联关系是指对象模型在内存中的一个或者多个引用。

1)关联就像导航.
2)单向关联:简单的讲：取出A的同时会去查询与A关联的B,取出B的时候不会去查询与B有关的A.(A为主B为从)
3)双向关联:简单的讲：取出A的同时会去查询与A关联的B,取出B的时候也会去查询与B有关的A.(A为主B为从)

Hibernate提供这些映射关系，常用就是一对一和一对多，并且在能不用连接表的时候尽量不要用连接表。
多对多会用到，如果用到了，应该首先考虑底层数据库设计是否合理。

 

在实际开发中，在Hibernate关联关系之外常常还有另外一种选择方案，表各自作为单表映射，业务逻辑控制外键关系（有时候就是一个相关联的列，但不一定要加外键约束），这样更加灵活，并且数据的完整性同样有保证。
建议:
先保存外键对象,再保存主对象.除非使用级联策略.cascade=CascadeType.ALL,级联更新与级联保存主要考虑数据是否已经持久化到数据库
CascadeType.REFRESH：级联刷新，当多个用户同时作操作一个实体，为了用户取到的数据是实时的，在用实体中的数据之前就可以调用一下refresh()方法！
CascadeType.REMOVE：级联删除，当调用remove()方法删除Order实体时会先级联删除OrderItem的相关数据！
CascadeType.MERGE：级联更新，当调用了Merge()方法，如果Order中的数据改变了会相应的更新OrderItem中的数据，
CascadeType.ALL：包含以上所有级联属性。
（注：以上几种级联操作，只能实在满足数据库的约束时才能生效，比如上边的Order和OrderItem存在主外键关联所以执行REMOVE()方法时是不能实现级联删除的）
CascadeType.PERSIST：级联保存，当调用了Persist() 方法，会级联保存相应的数据

9.ORM例子
1)实现一个ORM例子优化程序，为持久层编写一个公共的基类.（继承：代码的重用）
逻辑映射注解：描述对象模型，类之间的关系等等。
物理映射注解：描述了物理的schema,表,列,索引等等。

2)@Entity：注意：实体类的名称与属性避免使用关键字。(create,update,column,order,user)
3)@Id：
4)@GeneratedValue：
5)简单属性注解：@Column,@Basic,@Temporal,@Enumerated,@Lob
	注意：
		获取策略(普通属性):
			LAZY:延迟获取
			EAGER:即时获取（默认）
		加载策略(关联对象属性):
6)继承关系映射：
	@Inheritance指定继承关系到数据库的结构、策略
			InheritanceType.TABLE_PER_CLASS每个类一张表（不建议,不能使用AUTO 和 IdEntity生成器）
			InheritanceType.SINGLE_TABLE  每个类层次结构一张表（常用）
			InheritanceType.JOINED 连接的子类
	@DiscriminatorColumn用于重命名辨别符列。辨别符列默认名称为DTYPE
	@DiscriminatorValue用于定义辨别符列的值。辨别符列的值默认名为实体名
	
	@MappedSuperclass：该注解标识的类不会被持久化到数据库，但该类的属性可以通过继承被持久化到数据库
	注意：在继承该类的属性中不能重复定义父类所拥有的属性。

10.ORM关联关系
1.继承
2.ORM之一对一和联合主键实现 :@OneToOne
	1对1单向外键关联(fk):@JoinColumn(name="fk_id",unique="true") unique:唯一的
	1对1双向外键关联(bfk):双向关联必须使用mappedBy指定外键对象.
	1对1单向联合主键关联(ufk):
		主键类必须实现serializable接口,并重写hashCode()和equals()方法.
		主键类@Embeddable
		实体类联合主键@EmbeddedId
		主控类@JoinColumns
	1对1组件关联-
		组件类就是一个POJO类(简单的Java对象(Plain Old Java Objects)实际就是普通JavaBeans)
		实体类@Embedded
	@PrimaryKeyJoinColumn:共享主键
3.ORM之一对多关联 @OneToMany/@ManyToOne
	多对1单向外键关联:一般由多的一端来维护关联关系
	1对多单向外键关联
	1对多双向外键关联
4.ORM之多对多关联 @ManyToMany
	多对多单向外键关联
	多对多双向外键关联

@OneToOne
@OneToMany/@ManyToOne
@ManyToMany
@JoinColumn：外键关联
@JoinTable：关联表关联
mappedBy=""在双向关联的使用



Hibernate关联关系映射目录
│ 
├─单向关联
│  ├─  一对一外键单向关联
│  ├─  一对一主键单向关联
│  ├─  一对一连接表单向关联
│  ├─  一对多外键单向关联
│  ├─  一对多连接表单向关联
│  ├─  多对一外键单向关联
│  ├─  多对一连接表单向关联
│  └─  多对多单向关联
└─双向关联
    ├─  一对一外键双向关联
    ├─  一对一主键双向关联
    ├─  一对一连接表双向关联
    ├─  一对多外键双向关联
    ├─  一对多连接表双向关联
    └─  多对多双向关联

三：HQL
1.HQL的使用
2.抓取策略 
	延迟加载策略：获取对象A的时候，不会同时获取A对象关系的B对象或集合
	即时加载策略：获取对象A的时候，会同时获取A对象关系的B对象或集合
3.fetch关键字
4.HQL的三种传值方式 

四：扩展内容
1.Criteria接口实现条件查询 
2.Hibernate缓存机制 
3.悲观锁和乐观锁以及1+N问题 
4.Hibernate4的新特征 

五：后续例子整合内容
1.Hibernate与struts2的整合 ：http://www.dzone.com/tutorials/java/struts-2/struts-2-tutorial/struts-2-tutorial.html




