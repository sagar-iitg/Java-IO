package pkg;

class Solution {
    public static int  totalMoney(int n) {
        int totalWeek=n/7;
        int sum=0;

        for(int i=1;i<=totalWeek;i++)
        {
            int temp=(7)*(2*i+6);
             temp=temp/2;
            sum=sum+temp;
        }
        int remainingDays=n-totalWeek*7;
        return sum;


    }

    public static void main(String[] args) {
        System.out.println(totalMoney(7));
    }
}