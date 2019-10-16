# Java基本类型
###### 强类型语言

|Type|byte|short|int|long|double|float
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|Size(Byte)|1|2|4|8|8|4|

``` 
int hex = 0xCAFE;
int oct = 0777;
long l = 40000L;
```

	如果 short byte 需要使用强制类型转换才能保持原类型
	整数/0    Exception
	非零浮点数/0 无穷大 Infinity
	0.0/0    NaN (Not a number) 例如还有`sqrt(-1)`
	浮点运算存在误差，如2.0-1.1=8.89....
	使用BigDecimal计算没有误差
	char类下是使用Unicode编码
	boolean与int不能进行相互转换


---

# Java相关概念
	Java applet 在网页上运行的Java程序 (被JavaScript,flash取代)
	sdk  jdk的早期版本，软件开发工具
	JAR java Archive File  java档案文件 一种兼容zip的压缩文件
	jar cf test.jar test 创建jar包
###### 不同版本的区别在于JavaAPI库内容
- Java SE java标准版
- Java EE java企业版 	(相当于是API的超集)
- Java ME java微型版




---


# 深拷贝和浅拷贝
###### 浅拷贝与深拷贝的区别
> 浅拷贝与深拷贝的区别在于前者复制不了引用类型的域

数组拷贝(深拷贝)
`Array.copyOf(arr,length)` 将arr的值拷贝一份出来,arrLength新数组长度
Object.clone  浅拷贝

######关于克隆clone
自定义类实现克隆的方法：
>实现标记接口Cloneable
 实现Object clone()方法，通过(XX)super.clone()返回克隆对象

Object类提供的Clone机制只是简单的复制，存储的对象的域对象还是指向同一个地址。
（浅拷贝）只是克隆对象的成员变量值，不会对引用的对象进行克隆。
clone机制高效，比静态的copy方法快两倍。

---

# 动态绑定和静态绑定
######静态绑定
> 程序运行前就知道方法所属了。

###### 动态绑定
> 程序运行过程中，将函数调用和函数定义(绑定)对应起来。也可以说是找到方法是属于哪个类的。

	在静态绑定中，绑定可以在运行时或编译时解析。所有static，final和private方法的绑定过程都在编译时完成。


---

#继承和多态

`Father one = new Son();` 
此处引用one是用其子类构造，但是被**向上转型**成父类的类型了
向下变型(父类转子类)类型转换会有个类型转换异常,因而常常使用`(one instanceof Father)`判断


######多态
	overload和override是Java多态性的不同表现，前者称为重载后者称为重写，覆盖。
	overload可以让改变返回值的类型——这称为可协变的返回类型
	多态可以是使用一个父类型(接口)可以初始化不同行为(不同派生类)的对象
	多态可以是同一个方法拥有不同的类型

###### 可协变的返回类型

	子类方法覆盖父类方法，子类方法返回类型可以和父类方法不一致
	但是返回类型限定为父类方法返回类型的子类型 参考<? extends Type>
	因而这个限于引用类型，如果返回值是基本类型的话还是得保持一致的



###### 内联
> 早期java中，如果一个方法没有被覆盖且很短，编译器会对其优化处理，即内联

<br>
- final类不能被覆盖,final方法不能覆盖

- 接口中的default方法不需要被实现,相当于普通父类的普通方法。
  如果一个类继承了一个类并实现了一个接口，而其父类中有个和接口中默认方法同名(当然也同参)的普通方法。
  那么编译器要求实现该方法。当然两个接口也适用。
- 父类throws的异常是子类throws异常的超集
- 静态内部类可以去继承别的静态内部类，但是其父类的静态方法不能被重载。

---
# 反射：获取Runtime类型信息的途径

######常用功能：	
	能够分析类能力的程序
	在运行中分析类的能力
	在运行中查看对象
	实现数组的操作代码

程序运行期间，Java Runtime系统为所有对象维护一个runtime，保存着对象所属的类足迹。
虚拟机利用runtime信息选择相应的方法执行。

Class类用于访问这些信息



