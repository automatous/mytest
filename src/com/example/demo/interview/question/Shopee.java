package com.example.demo.interview.question;

public class Shopee {
    /*
     * 1. 介绍一下TCP和UDP? 工作在哪一层? TCP会如何保证自己是可靠传输?
     *
     * 2. 死锁是如何产生的? 如何避免
     *
     * 3. Linux进程和线程的联系和区别? 同一个线程共享了哪些东西? 进程间通信和线程间通信的区别?
     * 进程和线程的区别：
对于进程来说，子进程是父进程的复制品，从父进程那里获得父进程的数据空间，堆和栈的复制品。

而线程，相对于进程而言，是一个更加接近于执行体的概念，可以和同进程的其他线程之间直接共享数据，而且拥有自己的栈空间，拥有独立序列。

共同点： 它们都能提高程序的并发度，提高程序运行效率和响应时间。线程和进程在使用上各有优缺点。 线程执行开销比较小，但不利于资源的管理和保护，而进程相反。同时，线程适合在SMP机器上运行，而进程可以跨机器迁移。

他们之间根本区别在于 多进程中每个进程有自己的地址空间，线程则共享地址空间。所有其他区别都是因为这个区别产生的。比如说：
1. 速度。线程产生的速度快，通讯快，切换快，因为他们处于同一地址空间。
2. 线程的资源利用率好。
3. 线程使用公共变量或者内存的时候需要同步机制，但进程不用。

而他们通信方式的差异也仍然是由于这个根本原因造成的。

通信方式之间的差异
因为那个根本原因，实际上只有进程间需要通信,同一进程的线程共享地址空间,没有通信的必要，但要做好同步/互斥,保护共享的全局变量。

而进程间通信无论是信号，管道pipe还是共享内存都是由操作系统保证的，是系统调用.

一、进程间的通信方式
管道( pipe )：
管道是一种半双工的通信方式，数据只能单向流动，而且只能在具有亲缘关系的进程间使用。进程的亲缘关系通常是指父子进程关系。
有名管道 (namedpipe) ：
有名管道也是半双工的通信方式，但是它允许无亲缘关系进程间的通信。
信号量(semophore ) ：
信号量是一个计数器，可以用来控制多个进程对共享资源的访问。它常作为一种锁机制，防止某进程正在访问共享资源时，其他进程也访问该资源。因此，主要作为进程间以及同一进程内不同线程之间的同步手段。
消息队列( messagequeue ) ：
消息队列是由消息的链表，存放在内核中并由消息队列标识符标识。消息队列克服了信号传递信息少、管道只能承载无格式字节流以及缓冲区大小受限等缺点。
信号 (sinal ) ：
信号是一种比较复杂的通信方式，用于通知接收进程某个事件已经发生。
共享内存(shared memory ) ：
共享内存就是映射一段能被其他进程所访问的内存，这段共享内存由一个进程创建，但多个进程都可以访问。共享内存是最快的 IPC 方式，它是针对其他进程间通信方式运行效率低而专门设计的。它往往与其他通信机制，如信号两，配合使用，来实现进程间的同步和通信。
套接字(socket ) ：
套接口也是一种进程间通信机制，与其他通信机制不同的是，它可用于不同设备及其间的进程通信。
二、线程间的通信方式
锁机制：包括互斥锁、条件变量、读写锁
互斥锁提供了以排他方式防止数据结构被并发修改的方法。
读写锁允许多个线程同时读共享数据，而对写操作是互斥的。
条件变量可以以原子的方式阻塞进程，直到某个特定条件为真为止。对条件的测试是在互斥锁的保护下进行的。条件变量始终与互斥锁一起使用。
信号量机制(Semaphore)：包括无名线程信号量和命名线程信号量
信号机制(Signal)：类似进程间的信号处理
线程间的通信目的主要是用于线程同步，所以线程没有像进程通信中的用于数据交换的通信机制。
————————————————
版权声明：本文为CSDN博主「Harry_T」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/liyue98/article/details/80112246
     *
     * 4. 读取一个文件, 再经过socket发送到网络, 内存经过了几次拷贝?
     *
     * 5. 讲一下redis支持的常用数据类型, 列举一下分别可以用来做什么?
     *
     * 6. 什么是布隆过滤器? 使用场景是什么?
     *
     * 7. 进程间的通信方式有哪些?
     *
     * 8. TCP如何保证传输的可靠性?
     *
     * 9. 尽可能的列出熟悉和使用的linux命令和作用
     *
     * 10. http和https的区别
     *
     * 11. 什么叫做稳定的排序算法, 有什么是你知道的稳定排序算法
     *
     * 12. 什么叫跳表? 跳表有什么优缺点? 比较一下跳表和平衡二叉树?
     *
     * 13. 说说常见的设计模式, 举一个项目中觉得用的比较恰当的例子
     *
     * 14. http的状态码有哪些, 代表什么意思?
     *
     * 15. java中 == 与 equals 的区别
     *
     * 16. 简述几种排序算法
     *
     * 17. 哈希数据结构的实现原理, 哈希冲突问题的解决方式有哪些?
     *
     * 18. http的请求过程
     *
     * 19. 简述https认证的过程, 在交互的过程中, 至少用到了几组公钥私钥? 分别起到什么作用?
     *
     * 20. 简要说明os虚拟内存机制
     *
     * 21. Java线程池的理解, 如何创建? 核心参数及线程池工作原理
     *
     * 22. 聊一聊IO多路复用的三种实现方式: select, poll, epoll
     *
     * 23. Java中, 为什么重写equals时必须重写hashCode方法?
     *
     * 24. 平时开发的语言中会用到哪些数据结构? 有什么优缺点? hashMap冲突了怎么解决?
     *
     * 25. 用户态和内核态基础知识
     *
     * 26. 主键和唯一索引的区别
     *
     * 27. Java HashMap实现原理
     *
     * 28. Java中String, StringBuffer, StringBuilder的异同点
     *
     * 29. 什么是TCP窗口滑动机制?
     *
     * 30. 用户进程间通信主要有哪几种方式?
     *
     * 31. 虚拟内存是什么?
     *
     * 32. 简述几种Java容器类?
     *
     * 33. 长连接和短连接的区别
     *
     * 34. TCP为什么要三次握手? 而不是二次或者四次? 关闭为什么需要四次挥手?
     *
     * 35. 为什么推荐使用自增id作为主键?
     *
     * 36. 用过Redis的哪几种数据结构? zset是怎么实现的?
     *
     * 37. 栈和堆的区别, 为什么栈要快点?
     *
     * 38. 说明一下 强一致性, 弱一致性, 最终一致性的区别
     *
     * 39. 查看cpu的命令, 查看内存的命令, 内存里的buffer和cache的区别. 查看硬件的命令
     *
     * 40. HTTP常见状态码和缓存策略
     *
     * 41. HTTPS的工作原理
     *
     * 42. 进程和线程的区别? 浏览器的进程和线程是怎么样的?
     *
     * 43. 一次完整的http流程
     *
     * 44. GC是什么? 为什么要GC? 简述Java的回收机制
     *
     * 45. Java线程有几种状态? 分别代表什么含义?
     *
     * 46. Java中的volatile关键字的作用是什么?
     *
     * 47. Java中synchronized关键字可以修饰代码的哪些区域, 作用是什么?
     *
     * 48. Java中有哪些方式来使用多线程
     *
     * 49. 一个Java进程有两个线程, 一个线程OOM了, 另一个线程可以正常运行吗?
     *
     * 50. Java单例模式有哪几种实现方式?
     *
     *
     */

