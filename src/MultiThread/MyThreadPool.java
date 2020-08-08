package MultiThread;

import java.util.concurrent.*;

public class MyThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ExecutorService threadPoolExecutor =new ThreadPoolExecutor(corePoolSize,
        //                maxPoolSize,
        //                keepAliveTime,
        //                TimeUnit.MILLISECONDS,
        //                new LinkedBlockingQueue<Runnable>());
        //ctl：running-1<<count_bits、shutdown0<<count_bits、stop1<<count_bits、tidying2<<count_bits、terminated3<<count_bits
        //worker(){firsttask=task}-->threadfactory(worker)-->runworker(work)-->判断work.firstask-->真正的run()
        //线程池参数：
        /*
        * corePoolSize：核心线程数
        * maxPoolSize：最大线程数
        * keepAliveTime：非核心线程空闲存活时间
        * TimeUnit：参数keepAliveTime的时间单位
        * allowCoreThreadTimeout：是否允许核心线程空闲退出，默认值为false
        * workQueue：用于保存等待执行的任务的阻塞队列。
        * --1. ArrayBlockingQueue：是一个基于数组结构的有界阻塞队列，此队列按 FIFO（先进先出）原则对元素进行排序。
        * --2. LinkedBlockingQueue：一个基于链表结构的阻塞队列，此队列按FIFO （先进先出） 排序元素，吞吐量通常要高于ArrayBlockingQueue。静态工厂方法Executors.newFixedThreadPool()使用了这个队列。
        * --3. SynchronousQueue：一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于LinkedBlockingQueue，静态工厂方法Executors.newCachedThreadPool使用了这个队列。
        * --4. PriorityBlockingQueue：一个具有优先级得无限阻塞队列。
        * handler：任务拒绝策略
        * --1、直接丢弃
        * --2、丢弃队列中最老的任务
        * --3、抛异常
        * --4、将任务分给调用线程来执行
        * */
        //创建固定容量线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交给线程池并获取返回值
        Future future01 = executorService.submit(new RunnableTask());
        Future future02 = executorService.submit(new CallableTask<Object>());
        //Future提供了三种功能：
        //1）判断任务是否完成；isDone()
        //2）能够中断任务；cancel(boolean mayInterruptIfRunning) isCancelled()
        //3）能够获取任务执行结果。get() get(long timeout, TimeUnit unit) get方法会阻塞直到任务返回结果。
        //future01.get();

        //通过FutureTask提交给线程池

        FutureTask<Integer> futureTask01 = new FutureTask<Integer>(new RunnableTask(),0);
        FutureTask<Integer> futureTask02 = new FutureTask<Integer>(new CallableTask<Object>());
        executorService.submit(futureTask01);
        executorService.submit(futureTask02);

    }

    private static class RunnableTask implements Runnable {
        @Override
        public void run(){
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName()+"正在输出："+i);
            }
        }
    }

    private static class CallableTask<T> implements Callable {
        @Override
        public Boolean call() throws Exception {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName()+"正在输出："+i);
            }
            return true;
        }
    }
}
