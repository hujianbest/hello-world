public class Account{
    private String accountNo;
    private double balance;
    public Account(){};
    public Account (String accountNo,double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void setAccountNo(String accountNo){
        this.accountNo = accountNo;
    }

    public String getAccountNo(){
        return this.accountNo;
    }

    public double getBalance(){
        return this.balance;        
    }

    public synchronized void draw(double drawAmount){
        try{
            if(balance<drawAmount){
                System.out.println(Thread.currentThread().getName()+"����ȡǮ������");
                wait();
            }else{
                    System.out.println(Thread.currentThread().getName()+"ȡǮ��"+drawAmount);
	                balance -=drawAmount;
	                System.out.println("�˻����Ϊ��"+balance);
                    notifyAll();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount){
        try{
            if(balance>3000){
                System.out.println(Thread.currentThread().getName()+"���Դ�����3000");
                wait();
            }else{
                System.out.println(Thread.currentThread().getName()+"��"+depositAmount);
	            balance +=depositAmount;
	            System.out.println("�˻����Ϊ��"+balance);
	            notifyAll();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    public int hashCode(){
        return accountNo.hashCode();
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj!=null && obj.getClass() == Account.class){
            Account target = (Account)obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}