    // ===============================================================================================================

    /*
     * P20     1. Java的容器是什么?
        2. 常用框架JPA? A: Java Persistence API(Java 持久层 API: 用于对象持久化的 API); mybatis官方文档就说了他是一个半自动化的持久层框架, 相对于按自动的hibernate更加灵活可控;
        3. 认证授权：JWT/SSO?
P21     1. 消息队列消峰和降流
        2. 用markdown写简历，并转成PDF格式
P22     1. redis是单线程为什么还那么快? redis内存淘汰机制?  A: P197-1
P23     1. 了解/熟悉/掌握, 三个词的程度顺序
P24     1. 关于简历的小tips
        2. 学历、专业等软肋可以通过其他的优势来弥补
P25     1. 计算机基础: 1)计算机网络 2)操作系统 3)数据结构与算法, 第3点需要持续投入!
P27     1. 面向对象编程, SOLID软件设计原则? A: 另一种说法是: 面向对象编程的六大原则 (继承强调的是is-a的关系，而组合强调的是has-a的关系)
    SOLID: 单一职责原则(Single responsibility principle)/开闭原则(Open Close Principle)/
        里氏代换原则(Liskov Substitution Principle)/接口隔离原则(Interface Segregation Principle)/
        依赖倒转原则(Dependence Inversion Principle)
    六大原则: 多了一个 -> 迪米特法则(Demeter Principle), 又称最少知道原则(Law of Demeter，简称LoD, 更简单的定义: 只与直接的朋友通信)
P30     1. 一定要有一门自己的特长, 不管是技术好还是其他能力; 不需要掌握每门技术(你没有精力掌握那么多技术),
    而是需要深入研究某些技术, 对于其他技术我们可以简单的了解一下
P33     1. Java类单继承, C++支持多重继承; Java类虽然不能多继承, 但是接口可以多继承
P35     1. 关于重载/重写:
    -- 重载, 在字节码层面的解释? JVM如何判断重载方法的(重载解析)?
    A: (还没看JVM/字节码相关)重载就是方法名相同, 但是参数不同, 与返回值/抛出的异常无关(方法签名: 方法名+参数);
    -- 是继承重写还是重载? 如何与前面提到的"面向对象编程的六大原则"联系起来, 协调统一?
P36     1. 同上有关的重载/重写, 什么是多态性?
    A: 多态性: 1)方法的重载与重写 2)对象在运行过程中的多种形态;
    重写方法签名相同即可(返回值类型/抛出的异常范围: 小于父类; 访问修饰符: 大于父类; 即: 符合面向对象编程中的里氏代换原则)
P41     1. 线程BLOCKED状态, 什么时候进入BLOCKED状态? 等待进入synchronized方法/块? IO request?
        2. 静态内部类实现单例模式: 这种方式不仅具有延迟初始化的好处(懒加载), 而且由 JVM 提供了对线程安全的支持
            A: JVM类初始化时, 有加锁机制, 保证了只有一个线程能完成初始化, 即: 在一个静态内部类中初始化静态实例, 静态内部类初始化时, 此类先初始化静态实例,
                因为类初始化时JVM加了锁, 故线程安全的完成了静态内部类的静态实例的初始化, 以此来完成单例的初始化(PS: 一定都是静态的类/变量, 若有非静态的, 只能用volatile那种方式)
P50     1. RandomAccess接口只不过是一个标识罢了(类似的接口好像还有Cloneable, Serializable)
P51     1. HashTable的key/value都不能为null
P56     1. HashMap的长度为什么是2的幂次方?  A: (n-1) & hash 刚好是%n(n为2的幂次方), 二进制位操作&运算, 相对于%的运算更高效, 以达到存取高效的目的
        2. loadFactor负载因子, 在内存空间很多而又对时间要求很高, 可以降低负载因子的值;
    相反, 如果内存空间紧张而又对时间效率要求不高, 可以增加负载因子loadFactor的值, 这个值可以大于1
P57     1. 到了 JDK1.8 的时候已经摒弃了Segment的概念，⽽是直接⽤ Node 数组+链表+红⿊树的数据结构来实现，并发控制使⽤ synchronized 和 CAS 来操作
    Node数组(即table)用volatile修饰, 同样Node中的Node next属性也是; 至此volatile与CAS一同使用的条件成立, synchronized可用Node对象作为monitor
P72     1. 双重校验锁实现单例模式(参考P41依赖JVM的单例模式)
P77     1. 并发编程的3个重要特性: 1)原子性 2)可见性 3)有序性(禁止指令重排优化); volatile保证了2) 3)这2个特性; CAS保证了1)
P81     1. ThreadLocal对象调用get()/set()时, 会往当前的Thread的对象的属性threadLocals设值, 即:
    t.threadLocals = new ThreadLocalMap(this, firstValue); 只要set()时, 能保证设置的值私有, 即可保证多线程间没有共享数据
    注意事项:
1) 使用多个ThreadLocal对象的话, 第一个ThreadLocal内完成t.threadLocals = new ThreadLocalMap(this, firstValue)初始化赋值,
使Thread内部都使用此仅有的ThreadLocalMap存放数据, key就是不同的ThreadLocal对象, value就是set()的值
2) 泄露问题 ThreadLocalMap 中使⽤的 key 为 ThreadLocal 的弱引⽤, ⽽ value 是强引⽤. 所以, 如果 ThreadLocal 没有被外部强引⽤的情况下,
在垃圾回收的时候， key 会被清理掉，⽽ value 不会被清理掉. 这样⼀来, ThreadLocalMap 中就会出现key为null的Entry. 假如我们不做任何措施的话,
value 永远⽆法被GC 回收, 这个时候就可能会产⽣内存泄露. ThreadLocalMap实现中已经考虑了这种情况, 在调⽤ set()/get()/remove() ⽅法的时候,
会清理掉 key 为 null 的记录. 使⽤完ThreadLocal ⽅法后 最好⼿动调⽤ remove() ⽅法. 线程的exit()方法会将threadLocals设置为null,
故线程退出时, 不存在内存泄漏问题
P82     1. 像threadLocal这样的弱引用会被错误回收吗? 弱引用有哪些知识点? JVM GC安全点有哪些?
P86     1. ThreadPoolExecutor的饱和策略, CallerRunsPolicy判断当前线程池是否RUNNING, 若是则调用方自己执行(而非交给线程池执行), 所以可能会有延迟
P94     1. AtomicInteger 类主要利⽤ CAS (compare and swap) + volatile 和 native ⽅法来保证原⼦操作, 从⽽避免 synchronized 的⾼开销, 执⾏效率⼤为提升
P95     1. AQS使⽤CAS对该同步状态进⾏原⼦操作实现对其值的修改(同上)
P96     1. 了解基于AQS的自定义同步器? 以及现有的ReentrantLock/ReentrantReadWriteLock/Semaphore/CountDownLatch/CyclicBarrier?
P98~121 1. JVM相关: 对象创建过程? GC的不同回收策略(算法)及不同的GC收集器? 类文件结构(attributes)? 类加载过程(双亲委派模型)?
    A: 1)对象创建递归链式由下到上找层级关系, 再由上向下初始化(父类->子类, 静态->动态; 父类子类中的同名变量, 类似就近原则或也可以说直接覆盖,
    2)注意这些不影响多态, 所以在父类初始化是调用子类的方法出现初始化零值就不奇怪了, 因为子类还没真正初始化)
    3)标记-清除:空闲列表; 标记-复制:指针碰撞; 标记-整理(压缩):空闲列表+指针碰撞; G1(Garbage First)/CMS(Concurrent Mark Sweep)/ZGC
    4)具体看字节码文件; 类加载及生命周期:加载Loading->连接Linking(验证Verification->准备Preparation->解析Resolution)->初始化Initialization
    对象创建: 类加载检查->内存分配->初始化零值->设置对象头->执行init方法
P124~127    0. 将主机间的交付扩展到进程间的交付被称为运输层的多路复用与多路分解
                1)多路复用: 在源主机从不同套接字中收集数据块, 并为每个数据块封装上首部信息(这将在以后用于分解)从而生成报文段, 然后将报文段传递到网络层的这些所有工作
                2)多路分解: 将运输层报文段中的数据交付到正确的套接字的工作
            1. 1)TCP三次握手, SYN/ACK等机制? 2)四次挥手FIN/ACK等机制? 3)DNS相关?
        A: 1)三次握手(three-way handshake):
        第一次(发起方): 请求连接(SYN=1, seq=client_isn; SYN报文段)
        第二次(响应方): 连接允许(SYN=1, seq=server_isn, ack=client_isn+1; SYNACK报文段)
        第三次(发起方): ACK(SYN=0, seq=client_isn+1, ack=server_isn+1; ACK报文段)
        注意: 1) SYN洪泛攻击(解决方案: 未确认的连接不分配资源的SYNACK-cookie机制);
              2) TCP分岔: 优化云服务的性能, 客户端邻近有个类似与云端建立好连接的TCP连接池, 从而避免了TCP建立连接所需的(3+1)*RTT的较大延迟(RTT: Round-Trip Time往返时延)
        2)四次挥手(four-way wavehand)
        第一次(发起方): 关闭(FIN报文段)
        第二次(响应方): ACK
        第三次(响应方): FIN
        第四次(发起方): ACK(定时等待时间内, 没有再次收到FIN说明ACK被成功接收)
        注意: 为什么3次握手, 4次挥手? A: 因为响应方(服务器)在listen状态下, 收到建立连接请求的SYN报文段后, 把SYN & ACK放在一个报文段内发送给发起方(客户端);
            而关闭连接时, 收到对方的FIN报文时, 仅仅表示对方不再发报文, 但还是能接收数据, 己方也未必把全部数据发送给了对方, 所以己方可以立即close, 也可以发送完数据后,
            再发送FIN报文给对方表示同意现在关闭连接, 因此, 己方ACK & FIN 一般都会分开发送
        3)DNS使用
P127~129    1. 1)TCP/UDP数据包格式, 为什么这么设计? 2)TCP协议如何保证可靠传输?
            A: 1)TCP的数据包格式比UDP的复杂, 因为TCP含有各种控制信息
                2)TCP涉及连接管理/流量控制/往返时间估计/可靠数据传送/拥塞控制等等
            TCP通过 确认 & 重传 机制来实现(实现手段: 校验和/定时器/序号/确认/窗口/流水线) 数据分组/控制分组
            滑动窗口协议:回退N步(GBN)/选择重传(SR): 实际是 (ack 3次)累计确认, 结合了GBN/SR两者的优点(GBN避免了k确认之前的重传, SR做了缓存)
            发送方负责检测和恢复丢包的工作(定时器超时重传机制); ARQ协议(Automatic repeat reQuest): 自动重传请求协议, 通过另外三种协议功能实现 差错检测/接收方反馈/重传
            序号(sequence)为字节流编号, 确认号(acknowledgment); 计算方式: 发送方seq+data=接收方ack, 发送方ack=接收方seq, 反之亦然
                发送方: seq=42, ack=79, data=1; 接收方: seq=79, ack=43, data=1; 发送方: seq=43, ack=80, data=0
                由于序号是取模运算, 窗口长度必须小于或等于序号空间大小的一半, 避免无法区分是重传还是初次传输
                真实情况是字节流编号+TLL+最长分组寿命, 理论上可使相同序号被重新使用的荣誉分组重新排序问题完全避免(即在任一时刻, 不存在相同序号的有效分组)
            往返时间估计:由公式算的; 超时间隔加倍; 快速重传: 3个冗余ACK, 则执行快速重传(在定时器过期之前就重传丢失报文)
            流量控制: 发送方维护一个接受窗口(接收方给发送方的一个指示: 接收方还有多少可用的缓存空间)
            TCP拥塞控制: 端到端拥塞控制, 非网络辅助的拥塞控制(每个TCP发送方根据异步于其他TCP发送方的本地信息而行动)
                rwnd(接收窗口)/cwnd(拥塞窗口)/RTT(往返时间)/MSS(最大段, 简单了解就是包大小)/ssthresh(慢启动阈值)/dupACKcount(冗余ACK次数)
                以下3种方式遇到超时时, 都会使ssthresh=cwnd/2, cwnd=1MSS, 重传, 并执行慢启动过程
                以下3种方式遇到ACK冗余3次, 都会进入快速恢复, ssthresh=cwnd/2, cwnd=ssthresh+3MSS, 当相同的冗余ACK再次到达时cwnd=ssthresh+1MSS, 不同的ACK到达时, 执行拥塞避免
                慢启动: 慢启动不慢! cwnd<ssthresh时, 每过一个RTT, 确认多少个MSS, 就增加多少个MSS, 相当于指数增长; 当cwnd>=ssthresh时变为拥塞控制;
                拥塞避免: cwnd=cwnd+MSS*(MSS/cwnd), 相当于每过一个RTT, 新增一个MSS
                快速恢复: ssthresh=cwnd/2, cwnd=ssthresh+3MSS, 当相同的冗余ACK再次到达时cwnd=ssthresh+1MSS, 不同的ACK到达时, 执行拥塞避免
                由此可知: 以上3种方式, 可相互转换
                TCP拥塞控制: 加性增, 乘性减(Addictive-Increase, Multiplicative-Decrease, AIMD)
P187    1. MySQL innoDB MVCC(Multi Version Concurrency Control)多版本并发控制?
P188    1. MySQL字符集及校对规则: 校对规则(collation): 是在字符集内用于字符比较和排序的一套规则, 比如有的规则区分大小写, 有的则无视;
        存在校对规则命名约定: 以其相关的字符集名开始, 中间包括一个语言名, 并且以_ci(大小写不敏感), _cs(大小写敏感), _bin(二元)结束;
        若使用utf8_bin校对规则执行SQL查询时区分大小写, 使用utf8_general_ci不区分大小写(默认的utf8字符集对应的校对规则是utf8_general_ci)
P189    1. 事务的四大特性: ACID; 原子性(Atomicity)/一致性(Consistency)/隔离性(Isolation)/持久性(Durability)
        2. 并发事务带来的问题: 1)脏读Dirty Read:  一个事务读到了另一个事务未提交的数据;
                            2)丢失修改Lost to Modify: 两事务读到相同数据后, 一个事务的修改被另一个事务的修改覆盖了;
                            3)不可重复读Unreapeatable Read: 一个事务内的多次读取的单值可能不一样, 因为中间可能被其他事务给修改了
                            4)幻读Phantom Read: 与不可重复读类似, 一个事务多次读取几行数据, 由于期间另一个事务插入了一些数据, 导致前后多了一些原本不存在的记录, 就像发生了幻觉一样
        3. 事务隔离级别: 1)读未提交Read Uncommitted: 最低隔离级别, 允许读取尚未提交的数据, 可能会导致脏读/幻读/不可重复读
                        2)读已提交Read Committed: 允许读取并发事务已提交的数据, 可以阻止脏读, 但是幻读/不可重复读仍有可能发生
                        3)可重复读Repeatable Read: 对单值的多次读取结果都是一致的, 除非数据被本身事务自己所修改, 可以阻止脏读/不可重复读, 但幻读仍有可能发生(本质就是只对单值数据资源加锁保护, 其他资源不加锁保护)
                        4)可串行化Serializable: 最高的隔离级别, 完全服从ACID的隔离级别, 所有事务逐个依次执行, 事务之间完全不可能产生干扰, 可防止脏读/不可重复读/幻读(本质就是所有资源都加锁保护起来)
        4. MySQL innoDB 默认事务的隔离级别是: 可重复读Repeatable Read
P191    1. 事务隔离级别越低, 事务请求的锁越少; 大部分数据库系统的隔离级别是Read Committed, 但是InnoDB存储引擎默认使用Repeatable Read并不会有任何的性能损失
        2. 表级锁: MySQL中锁粒度最大的一种锁, 实现简单, 资源消耗少, 加锁快, 不会出现死锁, 并发度最低
            行级锁: MySQL中锁粒度最小的一种锁, 并发度高, 实现复杂, 开销大, 加锁慢, 会出现死锁
            发生死锁后, InnoDB一般都可以检测到, 并使一个事务释放锁回退, 另一个则可以获取锁完成事务
P195    1. 为什么用Redis?   A: 主要从 高性能/高并发 这两点来看问题
P197    1. Redis单线程模型也能高效? A: 1)纯内存操作 2)核心是基于非阻塞IO多路复用机制    3)单线程反而避免了多线程的频繁的上下文切换问题
P200    1. Redis持久化机制:
            RDB(Redis Database默认): 快照持久化(snapshotting)   触发田间: 900s->1/300s->10/60s->10000
            AOF(Append-only file): 开启参数appendonly yes; 与快照相比, AOF的持久化实时性更好, 已成为主流的持久化方案;
                 appendfsync always, 即每次有数据修改时都会写入AOF文件, 这样会严重降低Redis的速度
                 一般配置为appendfsync everysec, 即每秒钟同步一次, 显示的将多个命令同步到硬盘(Redis性能几乎没有受到任何影响, 而且即使出现系统崩溃, 用户最多丢失一秒内产生的数据)
                 appendfsync no, 即让操作系统决定何时进行同步
p201~202    0. MySQL并发能力, 默认最大的连接数在150左右, 这只是众多指标中的一个, CPU/内存/磁盘/网络/IO等等物理条件都是其运行时的指标, 一般3000个并发请求就能打死大部分数据库了
            1. 缓存雪崩: 缓存同一时间大面积失效, 所以, 请求都落在数据库上, 造成数据库短时间内承受大量请求而崩掉
                应对措施:   1)事前: 尽量保证Redis集群高可用, 机器故障及时排除, 选择合适的内存淘汰机制
                            2)事中: 本地缓存+限流/降级
                            3)事后: 利用持久化文件尽快恢复缓存
            2. 缓存穿透: 大量请求的key根本不存在缓存中, 导致请求直接到了数据库上, 根本没有经过缓存这一层(如: 黑客故意制造大量不存在的key发起攻击)
                应对措施: 1)更严格的数据格式校验(让构造数据变得不那么简单)
                            2)使用布隆过滤器, 原理: 通过hash与位图关联, 存在小概率误判, 因为是位图, 就算很大的数据总量, 实际占用空间也比较小
                                布隆过滤器使用场景: 1) 判断给定数据是否存在 2)去重: 如爬虫URL去重
P206    1. 如何保证缓存与数据库的数据一致?
            A: 1)一般允许偶尔不一致的情况, 故不需要串行化(串行化: 串到一个内存队列中, 这样就可以保证一定不会出现不一致的情况, 导致系统吞吐量大幅降低,
                    用更多的机器去支撑一个业务请求, 甚至还不一定能满足)
               2)最经典的缓存+数据库读写的模式, 就是 Cache Aside Pattern: 读的时候走缓存/做缓存, 写的时候先删除缓存, 再更新数据库;
                    更新数据库后不马上写缓存, 因为在非同步并发下, 有可能会写入脏数据(Lazy懒加载思想: 避免过多的不必要中间缓存, 这些缓存很快就会被覆盖掉)
               3)串行化队列时, 应该考虑系统的能力, 做相应的超时机制/限流/降级等, 避免请求超时
P206    1. Spring是一种轻量级的开发框架, 旨在提高开发人员的开发效率以及系统的可维护性
P207    1. IoC:控制反转(Inversion of Control, 缩写为IoC), 是面向对象编程中的一种设计原则, 可以用来减低计算机代码之间的耦合度; 其中最常见的方式叫做依赖注入(Dependency Injection, 简称DI), 还有一种方式叫"依赖查找"(Dependency Lookup)
            依赖倒置原则(Dependency Inversion Principle) -> (思路)Ioc -> (方法)DI
        2. AOP:在软件业, AOP为Aspect Oriented Programming的缩写, 意为: 面向切面编程, 通过预编译方式和运行期间动态代理实现程序功能的统一维护的一种技术
            动态代理: 动态代理就是, 在程序运行期, 创建目标对象的代理对象, 并对目标对象中的方法进行功能性增强的一种技术(期间也设计到反射)
P208    1. @Controller + @ResponseBody(Spring4之前开发RestFul web服务的话) = @RestController(Spring4之后新家的注解)
P209    1. IoC容器实际上就是个Map(key, value), Map中存放的是各种对象
        2. Spring时代通过XML文件来配置Bean(XML文件配置比较繁琐), 后来SpringBoot注解配置就慢慢开始流行起来
P211    1. @Component作用于类, @Bean作用于方法(既然是方法, 自定义性更强, 如: 可通过参数来实现不同的实例化)
P213    1. @PostConstruct该注解被用来修饰一个非静态的void()方法; 被@PostConstruct修饰的方法会在服务器加载Servlet的时候运行, 并且只会被服务器执行一次. PostConstruct在构造函数之后执行, init()方法之前执行;
        通常我们会是在Spring框架中使用到@PostConstruct注解 该注解的方法在整个Bean初始化中的执行顺序: Constructor(构造方法) -> @Autowired(依赖注入) -> @PostConstruct(注释的方法);
        @PostConstruct为准备这些初始化数据是系统开始运行前必须的数据
P219    1. #{}/${}区别: #{}占位符/sql预编译/防sql注入; ${}拼接符/sql拼接/不能防sql注入; #{}对应变量自动加上单引号'', ${}要注意何时加或不加单引号, 即 ${} 和 '${}'
        2. Mapper与XML映射: 接口全限名+方法名拼接作为key值, 可以找到唯一的namespace+id为对应方法名的映射, 故不能重载;
        Mapper接口的工作原理是JDK动态代理, Mybatis运行时JDK动态代理接口生成代理Proxy对象, 代理对象proxy会拦截接口方法, 转而执行MappedStatement所代表的sql, 然后将sql执行结果返回
P225~231        1. Broker/Topic/Partition/Replica/leader/follower之间有什么关系?
                2. 如何保证kafka消息消费顺序? 如何保证kafka消息不会丢失? kafka消息重复消费相关问题? kafka消费结构? 如何保证kafka消息正确消费(拿了消息宕机了, 可能导致数据不一致的情况)?
P238~240    1. Netty线程模型:
                1)单线程模型: 一个线程处理所有的accept/read/decode/process/encode/send等等事件, 对高负载/高并发等对性能要求比较高的场景不适用
                2)多线程模型: 一个accept线程只负责监听客户端的连接, 一个NIO线程池负责具体处理accept/read/decode/process/encode/send等事件;
                    满足绝大部分应用场景, 并非连接量不大的时候没啥问题, 但是遇到并发连接大的时候, 可能会出现问题, 成为性能瓶颈(个人理解: 有点类似多路复用)
                3)主从多线程模型: 一个主线程NIO线程池中, 选择一个线程作为Acceptor线程, 绑定监听客户端的连接, 其他线程负责后续的接入认证等工作;
                    连接建立完成后, Sub NIO线程池负责具体处理IO读写(一般用于: 一些并发连接数比较多, 如百万并发的场景下; 若一个线程负责接受客户端请求就存在性能问题了)
P254    1. 1)MySQL MVCC?    2)浏览器输入URL发生了什么? A: P291~293  3)跳表怎么实现? 增删改查如何实现? 时间复杂度如何?   4)如何非递归且不用额外空间, 遍历二叉树? 5)操作系统的内存管理机制?
P255    1. 1)Netty零拷贝?   2)现场写快排?   3)出现OOM后如何排查问题?    4)Nginx如何做负载均衡? 常见的负载均衡算法有哪些? 什么是一致性hash?
        2. 1)表达能力/沟通能力很重要, 可在面试前, 对于自我介绍/项目介绍/一些常见的问题 做反复练习, 确保面试时能清晰/简洁的说出来    2)面试后及时总结, 不以物喜不以己悲, 备战下一场面试!
        3. 别怼面试官, 即使你觉得他说的不对, 不反驳, 只说理解您的意思
P256    1. 自我介绍, 准备两份, 一份对技术面试官, 主讲技术细节/项目经验, 经历那些就一语带过; 一份对HR, 主讲能突出自己的经历, 会的编程技术一语带过
P257    1. ConcurrentLinkedQueue?
P259    1. 1)NIO的系统调用及如何实现?   2)聊天系统为何要用TCP?
P261    1. 1)几个经典HR面挂人的问题?    2)优点缺点? A: 缺点肯定不能是目标岗位的关键能力, 可以说自己比较容易紧张/怕生, 比较不自信, 一定要把自己的缺点圆回来!
P263    1. RPC? 整个过程? 客户端与服务端通过socket用什么通信协议, 消息如何序列化?
        2. 1)负载均衡算法: 随机/轮询/最少活跃请求数/一致性hash? 2)Nginx的作用与gateway的作用有何区别?
        3. redis做分布式锁, 为了保证不死锁, 给key加一个过期时间, 为了保证此key不至于过早失效, 可以起个监控线程, 判断处理线程是否存活(多少个key就多少个监控线程, 耗资源, 有没有更好的办法?)
            各人觉得, 锁本身粒度越小越好, 给个较大的超时时间, 绝对够了, 业务流程梳理是关键, 耗时的任务就不应该存在事务里, 而且业务逻辑上保证幂等性(消息多次消费也是如此解决)
P266    1. 1)Redis zset的实现(跳表)?    2)Redis key的过期策略?
P267    1. 1)红黑树?    2)为什么要用链地址法来避免冲突?   2)探测法有哪些? 4)链地址法和探测法的优劣对比?
        2. 1)项目一定要做好! 要有亮点的地方! 可提前联系好多遍   2)项目优化的地方? 有什么不足?
        3. 传统艺能⼿撕算法: 3道题
P268    1. 时刻准备面试的知识, 倒不是说想着跳槽, 主要是增加自己的筹码, 要涨薪? 气不过? 想走就走, 主动权掌握在自己的手里!
P269    1. MySQL 聚簇索引? 索引覆盖? 执行过程? 乐观锁MVCC? 悲观锁可以通过select .... for update加上排它锁?(不一定是本页, 很多问题综合到了一起)
P270    1. redis的主从机制是什么? 有哪些? 怎么实现的?
        2. CMS/G1 GC时的细节? 内存屏障/数据结构/remember set等等什么的? ThreadLocal弱引用相关? JVM参数-Xms/-Xmx等等是什么意思?
        3. Spring的生命周期?
P272    1. volatile的原理? 主内存/工作内存/读写内存屏障/happen-before等等?
        2. Spring的单例是怎么实现的?
P273    1. 如何确定是IO操作为主还是计算型操作为主?
        2. 跳表与红黑树的比较?  A: 跳表实现简单, 踩坑成本低, 红黑树每次插入都要通过旋转以维持平衡, 实现复杂
P274    1. 分布式限流? RateLimiter预消费策略?
P278    1. 项目突出难点/亮点, 一定要能够自圆其说
        2. 常见的设计模式(结合JDK/Spring相关源码)?
        3. 为什么使用SpringBoot? 有哪些好处?
        4. 线程池内部原理? 线程放哪了? 阻塞队列用了哪个? 线程数与任务数的关系? 阻塞队列怎么实现的?
P279    1. Netty/BIO NIO AIO/Linux IO select/poll/epoll
P281    1. B树/B+树的区别?
P282    1. 数据库范式?
        2. 线程jion()?
        3. SpringMVC这种MVC模式的了解? Spring中有哪些组件? 分别做什么的? REST风格的参数解析及回传? Tomcat容器/Spring容器/SpringMVC容器等等这些容器是一个还是多个? 有多少个? 如何协调?
            SpringBoot启动流程? 自动配置是如何实现的?
P282~283    1. 当自己不知道做什么的时候就去面试, 让社会对你进行评价, 要勇敢地跳出自己的舒适圈(理论与实践结合, 每天保持至少2h的学习时间, 终生学习, 沉淀自己, 机会是给有准备的人, 把主动权尽量握在自己的手里)
P284    1. 1)Java IO为什么既有字节流还要有字符流? 2)深拷贝/浅拷贝有何区别?
P285    1. 自我介绍, 简历上有的就不要再说了
P294    1. CompletableFuture什么场景下使用? 原理?
P311~317    1. 开源项目? 剑指offer 刷起来/leetCode 有时间看看/牛客网? 有时间看看
     */

