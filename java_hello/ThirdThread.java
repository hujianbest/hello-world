import java.util.concurrent.*;

public class ThirdThread{
	public static void main(String[] args) {
		ThirdThread rt = new ThirdThread();
		FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)()->{
			int i = 0;
			for(;i<100;i++){
				System.out.println(Thread.currentThread().getName()+"\'s value of i:"+i);
			}	
			return i;
		});
		for(int i=0;i<100;i++){
			System.out.println(Thread.currentThread()+"\'s value of i:"+i);
			if(i==20){
				new Thread(task,"Thread with return").start();
			}
		}
		try{
			System.out.println("return of subThread:"+task.get());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}