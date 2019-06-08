package dailyprg0804;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    private static ThreadLocal<Apple> appleThreadLocal
        = new ThreadLocal<>();

	public static void main(String[] args) throws Exception{

        class RunApple implements Runnable{
            private final int id;
            RunApple(int id){
                this.id = id;
            }
        
            @Override
            public void run(){
                while(!Thread.currentThread().isInterrupted()){
                    appleThreadLocal.set(new Apple(id));
                    Thread.yield();
                    System.out.println(this);
                }
                
            }

            @Override
            public String toString(){
                return "#" + id + ":" + appleThreadLocal.get().getAppleID();
            }
        }

        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            exec.execute(new RunApple(i));
        }
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
//        Object obj = new Object();
//        System.out.println(obj.hashCode());
    }
}

