package stream;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ConsumerConfig.class)
public class ConsumerTest {

    @Test
    public void test(){
        try {
            Consumer.run();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
