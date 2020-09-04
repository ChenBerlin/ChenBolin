package MultiThread.P_C;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class P_C_2 {
    public static class Container {
        Semaphore fullCount = new Semaphore(0);
        Semaphore emptyCount = new Semaphore(10);
        Semaphore isUsed = new Semaphore(1);
        LinkedList<Integer> list = new LinkedList<>();


        public void put(int val) {
            try {
                emptyCount.acquire();
                isUsed.acquire();

                list.add(val);
                System.out.println("生产者"+Thread.currentThread().getName()+"生产"+val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                isUsed.release();
                fullCount.release();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public int take() {
            int val = 0;
            try {
                fullCount.acquire();
                isUsed.acquire();

                val = list.removeFirst();
                System.out.println("消费者"+Thread.currentThread().getName()+"消费"+val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                isUsed.release();
                emptyCount.release();
            }
            return val;
        }
    }
    public static class Producer implements Runnable {
        private Container container;

        public Producer(Container container) {
            this.container = container;
        }


        @Override
        public void run() {
            while (true) {
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
            while (true) {
                container.take();
            }
        }
    }

    public static void main(String[] args) {
        Container container = new Container();
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
