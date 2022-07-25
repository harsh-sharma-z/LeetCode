// 0 ms runtime

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int arr[]={-1,-1};
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>target)
                break;
            if(nums[i]==target)
            {
                arr[0]=i;
                arr[1]=i;
                for(int j=i+1;j<nums.length;j++)
                {
                    if(nums[j]==target)
                        arr[1]=j;
                    else
                        break;
                }
                break;
            }
        }
        
        return arr;
        
    }
}
