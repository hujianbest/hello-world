class Solution {
    public static int trailingZeroes(int n) {
        int count=0;
        long sum=1;
        while(n>0){
            sum*=n;
            n=n-1;
        }
        System.out.println("sum="+sum);
        while(sum>=10 && sum%10==0){
            count++;
            sum=sum/10;
        }
        System.out.println("count="+count);
        return count;
    }
    public static void main(String[] args) {
        trailingZeroes(30);
    }
}