    // ===================================================================================================================================

    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ MySQL ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    /*
    ### MySQL



**ACID的实现机制是什么？**

- 原子性（Atomicity）：事务内SQL要么同时成功要么同时失败 ，基于UndoLog实现。

- 一致性（Consistency）：系统从一个正确态转移到另一个正确态，由应用通过AID来保证，并非数据库的责任。

- 隔离性（Isolation）：控制事务并发执行时数据的可见性，基于锁和MVCC实现。

- 持久性（Durability）：提交后一定存储成功不会丢失，基于RedoLog实现。



> 回表

MySQL的数据存储在叶子节点，当查询非主键索引时，需要根据索引找到主键ID所在的位置，去主键索引查询获取数据记录，这个过程叫做回表。

> 索引下推Index Condition Pushdown

MySQL5.6版本开始引进的优化技术：在使用了组合索引的情况下，直接在匹配索引的同时剔除不符合范围条件的记录。减少回表的次数和加载的数据量，来达到查询优化的目的。

- For `InnoDB` tables, ICP is used only for secondary indexes. The goal of ICP is to reduce the number of full-row reads and thereby reduce I/O operations. For `InnoDB` clustered indexes, the complete record is already read into the `InnoDB` buffer. Using ICP in this case does not reduce I/O.

- Conditions that refer to subqueries cannot be pushed down.

- Conditions that refer to stored functions cannot be pushed down. Storage engines cannot invoke stored functions.
- Triggered conditions cannot be pushed down.

> 索引覆盖

当查询的字段全都在索引上可以返回时的情况叫做索引覆盖

> B+树

mysql的底层索引使用的是B+树的结构，是在 B树 基础上的一种优化。

B+树在 B 树的基础上，做了一些改进：

  1）非叶子节点不再存储数据，数据只存储在同一层的叶子节点上；

  2）叶子之间，增加了链表，获取所有节点，不再需要中序遍历；

范围查询在 SQL 中用得很多，这是 B+树比 B 树最大的优势。![img](https://wework.qpic.cn/wwpic/451824_9B6Po2GrQQ2M0dq_1634010392/0?tp=webp)



通常在 B+Tree 上有两个头指针，一个指向根节点，另一个指向关键字最小的叶子节点，而且所有叶子节点之间是一种链式环结构。 因此可以对 B+Tree 进行两种查找运算：一种是对于主键的范围查找和分页查找，另一种是从根节点开始，进行随机查找。



**事务隔离级别**

* 读未提交
* 读已提交
* 不可重复读
* 串行化

当前 MySQL 默认情况下使用RR的隔离级别，而NEXT-KEY LOCK正是为了解决RR隔离级别下的幻读问题



**数据库存储引擎InnoDB和MyISAM区别**

* InnoDB 支持事务，MyISAM 不支持事务

* InnoDB 最小的锁粒度是行锁，MyISAM 最小的锁粒度是表锁

* InnoDB 支持外键，而 MyISAM 不支持

* InnoDB 是聚集索引，MyISAM 是非聚集索引。聚簇索引的文件存放在主键索引的叶子节点上，因此 InnoDB 必须要有主键，通过主键索引效率很高。但是辅助索引需要两次查询，先查询到主键，然后再通过主键查询到数据。因此，主键不应该过大，因为主键太大，其他索引也都会很大。而 MyISAM 是非聚集索引，数据文件是分离的，索引保存的是数据文件的指针。主键索引和辅助索引是独立的。



**Redo log、Undo log、binlog**

由于传统磁盘顺序访问性能远好于随机访问，采用Logging的故障恢复机制意图利用顺序写的Log来记录对数据库的操作，并在故障恢复后通过Log内容将数据库恢复到正确的状态。简单的说，每次修改数据内容前先顺序写对应的Log，同时为了保证恢复时可以从Log中看到最新的数据库状态，要求Log先于数据内容落盘，也就是常说的**Write Ahead Log(WAL)**。除此之外，事务完成Commit前还需要在Log中记录对应的Commit标记，以供恢复时了解当前的事务状态，因此还需要关注Commit标记和事务中数据内容的落盘顺序。根据Log中记录的内容可以分为三类：Undo-Only，Redo-Only，Redo-Undo。



**索引优化技术**

1. **适度冗余, 减少频繁查询的join操作**

join操作本身就比较耗时,而且mysql对于复杂的join操作容易出现不合理的执行计划,因此对于更新不频繁但是查询频繁的其他表中的数据可以适当冗余存储在查询主表中。

2. **大表分拆**

当一个表的记录数超过1000万时就要考虑分拆或数据迁移了, 一个大表往往很容易造成性能瓶颈，几个效率低下的sql并发就可以把数据库拖垮。并且大表后期维护比较麻烦，后续对表的变更将会变得非常不易，使用pt工具不锁表变更，需要对原表数据进行完全拷贝，会产生比较多的binlog，会造成主从延迟和依赖binlog同步的应用延迟影响。

3. **选择合适的主键**

表一定要有主键，不管是使用数据库自带的自增主键或是自定义生成的主键，并且类型最好是整型，无业务意义的，并且不要使用多个字段组成的复合主键。一方面是方便后期维护简单，很多工具依赖此，包括我们生产表变更工具pt，没有的话将无法运行，就只能直接执行，带来的影响就是表级锁，增删改全部被阻塞，是不可接受的。另一方面，线上数据库binlog格式都是ROW，当没有主键的表做大事务更新时，从库的同步将会卡住相当长的一段时间，造成严重延迟。

4. **选择合适的数据类型**

数据库操作中最为耗时的操作就是 IO 处理，大部分数据库操作 90% 以上的时间都花在了 IO 读写上面。所以尽可能减少 IO 读写量，可以在很大程度上提高数据库操作的性能。

1）数字类型：不要使用DOUBLE，不仅仅只是存储长度的问题，同时还会存在精确性的问题。

2）字符类型：文本数据尽量用varchar存储。因为varchar是变长存储，并且要控制长度。

3）BLOB/text类型：禁止在数据库中存放 BLOB /text类型数据，它们都比较浪费硬盘和内存空间。在加载表数据时，会读取大字段到内存里从而浪费内存空间，影响系统性能。

4）时间类型：尽量使用TIMESTAMP类型，因为其存储空间只需要 DATETIME 类型的一半。对于只需要精确到某一天的数据类型，建议使用DATE类型，因为他的存储空间只需要3个字节，比TIMESTAMP还少。

**不使用索引的情况**

* 隐式类型转换：column的类型是char或者varchar，但是查询条件是数字。
* like语句时%号开头
* 不符合组合索引的最左匹配原则
* or语句：or语句分割开的查询条件，如果有一个没有索引，那么会走全表扫描
* MySQL查询优化器认为使用索引比全表扫描更慢时不使用索引
* 避免对建有索引的字段进行运算或函数类操作，否则会导致索引无法使用到，例如a*3，func(a)等
* where 条件中 not 和 <>、!= ，is null等操作无法使用索引
* 多表关联时，要保证关联字段上一定有索引，并且关联的字段字符集要一样，否则使用不到索引。

**简单查询优化**

1. 使用筛选度高的字段作为索引
2. 使用in查询时，控制in的数量在200以内
3. join表时相关字段加索引并且要保持类型和字符编码一致
4. 排序字段加索引
5. 索引覆盖、索引下推技术



> 主从同步



> 数据库InnoDB锁

InnoDB 支持多粒度锁定，允许行锁和表锁共存。

`InnoDB` supports *multiple granularity locking* which permits coexistence of row locks and table locks. For example, a statement such as [`LOCK TABLES ... WRITE`](https://dev.mysql.com/doc/refman/8.0/en/lock-tables.html) takes an exclusive lock (an `X` lock) on the specified table. To make locking at multiple granularity levels practical, `InnoDB` uses [intention locks](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_intention_lock). Intention locks are table-level locks that indicate which type of lock (shared or exclusive) a transaction requires later for a row in a table. There are two types of intention locks:

- An [intention shared lock](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_intention_shared_lock) (`IS`) indicates that a transaction intends to set a *shared* lock on individual rows in a table.
- An [intention exclusive lock](https://dev.mysql.com/doc/refman/8.0/en/glossary.html#glos_intention_exclusive_lock) (`IX`) indicates that a transaction intends to set an exclusive lock on individual rows in a table.

For example, [`SELECT ... FOR SHARE`](https://dev.mysql.com/doc/refman/8.0/en/select.html) sets an `IS` lock, and [`SELECT ... FOR UPDATE`](https://dev.mysql.com/doc/refman/8.0/en/select.html) sets an `IX` lock.

The intention locking protocol is as follows:

- Before a transaction can acquire a shared lock on a row in a table, it must first acquire an `IS` lock or stronger on the table.
- Before a transaction can acquire an exclusive lock on a row in a table, it must first acquire an `IX` lock on the table.

InnoBD支持多粒度的锁，允许行锁和表锁共存，InnoDB通过意向锁来实现多粒度锁共存。

* 意向共享锁标识着某个事务意图在表的各行设置一个共享锁。
* 意向排他锁标识着某个事务意图在表的各行设置一个排它锁。

例如： ```SELECT ... FOR SHARE```设置的是意向共享锁，```SELECT ... FOR UPDATE```设置的是意向排他锁

意向锁的协议如下：

* 在事务获取一行记录的共享锁之前必须获取到表的意向共享锁或者更强的锁
* 在事务获取一行记录的排他锁之前必须获取到表的排他锁

意向锁的目的是标识一个事务正在锁定某一行或者打算锁定某一行

**意向锁**
假设事务T1希望对整个数据库加排他锁，也就是对root节点加排他锁，那么锁管理器需要确认这个加锁请求能否成功。为此，锁管理器需要遍历整个树状层次结构的所有节点，如果所有节点都没持有锁，那么可以对root节点加排他锁，否则需要延迟或拒绝该加锁请求。遍历整个层级结构的所有节点去判断能够加锁成功，这种方式不符合了多粒度锁的初衷，因为检查所有节点是否加锁跟直接对所有节点加锁的代价可以认为是相同的(最起码是一个数量级的)。

为了解决上述问题，引入了一种新的锁类型-意向锁。如果一个节点加了意向锁，则意味着要在其后代节点进行显式加锁。在一个节点显式加锁之前，该节点的全部祖先节点均加上了意向锁。因此，判定能够成功给一个节点加锁时不必搜索整棵树。给某个节点加锁的事务必须遍历从root节点到该节点的路径，并给路径上的各节点加上意向锁。

意向锁相当于是一个提前的加锁声明。这样其他事务就可以根据节点上的意向锁类型来判断它的加锁请求能否成功。为了达到这个目的要求，对某个节点显式的加共享锁或排他锁之前，必须对root节点到该节点的路径上的其他节点加相应的意向锁。通过意向锁，事务可以在一个高的层次上去加共享锁或排他锁，而不需要去检查所有的后代节点的加锁情况。

意向锁分为以下三类：

共享型意向锁(IS): 将在后代节点上显示加共享锁。

排他性意向锁(IX): 将在后代节点上显示加排他锁或共享锁。

共享排他型意向锁(SIX)：当前节点被显示的加共享锁，并将在后代节点上加排他锁。

 **行锁**

行锁是指对索引记录的锁，InnoDB锁对行所有相关的索引进行锁定。

```java
CREATE TABLE `stu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `age` int NOT NULL DEFAULT '0',
  `class_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_age` (`age`) USING BTREE,
  KEY `idx_username` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4
```

```update stu set class_name='ABC' where age=1;```则会锁定age=1对应记录的ID索引、idx_age索引和idx_username索引

> 数据库高可用


     */

