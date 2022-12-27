class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int aR) {
        for(int i=0;i<capacity.length;i++)
        {
            capacity[i]-=rocks[i];
        }
        Arrays.sort(capacity);
        int i;
        for(i=0;i<capacity.length;i++)
        {
            if(aR>0)
                aR-=capacity[i];
            else
                break;
        }
        
        if(aR<0)
            return i-1;
        return i;
    }
}