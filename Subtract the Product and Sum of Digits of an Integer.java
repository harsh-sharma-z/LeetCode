class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0,pro=1,rem;
        while(n!=0)
        {
            rem=n%10;
            sum+=rem;
            pro=pro*rem;
            n/=10;
        }
        
        return pro-sum;
        
    }
}
