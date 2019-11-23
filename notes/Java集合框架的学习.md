最近在看集合框架里的一些东西。

## 关于toArray的一些想法
`AbstractCollection`有转换成对应数组的方法，即`toArray()`


先准备数据：
```
List<String> list = new ArrayList<>();
list.add("hello");
list.add("world");
```

```
// String[] arr1 = list.toArray(); /*这里会报错*/
String[] arr2 = (String[])list.toArray();

for(String str : arr2)
   System.out.println(str);  /*这里会抛异常*/
```

这里`arr1`会报错，而`arr2`则会抛出类型转换异常`ClassCastException`

因为`toArray`方法的返回值类型是`Object[]`，数组类型是没有继承关系的，因此不能向上转型向下变型。

一种正确使用方法是：
```
Object[] arr3 = list.toArray();

for(Object obj: arr3)
   System.out.println((String)obj);
```
这是使用遍历的手段逐一向下变型。

而另一种手段就是使用同名方法`toArray(T[] t)`
```
String[] arr4 = new String[list.size()];
String[] arr5 = list.toArray(arr4);
System.out.println(arr4 == arr5);
```
这里的输出结果是`true`，说明`arr4`和`arr5`是指向同一个地址。
重要的是这里免去了类型转换，通过指定了传入的数组类型，确定了返回值的类型(修改了传入的值后返回)。

这种手段还有另一种写法：
```
String[] arr6 = list.toArray(new String[0]);
```
这样传入的参数就只是指定了类型。便可以通过泛型获得传入数组元素的Class，生成相应类型的数组并返回。


## 关于transient的一些想法
最近有留意到关键字`transisent`

比如`ArrayList`里的：
```
transient Object[] elementData;
```
很显然这个数组是`ArrayList`内部存数据的字段。
但是为什么要加上`transient`这个修饰符呢？
带着这样的想法我去搜索了一下transient。
得到的结论是`transient`关键字标记的成员变量不参与序列化过程。

这里又蹦出一个序列化的概念，当然知道的朋友可以跳。
将对象的状态信息转换为可以存储或传输的形式的过程。
在Java里就是将内存上的数据持久化到硬盘上。
一个类需要被序列化便实现标记接口`Serializable`
这样代表这个类能被序列化。而被标记为`transient`的域不被序列化。

这时候我们就开始思考，域作为一个类的属性而存在，几乎是不可缺少的一部分，都序列化一个类了为什么不把域也带进去。

我们先来了解一下序列化以及反序列化的过程吧。
首先定义一个可序列化类
```
class Person implements Serializable{
    private static final long serialVersionUID=1L;
    String name;
    Person(String name){this.name = name;}
}
```
写一个序列化的方法
```
private static void output(String fileName, Person person) throws IOException {
	FileOutputStream outputStream = new FileOutputStream(fileName);
	ObjectOutputStream out = new ObjectOutputStream(outputStream);
	out.writeObject(person); 
	out.close();
	outputStream.close();
}
```
这里创建了一个`ObjectOutputStream`流，带有一个`wirteObject`方法，传入一个对象。
这个writeObject就是序化的关键方法。

反序列化的过程如下：
```
private static void output(String fileName, Person person) throws IOException {
    FileOutputStream outputStream = new FileOutputStream(fileName);
    ObjectOutputStream out = new ObjectOutputStream(outputStream);
    out.writeObject(person);
    out.close();
    outputStream.close();
}
```

序列化的过程也可是说是一个浅拷贝的过程。
对于关键的数据，我们必须对类重写writeObject方法和readObject方法