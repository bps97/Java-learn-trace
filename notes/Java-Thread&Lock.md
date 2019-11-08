# Java线程

###### 创建线程 ######

1. 类继承Thread并实现run方法 
>注意不要实现Thread类或者Runnable对象的run方法。直接调用run方法不会启动新线程
应该使用Thread.start,将会创建一个执行run方法的新线程
2. 类实现Runnable的run方法，并将类传给一个Thread对象  Thread(run)

创建线程来源于两个方法`Thread()` `Thread(Runable target)`，前者通过继承，后者通过传参
Thread的源码中，只有含有Runnable类型的私有域，run方法才能执行。

- 启动线程的实质是JVM运行线程，然后通过线程调度器调度
- run方法是JVM直接调用的，因此在代码中使用线程的run方法，是运行在当前线程的，这违背了“多线程”的初衷
- 父线程是守护线程，那么子线程也是；父子线程优先级默认保持一致，生命周期无关系
- 一些方法
```
void join() 若线程A调用线程B的join方法，那么线程的A的运行将会被暂停，直到B线程执行结束
static void yield() 尝试让当前线程暂停(让调度器重新调度)
```

###### 中断线程
正常情况下，run方法执行到最后一条语句，线程将中止。
interrupt中断线程。 调用时线程的中断状态将被置位。
thread.isInterrupted()查看线程中断状态
Thread.interrrupted清除中断状态
若线程被阻塞则无法检测。检测时产生InterruptedException

###### 线程状态
>`Thread.State getState()`返回线程的状态

- Thread.Status 一个枚举类，枚举了线程的状态信息
1. new 线程刚刚创建时的状态 
2. Runable 调用了start方法，变为可运行状态，可能在运行也可能没用运行。
3. Blocked 被阻塞 当一个线程试图获取一个内部的对象锁，而该锁被其他线程持有。想要获得锁，而锁被其他线程持有，那么该线程进入阻塞状态。不运行任何代码消耗最少的资源 直到线程调度器重新激活它。
4. waiting 等待另一个线程通知调度器的状态。当一个线程等待另一个线程通知调度器一个条件时，该线程进入等待状态。
5. Timed waiting	超时之后，计时等待
6. Terminated	自然死亡或者意外死亡


###### 线程优先级
>`setPriority(int)`设置线程优先级，线程优先级是依赖于系统的。

###### 守护线程
>`thread.setDaemon(true)` 将线程设为守护线程,为其他线程提供服务，如计时线程，垃圾回收线程。
	如果只有守护线程的话，那么程序也就结束了。

###### 未捕获异常处理器
>线程的run方法不能抛出任何被检测的异常，但是如果不检测的话会导致线程死亡。这时候可以:
1. 安装一个处理器——一个实现Thread.UncaughtExceptionHandler接口uncaughtException方法的类。
2. 用setUncaughtExceptionHandler方法为任何线程安装一个处理器
3. 用Thread的静态方法setDefaultUncaughtExceptionHandler为所有线程安装一个默认处理器。

如果不安装默认处理器，默认处理器为空。
如果不为独立的线程安装处理器，此时的处理器就是该线程的ThreadGroup对象。
线程组是一个可以统一管理的线程集合，默认情况下所有线程属于同一个线程组。
ThradGroup实现了Thrad.UncaughtExceptionHandler接口

# 多线程和同步问题
**concurrent** 并发
**parallel** 并行 并发的极致
- 高并发 处于Runnable的线程数量越多，并发程度越高

###### 线程安全
>一个类在单线程和多线程的情况下都能正常运行。

###### Java实现原子操作的两种方式
1. Lock接口	保证一个共享变量一个时刻只能被一个线程访问。
2. CAS

>除了long,double之外的其他类型变量的写操作都是源自操作(JVM实现的)
>用volatile修饰后可保证其原子性

###### 锁
用来保护代码片段，使得任何时候只有一个线程执行被保护的代码。
也可以管理视图进入被保护的代码片段的线程
通过条件对象来管理那些已经进入被保护的代码片段

- **锁的排他性** 一个锁只能被一个线程持有，称为互斥锁，mutex

按照JVM来分，分为
1. 内部锁 又称监视器
2. 显式锁

###### 内部锁
使用synchronized修饰方法或者代码块，修饰的方法称为同步方法
用以保证该方法一次只被一个线程执行，而代码块称为同步块
```
synchronized(锁句柄){
...
}
```
这里的锁句柄可以是this，此时会锁句柄为锁，对应的句柄为引导的锁
- 同步静态方法相当于当前类对象XX.class为引导的同步块
- 称为内部锁的原因：线程对内部锁的申请和释放由JVM代由实施

###### 显式锁
Lock接口的实例，默认实现类ReentrantLock
常用方法
```
void lock() 获取锁
void unlock() 释放锁  一般放在finally块里
boolean tryLock() 尝试获得锁
new ReentrantLock(true) 创建公平锁 （默认是非公平锁）公平锁增加了线程的暂停和唤
```
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

###### 线程安全
>当多线程访问一个类时，可以不用考虑这些线程在运行时环境下的调度和交替执行，
 并且不需要额外的同步及在调用方代码不必作其他的调度，这个类的行为仍然是正确的。

###### sleep方法和wait方法的联系和区别
- sleep,wait方法都可以通过interrupt方法被打断线程的暂停状态，
- 如果线程正在处于sleep，wait，join等状态，会立刻抛出InterruptedException
- sleep方法没用释放锁，wait方法释放了锁，使得其他线程可以使用同步控制块
- sleep可以在任何地方使用，需要捕获异常



await 释放锁并进入等待阻塞状态
signalAll 通知等待的线程，激活他们
若是一个线程进入await，而又没有其他等待的线程激活它，那么就进入了死锁

```
notify()	唤醒在此对象监视器上等待的单个线程。 
notifyAll()	唤醒在此对象监视器上等待的所有线程。
wait()		导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法。
```

wait,notifyAll,notify都是final方法，来自Object
wait 方法使当前线程进入等待状态并释放锁

线程之间如何通信：通过notify和wait
什么要在同步块内呢：因为不同线程之间会随机竞争资源，我们要对共享资源的操作定序
