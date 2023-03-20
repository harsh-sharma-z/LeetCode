class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int c=1;
        int ans=0;
        for(int i=0;i<arr.length ;i++)
        {
            if(arr[i]==0)
                c++;
            else
            {
                ans+=(c-1)/2;
                c=0;
            }
        }
        if(c!=0)
            ans+=c/2;
        return ans>=n;
    }
}