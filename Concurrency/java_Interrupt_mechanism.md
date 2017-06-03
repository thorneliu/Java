# 中断的原理
Java的中断机制是一种协作机制，也就是说通过中断并不能直接终止另一个Thread，而是需要被中断的Thread自己处理中断。
每个Thread Object有一个boolean的flag

```
  public class Thread {
    private boolean isInterrupted;
    
    public boolean isInterrupted() {
      return isInterrupted;
    }
    
    public boolean static interrupted(){
      boolean flag = isInterrupted;
      isInterrupted = flase; //static method clears this flag
      return flag;
    }
    
    public void interrupt() {
      isInterrupted = true;
      //do something interrupt this Thread
    }
  }
```

# 阻塞方法 blocking method

阻塞方法不同于一般的要运行较长时间的方法。一般方法的完成只取决于它所要做的事情，以及是否有足够多可用的计算资源（CPU 周期和内存）。而阻塞方法的完成还取决于一些外部的事件，例如计时器到期，I/O 完成，或者另一个线程的动作（释放一个锁，设置一个标志，或者将一个任务放在一个工作队列中）。一般方法在它们的工作做完后即可结束，而阻塞方法较难于预测，因为它们取决于外部事件。阻塞方法可能影响响应能力，因为难于预测它们何时会结束。

阻塞方法可能等不到所等的事件而无法终止。因此需要一定的方法来中止阻塞方法，令其可取消就变得很有用。可取消就是只在正常完成之前外部使之停止的操作。由 Thread 提供并受 Thread.sleep() 和 Object.wait() 支持的中断机制就是一种取消机制；它允许一个线程请求另一个线程停止它正在做的事情。

比如：

```
public class LaoLiu {
  public void pickUpChild throw InterrruptedException { 
    //1. Wait child off scholl
    //2. Send child to home
    if (shouldCancelTheJob())
    {
      Thread.stop();//LaoLiu will throw the InterruptedException to its caller,
      //indicated that he was interrupted
    }
  }
}
```
当一个方法抛出 InterruptedException 时，它是在告诉您，如果执行该方法的线程被中断，它将尝试停止它正在做的事情而提前返回，并通过抛出 InterruptedException 表明它提前返回。 行为良好的阻塞库方法应该能对中断作出响应并抛出 InterruptedException，以便能够用于可取消活动中，而不至于影响响应。

中断是一种协作机制。当一个线程中断另一个线程时，被中断的线程不一定要立即停止正在做的事情。相反，中断是礼貌地请求另一个线程在它愿意并且方便的时候停止它正在做的事情。有些方法，例如 Thread.sleep()，很认真地对待这样的请求，但每个方法不是一定要对中断作出响应。对于中断请求，不阻塞但是仍然要花较长时间执行的方法可以轮询中断状态，并在被中断的时候提前返回。 您可以随意忽略中断请求，但是这样做的话会影响响应。
中断的协作特性所带来的一个好处是，它为安全地构造可取消活动提供更大的灵活性。我们很少希望一个活动立即停止；如果活动在正在进行更新的时候被取消，那么程序数据结构可能处于不一致状态。中断允许一个可取消活动来清理正在进行的工作，恢复不变量，通知其他活动它要被取消，然后才终止。

# 处理 InterruptedException

如果抛出 InterruptedException 意味着一个方法是阻塞方法，那么调用一个阻塞方法则意味着您的方法也是一个阻塞方法，而且您应该有某种策略来处理 InterruptedException。通常最容易的策略是自己抛出 InterruptedException，如清单 1 中 putTask() 和 getTask() 方法中的代码所示。 这样做可以使方法对中断作出响应，并且只需将 InterruptedException 添加到 throws 子句。

## 不捕捉 InterruptedException，将它传播给调用者

```
public class TaskQueue {
    private static final int MAX_TASKS = 1000;
 
    private BlockingQueue<Task> queue 
        = new LinkedBlockingQueue<Task>(MAX_TASKS);
 
    public void putTask(Task r) throws InterruptedException { 
        queue.put(r);
    }
 
    public Task getTask() throws InterruptedException { 
        return queue.take();
    }
}
```

