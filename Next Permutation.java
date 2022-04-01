class Solution {
    public void nextPermutation(int[] nums) {
        int ip=-1;
  
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ip=i;
                break;
            }
        }
        
        if(ip==-1){
            reverse(nums,ip);
            return;
        }else{
            for(int i=nums.length-1;i<nums.length;i--){
                if(i!=ip && nums[ip]<nums[i]){
                   swap(nums,i,ip);
                   break;
                 }
            }
        }
        
        reverse(nums,ip);
    }
    
    public void reverse(int[] nums, int ip){
        for(int i=ip+1,j=nums.length-1;i<j;i++,j--){
           swap(nums,i,j);
        }
    }
    
    public void swap(int[] nums,int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
