import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account{
    private final Lock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();
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

    public void draw(double drawAmount){
        lock.lock();
        try{
            if(balance<drawAmount){
                System.out.println(Thread.currentThread().getName()+"����ȡǮ������");
                cond.await();
            }else{
                    System.out.println(Thread.currentThread().getName()+"ȡǮ��"+drawAmount);
	                balance -=drawAmount;
	                System.out.println("�˻����Ϊ��"+balance);
                    cond.signalAll();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }

    public void deposit(double depositAmount){
        lock.lock();
        try{
            if(balance>3000){
                System.out.println(Thread.currentThread().getName()+"���Դ�����3000");
                cond.await();
            }else{
                System.out.println(Thread.currentThread().getName()+"��"+depositAmount);
	            balance +=depositAmount;
	            System.out.println("�˻����Ϊ��"+balance);
	            cond.signalAll();
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
        finally{
            lock.unlock();
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