    // ___________________________________________________ MySQL _____________________________________________________________


    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ JAVA ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


    /*


Eureka

Feign

Nacos

HashMap

ConcurrenHashMap

AQS

Redis

分布式缓存

Spring

Kafka架构、优缺点

RocketMQ架构、优缺点

Zookeeper架构

两阶段、三阶段提交协议；Paxos协议、Zab协议、Raft协议；

分库分表、一致性哈希

分布式事务

Docker、K8S



**Java异常**

Java的异常体系分为**Error**和**Exception**。**Error**是程序无法处理的，一旦出现，程序会被迫终止；**Exception**不会导致程序终止，**Exception**分为运行时异常(**RuntimeException**)和检查异常(**CheckedException**)，运行时异常发生在程序运行过程中，检查异常发生在程序编译时期，检查异常是程序必须要进行处理的，不处理无法通过编译。常见的运行时异常有```ArrayIndexOutOfBoundsException```、```ArithmeticException```、```NullPointerException```、```NumberFormatException```、```ClassCastException```，常见的检查异常有``IOException``、``FileNotFoundException``、```ClassNotFoundException```、```InterruptedException```



### JVM

#### 类加载

> Java有```Bootstrap ClassLoader```、```ExtClassLoader```、```AppClassLoader```。```Bootstrap ClassLoader```负责加载```JAVA_HOME/jre/lib```下的jar包的类；```ExtClassLoader```负责加载```JAVA_HOME/jre/ext```下的jar包类；AppClassLoader负责加载classpath下的类。



> **双亲委派机制**

每个CLassLoader都会有一个父类加载器，当类加载器加载类的时候，会先去查看父类（如果没有找到父类则会视```BootstrapClassLoader```为父类，```bootstrap class loader```是虚拟机层面的类加载器）加载器是否加载了该类，如果加载过了则直接返回，如果没有加载则会调用自身的findClass方法去查找该类。



```java
public abstract class ClassLoader {

     private static native void registerNatives();
     static {
         registerNatives();
     }

     // The parent class loader for delegation
     // Note: VM hardcoded the offset of this field, thus all new fields
     // must be added *after* it.
     private final ClassLoader parent;
 }
```

 自定义加载类需要调用defineClass方法去将类变成JVM管理的类对象，defineClass方法会调用preDefineClass方法，改方法会检测类的包名是否是```java.```开头，如果是则抛出```SecurityException```异常。

 ```Java
     private ProtectionDomain preDefineClass(String name, ProtectionDomain pd) {
         if (!checkName(name)) {
             throw new NoClassDefFoundError("IllegalName: " + name);
         }

         // Note:  Checking logic in java.lang.invoke.MemberName.checkForTypeAlias
         // relies on the fact that spoofing is impossible if a class has a name
         // of the form "java.*"
         if ((name != null) && name.startsWith("java.")) {
             throw new SecurityException("Prohibited package name: "
                     + name.substring(0, name.lastIndexOf('.')));
         }
         if (pd == null) {
             pd = defaultDomain;
         }

         if (name != null) {
             checkCerts(name, pd.getCodeSource());
         }
         return pd;
     }
 ```



**类加载过程**

> 加载---->验证---->准备---->解析---->初始化
>
> 1. **加载**：把class文件解析成二进制数据
> 2. **验证：**验证class文件的格式和数据的正确性，是否符合标准的class文件的定义
> 3. **准备：**为类变量（常量和静态变量赋初始值）。```byte```、``short``、``int``、``long``的默认值为**0**、`float`、`double`的默认值为**0.0**、`char`的默认值为``''``、`boolean`的默认值为**false**；引用类型的初始值为null；常量类型的初始值为代码中设置的值。
> 4. **解析：**将常量池内的符号引用替换为直接引用。在解析阶段，虚拟机会把所有的类名、方法名、字段名这些符号引用替换为具体的内存地址或者偏移量。
> 5. **初始化：**这个阶段主要是对类变量初始化，执行静态代码块



### Class.forName和ClassLoader的loadClass方法的区别

> ``ClassLoader``的``loadClass``方法仅仅是把Class文件变成虚拟机的运行时数据结构Class；而``Class.forName``除了会把Class文件变成虚拟机的运行时数据结构Class之外，还会触发类的初始化



### 内存分区

堆、虚拟机栈、本地方法栈、程序计数器、方法区

* **堆：**线程共享，主要是存放对象实例和数组。当空间不足分配对象时会触发**OutOfMemoryError**

* **虚拟机栈：**线程私有，存储局部变量表、操作数栈、动态链接、方法出口；当空间不足时，会触发StackOverflowError

* **本地方法栈：**供Native方法使用的栈

* **程序计数器：**存储线程当前执行的Java方法代码的指令地址，如果执行的方法是Native方法，那么此时程序计数器存储的值是```undefined```

* **方法区：** 存储已被虚拟机加载的类信息、运行时常量池、静态变量、即时编译器编译后的代码等数据

  > In the method area, all class level information like class name, immediate parent class name, methods and variables information etc. are stored, including static variables. There is only one method area per JVM, and it is a shared resource

***对象分配过程***：对象首先分配在Eden区，当Eden区满的时候会触发Minor GC，把Eden区存活的对象放到S0区；如果此时Eden区仍然无法满足对象分配的空间，那么会尝试将对象放到老年代；如果老年代空间不足，则进行Major GC。



**垃圾回收器**



#### 虚拟机调优

**jstat指令**

> jstat(JVM statistics Monitoring)是用于监视虚拟机运行时状态信息的命令，它可以显示出虚拟机进程中的类装载、内存、垃圾收集、JIT编译等运行数据。
>
> ```jstat -gc 1262 2000 20```: 这个命令意思就是每隔2000ms输出1262的gc情况，一共输出20次
>
> - S0C : survivor0区的总容量
> - S1C : survivor1区的总容量
> - S0U : survivor0区已使用的容量
> - S1U : survivor1区已使用的容量
> - EC : Eden区的总容量
> - EU : Eden区已使用的容量
> - OC : Old区的总容量
> - OU : Old区已使用的容量
> - PC: 当前perm的容量 (KB)
> - PU: perm的使用 (KB)
> - YGC : 新生代垃圾回收次数
> - YGCT : 新生代垃圾回收时间
> - FGC : 老年代垃圾回收次数
> - FGCT : 老年代垃圾回收时间
> - GCT : 垃圾回收总消耗时间
>
> ##### -gccapacity
>
> 同-gc，不过还会输出Java堆各区域使用到的最大、最小空间
>
> - NGCMN : 新生代占用的最小空间
> - NGCMX : 新生代占用的最大空间
> - OGCMN : 老年代占用的最小空间
> - OGCMX : 老年代占用的最大空间
> - OGC：当前年老代的容量 (KB)
> - OC：当前年老代的空间 (KB)
> - PGCMN : perm占用的最小空间
> - PGCMX : perm占用的最大空间
>
> ##### -gcutil
>
> 同-gc，不过输出的是已使用空间占总空间的百分比



**jmap**命令

> jmap(JVM Memory Map)命令用于生成heap dump文件，如果不使用这个命令，还阔以使用-XX:+HeapDumpOnOutOfMemoryError参数来让虚拟机出现OOM的时候·自动生成dump文件。 jmap不仅能生成dump文件，还阔以查询finalize执行队列、Java堆和永久代的详细信息，如当前使用率、当前使用的是哪种收集器等。
>
> **option参数**
>
> - dump : 生成堆转储快照
> - finalizerinfo : 显示在F-Queue队列等待Finalizer线程执行finalizer方法的对象
> - heap : 显示Java堆详细信息
> - histo : 显示堆中对象的统计信息
> - permstat : to print permanent generation statistics
> - F : 当-dump没有响应时，强制生成dump快照
>
> ##### -dump
>
> 常用格式
>
> ```
> -dump::live,format=b,file=<filename> pid
> ```
>
> dump堆到文件,format指定输出格式，live指明是活着的对象,file指定文件名
>
> ```
> $ jmap -dump:live,format=b,file=dump.hprof 28920  Dumping heap to /home/xxx/dump.hprof ...  Heap dump file created
> ```
>
> dump.hprof这个后缀是为了后续可以直接用MAT(Memory Anlysis Tool)打开。



**jstack指令**

> jstack用于生成java虚拟机当前时刻的线程快照。线程快照是当前java虚拟机内每一条线程正在执行的方法堆栈的集合，生成线程快照的主要目的是定位线程出现长时间停顿的原因，如线程间死锁、死循环、请求外部资源导致的长时间等待等。
>
> ### option参数
>
> - -F : 当正常输出请求不被响应时，强制输出线程堆栈
> - -l : 除堆栈外，显示关于锁的附加信息
> - -m : 如果调用到本地方法的话，可以显示C/C++的堆栈
>
> jstack -l 11494
>
>

### Happen-before原则

1. **单线程happen-before原则：**在同一个线程中，发生在前面的操作happen-before于后面的操作

2. **锁的happen-before原则：**同一个锁的unlock操作happen-before于此锁的lock操作
3. **volatile的happen-before原则：**对一个volatile变量的写操作happen-before于后续对该volatile变量的所有的读操作
4. **线程启动的happen-before原则：**Thread 对象的 start() 方法先行于此线程的每一个动作
5. **happen-before的传递性：**a happen-before b ，b happen-before c ，那么 a happen-before c 。

### **volatile 使用了内存屏障实现可见性**

- 在每个 volatile写操作的前面插入一个Storestore屏障。
- 在每个 volatile写操作的后面插入一个Storeload屏障。
- 在每个 volatile读操作的后面插入一个Loadload屏障。
- 在每个 volatile读操作的后面插入一个Loadstore屏障。



**Spring事务传播机制**

* **REQUIRED：**当前存在事务，则加入当前事务，如果当前没有事务，就新建一个事务方法执行
* **SUPPORTS：**当前存在事务，则加入当前事务，如果当前没有事务，就以非事务方法执行
* **MANDATORY：**当前存在事务，则加入当前事务，如果当前事务不存在，则抛出异常
* **REQUIRES_NEW：**创建一个新事务，如果存在当前事务，则挂起该事务
* **NOT_SUPPORTED：**始终以非事务方式执行,如果当前存在事务，则挂起当前事务
* **NEVER：**不使用事务，如果当前事务存在，则抛出异常
* **NESTED：**如果当前事务存在，则在嵌套事务中执行，否则REQUIRED的操作一样（开启一个事务）


     */

    // _____________________________________________ JAVA _______________________________________________________________


    // ===================================================================================================================================

    /*

HTTPS原理:(来自《普林斯顿大学计算机公开课》)
    公钥加密在因特网上进行安全通信的关键要素。设想我准备在网上买一本书。我得告诉亚马逊网站我的信用卡号，但我并不想发送明文，这样就需要使用加密的通信通道。
直接使用AES是不可能的，因为我和亚马逊之间没有共享密钥。为了商定共享密钥，我的浏览器必须首先随机生成一个临时口令，并用亚马逊的公钥加密这个临时口令，
然后把加密后的结果传给亚马逊。亚马逊用它的私钥解出临时口令后，我的浏览器和亚马逊就可以在AES算法中用这个临时口令来加密要传送的信息，比如我的信用卡号。



     */
}