反射机制的内容
1. 检查类的结构
	`Field、Method、Constructor`
	用以获取类的域，方法，构造器的相关信息。
	在java.lang.Class中，
	分别对应着`getFields() getDeclaredFields getMethods()`
2. 查看编译时还不清楚的对象作用域
	反射机制的默认行为受限于java的访问控制权限。
	即private等静态域，通过getField.getName之类的访问会产生异常
3. 使用反射编写泛型数组
	如，数组扩展，扩展的新数组需要确定类型。通过Array.newInstance

`method.invoke(object this,Object...args) `
第一个参数是对应对象句柄，静态方法可省略，可设置为null，第二个方法是对应方法参数，返回值是Object

---

# 接口和抽象类
	接口所有普通方法都不能自己实现，可以有default,statc方法(Java8)这些被实现的方法，抽象类没有default关键字,有staic方法。
	接口的域自动设为常量。
	接口默认是default，一般设为public

###### 接口和抽象类的区别
> 首先在意义上，接口是一种规范，定义了类的标准，而抽象类是类的高度抽象化。
用法上，接口的一般方法(defalut,static)都不能自己实现。抽象类可以有可实现的方法。


**标记接口** 没有方法，唯一目的是可以用instanceof进行类型检查。如`xx instanceof Cloneable`

abstract不能与final同时修饰一个类。

---
# 枚举类
- 一个java源文件只能定义一个public访问权限的枚举类
- 默认继承了 java.lang.Enum 因此不能显示继承其他父类
- Enum实现了Serializable Comparable接口
- enum默认的定义的非抽象类默认是final修饰，因此不能派生出子类
- 构造器只能是private
- 枚举类实例必须在第一行声明列出
>如 `enum XXEnum{ A,B,C,D;}`
- 使用某个实例  XXEnum.A
对于switch而言，若switch的控制表达式使用的枚举类型时，
case表达式中的值直接使用枚举值的名称，无需枚举类限定。如直接输入A
- Eunm的常用方法
```
int compareTo(E o)和另一个枚举类实例比较
int ordinal() 	返回枚举类实例的索引值
valueOf(enumType,Stirng) 返回指定名称的枚举值
```
- 枚举类实现接口时，给所有声明的实例通过匿名内部类去实现接口定义的方法。这样可以让不同的枚举实例实现不同的行为。
  同样，可以给枚举类安排一个抽象方法，让枚举实例通过匿名内部类分别实现。

---
#内部类
内部类可以访问所在外部类的数据(这个概念叫**闭包**)，包括私有。对同包下其他类隐藏。
内部类有个隐式引用，指向创建它的外部类对象,一般是Outer.this.xx引用外部类的域

###### 局部内部类
	在局部作用域内的内部类，如方法体内。
	不能被public、private,只能在局部内访问。
	局部内部类可以访问局部变量，但是该局部变量必须是final的。可以不声明，但是这个局部变量的值一定不能改变。
###### 匿名内部类  
	不命名直接创建类对象
	常用定义实现某接口的类，如Comparator接口
###### 静态内部类  
	为了单纯地隐藏该类到另一个类内部，并不需要内部类引用外部类。static修饰类的话，只能是静态内部类。

---
# 异常类
\- Throwable(基类)
\- - Error		运行时系统内部错误
\- - Exception
\- - - RuntimeException 程序错误导致的异常 `错误的类型转换、数组访问越界、访问空指针`
\- - - 其他异常 程序本身没问题，如I/O错误这些 `文件结尾读取数据、打开错误格式的URL、用不存在的class查找Class错误`
>Error和RuntimeException称为为未检查异常。
	其他为已检查异常，拥有异常处理器。
	未检查异常要么不可控制(Error)，要么应该避免发生(RuntimeException)。


#######堆栈跟踪，
>stack trace   一个方法调用的列表, 包含程序执行过程中方法调用的特定位置。

######断言
>声称(断言)某个东西是某东西(符合某个要求)，若不是则抛出异常。




- 父类throws的异常是子类throws异常的超集

