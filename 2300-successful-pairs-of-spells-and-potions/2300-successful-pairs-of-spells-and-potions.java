class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m=spells.length;
        int n=potions.length;
        Arrays.sort(potions);
        int[] ans=new int[m];
        int maxPotion=potions[n-1];
        for(int i=0;i<m;i++)
        {
            int spell=spells[i];
            long minPotion=(long)Math.ceil((double)success/spell);
            if(minPotion>maxPotion)
            {
                ans[i]=0;
                continue;
            }
            int index=apnaLowerBound(0,n-1,potions,minPotion);
            ans[i]=n-index;
        }
        return ans;
    }
    private int apnaLowerBound(int l,int r, int[] potions, long minPotion)
    {
       int p=-1;
        int mid=0;
        while(l<=r)
        {
             mid=l+(r-l)/2;
             if(potions[mid]>=minPotion)
             {
                 p=mid;
                 r=mid-1;
             }
            else
                l=mid+1;
        }
        return p;
    }
}