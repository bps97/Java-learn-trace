# Java

[TOC]

## Java基本类型

1. 强类型语言

|Type|byte|short|int|long|double|float
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
|Size(Byte)|1|2|4|8|8|4|

``` java
int hex = 0xCAFE;
int oct = 0777;
long l = 40000L;
```

2. short byte 的运算需要使用强制类型转换才能保持原类型
``` java
short s1 = (short)(1 + Short.MAX_VALUE);
long l1 = 1L + Integer.MAX_VALUE;
```


3. 整数/0    Exception

4. 非零浮点数/0 无穷大 Infinity

5. `0.0/0`    `NaN` (Not a number) 例如`sqrt(-1)`

6. 使用`BigDecimal`计算没有误差

7. char类型下是使用Unicode编码,因此包括了中文字符

8. boolean 与 int 不能进行相互转换

9. long, double 类型不是线程安全的，加上`volatile`读写安全。

10. 很多基本类型的包装类具有常量池，但不包括**Float, Double**

11. 浮点数计算误差问题

    浮点运算存在误差，如 $2.0-1.1=8.89....$  
    原因在于二进制小数无法精确的表达10进制小数，小数表示分为尾数，阶码

12. 关于移位运算符
    
    `>>` 右移 移的过程中高位，正数补0，负数补1  
    `<<` 左移  
    `>>>` 无符号右移	即不把符号位当符号位处理，移的过程中高位补0

---
## Java相关概念

1. **Java applet** 在网页上运行的Java程序 (被JavaScript,flash取代)

2. **sdk**  jdk的早期版本，软件开发工具

3. **JAR** java Archive File  java档案文件 一种兼容zip的压缩文件

4. `jar cf test.jar test` 创建jar包

5. 不同版本的区别在于JavaAPI库内容  
    - Java SE java标准版
    - Java EE java企业版 	(相当于是API的超集)
    - Java ME java微型版

---
## 值传递和引用传递

- 值传递是对基本变量而言的，传递的是该变量的一个副本，改变副本不影响原变量 。 
    引用传递是对对象型变量而言的，传递的是对象地址的一个副本。  
    一般认为Java内都是值传递，因为java传入的非基本类型值是引用。

## 深拷贝和浅拷贝

1. 浅拷贝与深拷贝的区别
    浅拷贝与深拷贝的区别在于前者复制不了引用类型的域

2. 数组拷贝(深拷贝)
    `Array.copyOf(arr,length)` 将`arr`的值拷贝一份出来,`arrLength`新数组长度
    
3. `Object.clone`  浅拷贝

4.  关于克隆clone

    自定义类实现克隆的方法：  
    `implement`标记接口`Cloneable`;  
    实现`Object clone()`方法;  
    通过`(XX)super.clone()`返回克隆对象

5. `Object`类提供的Clone机制只是简单的复制，存储的对象的域对象还是指向同一个地址。
   
    （浅拷贝）只是克隆对象的成员变量值，不会对引用的对象进行克隆。  
    `clone`机制高效，比静态的`copy`方法快两倍。

---
## 动态绑定和静态绑定

6. 静态绑定,程序运行前就知道方法所属了。

7.  动态绑定
    程序运行过程中，将函数调用和函数定义(绑定)对应起来。也可以说是找到方法是属于哪个类的。

8. 在静态绑定中，绑定可以在运行时或编译时解析。

    所有`static, final`和`private`方法的绑定过程都在编译时完成。

---
## 类型比较

1. Object的`hashcode`方法是本地方法，通过c或c++实现的，返回对象的内存地址。

2. 对于`HashMap`的key的比较，需要重写`hashCode`和`equals`两个方法。
    在满足了`hashcode`值相等的前提下`equals`返回为true时，key才算相同。

3. **Comparable**接口和**Comparator**接口

 **comparable**接口包含一个返回值为int的`compareTo(T t)`方法。   
常常表示这个类是可比较的，如包装类，枚举类。  
`Arrays.binarySerach()`就是需要一个实现Comparable接口的List，不然不能进行二分查询。
    
 **comparator**接口包含两个抽象方法，分别是返回值为int的`compara(T o1,T o2)`方法和返回值为boolean的`equals(Object obj)`方法。  
 因为每个类默认实现Object，所以equals可以选择性覆盖。  
 这个接口称为比较器。描述的是比较策略，与对象(类)无关。

 但是本人想不通这个接口里设立这个`equals`方法的意义是什么。  
 实际使用的时候不需要实现equal方法。

    `Collections.sort()`这个容器排序方法就可以传入一个比较策略(策略设计模式)来比较集合元素。  
    同理`Collections.binarySearch`方法也是。



