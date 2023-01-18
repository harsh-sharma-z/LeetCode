class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int c_max=Integer.MIN_VALUE;
        int c_min=Integer.MAX_VALUE;
        int smax=0;
        int smin=0;
        int s=0;
        
        for(int i:nums)
        {
            smax+=i;
            smin+=i;
            c_max=Math.max(smax,c_max);
            c_min=Math.min(smin,c_min);
            if(smax<0)
                smax=0;
            if(smin>0)
                smin=0;
            
            
            
            s+=i;
        }
        
        if(s==c_min)
            return c_max;
        return (Math.max(s-c_min,c_max));
    }
}