- 一般捕获那些知道如何处理的异常，抛出那些不知道怎么处理的异常。

- 在catch中抛出异常(抛出异常链)
如 catch(XXException e){throw new BBExceptiom..}

- finally  即使return也得先执行finally
	throws 提前声明了可能会发生什么异常，那么运行时，将不会正常执行，构造器将会抛出异常对象，runtime就会开始搜索异常处理器。



---
#泛型 
>泛型程序设计 generic programming
泛型类看作普通类的工厂。


######泛型类
```
public class XX<T>{ 
	public XX(){} 
	public T getA(){};
	public void setA(T xx){};
}

/*普通类中的泛型方法*/
class XX{
	public <T> T getA(T[] xx){
		return xx[0];
	}
}
/*类型变量放在修饰符和返回类型之间
```

`XX.<String>getA();`这里返回一个String类型的值，其实String可以省略,因为编译器可以推断出所调用的方法。




######泛型类型变量的限定
	假如在一个泛型方法中，泛型变量的类型是限定的。
	比如是实现某个接口的类型，这个类型的范围就缩小了，
	这时候就需要在方法声明处修改,如：
	public static <T extends Comparable> T fun(){..}
	此时，这个T表示的是所有实现Comparable接口的类型，
	限定多个事，用&隔开。如T extends Comparable & Serializable>


######擦除：删除类型参数后的泛型类型名。
	如XX<T>的原始类型是XX,类定义其中的T用Object替换
	因为T是一个无限定的变量，所以直接用Object替换。
	如果是<T extends Comparable & Serialiizable>, 则用Comparable替换
```
当程序调用泛型方法的时候，如果擦除返回类型，编译器将插入强制类型转换符。
Pair<XX> xxs = ...;
XX xx = xx.getFirst();
这里getFirst()返回的XX被擦除成Object，编译器自动插入强制转换成XX.
```

	虚拟机里没有泛型，只有普通的方法和类；
	所有类型参数都用他们的限定类型替换；
	为保持类型安全性，必要时插入强制类型转换。
```
泛型仅仅是java的一颗语法糖，它不会影响Java虚拟机生成的汇编代码。
在编译阶段，虚拟机就会把泛型的类型擦除，还原成没有泛型的代码，
顶多编译速度稍微慢一些，执行速度是完全没有什么区别的。
```


######类型变量的限定
```
/*此处泛型限定为实现所有Comparable接口的类型*/
    public static <T extends  Comparable> Pair<T> minMax(T[] a){
        if(a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for(int i = 0; i < a.length; i++){
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<T>(min,max);
    }
```



######泛型类型的继承规则和通配符类型
- Manager是Employee的子类
那么`XX<Manager>` 和 `XX<Employee>`都是`XX<？ extends Employee>`的子类型，
`XX<？ extends Employee>`是`XX<raw>`的子类型
注意：对于`XX<? extends Manager>`类型的引用，不能使用set(参数)这样的方法，因为它不知道set方法的参数，但get可以
使用：`XX<？ extends Employee> xx = new XX<Manager>();`

- 同理，对于`XX<? super Manager>`, `XX<Employee>`和`XX<Object>`是`XX<? super Manager>`的子类
是`XX<?>`的子类型，这里`XX<?>是XX<raw>`的子类型。
注意：对于`XX<? super Manager>`类型不能使用get()这样的方法，set可以用任意的Manager对象调用
使用：`XX<？ super Employee> xx = new XX<Object>();`


- 总言之，带有超类型限定的通配符可以向泛型对象写入，
带有子类型限定的通配符可以从泛型对象读取。

- 无限通配符 XX<?>


######其他
- 泛型不能用基本类型的原因是擦除之后Object不能存储基本类型。
- 运行时类型查询只适用于原始类型,泛型当做原始类型处理。
- 泛型类拓展Throwable不合法,但throws异常可以使用类型变量，例如：
```
	public static <T extends Throwable> void doWork(T t) throws T{
		try{
			do work
		}catch (Throwable realCause){
			t.initCause(realCause);
			throw t;
		}	
	}
```



