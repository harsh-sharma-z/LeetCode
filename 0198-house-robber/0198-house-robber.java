class Solution {
    public int rob(int[] nums) {
        int Y=0;
        int N=0;
        
        for(int i:nums)
        {
            int temp=N;
            N=Math.max(Y,N);
            Y=i+temp;
        }
        return Math.max(Y,N);
    }
 
}