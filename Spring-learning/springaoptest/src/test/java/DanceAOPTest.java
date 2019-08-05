import com.example.springaoptest.DanceConfig;
import com.example.springaoptest.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DanceConfig.class)
public class DanceAOPTest {

    @Autowired
    private Performance dance;

    @Test
    public void test(){
        dance.perform();
    }

}
