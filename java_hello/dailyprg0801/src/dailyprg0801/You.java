package dailyprg0801;

public class You extends Dad{
    public static final int Age = 20;
    public You(){
        System.out.println("执行你的构造函数");
    }
    static{
        System.out.println("执行你的静态块");
    }
    {
        System.out.println("执行你的构造块");
    }
    public static void say(){}
}
