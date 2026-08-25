class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product=1;
        int x=n;
        while(x>0){
            int digit=x%10;
            sum=sum+digit;
            product=product*digit;
            x=x/10;
        }
        int total=sum+product;
        return n%total==0;
    }
}