- 禁止使用参数化类型的数组，不合法。
因为数组会记住元素的存储类型，如果可行，擦除之后数组只能记住擦除之后类型，强转不方便。
- 不能再静态域和静态方法中使用泛型变量
- 泛型类不支持内部类型的
- Class类是泛型的，`String.class`实际上是`Class<String>`类的对象


---
#集合框架
>基本接口 Colllection,Map

######迭代器
- iterator.remove()  删除上次调用next返回的元素，在之前没用next的话就不合法，就会抛出异常
- ListIterator
>	add(E)
	previous()   对应next()方法
	hasPrivious()




######Set

- 对于TreeSet的使用
>通过实现Comparable<T>接口的compareTo方法来比较类的先后
>>如果要实现不同set实例不同的比较策略：
  实现Comparator接口的compare(T a,T b)方法
  然后将这个类的对象传给TreeSet的构造器，那么该TreeSet实例的的排序策略就定了
  常常是通过匿名内部类实现，对应对象常常被称为函数对象。




- 集合子范围 subrange
```
List group = staff.subList(10,20)   [10,20)
group.clear()  清除子范围
SortedSet<E> subSet(E from, E to)
SortedSet<E> headSet(E to)
SOrtedSet<E> headSet(E from)  返回大于等于from，小于to的所有元素子集
```
- 相应的，map也有相似的方法
```
SortedMap<K,V> subMap(K from,K to)
SortedMap<K,V> headMap(K to)
SortedMap<K,V> tailMap(K from)  返回键落在指定范围内的所有元素
```
- 交集
```
Set<String> result = new HashSet<String>(a);
result.retainAll(b); //此时result便是ab的交集
```


	视图：可以获得其他实现[集合接口和映射表接口]对象的对象  (可以结合数据库的视图理解)
```
例如keySet()返回的集合。 它是返回实现Set接口的类对象，这个类的方法对原映射表进行操作。
Array.asList(xx[]) 返回的对象不算ArrayList实例，而是一个视图对象，带有访问底层数组的get和set方法，改变数组大小的方法。
```
	通过视图删除原映射表的内容
	比如 view 为 map key的集合子范围,map.keySet().removeAll(view);


######Collections
Collections里有许多静态方法
```
Collections.sort(list)
Collections.sort(list,new Comparator);
Collections.sort(list, Collections.reverseOrder(new Comparator))   逆序排序
```

	Java的排序，基本类型使用快排，引用类型使用归并排序，是一个稳定排序
	先将元素转成数组并使用归并排序的变体进行排序，然后再复制回列表。

```
	对于已排序的集合，可用Collections.binarySearch(容器,key/element) 也可以添加一个compartor对象的参数
```
	Collections.min、Collections.max
	Collectuons.copy(to,from)
	Collections.fill(con,value)
	Collections.addAll(con,valuel,value2...)
	Collections.replaceAll(con,oldValue,newValue)

######其他
- Hsahtable   小写table 与Vector一样同步
- Enumeration  hasMoreElements nextElement  与迭代器相似
- Properties 属性映射表  键值对都是字符串 可以保存在文件中，也可以从文件中加载
- Stack push pop 栈
- BitSet	位集	 存放一个位序列 进行 and or运算
- ArrayList list = new ArrayList()  默认创建大小为10的数组，一次扩容1.5倍
ArrayList list = new ArrayList(15) 这样的话就直接指定

- 堆是一个可以经过自我调整的二叉树

- EnumSet 枚举集
EnumMap 键类型为枚举类型
- NavigatableSet接口



#多线程和同步问题
实现方式
1. 类实现Runnable的run方法，并将类传给一个Thread对象  Thread(run)
2. 类继承Thread并实现run方法 不推荐。
>注意不要实现Thread类或者Runnable对象的run方法。直接调用run方法不会启动新线程
应该使用Thread.start,将会创建一个执行run方法的新线程

######中断线程
	正常情况下，run方法执行到最后一条语句，线程将中止。
	interrupt中断线程。 调用时线程的中断状态将被置位。
	thread.isInterrupted()查看线程中断状态
	Thread.interrrupted清除终端状态
	若线程被阻塞则无法检测。检测时产生InterruptedException
