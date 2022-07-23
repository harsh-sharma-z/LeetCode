class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int c=0;
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j]<nums[i]) {
                    c++;
                }
            }
            result.add(c);
            c=0;
        }
        return result;
        
        
    }
}
