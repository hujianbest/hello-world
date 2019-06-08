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
                System.out.println(Thread.currentThread().getName()+"³¢ÊÔÈ¡Ç®£ºÓà¶î²»×ã");
                wait();
            }else{
                    System.out.println(Thread.currentThread().getName()+"È¡Ç®£º"+drawAmount);
	                balance -=drawAmount;
	                System.out.println("ÕË»§Óà¶îÎª£º"+balance);
                    notifyAll();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount){
        try{
            if(balance>3000){
                System.out.println(Thread.currentThread().getName()+"³¢ÊÔ´æ¿î£ºÓà¶î³¬¹ý3000");
                wait();
            }else{
                System.out.println(Thread.currentThread().getName()+"´æ¿î£º"+depositAmount);
	            balance +=depositAmount;
	            System.out.println("ÕË»§Óà¶îÎª£º"+balance);
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