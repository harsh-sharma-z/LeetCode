class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0)
            return nums;

        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,-1);

        if(n<2*k+1)
            return res;

        long window=0;
        int left=0;
        int right=2*k;
        int i=k;
        int count=right+1;
        for(int j=left;j<=right;j++)
            window+=nums[j];

        res[i]=(int)(window/count);
        right++;
        i++;
        
        while(right<n)
        {
            window+=(nums[right++]-nums[left++]);
            res[i++]=(int)(window/count);
        }
        return res;
    }
}