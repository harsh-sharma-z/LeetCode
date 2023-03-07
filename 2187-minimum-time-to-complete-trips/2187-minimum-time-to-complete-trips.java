class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left=1;
        long min=time[0];
        for(int i:time)
            min=Math.min(min,i);
        long right=totalTrips*min;
        
        while(left<right)
        {
            long mid=((right-left)/2)+left;
            long tot=help(time,mid);
            if(tot<totalTrips)
                left=mid+1;
            else
                right=mid;              
        }
        return left;  
    }
    private long help(int[] time, long mid)
    {
        long ans=0l;
        for(int i:time)
            ans+=((long)mid)/i;
        return ans;
    }
}