public class DrawTest{
    public static void main(String[] args) {
        Account acct = new Account("123456",0);
        new DepositThread("����߼�", acct,800).start();
        new DepositThread("�������", acct,400).start();
        new DepositThread("����߱�", acct,500).start();
        new DrawThread("ȡǮ��A", acct, 500).start();
        new DrawThread("ȡǮ��B", acct, 600).start();
        new DrawThread("ȡǮ��C", acct, 500).start();
    }
}