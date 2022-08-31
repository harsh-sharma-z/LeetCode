class Solution {
    public int trap(int[] height) {
        int len=height.length;
        
        int left[]=new int[len];
        int right[]=new int[len];
        int max=height[0];
        for(int i=0;i<len;i++)
        {
            max=Math.max(height[i],max);
            left[i]=max;
        }
        max=height[len-1];
        for(int i=len-1;i>=0;i--)
        {
            max=Math.max(height[i],max);
            right[i]=max;
            
        }
        
        int sum=0;
         
        for(int i=0;i<len;i++)
        {
            
            sum+=Math.min(left[i],right[i])-height[i];
            
        }
        return sum;
        
    }
}