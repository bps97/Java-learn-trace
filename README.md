# bps-springMVC
This is the repository for bps to learn Spring MVC
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


<hr>

# Java相关概念
	Java applet 在网页上运行的Java程序 (被JavaScript,flash取代)
	sdk  jdk的早期版本，软件开发工具
###### 不同版本的区别在于JavaAPI库内容
	Java SE java标准版
	Java EE java企业版 	(相当于是API的超集)
	Java ME java微型版


<hr>


# 深拷贝和浅考研
###### 浅拷贝与深拷贝的区别
> 浅拷贝与深拷贝的区别在于前者复制不了引用类型的域

数组拷贝(深拷贝)
`Array.copyOf(arr,length)` 将arr的值拷贝一份出来,arrLength新数组长度
Object.clone  浅拷贝

<hr>

# 动态绑定和静态绑定
######静态绑定
> 程序运行前就知道方法所属了。

###### 动态绑定
> 程序运行过程中，将函数调用和函数定义(绑定)对应起来。也可以说是找到方法是属于哪个类的。

	在静态绑定中，绑定可以在运行时或编译时解析。所有static，final和private方法的绑定过程都在编译时完成。


<hr>

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

<hr>
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

<hr>

# 接口和抽象类
	接口所有普通方法都不能自己实现，可以有default,statc方法(Java8)这些被实现的方法，抽象类没有default关键字,有staic方法。
	接口的域自动设为常量。
	接口默认是default，一般设为public

###### 接口和抽象类的区别
> 首先在意义上，接口是一种规范，定义了类的标准，而抽象类是类的高度抽象化。
用法上，接口的一般方法(defalut,static)都不能自己实现。抽象类可以有可实现的方法。


**标记接口** 没有方法，唯一目的是可以用instanceof进行类型检查。如`xx instanceof Cloneable`

abstract不能与final同时修饰一个类。


<hr>
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
	为了单纯地隐藏该类到另一个类内部，并不需要内部类引用外部类。

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
```
######普通类中的泛型方法
```
class XX{
	public <T> T getA(){}
}
```

`XX.<String>getA();`这里返回一个String类型的值，其实String可以省略。


泛型仅仅是java的一颗语法糖，它不会影响java虚拟机生成的汇编代码，在编译阶段，虚拟机就会把泛型的类型擦除，还原成没有泛型的代码，顶多编译速度稍微慢一些，执行速度是完全没有什么区别的。

泛型类型变量的限定
假如在一个泛型方法中，泛型变量的类型是限定的，比如是实现某个接口的类型，这个类型的范围就缩小了，这时候就需要在方法声明处修改。如 public static <T extends Comparable> T fun(){..}
此时，这个T表示的是所有实现Comparable接口的类型
限定多个事，用&隔开。如T extends Comparable & Serializable


擦除：删除类型参数后的泛型类型名。
如XX<T>的原始类型是XX,类定义其中的T用Object替换
因为T是一个无限定的变量，所以直接用Object替换。
如果是<T extends Comparable & Serialiizable>
则用Comparable替换


当程序调用泛型方法的时候，如果擦除返回类型，编译器将插入强制类型转换符。
Pair<XX> xxs = ..;
XX xx = xx.getFirst();
这里getFirst()返回的XX被擦除成Object，编译器自带插入强制转换成XX.


虚拟机里没有泛型，只有普通方法和类；
所有类型参数都用他们的限定类型替换；
巧方法被合成来保持多台。
为保持类型安全性，必要时插入强制类型转换。


泛型不能用基本类型的原因是擦除之后Object不能存储基本类型。
运行时类型查询只适用于原始类型,泛型当做原始类型处理。如instanceof getClass

泛型类拓展Throwable不合法
但throws异常可以使用类型变量，例如：
public static <T extends Throwable> void doWork(T t) throws T{........}

禁止使用参数化类型的数组，不合法。
因为数组会记住元素的存储类型，如果可行，擦除之后数组只能记住擦除之后类型，强转不方便。

禁止使用带有类型变量的静态域和静态方法

泛型类不支持内部类型的


这样就可以使用指定参数了

Manager是Employee的子类
那么，XX<Manager> 和 XX<Employee>没什么关系，
但是都是XX<? extends Employee>的子类型，
XX<? extends Employee>是XX<raw>的子类
注意：对于通配符类型不能使用set(参数)这样的方法，因为它不知道什么参数；get可以

同理，对于XX<? super Manager>
是XX<?>的子类，这里XX<?>是XX<raw>的子类。
XX<Employee>和XX<Object>是XX<? super Manager>的子类
注意：对于通配符类型不能使用get()这样的方法，；set可以用任意的Manager对象调用

总言之，带有超类型限定的通配符可以向泛型对象写入，
带有子类型限定的通配符可以从泛型对象读取。

无限通配符 XX<?>

Class类是泛型的，String.class实际上是Class<String>类的对象
