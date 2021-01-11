# Java Concurrency Constructs Usage
* A research paper reading  
 Research paper: "A Large-Scale Study on the Usage of Java’s Concurrent Programming Constructs"


## What is this about, in short?

### Have you been in this situation? 
>Interviewer: Hey, lets talk about Java concurrency.  
> Interviewee: Uh, never used it, but go ahead.  
> Interviewer: So, I got this interview example from somewhere, and although I have not coded in last 15 years, it will prove that you are not up to the task of coding using concurrency.  
> Interviewee: (To self: Need to figure out if this is even used in industry?)  
> Goes and reads Research paper: "A Large-Scale Study on the Usage of Java’s Concurrent Programming Constructs"

#### So what did you find?
* Developers employ mainly simple mutual exclusion constructs. These constructs are easy to understand (though difficult to reason about) and have been available in Java since its initial version, released more than 15 years ago.  
    > No surprise this one, simplicity is best.

* Almost 80% of the concurrent projects include at least one synchronized method. synchronized blocks are growing in popularity.   
    > Yes, I know this!   
    > Great, let's discuss using Double-checked locking pattern when creating Singleton.

* Less than 25% of the projects employ the abstractions implemented by the java.util.concurrent library.
    > Wait, doesn't this library have Executors, Executor, ExecutorService, ThreadPoolExecutor, Callable, Future, ThreadFactory, Lock, ReentrantLock, AtomicInteger, Semaphore, BlockingQueue, DelayQueue, ConcurrentLinkedDeque, CountDownLatch, ForkJoinPool, ThreadLocal... all the best concurrency has to offer?  
    >> ThreadLocal: Seriously? I am there from version 1.2  
    >> Don't just write off the Executor framework, the usage is growing (probably, maybe)  

* Most frequently used: synchronized blocks and methods. Less common: volatile, explicit locks, read-write locks, atomic datatypes. 50.14% still use Hashtable. Runnable interface is the most common approach to define new threads. Also found out that developers are apparently not worried about errors that might cause threads to end abruptly.
    > synchronized, Yes!  
    > Hashtable, the all methods are synchronised dinosaur? HashMap vs Hashtable: A popular interview question 10 years ago. ConcurrentHashMap should be used more.    
    > Developers not worried about dead threads, now I don't know which side to choose.

* 3% of the concurrent projects implement the Thread.UncaughtExceptionHandler interface; in 97% of concurrent projects, programming error leads to silent dead threads.
    > uh

* Semaphore class has never been used in the analyzed projects
    > uh

* Developers waste a large number of opportunities to use high level constructs for concurrent programming, in favor of lower-level, more error-prone constructs. CountDownLatch could replace notify, notifyAll, wait. 
    > Gotta learn some high level constructs.


## Intrigued, lets talk details?

### Background
> Process vs threads. In single core, threads will do time-division multiplexing. In multicore, each thread can take a  core. Lock, ReentrantLock, ReadWriteLock, Condition, tryLock() are more flexible than synchronised. AtomicBoolean, AtomicInteger and AtomicIntegerArray (just like volatile of yesteryears) use compareAndSet() (This method atomically sets a variable if its current value equals that of the method’s first argument, returning true on success) and other methods. ConcurrentHashMap, CopyOnWriteArrayList, CopyOnWriteArraySet, and ArrayBlockingQueue use multiple threads access, are thread-safe. A CountDownLatch waits for N threads to finish before allowing all of them to proceed. CyclicBarrier, another synchronization aid, allows a set of threads to all wait for each other to reach a common barrier point. ExecutorService manages queuing and scheduling of tasks, and allows controlled shutdown.ExecutorService interface and its implementations provide methods to asynchronously execute any function expressed as a Callable, the result-bearing analog of Runnable. The ScheduledExecutorService subinterface adds support for delayed and periodic task execution. A Future returns the results of a function, allows determining whether the execution has completed, and provides the means to cancel execution. Its implementations provide tunable, flexible thread pools. The Executors class provides factory methods.  
>
> Language pitfall: long not guaranteed to be atomic in all environments. New in JLS: now you can count on all statements in a constructor having completed before the constructor returns; when did this happen?. most often used construct of the java.util.concurrent library: ConcurrentHashMap 21%, ExecutorService ⇒ 13%, ConcurrentMap 12%, Executor 10% Future 10%. 
