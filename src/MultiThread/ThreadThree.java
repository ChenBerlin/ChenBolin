package MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadThree {
    public static void main(String[] args) throws Exception{
        MyCallable myCallable1 = new MyCallable();
        MyCallable myCallable2 = new MyCallable();
        FutureTask<Boolean> futureTask1 = new FutureTask<>(myCallable1);
        FutureTask<Boolean> futureTask2 = new FutureTask<>(myCallable2);
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        futureTask1.get();
        futureTask2.get();
    }

}
class MyCallable implements Callable<Boolean>{
    private static int j = 0;
    @Override
    public Boolean call() throws Exception{
        for (int i = 0; i < 10000 ; i++) {
            j++;
            System.out.println(Thread.currentThread().getName()+"输出："+j);
        }
        return true;
    }
}