######线程状态
>`Thread.State getState()`返回线程的状态

- new 线程刚刚创建时的状态 
- Runable 调用了start方法，变为可运行状态，可能在运行也可能没用运行。
- Blocked 被阻塞 不运行任何代码消耗最少的资源 直到线程调度器重新激活它
  想要获得锁，而锁被其他线程持有，那么该线程进入阻塞状态。
- waiting 等待另一个线程通知调度器的状态
- Timed waiting	超时之后，计时等待
- Terminated	自然死亡或者意外死亡


######线程优先级
>`setPriority(int)`设置线程优先级，线程优先级是依赖于系统的。

######守护线程
>`thread.setDaemon(true)` 将线程设为守护线程,为其他线程提供服务，如计时线程，垃圾回收线程。
	如果只有守护线程的话，那么程序也就结束了。

######未捕获异常处理器
>线程的run方法不能抛出任何被检测的异常，但是如果不检测的话会导致线程死亡。这时候可以:
1. 安装一个处理器——一个实现Thread.UncaughtExceptionHandler接口uncaughtException方法的类。
2. 用setUncaughtExceptionHandler方法为任何线程安装一个处理器
3. 用Thread的静态方法setDefaultUncaughtExceptionHandler为所有线程安装一个默认处理器。

	如果不安装默认处理器，默认处理器为空。
	如果不为独立的线程安装处理器，此时的处理器就是该线程的ThreadGroup对象。
	线程组是一个可以统一管理的线程集合，默认情况下所有线程属于同一个线程组。
	ThradGroup实现了Thrad.UncaughtExceptionHandler接口

#####同步
	锁对象 用来保护代码片段，使得任何时候只有一个线程执行被保护的代码。
		  也可以管理视图进入被保护的代码片段的线程
	      通过条件对象来管理那些已经进入被保护的代码片段
*synchronized*
>java的每一个对象都有一个内部锁，一个方法用synchronized来声明，那么该对象的锁将保护整个方法。
>对于静态同步方法，对应的便是类对象的内部锁。

```
public synchronized void method(){
	wait();
	...
	notifyAll();
}
```
客户端锁定:  不推荐使用
`synchronized(obj){...} `线程获得obj的锁

######线程安全
>当多线程访问一个类时，可以不用考虑这些线程在运行时环境下的调度和交替执行，
 并且不需要额外的同步及在调用方代码不必作其他的调度，这个类的行为仍然是正确的。

######sleep方法和wait方法的联系和区别
- sleep,wait方法都可以通过interrupt方法被打断线程的暂停状态，
- 如果线程正在处于sleep，wait，join等状态，会立刻抛出InterruptedException
- sleep方法没用释放锁，wait方法释放了锁，使得其他线程可以使用同步控制块
- sleep可以在任何地方使用，需要捕获异常



	await 释放锁并进入等待阻塞状态
	signalAll 通知等待的线程，激活他们
	若是一个线程进入await，而又没有其他等待的线程激活它，那么就进入了死锁

```
wait,notifyAll,notify都是final方法，来自Object
wait 方法使当前线程进入等待状态并释放锁
```
	线程之间如何通信：通过notify和wait
	什么要在同步块内呢：因为不同线程之间会随机竞争资源，我们要对共享资源的操作定序


#垃圾回收
强制开始垃圾回收
>System.gc()
Runtime.getRuntime().gc()

垃圾回收器调用finalize()
finalize()方法返回后，对象消失，垃圾回收机制开始执行。
可以重写finlize方法实现复活该被清理的对象。

强引用：一个对象赋给一个引用就是强引用，比如new一个对象，一个对象被赋值一个对象。
软引用：用SoftReference类实现，一般不会轻易回收，只有内存不够才会回收。
弱引用：用WeekReference类实现，一旦垃圾回收已启动，就会回收。
虚引用：不能单独存在，必须和引用队列联合使用。主要作用是跟踪对象被回收的状态。