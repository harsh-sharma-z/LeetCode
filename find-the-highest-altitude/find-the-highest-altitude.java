class Solution {
    public int largestAltitude(int[] gain) {
        int curr=0;
        int ans=0;
        for(int i:gain)
        {
            curr+=i;
            ans=Math.max(curr,ans);
        }
        return ans;
    }
}