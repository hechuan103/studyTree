### Semaphore

**Semaphore** 是一个信号计数器；从概念上说，一个信号包含一组许可。如果需要，每个acquire()都会阻塞，直到有可以使用的许可，然后再获取这个许可。每个release() 都会增加一个许可，然后释放一个被阻塞的请求者（acquirer）。但是，没有实际的许可对象被使用。信号量只是记录了一个可用的数量并执行相应的动作。

信号量经常被用于限制可以访问某些（物理或是逻辑）资源的线程数量。比如使用信号量控制对资源池访问数量。在获取一个资源项时每个线程必须从**semaphore** 获得一个许可来保证资源项是可以使用的。当这个线程使用完资源项归还到资源池并把许可同时返还给**Semaphore**时，允许别的线程来请求这个资源项（允许重复使用许可）。当调用acquire()时不会持有同步锁(synchronization lock)因为这会组织资源项返回资源池。信号量封装了限制访问资源池的所需要的同步锁(synchronization lock)，与池本身需要的任何同步和维持一致性分开。

信号量初始化为1，则最多只有一个许可能被使用，能作为一个互斥锁。这通常被认作为一个二进制信号量，因为它只有两个状态：1个可被使用的许可或者0个被使用的许可。在这种使用方式下，二进制信号量有以下属性（与许多lock实现不同），这种类型的锁能被其他线程不仅仅是自己的线程释放（信号量没有所有权概念）；它在某些特殊情况下很有用，比如死锁恢复。

Semaphore 构造函数接受一个可选的*fairness* 参数，当设置成false时，semaphore不保证线程获取许可的顺序。尤其抢占是被允许的，就是说，一个线程调用acquire()能被分配一个许可在一个等待分配的线程之前。从逻辑上讲新线程将自己放置到线程等待队列的头部。如果*fairness* 设置成true,semaphore能保证任何调用acquire()的线程按照调用acquire的顺序获得许可（先进先出，FIFO）。注意：先进先出的顺序必须适用于这些方法的内部执行点。所以，有可能一个线程在另外一个线程前调用acquire，但是，他到达顺序点是在另外一个线程之后，并且从方法返回类似。另请注意，不定时的 tryAcquire 方法不遵守公平设置，但会获取任何可用的许可。

一般来说，semaphore用来作为资源访问控制时应该设置成公平的来确保线程不会因为访问资源而被饿死，当用来作为同步控制时，非公平排序的吞吐量优势常常超过公平性考虑。

semaphore还提供了一次acquire和release多个许可方便的方法，这些方法比循环更加高效，然而，他们没有建立任何优先顺序。例如：一个线程A调用了 s.acquire(3)线程B执行s.acquire(2),有2个许可变得可用时，不能保证线程B获取到许可除非它先执行s.acquire并且Semaphore s 是公平模式。

