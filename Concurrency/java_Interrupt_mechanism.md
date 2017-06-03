# 中断的原理
Java的中断机制是一种协作机制，也就是说通过中断并不能直接终止另一个Thread，而是需要被中断的Thread自己处理中断。
每个Thread Object有一个boolean的flag

```
  public class Thread {
    private boolean isInterrupted;
    
    public boolean interrupted() {
      return isInterrupted;
    }
    
    public boolean static interrupted(){
      boolean flag = isInterrupted;
      isInterrupted = flase; //static method clears this flag
      return flag;
    }
    
    public void interrupt() {
      isInterrupted = true;
    }
  }
```
