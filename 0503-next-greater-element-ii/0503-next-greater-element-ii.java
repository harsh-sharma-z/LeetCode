class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int ans[]=new int[nums.length];
        Arrays.fill(ans,-1);
        Stack<Integer> s=new Stack<>();
        
        for(int i=0;i<nums.length*2;i++)
        {
            
            while(!s.empty() && nums[i%nums.length]>nums[s.peek()])
                ans[s.pop()]=nums[i%nums.length];
                if(i<nums.length)
                    s.push(i);
        }
    
    
    return ans;
}
}




 