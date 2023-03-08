class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int l=1;
        int r=Integer.MIN_VALUE;
        for(int i:piles)
            r=Math.max(r,i);
        while(l<r)
        {
            int mid=l+(r-l)/2;
            
            if(canEat(piles,mid,h))
                r=mid;
            else
                l=mid+1;
        }
        return l;
    }
    private boolean canEat(int[] piles, int mid, int h)
    {
        int ans=0;
        for(int i:piles)
        {
            ans+=i/mid;
            if(i%mid>0)
                ans++;
        }
        if(ans<=h)
            return true;
        return false;
    }
}