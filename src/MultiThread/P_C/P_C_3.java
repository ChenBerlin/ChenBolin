package MultiThread.P_C;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class P_C_3 {
    public static class Producer implements Runnable {
        private ArrayBlockingQueue<Integer> queue;

        public Producer(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(1000);
                    if (queue.size() == 10) {
                        System.out.println("队列已满，生产者请等待......"+queue.size());
                        continue;
                    }
                    int val = random.nextInt(100);
                    queue.put(val);
                    System.out.println("生产者"+Thread.currentThread().getName()+"生产"+val);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Consumer implements Runnable {
        private ArrayBlockingQueue<Integer> queue;
        public Consumer(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    if (queue.size() == 0) {
                        System.out.println("队列为空，消费者请等待......"+queue.size());
                        continue;
                    }
                    int val = queue.take();
                    System.out.println("消费者"+Thread.currentThread().getName()+"消费"+val);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread producer1 = new Thread(new Producer(queue));
        Thread producer2 = new Thread(new Producer(queue));
        Thread producer3 = new Thread(new Producer(queue));
        Thread producer4 = new Thread(new Producer(queue));
        Thread producer5 = new Thread(new Producer(queue));

        Thread consumer1 = new Thread(new Consumer(queue));
        Thread consumer2 = new Thread(new Consumer(queue));
        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        consumer1.start();
        consumer2.start();
        try {
            producer1.join();
            producer2.join();
            producer3.join();
            producer4.join();
            producer5.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
