import java.util.concurrent.*;

public class ExecutorCompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Executor executor = Executors.newFixedThreadPool(3);
        CompletionService<String> service = new ExecutorCompletionService<>(executor);
        for (int i = 0 ; i < 5 ;i++) {
            int seqNo = i;
            service.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "HelloWorld-" + seqNo + "-" + Thread.currentThread().getName();
                }
            });
        }
        for (int j = 0 ; j < 5; j++) {
            System.out.println(service.take().get());
        }
    }
}
