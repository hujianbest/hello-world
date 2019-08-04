package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTimerUtil {

    public static void getTime(){
        //获取当前类型
        String className = Thread.currentThread().getStackTrace()[2].getClassName();

        try {
            Class clazz = Class.forName(className);
            Object object = clazz.newInstance();
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m: methods) {
                //判断该方法上是否包含MyTimer注解
                if(m.isAnnotationPresent(ExecuteTime.class)){
                    m.setAccessible(true);
                    long startTime = System.currentTimeMillis();
                    //执行该方法
                    m.invoke(object);
                    long endTime = System.currentTimeMillis();
                    System.out.println(m.getName()+"() cost time: "+String.valueOf((endTime-startTime)));
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
