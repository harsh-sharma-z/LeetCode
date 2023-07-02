class Solution {
    int ans=0;
    public int maximumRequests(int n, int[][] requests) {
        int[] temp=new int[n];
        help(0,requests, 0, temp);
        return ans;
    }
    private void help(int i, int[][] arr, int l, int[] temp)
    {
        if(i==arr.length)
        {
            for(int k:temp)
            {
                if(k!=0)
                return;
            }
            ans=Math.max(ans,l);
            return;
        }

        help(i+1,arr,l,temp);
        temp[arr[i][0]]--;
        temp[arr[i][1]]++;
        help(i+1 , arr,l+1,temp);
        temp[arr[i][0]]++;
        temp[arr[i][1]]--;

    }
}