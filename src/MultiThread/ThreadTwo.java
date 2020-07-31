package MultiThread;

public class ThreadTwo {
    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable();
        MyRunnable myRunnable2 = new MyRunnable();
        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();
    }
}
class MyRunnable implements Runnable{
    private static int j = 0;
    @Override
    public void run(){
        for (int i = 0; i < 10000 ; i++) {
            j++;
            System.out.println(Thread.currentThread().getName()+"输出："+j);
        }
    }
}