------
## 继承和多态

1. `Father one = new Son();` 

    此处引用one是用其子类构造，但是被**向上转型**成父类的类型了  
    向下变型(父类转子类)类型转换会有个类型转换异常,因而常常使用`(one instanceof Father)`判断

2. overload和override是Java多态性的不同表现，前者称为重载后者称为重写，覆盖。

3. override可以让改变返回值的类型——这称为可协变的返回类型

4. 多态可以是使用一个父类型(接口)可以初始化不同行为(不同派生类)的对象
    多态可以是同一个方法拥有不同的类型

5. 可协变的返回类型

    子类方法覆盖父类方法，子类方法返回类型可以和父类方法不一致  
    但是返回类型限定为父类方法返回类型的子类型 参考`<? extends Type>`  
    因而这个限于引用类型，如果返回值是基本类型的话还是得保持一致的


6. 内联
    早期java中，如果一个方法没有被覆盖且很短，编译器会对其优化处理(将代码直接复制到目标处)，即内联

7. final类不能被覆盖,final方法不能覆盖

8. 接口中的default方法不需要被实现,相当于普通父类的普通方法。

9. 如果一个类S继承了一个类F并实现了一个接口I，而其父类F中有个和接口I中默认方法同名(当然也同参)的普通方法。  
    那么编译器要求实现该方法。当然两个接口也适用。

10. 父类throws的异常是子类throws异常的超集,子类方法的访问权限不能少于父类

11. 静态内部类可以去继承别的静态内部类，但是其父类的静态方法不能被重载。
    因为方法覆盖是基于运行时动态绑定的
---
## 接口和抽象类

1. 声明方法而不去实现它的类被称为抽象类。

2. 接口所有普通方法都不能自己实现，可以有default,statc方法(Java8)这些被实现的方法，

3. 抽象类没有default关键字,有staic方法。

4. 接口的域自动设为静态常量。

5. 接口默认是default，一般手动设为public

6. 接口和抽象类的区别

    首先在意义上，接口是一种规范，定义了类的标准，而抽象类是类的高度抽象化。  
    用法上，接口的一般方法(defalut,static)都不能自己实现。抽象类可以有可实现的方法。  
    抽象类可以implements接口，继续抽象。抽象类的中的main入口可以被调用。

7. **标记接口** 没有方法，唯一目的是可以用instanceof进行类型检查。如`xx instanceof Cloneable`

8. abstract不能与final同时修饰一个类。

---
## 枚举类

1. 一个java源文件只能定义一个public访问权限的枚举类

2. 默认继承了 `java.lang.Enum` 因此不能显示继承其他父类

3. Enum实现了Serializable Comparable接口

4. enum默认的定义的非抽象类默认是final修饰，因此不能派生出子类

5. 构造器只能是private

6. 枚举类实例必须在第一行声明列出

    如 `enum XXEnum{ A,B,C,D;}`

7. 使用某个实例  XXEnum.A

    对于switch而言，若switch的控制表达式使用的枚举类型时，  
    case表达式中的值直接使用枚举值的名称，无需枚举类限定。如直接输入A
    
8. Eunm的常用方法
    
    `int compareTo(E o)`和另一个枚举类实例比较  
    `int ordinal()`返回枚举类实例的索引值  
    `valueOf(enumType,Stirng)` 返回指定名称的枚举值

9. 枚举类实现接口时，给所有声明的实例通过匿名内部类去实现接口定义的方法。这样可以让不同的枚举实例实现不同的行为。  
    同样，可以给枚举类安排一个抽象方法，让枚举实例通过匿名内部类分别实现。

---
## 内部类

1. 内部类可以访问所在外部类的数据(这个概念叫**闭包**)，包括私有。但对同一个包下其他类隐藏。  
    通常的内部类需要在外部类实例化后才能实例化。

2. 内部类有个隐式引用，指向创建它的外部类对象,一般是Outer.this.xx引用外部类的域

3. 外部类访问内部类 this.new Inner();

4. 普通类只有public和默认不修饰，内部类可以是static,protect,private

5. 内部类拥有独立的名称空间，当外部类被其他类继承的时候，内部类没有被继承。 

6. 局部内部类
    
    在局部作用域内的内部类，如方法体内。  
    不能被public、private,只能在局部内访问。  
    局部内部类可以访问局部变量，但是该局部变量必须是final的。  
    可以不声明，但是这个局部变量的值一定不能改变。  

