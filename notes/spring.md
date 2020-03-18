## spring

轻量级开源框架，
以IoC和AOP为内核，
表现层的SpringMVC
持久层的Spring JDBC 

优势
1. 方便解耦，简化开发。
2. 对AOP编程的支持。
3. 声明式事务的支持
4. 方便程序的测试
5. 方便集成各种优秀框架
6. 降低JavaEE API的使用难度
7. Java源码是经典学习范例

#### 程序的耦合
**耦合**指程序间的依赖关系，包括：

1. 类之间的依赖
2. 方法间的依赖

**解耦**用于降低程序之间的依赖
实际开发中：编译器不暴露依赖，运行时才暴露依赖
因此可以尝试：

- 使用反射来创建对象，避免使用new关键字
- 读取配置文件来获取对象的全限定名

解耦之后 会将编译时的异常转为运行时的异常(笑)(并非特指RuntimeException)





### Ioc (Inversion of Control)

**工厂模式**内核在于统一分配对象 ，APP默认直接控制资源，如果是采用工厂模式，APP通过工厂获取资源

控制反转可以说是把原本自己掌控的(直接new出来的)权利(创建对象的权利)，让给了工厂，降低了耦合

经常变换改变的数据不适合采用注入的方式。



Ioc容器

两个主要容器，分别是`BeanFactory`和`ApplicationContext`


**ApplicationContext**
可称为应用上下文，实现多个接口，功能较多
	创建核心容器时，创建对象采取的策略是采用立即加载的方式。 适合单例对象。
	一读取完配置文件马上创建配置文件中配置的对象
**BeanFactory**
可以理解是一个`HashMap`，一个beanName获取一个beanInstance
	构建核心容器时，创建对象采取的策 略是延迟加载的方式。 适合多例对象。

`ApplicationContext`的三个实现类：
	`ClassPathXmlApplicationContext`
	`FileSystemXmlApplicationContext`
	`AnnotationConfigurationContext`



#### bean的注入
1. 采用默认构造函数创建，当类拥有默认构造函数，其没有除id和class以外的属性的配置。
2. 采用普通工厂中的方法创建对象(使用类中的某个方法创建对象，并存入spring容器)
3. 使用静态工厂中的静态方法创建对象（使用类中某个静态方法创建对象）

普通工厂模式其实是将一普通bean和工厂bean都注入，再使用工厂bean获取普通bean
静态厂模式直接通过静态方法获取

**JavaBean**  可重用组件  如实体类 业务类 数据访问类

**bean的作用范围**
1.singleton 单例	2. prototype 多例	3.request 作用web应用的请求范围	4.session 作用web应用的回话范围	5.global-session 作用于集群环境的回话范围

**bean的生命周期**
	singleton 伴随着容器
	prototype 使用时创建,自动被垃圾回收

#### DI (Dependency Injection)

依赖注入的作用：降低程序之间的耦合
依赖注入：依赖关系的维护，获取bean所需的属性值等相关依赖
依赖注入的三种方式

##### ① 构造函数法 

bean拥有默认构造函数 或者 自己在xml里配置带有构造函数的bean(适用于含有默认构造器的bean)
```xml
<!-- 通过构造器 -->
<constructor-arg name="name" value="constructor"> </constructor-arg>
```

##### ② set方法 (更常用)

```xml
<!-- 通过setter -->
<property name="name" value="setter"></property>
```
##### 附：复杂类型的注入 
```xml
<!-- list array set -->
<property name="">
 <xx>
  <value></value>
  <value></value>
 </xx>
</property>
```
```xml
<!-- map -->
<property  name="">
 <map>
  <entry key="key1" value="val1"></entry>
  <entry key="key2" value="val2"></entry>
 </map>
</property>
```
```xml
<!-- props -->
<property name="">
 <props>
  <prop key="key3" >val3</prop>
  <prop key="key4" >val4</prop>
 </props>
</property>
```

##### ③ 注解法

`@Component`   将当前类注入spring容器

```xml
<context:component-scan base-package="xx.xx.package"></context:component-scan>
```

`@Controller` 表现层注解
`@Service`	业务层注解
`@Repository` 持久层注解

`@Autowired`  （注入自定义类型）
先根据类型找，如果只有一个的话就注入，否则根据变量名找，如果没有匹配则报错。
配合`@Qualifier(beanID)` 注入指定id的bean

` @Resource(beanID)` 整合`@Autowired`和`@Qualifier`

注入基本类型`@Value(val)`

改变作用范围(改变类型)`@Scope("singleton")`  `@Scope("prototype")`

改变生命周期,定义初始化和销毁方法，
加上注释`@PostConstruct`  `@PreDestory`

#### Junit测试

`@Configuration`  指定该类为配置类，一般都得写
当配置类作为`AnnotationConfigApplicationContext`对象创建的参数时，可省略该配置

`@ComponentScan` 通过注解指定spring容器创建时需要扫描的包
例如`@ComponentScan(value="xx.xx.xx")`

`@Bean(name="xxxbean")`  默认值是方法名
将当前方法的返回值作为bean存入spring的IoC容器中,这样配置的bean是默认是单例
只有通过@Scope修改使用范围。

对应导入容器的类
`AnnotationConfigApplicationContext(xxx.class);`

`@Import(OtherConfigurartion.class)`
用于导入其他注解类,这个其他注解类不需要标明是Configuration。普通类即可。


如果注解是自己写的用注解比较方便，如果是来自jar包的用xml配置比较方便

`@PropertySource("xx.property")`
加载property可作为jstl用
此时可以结合@Value使用，如 ：


```java
@Value("#{jdbc.username}")
private String username
```

这时候username就被注入了property文件中的指的值了。

##### Spring整合Junit

jar包 spring-test

@RunWith(SpringJunit4ClassRunner.class)
@ContextConfiguration()
	locations=xml位置
	classes=注解类位置

Junit单元测试的大概原理，junit集成了一个main方法，该方法会判断当前测试类中哪些方法有@Test注解，Junit就让有Test注解的方法执行。



### AOP  面向切面编程

通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术
不修改源码对已有方法进行增强。

连接点 Joinpoint
	业务层方法，被拦截到的点。连接业务方法和增强方法的点。

切入点 PointCut  (所有的切入点都是连接点)
	业务层方法中被增强的方法，

通知	  Active
	拦截到joinpoint要做的事情，也就是重复性业务。
	前置通知，后者通知，异常通知，最终通知，环绕通知。
	环绕通知中又明确的切入点方法调用。

织入 



#### spring事务 

基于AOP

PlatformTransactationManager

TransactionDefinition
    String getName
    int getIsolationLevel   事务隔离级别
    int getPropationBeheavior   事务传播行为
    int getTimeout  事务超时时间
    boolean isReadOnly  事务是否只读  给查询用

