package MultiThread;

public class ThreadOne {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
    }
}

class MyThread extends Thread{
    private static int j = 0;
    @Override
    public void run(){
        for (int i = 0; i < 10000 ; i++) {
            j++;
            System.out.println(Thread.currentThread().getName()+"输出："+j);
        }
    }
}