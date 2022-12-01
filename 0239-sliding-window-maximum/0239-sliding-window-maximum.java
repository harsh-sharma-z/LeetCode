class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
//         if( nums.length==1)
//             return nums;
//         if(k==nums.length)
//         {
//             int ans =Integer.MIN_VALUE;
            
//             for(int i:nums)
//             {
//                 ans=Math.max(ans,i);
//             }
//             int []a={ans};
//             return a;
//         }
        Deque<Integer> dq=new LinkedList<Integer>();
        int[] ans=new int[nums.length-k+1];
        int j=1;
        for(int i=0;i<k;i++)
        {
            while(!dq.isEmpty() && nums[i]>nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.add(i);// add last
        }
        ans[0]=nums[dq.getFirst()];
            for(int i=k;i<nums.length;i++)
            {
                while(!dq.isEmpty() && nums[i]>nums[dq.getLast()]){
                dq.removeLast();
                }
            dq.add(i);
                
                if(!dq.isEmpty() && dq.getFirst()==i-k){
                    dq.removeFirst();
                }
                ans[j]=nums[dq.getFirst()];
                j++;
                
            }
        return ans;
    }
}