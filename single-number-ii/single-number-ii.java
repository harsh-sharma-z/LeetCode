class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<=31;i++)
        {
            int temp=(1 << i);

            int zero=0;
            int one=0;

            for(int n:nums)
                if((n&temp)==0)
                    zero++;
                else
                    one++;

            if(one%3==1)
                ans= (ans|temp);
        }
        
        return ans;
    }
}