package MultiThread.P_C;

import java.util.LinkedList;
import java.util.Random;

public class P_C_1 {
    public static class Container {
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 10;
        public void put(int value) {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    while (list.size() == capacity) {
                        System.out.println("容器已满，正在等待......");
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("生产者"+Thread.currentThread().getName()+"生产"+value);
                    list.add(value++);
                    notifyAll();
                }
            }
        }
        public int take() {
            int val = 0;
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (this) {
                    while (list.size() == 0) {
                        System.out.println("容器为空，正在等待......");
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    val = list.removeFirst();
                    System.out.println("消费者"+Thread.currentThread().getName()+"消费"+val);
                    notifyAll();
                }
            }
        }
    }
    public static class Producer implements Runnable {
        private Container container;

        public Producer(Container container) {
            this.container = container;
        }
        @Override
        public void run() {
            container.put(new Random().nextInt(100));
        }
    }
    public static class Consumer implements Runnable {
        private Container container;

        public Consumer(Container container) {
            this.container = container;
        }
        @Override
        public void run() {
            container.take();
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
