package dailyprg0713;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        IHelloWorld hw = new HelloWorld();
        HelloHandler handler = new HelloHandler(hw);
        IHelloWorld proxy = (IHelloWorld)Proxy.newProxyInstance(Thread.currentThread()
            .getContextClassLoader(),hw.getClass().getInterfaces(), handler);
        proxy.say();
    }
}
