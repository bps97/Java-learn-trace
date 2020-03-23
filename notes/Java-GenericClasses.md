## 泛型 

1. 泛型程序设计 generic programming

    泛型类看作普通类的工厂。

2. 泛型类
    ``` Java
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
    }/*类型变量放在修饰符和返回类型之间
    ```
    `XX.<String>.getA()`这里返回一个String类型的值, 其实String可以省略,因为编译器可以推断出所调用的方法。\
    
    对于方法, 泛型符号`<T>`必须在类名之后, 又必须在方法名之前
    
3. 泛型类型变量的限定

    假如在一个泛型方法中，泛型变量的类型是限定的。比如是实现某个接口的类型，这个类型的范围就缩小了，
    
    这时候就需要在方法声明处修改,如：

    `public static <T extends Comparable> T fun(){..}`
    
    此时，这个T表示的是所有实现Comparable接口的类型，限定多个事，用&隔开。如`T extends Comparable & Serializable>`


4. 擦除：删除类型参数后的泛型类型名。

    如XX<T>的原始类型是XX,类定义其中的T用Object替换,因为T是一个无限定的变量，所以直接用Object替换。  
    如果是<T extends Comparable & Serialiizable>, 则用Comparable替换

5. 当程序调用泛型方法的时候，如果擦除返回类型，编译器将插入强制类型转换符。
    
    ``` Java
    Pair<XX> xxs = ...;
    XX xx = xx.getFirst();
    ```
    
    
    这里getFirst()返回的XX被擦除成Object，编译器自动插入强制转换成XX.


6. 虚拟机里没有泛型，只有普通的方法和类；

    所有类型参数都用他们的限定类型替换；  
    为保持类型安全性，必要时插入强制类型转换。
    

7. 泛型仅仅是java的一颗语法糖，它不会影响Java虚拟机生成的汇编代码。

    在编译阶段，虚拟机就会把泛型的类型擦除，还原成没有泛型的代码，顶多编译速度稍微慢一些，执行速度是完全没有什么区别的。



8. 类型变量的限定

    ``` Java
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


9. 泛型类型的继承规则和通配符类型

    ``` Java
    <？ extends Employee>  可能是Employee也可能是其派生类
    <XX<？ super Employee>  可能是Employee也可能是其超类
    ```

10. Manager是Employee的子类,那么`XX<Manager>` 和 `XX<Employee>`可以看做是`XX<？ extends Employee>`的子类型，`XX<? extends Employee>`看做是`XX<raw>`的子类型
        
    使用：`XX<? extends Employee> xx = new XX<Manager>();`  
    注意：拿List作例子，对于`List<? extends Manager>`，不能使用add(T t)这样的方法，但get可以。  
    可以这么理解：这个容器存放的是所有实现Manager的类(包括自己)。我们不知道add的是什么类型，但是get方法却可以，因为我传出去的对象无论如何都能被Manager接收。可以add(null)

    同理，对于`XX<? super Manager>`, `XX<Employee>`和`XX<Object>`是`XX<? super Manager>`的子类,XX<? super Manager>的子类 是XX<?>的子类型，这里`XX<?>是XX<raw>`的子类型。  
    使用：`<XX<？ super Employee> xx = new XX<Object>();`  
    注意：拿List作例子，对于`List<? super Manager>`类型不能使用get()这样的方法，add可以。  
    可以这么理解：这个通配符类型代表的是所有Manager的超类(包括自己)。要是传入一个Manager的派生类(Manager的超类不行)，肯定都是能被Manager或者Manager的超类接收的，但是get方法却不可以，除了Object，其他都接收不了。

    总言之，带有超类型限定的通配符可以向泛型对象写入，带有子类型限定的通配符可以从泛型对象读取。

11. 无限通配符 XX<?>

12. 泛型不能用基本类型的原因是擦除之后Object不能存储基本类型。
        
13. 运行时类型查询只适用于原始类型,泛型当做原始类型处理。
        
14. 泛型类拓展Throwable不合法,但throws异常可以使用类型变量，例如：
        
    ``` Java
    public static <T extends Throwable> void doWork(T t) throws T{
        try{
            do work
        }catch (Throwable realCause){
            t.initCause(realCause);
            throw t;
        }
    }
    ```

17. 禁止使用参数化类型的数组，不合法。因为数组会记住元素的存储类型，如果可行，擦除之后数组只能记住擦除之后类型，强转不方便。

18. 不能再静态域和静态方法中使用泛型变量

19. 泛型类不支持内部类型的
        
20. Class类是泛型的，`String.class`实际上是`Class<String>`类的对象

21. 泛型的使用

    泛型类定义内部使用泛型符号如`T`来表示, 能声明变量, 声明参数, 用作类型转换, 作为返回类型.  
    但是不能通过new初始化对象
      