package com.example.demo.features;

public class Note {


    static final String ZHANG_HENG_SUMMARY = """
            Java面试宝典
                        
            1.JAVA中的几种基本数据类型是什么，各自占用多少字节\s
                        
                        
                        
            名词解释：
            　bit：位，计算机存储数据的最小单位，二进制数中的一个位数。
            　byte：字节，计算机存储数据的基本单位，一个字节由8位二进制数组成。通常一个汉字占两个字节。
                        
                        
            2.String类能被继承吗，为什么
                        
            ① 不可以，因为String类有final修饰符，而final修饰的类是不能被继承的，实现细节不允许改变。
                        
            ② 关于final修饰符，介绍如下：
             根据程序上下文环境，Java关键字final有“这是无法改变的”或者“终态的”含义，它可以修饰非抽象类、非抽象类成员 方法和变量。你可能出于两种理解而需要阻止改变：设计或效率。 
            　　 A. final类不能被继承，没有子类，final类中的方法默认是final的。 
            　　 B. final方法不能被子类的方法覆盖，但可以被继承。 
            　　 C. final成员变量表示常量，只能被赋值一次，赋值后值不再改变。 
            　　 D. final不能用于修饰构造方法。 
            　　 注意：父类的private成员方法是不能被子类方法覆盖的，因此private类型的方法默认是final类型的。
                        
            ③ 如果一个类不允许其子类覆盖某个方法，则可以把这个方法声明为final方法。 
            　　 使用final方法的原因有二： 
            　　 A. 第一、把方法锁定，防止任何继承类修改它的意义和实现。 
            　　 B. 第二、高效。编译器在遇到调用final方法时候会转入内嵌机制，大大提高执行效率。
                        
                        
            3.String、StringBuffer、StringBuilder的区别
                        
            ① String类是不可变（final修饰）的，每次拼接字符串都会产生新的String对象，占用内存，效率低
                        
            ② StringBuffer、StringBuilder拼接字符串不会产生新的对象，效率高
                        
            ③  StringBuffer支持并发操作，线程安全的，适合多线程中使用
                        
            ④  StringBuilder不是线程安全的，但其在单线程中的性能比StringBuffer高
                        
            总结：
             A. 如果要操作少量的数据用 String
             B. 单线程操作字符串缓冲区下操作大量数据用StringBuilder
             C. 多线程操作字符串缓冲区下操作大量数据用StringBuffer
                        
                        
            4.ArrayList和LinkedList有什么区别
                        
            ① ArrayList是实现了基于动态数组的数据结构，而数组是一段连续的内存空间，因为数组在存储数据时是按顺序存储的，存储数据的内存也是连续的，所以他的特点就是寻址读取 数据比较容易，插入和删除比较困难
                        
            ② LinkedList底层是双向链表，当需要在首位置插入元素时，first 引用指向需要插入到链表中的节点对象，新的节点对象的next引用指向原先的首节点对象
                        
            总结：
             A. ArrayList是实现了基于动态数组的数据结构，LinkedList是基于链表结构
             B. 对于随机访问的get和set方法，ArrayList要优于LinkedList，因为LinkedList要移动指针
             C. 对于新增和删除操作add和remove，LinkedList比较占优势，因为ArrayList要移动数据
             D. 对ArrayList和LinkedList而言，在列表末尾增加一个元素所花的开销都是固定的
             E. LinkedList集合不支持 高效的随机随机访问（RandomAccess），因为可能产生二次项的行为
             F. ArrayList的空间浪费主要体现在在list列表的结尾预留一定的容量空间，而LinkedList的空间花费则体现在它的每一个元素都需要消耗相当的空间
                        
                        
            5.讲讲类的实例化顺序
                        
            父类静态变量、 
            父类静态代码块、 
            子类静态变量、 
            子类静态代码块、 
            父类非静态变量（父类实例成员变量）、 
            父类构造函数、 
            子类非静态变量（子类实例成员变量）、 
            子类构造函数
                        
                        
            6.用过哪些Map类，都有什么区别，HashMap是线程安全的吗,并发下使用的Map是什么，他们
                内部原理分别是什么，比如存储方式，hashcode，扩容，默认容量等
                        
            常见的map类有： HashMap, ConcurrentHashMap (JDK1.8) , LinkedHashMap, TreeMap, Hashtable
                        
            ① HashMap是非线程安全的，而ConcurrentHashMap是线程安全的
                        
            ② 并发情况下可以使用HashTable和ConcurrentHashMap
             A.ConcurrentHashMap的hash计算公式：(key.hascode()^ (key.hascode()>>> 16)) &0x7FFFFFFF, 而 HashTable的hash计算公式：key.hascode() & 0x7FFFFFFF
             B.HashTable存储方式都是链表+数组，数组里面放的是当前hash的第一个数据，链表里面放的是hash冲突的数据 ，ConcurrentHashMap是数组+链表+红黑树
             C.线程安全的保证： HashTable是在每一个操作方法上都加上synchronized关键字来达 到线程安全的目的，而ConcurrentHashMap则是通过CAS算法      （CompareAndSwap）来保证线程安全
                        
            ③ ConcurrentHashMap 放弃了分段锁，而使用了Nodo锁，减低了锁的粒度，提高了性能，并使用CAS操作来保证Node操作的原子性。但是ConcurrentHashMap的一些操作使用了synchronized锁，而不是ReentrantLock,虽然说jdk8的synchronized的性能进行了优化，但是我觉得还是使用ReentrantLock锁能更多的提高性能
                        
            ④ 顺序的 Map 实现类:LinkedHashMap,TreeMap
             LinkedHashMap 是基于元素进入集合的顺序或者被访问的先后顺序排序，TreeMap 则是基于元素的固有顺序 (由Comparator 或者 Comparable 确定)
                        
            ⑤ HashMap和Hashtable
             A. HashMap是继承自AbstractMap类，而HashTable是继承自Dictionary类
             B. Hashtable既不支持Null key也不支持Null value
              HashMap只支持一个null key ,可以有一个或多个键的值为null
             C. 计算hash值的方法不同 : Hashtable直接使用对象的hashCode
              HashMap为了提高计算效率，将哈希表的大小固定为了2的幂，这样在取模预算时，不需要做除法，只需要做位运算
                        
                        
            7.接口可以继承接口吗，抽象类可以继承接口吗，抽象类可以继承实体类吗
                        
            ① 接口可以继承接口，抽象类不可以继承接口，但可以实现接口
                        
            ② 抽象类可以继承实体类。抽象类可以实现(implements)接口，抽象类是否可继承实体类，但前提是实体类必须有明确的构造函数
                        
            ③ 抽象类可以继承实体类，就是因为抽象类的可以继承性和有方法
                        
            ④ 一个接口可以继承多个接口，一个类可以实现多个接口，但是一个类只能继承一个类,不能继承多个类，在继承类的同时,也可以实现多个接口
                        
            ⑤ 抽象类的概念：
             A. 抽象类和抽象方法都要被abstract修饰，抽象方法一定要定义在抽象类中，
             B. 只有覆盖了抽象类中所有的抽象方法后，其子类才可以创建对象。否则该子类还是一个抽象类
             C. 抽象类是一个父类，可以不定义抽象方法，不可以直接创建对象，方法可以直接让子类去使用
             D. Abstract和private也是不可以一起使用的
                        
                        
            8.继承、聚合、组合的区别在哪
                        
            ① 继承：他是is-a的关系，指一个类继承另外一个类的功能
            　　 例如：public class A extends B { }
                        
            ② 聚合：他是has-a　　
            　　 例如：public class A{ List<B> b} A可以有b
                        
            ③ 组合：他是contans-a（强聚合）
            　　 public class A { B b} A一定有b
                        
                        
            9.IO模型有哪些，讲讲你理解的nio ，他和bio，aio的区别是啥，谈谈reactor模型
                        
            ①  BIO：同步并阻塞，服务器实现模式为一个连接一个线程，即客户端有连接请求时服务器端就需要启动一个线程并处理，如果这个连接不做任何事情会造成不必要的开销，当然可以通过线程池机制改善
             使用场景：适用于连接数目比较小且固定的架构，这种方式对服务器资源要求比较高，并发局限于应用中，JDK1.4以前 的唯一选择，但程序直观简单易理解
             实际应用：tomcat采用的传统的BIO（同步阻塞IO模型）+线程池模式，对于十万甚至百万连接的时候，传统BIO模型是无能为力的
                        
            ② NIO：同步非阻塞，服务器实现模式为一个请求一个线程，即客户端发送的连接请求都会注册到多路复用器上，多路复用器轮询到连接有IO请求时才启动一个线程进行处理
             使用场景：适用于连接数目多且连接比较短（轻操作）的架构，比如聊天服务器，并发局限于应用中，编程比较复杂，JDK1.4开始支持
             实际应用：NIO基于Reactor，当socket有流可读或可写入socket，操作系统会相应的通知引用程序进行处理，应用再将流读取到缓冲区或写入操作系统。也就是，不是一个链接就要对应一个处理线程，                          而是一个有效请求对应一个线程，当连接没有数据时，是没有工作线程来处理的
                        
            ③ AIO：异步非阻塞，服务器实现模式为一个有效请求一个线程，客户端的I/O请求都是由OS先完成了再通知服务器应用去启动线程进行处理
             使用场景：适用于连接数目多且连接比较长（重操作）的架构，比如相册服务器，充分调用OS参与并发操作，编程比较复杂，JDK7开始支持
             实际应用：AIO需要一个链接注册读写事件和回调方法，当进行读写操作时，只须直接调用API的read或write方法即可，这两种方法均为异步，对于读操作而言，当有流可读取时，操作系统会将可读的流 传入read方法的缓冲区，并通知应用程序；对于写操作而言，当操作系统将write方法传递的流写入完毕时，操作系统主动通知应用程序，即read/write方法都是异步的，完成后会主动调用回调函数
                        
            ④ Reactor模型
             NIO只有acceptor的服务线程是堵塞进行的，其他读写线程是通过注册事件的方式，有读写事件激活时才调用线程资源区执行，不会一直堵塞等着读写操作，Reactor的瓶颈主要在于acceptor的执行，读写事件也是在这一块分发。
                        
                        
            10.Java反射机制(创建Class对象的三种方式)
            https://www.cnblogs.com/qlwang/p/8018175.html
                        
                        
            11.反射中，Class.forName和ClassLoader区别
            https://blog.csdn.net/u013308490/article/details/87809824
                        
                        
            12.描述动态代理的几种实现方式，分别说出相应的优缺点
            https://blog.csdn.net/zy_281870667/article/details/53216776
                        
                        
            13.final的用途
            https://www.cnblogs.com/xrq730/p/4820296.html
                        
                        
            14.java 详解类加载器的双亲委派及打破双亲委派
            https://blog.csdn.net/Dopamy_BusyMonkey/article/details/79739748
                        
                        
            15.jvm 工作原理
            https://www.cnblogs.com/yueminghai/p/6639170.html
                        
                        
            16.Java消息队列
            https://www.zhihu.com/tardis/sogou/art/45164861
                        
                        
            17.java设计模式
            https://blog.csdn.net/syq8023/article/details/92397890
                        
                        
            18.SpringCloud服务间调用
            https://segmentfault.com/a/1190000018531262?utm_source=tag-newest
                        
                        
            19.Java单例模式——并非看起来那么简单
            https://blog.csdn.net/goodlixueyong/article/details/51935526
                        
                        
            20.线程5种状态及转换
            https://www.jianshu.com/p/ac81851db978
                        
                        
            21.java高并发的处理--锁机制（悲观锁、乐观锁）
            https://blog.csdn.net/zhigang1007/article/details/78910373
                        
                        
            22.Java分布式锁,搞懂分布式锁实现看这篇文章就对了
            https://www.cnblogs.com/toutou/archive/2018/09/24/9554974.html
                        
                        
            23.Redis分布式锁的正确实现方式
            https://blog.csdn.net/sdmxdzb/article/details/78410494
                        
                        
            24.数据库优化方案整理
            https://blog.csdn.net/u013628152/article/details/82184809
                        
                        
            25.RabbitMQ
            https://www.cnblogs.com/ysocean/p/9251884.html
                        
                        
            26.Jvm参数调优
            https://www.jianshu.com/p/c3fc376114ec
                        
                        
            27.SpringCloud架构图
                        
                        
                        
            28.Hash算法及HashMap底层实现原理
            https://www.jianshu.com/p/67b825e08d17
                        
                        
            29.Redis和Jedis的用法，区别
            https://blog.csdn.net/zxl646801924/article/details/82770026
                        
                        
            30.基于分布式微服务的秒杀抢购功能的实现
            https://www.cnblogs.com/wuhen8866/p/11127341.html
                        
                        
            31.Redis分布式事务
            http://www.360doc.com/content/18/0204/14/33260087_727645415.shtml
                        
                        
            32.Java Spring Cloud + TX-LCN分布式事务框架 亲测
            https://blog.csdn.net/qcl108/article/details/100008107
                        
                        
            32.Get和Post的区别
            https://www.zhihu.com/tardis/sogou/art/63435719
                        
                        
            33.MongoDB、Redis、Memcache优缺点
            https://www.zhihu.com/tardis/sogou/art/88598277
                        
                        
            34.spring boot启动原理
                        
                        
            35.索引失效
            什么时候没用
            1.有or必全有索引;
            2.复合索引未用左列字段（多个字段索引，必须使用到最左列字段索引）;
            3.like以%开头;
            4.需要类型转换;
            5.where中索引列有运算;
            6.where中索引列使用了函数;
            7.如果mysql觉得全表扫描更快时（数据少）;
                        
            什么时没必要用
            1.唯一性差;
            2.频繁更新的字段不用（更新索引消耗）;
            3.where中不用的字段;
            4.索引使用<>时，效果一般;
                        
            36. java 基础排序（冒泡、插入、选择、快速）算法回顾
            https://www.cnblogs.com/lenovo_tiger_love/p/11596798.html
                        
            https://blog.csdn.net/weixin_44093765/article/details/87475673
                        
            结论:基础排序算法单纯时间上来说，对10000个数的排序效率：
            quick_sort>select_sort>insert_sort>bubble_sort
                        
            37. 数组与链表的区别
            https://zhuanlan.zhihu.com/p/52440208
                        
            38.Kafka优势及应用场景
            https://www.jianshu.com/p/6ac4dcfcdccf
                        
            39.java hash 分库分表_分库分表方案
            https://blog.csdn.net/weixin_28900073/article/details/114568429
                        
            40.Redis缓存击穿、穿透、雪崩解决方案
            https://www.jianshu.com/p/b7f822935e28
                        
            41.HashMap初始化大小设定多少合适
            https://blog.csdn.net/ren365880/article/details/108083998
                        
            42.ELK简介
            https://zhuanlan.zhihu.com/p/121099453
                        
            43.SkyWalking
            https://blog.csdn.net/qq_17231297/article/details/112792366
                        
            44.Sentinel
            https://blog.csdn.net/zzprongyi/article/details/109056356
                        
            45.ES
            https://zhuanlan.zhihu.com/p/321248369
                        
            46.Java多线程间是如何通信的呢？
            https://blog.csdn.net/cxh6863/article/details/106779083
                        
            47.Java线程池使用和常用参数
            https://www.cnblogs.com/owenma/p/8557074.html
                        
            48. mybatis是如何防止SQL注入的
            https://www.zhihu.com/tardis/sogou/art/39408398
                        
            49.mysql事务四大特性
            https://www.zhihu.com/tardis/sogou/art/83202409
                        
            50.消息队列Kafka、RocketMQ、RabbitMQ的优劣势比较
            https://zhuanlan.zhihu.com/p/60288391
                        
            51.CAS算法
            https://zhuanlan.zhihu.com/p/93418208
                        
            52.spring事务失效
            https://www.zhihu.com/tardis/sogou/art/101396825
                        
            53.分布式id
            https://zhuanlan.zhihu.com/p/107939861
                        
            54.数组与链表的区别
            https://zhuanlan.zhihu.com/p/52440208
                        
            55.spring mvc原理
            https://www.jianshu.com/p/8a20c547e245
                        
            56.spring bean的生命周期
            https://www.jianshu.com/p/1dec08d290c1
                        
            57.redis哨兵模式
            https://zhuanlan.zhihu.com/p/102347295
                        
            58.redis面试题
            https://zhuanlan.zhihu.com/p/91539644
                        
            """;
}