## 可以捕捉 InterruptedException，执行清理，然后抛出异常
有时候需要在传播异常之前进行一些清理工作。在这种情况下，可以捕捉 InterruptedException，执行清理，然后抛出异常。清单 2 演示了这种技术，该代码是用于匹配在线游戏服务中的玩家的一种机制。 matchPlayers() 方法等待两个玩家到来，然后开始一个新游戏。如果在一个玩家已到来，但是另一个玩家仍未到来之际该方法被中断，那么它会将那个玩家放回队列中，然后重新抛出 InterruptedException，这样那个玩家对游戏的请求就不至于丢失。
清单 2. 在重新抛出 InterruptedException 之前执行特定于任务的清理工作

```
public class PlayerMatcher {
    private PlayerSource players;
 
    public PlayerMatcher(PlayerSource players) { 
        this.players = players; 
    }
 
    public void matchPlayers() throws InterruptedException { 
        try {
             Player playerOne, playerTwo;
             while (true) {
                 playerOne = playerTwo = null;
                 // Wait for two players to arrive and start a new game
                 playerOne = players.waitForPlayer(); // could throw IE
                 playerTwo = players.waitForPlayer(); // could throw IE
                 startNewGame(playerOne, playerTwo);
             }
         }
         catch (InterruptedException e) {  
             // If we got one player and were interrupted, put that player back
             if (playerOne != null)
                 players.addFirst(playerOne);
             // Then propagate the exception
             throw e;
         }
    }
}
```

## 捕捉 InterruptedException 后恢复中断状态
有时候抛出 InterruptedException 并不合适，例如当由 Runnable 定义的任务调用一个可中断的方法时，就是如此。在这种情况下，不能重新抛出 InterruptedException，但是您也不想什么都不做。当一个阻塞方法检测到中断并抛出 InterruptedException 时，它清除中断状态。如果捕捉到 InterruptedException 但是不能重新抛出它，那么应该保留中断发生的证据，以便调用栈中更高层的代码能知道中断，并对中断作出响应。该任务可以通过调用 interrupt() 以 “重新中断” 当前线程来完成，如清单 3 所示。至少，每当捕捉到 InterruptedException 并且不重新抛出它时，就在返回之前重新中断当前线程。

```
清单 3. 捕捉 InterruptedException 后恢复中断状态
public class TaskRunner implements Runnable {
    private BlockingQueue<Task> queue;
 
    public TaskRunner(BlockingQueue<Task> queue) { 
        this.queue = queue; 
    }
 
    public void run() { 
        try {
             while (true) {
                 Task task = queue.take(10, TimeUnit.SECONDS);
                 task.execute();
             }
         }
         catch (InterruptedException e) { 
             // Restore the interrupted status
             Thread.currentThread().interrupt();
         }
    }
}
```

## 不要生吞中断

处理 InterruptedException 时采取的最糟糕的做法是生吞它 —— 捕捉它，然后既不重新抛出它，也不重新断言线程的中断状态。对于不知如何处理的异常，最标准的处理方法是捕捉它，然后记录下它，但是这种方法仍然无异于生吞中断，因为调用栈中更高层的代码还是无法获得关于该异常的信息。（仅仅记录 InterruptedException 也不是明智的做法，因为等到人来读取日志的时候，再来对它作出处理就为时已晚了。） 清单 4 展示了一种使用得很广泛的模式，这也是生吞中断的一种模式：
清单 4. 生吞中断 —— 不要这么做

```
// Don't do this 
public class TaskRunner implements Runnable {
    private BlockingQueue<Task> queue;
 
    public TaskRunner(BlockingQueue<Task> queue) { 
        this.queue = queue; 
    }
 
    public void run() { 
        try {
             while (true) {
                 Task task = queue.take(10, TimeUnit.SECONDS);
                 task.execute();
             }
         }
         catch (InterruptedException swallowed) { 
             /* DON'T DO THIS - RESTORE THE INTERRUPTED STATUS INSTEAD */
         }
    }
}
```
如果不能重新抛出 InterruptedException，不管您是否计划处理中断请求，仍然需要重新中断当前线程，因为一个中断请求可能有多个 “接收者”。标准线程池 （ThreadPoolExecutor）worker 线程实现负责中断，因此中断一个运行在线程池中的任务可以起到双重效果，一是取消任务，二是通知执行线程线程池正要关闭。如果任务生吞中断请求，则 worker 线程将不知道有一个被请求的中断，从而耽误应用程序或服务的关闭。



      Java 理论与实践: 处理 InterruptedException：http://www.ibm.com/developerworks/cn/java/j-jtp05236.html

      详细分析Java中断机制：http://www.infoq.com/cn/articles/java-interrupt-mechanism
