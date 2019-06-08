public class DrawTest{
    public static void main(String[] args) {
        Account acct = new Account("123456",0);
        new DepositThread("存款者甲", acct,800).start();
        new DepositThread("存款者乙", acct,400).start();
        new DepositThread("存款者丙", acct,500).start();
        new DrawThread("取钱者A", acct, 500).start();
        new DrawThread("取钱者B", acct, 600).start();
        new DrawThread("取钱者C", acct, 500).start();
    }
}