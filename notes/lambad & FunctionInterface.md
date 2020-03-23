##### 函数式接口
- Lambda的目标类型——target;  type 必须是 函数式接口 
- 函数式接口：
    只包含一个抽象方法的接口, 但可以有多个默认方法, 类方法.  
    对于匿名内部类语法实现函数式接口，只需要实现一个抽象方法  
    例 `Runnable r = () -> { statement }`

    Runnable是Java提供的一个函数式接口

注: Lambda表达式的目标类型必须是明确的函数式接口，只能由函数式接口接收
	Lambda表达式只能实现一个方法
Object obj = ()->{}  这样不行
Object obj = (Runnable)()->{} 这样可以

Lambda表达式实现的匿名方法与函数式接口中唯一的抽象方法有相同的形参列表。

@FunctionakInterFace 与@Override相似，检查是否是函数式接口

预定义函数式接口
XxxFunction apply()抽象方法 一般对参数进行处理，转换，返回一个新值
XxxPredicate test() 对参数继续某种判断，返回一个boolean值
XxxConsumer accept()抽象方法 对数据进行处理，但是不返回新值
XxxSuppllier getAsXxx()  直接返回一个数据

方法引用，构造器引用

引用类方法(static)
	Converter con = Integer::valueOf;  等效于
	Converter con = from -> Integer.valuesOf(from);
引用特定对象实例方法  
	(a,b...)-> xx.fun(a,b...)等效于 对象::实例方法  

引用某类对象的实例方法 
	(a,b...)-> a.fun(b...)  等效于 类名::实例方法
引用构造器   
	(a,b...)-> new 类名  等效于 Xx::new;

lambda是匿名内部类的一种简化
lambda也你能访问effectibely final的局部变量，外部类的实例，以及类变量(static)
使用lambad创建函数接口对象，该对象也能访问默认方法
但是lambad代码块不能调用默认方法，匿名内部类可以。

Arrays中的一些lambad方法
Arrays.parallelSort(arr1,(o1,o2)-> o1.length()-o2.length());
Arrays.parallelPrefix(arr2,(left,right)->left*right);
Arrays.parallelSetAll(arr3,operand->operand*5);

Iterable接口的的forEach方法
例 	Collection coll = new HashSet();
	coll.add("...");
	coll.forEach(obj->System.out.println(obj))

	coll.removeIf(ele->((String)ele).length()<10);

stream 自己不会存储元素，元素可能被存储在底层的集合中，或者根据需要产生出来。
stream 操作符不会改变源对象。相反，他们会返回一个特殊的结果——新的stream
stream 操作符可能是延后执行的，等到需要结果时才执行。

使用分三个阶段：
	1 创建一个stream
	2 stream流转换
	3 终止操作符

创建
	Arrays.stream(array, from ,to)  将数组的一部分转化为stream
	无限流的创建方法
	Stream接口中
		.generate(一个无参数的函数类型)
		.iterate(seed, 函数)  seed是种子，函数会对对种子进行重复操作。
		如果函数为f,那么对应的流为  seed,f(seed),f(f(seed))...

流转换
无状态的流转换
	filter 参数是一个从T到boolean的函数
	map 对每一个元素应用一个函数
	flatmap 将流中中的流元素转换出来
	获取子流
		.limit(n)
		.skip(n) 舍弃前面的n个元素
	连接流
		Stream.concat(stream1,steam2)   静态的
	peek(函数) 拷贝一个流的所有元素，并对新流作处理
有状态的流转换		需要记住之前流的状态
	.distinct()  去除重复元素
	.sort(comperator对象函数)

聚合方法
	.count()  	返回流中的元素总数
	.max()  .min()
	.findFirst()  找到第一个元素
	.findAny()
	.anyMatch(Predicate) 是否含有匹配元素
	.noneMatch(predicate)  没有则返回true




lambda例子
	(parm1,parm2)->{...}
	()->{...}
	(Long i,Long j)>{...}
	总之(){}都可以不写，甚至也可以指明类型
一个lambad包含的三个部分
	一段代码
	参数
	自由变量的值(不是变量且没在代码中定义) 
lambda会捕获自由变量
含有自由变量的代码块称为闭包 	closure   java中另一个闭包就是内部类
自由变量的值不可在代码块内更改 原因是表达式内变量非线程安全
默认方法	在接口中子类不可实现
如果在接口中定义了默认方法，而在另一个父类定义了一个同名方法。执行如下原则：
	1、 	类优先原则，有父类，有接口，将会采用父类的具体方法，接口中的默认方法被忽略。
	2、	如果是两个接口，需要开发人员来解决冲突，即在子类中重写该方法，通过桥方法，在子类中通过super使用父类方法。
	3、 	如果是两个接口，其中一个非默认方法，即未实现方法，也采取2

lambda也需要类型推断的引子
分为惰性求值和及早求值
常用流操作
	Stream.of(...)
		用一组初始值生成新的Stream
	collect(toList())   收集器
		由stream里的值生成一个列表
	map(Function)  
		对元素进行替换
	filter(Predicate)
		保留符合条件的元素
	flatMap(Function)   这里返回的是Stream
  		将多个Stream连接成一个Stream
  	min(Comparator.comparing)	/max
  		java8中的静态方法comparing(Function)，更为方便实现一个比较器

对于StreamAPI建议使用链式调用

Predicate(谓词)


Optional 是为核心类库新设计的一个数据类型，用来替换 null 值。

toCollection定制收集器的类型
stream.collect(toCollection(TreeSet::new));