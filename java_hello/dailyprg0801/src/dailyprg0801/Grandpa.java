package dailyprg0801;

public class Grandpa {
    public static int Age = 80;
    public Grandpa(){
        System.out.println("执行爷爷构造函数");
    }
    static{
        System.out.println("执行爷爷静态块");
    }
    {
        System.out.println("执行爷爷构造块");
    }
    public static void say(){}
}
