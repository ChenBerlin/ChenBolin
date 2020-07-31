package MultiThread;

public class Singleton {

    private volatile static Singleton instance;
    private Singleton(){}

    //懒汉式、线程不安全
    /*
    public static Singleton getInstance() {
        //使用时再创建对象-->懒汉式
        //若多个线程同时调用getInstance()则会创建多个实例
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    */

    //懒汉式、线程安全<--加synchronized-->即使创建了实例，每次也只允许一个线程调用getInstance()，效率低
    /*
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    */

    //双重检验锁(Double checked locking pattern)
    //1、同步块加锁 2、检验两次instance==null 3、将instance声明成volatile(因为instance = new Singleton();不是原子操作)
    public static Singleton getInstance(){
        //第一次检验
        if (instance == null){
            synchronized (Singleton.class){
                //第二次检验
                //原因：第一次调用时，可能用有多个线程同时通过第一次检验。
                if (instance == null){
                    /*
                    * instance=new Singleton();在JVM里面的步骤：
                    * 1、给 instance 分配内存
                    * 2、调用 Singleton 的构造函数来初始化成员变量
                    * 3、将instance对象指向分配的内存空间（执行完这步 instance 就为非 null 了）
                    * 其中2、3可能发生重排序，故加关键字volatile。
                    */
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    //饿汉式
    //类加载时就初始化
    //当Singleton实例的创建依赖参数或者配置文件时，即需要传参创建时，这种写法就无法使用。
    /*
    private static final Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
      return instance;
    }
    */

    //静态内部类
    //JVM本身机制保证了线程安全、懒汉式、没有性能缺陷、不依赖JDK版本
    /*
    private static class SingletonHolder{
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}
    public static final Singleton getInstance(){
        return  SingletonHolder.INSTANCE;
    }
    */

    //枚举
    /*
    public enum EasySingleton{
        INSTANCE;
    }
    */
}
