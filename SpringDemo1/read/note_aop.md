### config
```xml
<beans 
	xmlns="http://www.springframework.org/schema/beans"
 	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	
	xmlns:aop="http://www.springframework.org/schema/aop" 
	xsi:schemaLocation=".....
	http://www.springframework.org/schema/aop 
	http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
	<!-- 自动代理 -->
	<aop:aspectj-autoproxy />
	<!-- 必须在配置文档生命切片类，否则无法切片-->
	<bean class="com.spring.aop.MyAspect"> 
		<!-- configure properties of aspect here as normal --> 
	</bean>   
</beans>
```

### 切片类定义

```java

@Aspect
public class MyAspect {

	//添加操作的事务
	@Pointcut("execution(public * add*(..))")
	private void addAspect(){}
	
	//删除操作的事务
	@Pointcut("execution(public * delete*(..))")
	private void deleteAspect(){}
	
	//切入到所有service包下的类
	@Pointcut("within(com.spring.service.*)")
	private void allService(){};
	
	//纯表达式AjectJ表达式
	@Before(value="execution(public * *(..)) && within(com.spring.service.*)")
	private void opertation(){
		System.out.println("before a opertation!");
	}
	//表达式+切点	args(user) -->拦截user参数
	@Before(value="addAspect() && allService() && args(user)")
	private void beforeAdd( User user){
		System.out.println("before -->"+user.getUserName());
	}
}

```