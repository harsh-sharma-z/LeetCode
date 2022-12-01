class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min=new int[nums.length];
        min[0]=nums[0];
        
        for(int i=1;i<min.length;i++)
        {
            min[i]=Math.min(nums[i],min[i-1]);
            
        }
        
        Stack<Integer> uwu=new Stack<>();
        for(int j=nums.length-1;j>=0;j--)
        {
            int a=min[j];
            while(!uwu.isEmpty() && a>=nums[uwu.peek()])
                uwu.pop();
            if(!uwu.isEmpty() && nums[j]>nums[uwu.peek()])
                return true;
            uwu.push(j);
        }
        return false;
    }
}