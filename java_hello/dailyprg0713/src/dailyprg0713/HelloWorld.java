package dailyprg0713;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorld implements IHelloWorld{
    public void say(){
        System.out.println("Hello World !");
    }
}

class HelloHandler implements InvocationHandler{
    
    private Object target;
    public HelloHandler(Object target){
        this.target = target;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object result = method.invoke(target, args);
        System.out.println("Hello Java World");
        return result;
    }
}
