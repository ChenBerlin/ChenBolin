package MultiThread.P_C;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class P_C_4 {
    public static class Container {
        private final Lock lock = new ReentrantLock();
        private final Condition notFull = lock.newCondition();
        private final Condition notempty = lock.newCondition();
        private int capacity = 10;
        private LinkedList<Integer> list = new LinkedList<>();

        public Container(int capacity) {
            this.capacity = capacity;
        }
        public void put(int value) {
            lock.lock();
            while (list.size() == capacity) {
                System.out.println("队列已满，生产者请等待......"+list.size());
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(value);
            System.out.println("生产者"+Thread.currentThread().getName()+"生产"+value);
            notempty.signalAll();
            lock.unlock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public int take() {
            lock.lock();
            while (list.size() == 0) {
                System.out.println("队列为空，消费者请等待......"+list.size());
                try {
                    notempty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int value = list.removeFirst();
            System.out.println("消费者"+Thread.currentThread().getName()+"消费"+value);
            notFull.signalAll();
            lock.unlock();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return value;
        }
    }
    public static class Producer implements Runnable {
        private Container container;
        public Producer(Container container) {
            this.container = container;
        }
        @Override
        public void run() {
            while (true){
                container.put(new Random().nextInt(100));
            }
        }
    }
    public static class Consumer implements Runnable {
        private Container container;
        public Consumer(Container container) {
            this.container = container;
        }
        @Override
        public void run() {
            while (true){
                Integer val = container.take();
            }
        }
    }
    public static void main(String[] args){
        Container container = new Container(5);
        Thread producer1 = new Thread(new Producer(container));
        Thread producer2 = new Thread(new Producer(container));
        Thread producer3 = new Thread(new Producer(container));
        Thread producer4 = new Thread(new Producer(container));
        Thread producer5 = new Thread(new Producer(container));
        Thread consumer1 = new Thread(new Consumer(container));
        Thread consumer2 = new Thread(new Consumer(container));
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        consumer1.start();
        consumer2.start();
    }
}