7. 匿名内部类  

    不命名直接创建类对象  
    常用定义实现某接口的类，如Comparator接口

8. 静态内部类  

    为了单纯地隐藏该类到另一个类内部，并不需要内部类引用外部类。当然，外部类的静态域还是正常访问的。  
    static修饰类的话，只能是静态内部类。

---
## 异常类

1. Throwable(基类)
    - Error(运行时系统内部错误)
    - Exception
        - RuntimeException(程序错误导致的异常)  
        (错误的类型转换、数组访问越界、访问空指针)
        - 其他异常 程序本身没问题  
        (如I/O错误这些 文件结尾读取数据、打开错误格式的URL、用不存在的class查找Class错误)

2. Error和RuntimeException称为为未检查异常。

    其他为已检查异常，拥有异常处理器。  
    未检查异常要么不可控制(Error)，要么应该避免发生(RuntimeException)。


3. 堆栈跟踪
    
    stack trace   一个方法调用的列表, 包含程序执行过程中方法调用的特定位置。

4. 断言

    声称(断言)某个东西是某东西(符合某个要求)，若不是则抛出异常。

5. 父类throws的异常是子类throws异常的超集

6. 一般捕获那些知道如何处理的异常，抛出那些不知道怎么处理的异常。

7. 在catch中抛出异常(抛出异常链)
    
    如 catch(XXException e){throw new BBExceptiom..}

8. finally  即使return也得先执行finally

    throws 提前声明了可能会发生什么异常，那么运行时，将不会正常执行，构造器将会抛出异常对象，runtime就会开始搜索异常处理器。

---
## 反射：获取Runtime类型信息的途径

1. 常用功能：  
    - 能够分析类能力的程序
    - 在运行中分析类的能力
    - 在运行中查看对象
    - 实现数组的操作代码

2. 程序运行期间，Java Runtime系统为所有对象维护一个runtime，保存着对象所属的类足迹。  
    虚拟机利用runtime信息选择相应的方法执行。

3. Class类用于访问这些信息

4. 反射机制的内容

    a. 检查类的结构 `Field、Method、Constructor`  
    b. 用以获取类的域，方法，构造器的相关信息。  
    c. 在java.lang.Class中, 分别对应着`getFields getDeclaredFields getMethods`  

5. 查看编译时还不清楚的对象作用域

    a. 反射机制的默认行为受限于java的访问控制权限。  
    b. 即private等静态域，通过getField.getName之类的访问会产生异常
    
6. 使用反射编写泛型数组

    如，数组扩展，扩展的新数组需要确定类型。通过Array.newInstance

7. `method.invoke(object this,Object...args) `

    第一个参数是对应对象句柄，静态方法可省略，可设置为null，第二个方法是对应方法参数，返回值是Object

8. `getConstructor()`方法获得构造器对象，配合`newInstance()`方法可以创建对象

---



## 垃圾回收
1. 强制开始垃圾回收
        
    System.gc()  
    Runtime.getRuntime().gc()

2. 垃圾回收器调用finalize()
        
    finalize()方法返回后，对象消失，垃圾回收机制开始执行。
    可以重写finlize方法实现复活该被清理的对象。
3. 引用分类
        
    强引用：一个对象赋给一个引用就是强引用，比如new一个对象，一个对象被赋值一个对象。  
    软引用：用SoftReference类实现，一般不会轻易回收，只有内存不够才会回收。  
    弱引用：用WeekReference类实现，一旦垃圾回收已启动，就会回收。  
    虚引用：不能单独存在，必须和引用队列联合使用。主要作用是跟踪对象被回收的状态。  


## String
        
1. 不可变对象是指一个对象的状态在对象被创建之后就不再变化。

2. String是一个final类，String底层是char[] 实现的，实现时char[]是final的

    不可变的好处：节省堆空间。
        
    不可变可保证安全性，比如数据库账户密码等，没有办法在不修改地址的情况下修改其值。线程安全。  
    因为不可变，不可写，读一致。不可变保证了HashCode码的唯一性，不需要重新计算，适合作为字典的key

## 数组
1. 数组由JVM在运行时生成，直接存储在堆中，数组的"类名"为[+元素类型,如：
        
    `int[]` 对应的类名是 `[I`  
    `int[][]` 对应的类名是 `[[I`  
    `Object[]` 对应的类名是 `[Ljava/lang/Object`  
        
2. 普通对象由new 指令创建 然后由构造函数初始化
        
    基本类型的数组由 newarray指令创建  
    引用类型的数组由 anewarray指令创建  
    多维数组由 multianewarray指令创建
        