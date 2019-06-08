package dailyprg0714;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("Jenny");

        Class class1 = student.getClass();
        System.out.println(class1.toString());

        try {
            Class class2 = Class.forName("dailyprg0714.Student");
            System.out.println(class2.toString());
            System.out.println(class1==class2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class class3 = Student.class;
        System.out.println(class3.toString());
        System.out.println(class1==class3);
        System.out.println();

        Field[] fields = class1.getDeclaredFields();
        Method[] methods = class1.getDeclaredMethods();
        Constructor[] constructors = class1.getConstructors();

        for(Field field : fields){
            System.out.println(field.getName());
        }
        for(Method method : methods){
            System.out.println(method.getName());
            try {
                method.invoke(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        for(Constructor constructor : constructors){
            System.out.println(constructor.getName());
        }
    }
}

