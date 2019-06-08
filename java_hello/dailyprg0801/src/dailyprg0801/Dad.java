package dailyprg0801;

public class Dad extends Grandpa {
    public static int Age = 50;
    public Dad(){
        System.out.println("执行爸爸构造函数");
    }
    {
        System.out.println("执行爸爸构造块");
    }
    static{
        System.out.println("执行爸爸静态块");
    }
    public static void say(){}
}
