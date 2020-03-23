## 集合框架
        
1. 基本接口 Colllection,Map

2. 迭代器

    iterator.remove()  删除上次调用next返回的元素，在之前没用next的话就不合法，就会抛出异常

    ListIterator
    . add(E)
    . previous()   对应next()方法
    . hasPrivious()

#### Set

3. 对于TreeSet的使用

    通过实现Comparable<T>接口的compareTo方法来比较类的先后

    如果要实现不同set实例不同的比较策略：
    实现Comparator接口的compare(T a,T b)方法
    然后将这个类的对象传给TreeSet的构造器，那么该TreeSet实例的的排序策略就定了
    常常是通过匿名内部类实现，对应对象常常被称为函数对象。


4. 集合子范围 subrange

    ```
    List group = staff.subList(10,20)   [10,20)
    group.clear()  清除子范围
    SortedSet<E> subSet(E from, E to)
    SortedSet<E> headSet(E to)
    SOrtedSet<E> headSet(E from)  返回大于等于from，小于to的所有元素子集
    ```
        
5. 相应的，map也有相似的方法
        
    ```
    SortedMap<K,V> subMap(K from,K to)
    SortedMap<K,V> headMap(K to)
    SortedMap<K,V> tailMap(K from)  返回键落在指定范围内的所有元素
    ```
        
6. 交集

    ```
    Set<String> result = new HashSet<String>(a);
    result.retainAll(b); //此时result便是ab的交集
    ```


7. 视图：可以获得其他实现[集合接口和映射表接口]对象的对象  (可以结合数据库的视图理解)

    例如keySet()返回的集合。 它是返回实现Set接口的类对象，这个类的方法对原映射表进行操作。
        
    Array.asList(xx[]) 返回的对象不算ArrayList实例，而是一个视图对象，带有访问底层数组的get和set方法，改变数组大小的方法。

    通过视图删除原映射表的内容
    比如 view 为 map key的集合子范围,map.keySet().removeAll(view);


##### Map
        

8. HashMap 允许一条记录的键为null,多条记录的值为null；

    需要支持同步时可以用Collections的synchronizedMap方法使HashMap具有同步的能力，或者使用ConcurrentHashMap。遍历速度更容量有关。
        
9. HashTable 线程安全，继承Dictionary类，不运行键或值为null
        
10. LinkedHashMap 保存了记录的插入顺序，使用iterator遍历时按照插入顺序遍历。也可以在构造是用参数，按照指定规则排序。遍历速度跟实际数据有关。
        
11. TreeMap 实现了SortMap接口，基于红黑树的NabigableMap实现，能够将保存的记录根据键排序，默认按键值升序，也可以指定排序比较器`Comparator`。

12. Collections
        
    Collections里有许多静态方法
        
    ```java
    Collections.sort(list)
    Collections.sort(list,new Comparator);
    Collections.sort(list, Collections.reverseOrder(new Comparator))   逆序排序
    ```

13. Java的排序，基本类型使用快排，引用类型使用归并排序，是一个稳定排序
先将元素转成数组并使用归并排序的变体进行排序，然后再复制回列表。


14. 对于已排序的集合，可用Collections.binarySearch(容器,key/element) 也可以添加一个compartor对象的参数
        
    ``` Java
    Collections.min、Collections.max
    Collectuons.copy(to,from)
    Collections.fill(con,value)
    Collections.addAll(con,valuel,value2...)
    Collections.replaceAll(con,oldValue,newValue)
    ```
        
15. Hsahtable   小写table 与Vector一样同步
16. Enumeration  hasMoreElements nextElement  与迭代器相似
17. Properties 属性映射表  键值对都是字符串 可以保存在文件中，也可以从文件中加载
18. Stack push pop 栈
19. BitSet 位集 存放一个位序列 进行 and or运算
20. ArrayList list = new ArrayList()  默认创建大小为10的数组，一次扩容1.5倍

        ArrayList list = new ArrayList(15) 这样的话就直接指定

21. 堆是一个可以经过自我调整的二叉树

22. EnumSet 枚举集
23. EnumMap 键类型为枚举类型
24. NavigatableSet接口

25. Vector使用数组方式存储数据，相比链表插入删除比较慢。线程安全(添加了synchronized),性能比ArrayList差
        
26. LinkedList 使用双向链表实现存储。比ArrayList更吃内存。

