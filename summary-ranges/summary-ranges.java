class Solution {
    public List<String> summaryRanges(int[] nums) {
        int l=nums.length;
        List<String> uwu=new ArrayList<>();
        for(int i=0;i<l;i++)
        {
            int n=nums[i];
            while(i<l-1 && nums[i]+1==nums[i+1])
            i++;
            if(n!=nums[i])
            uwu.add(n+"->"+nums[i]);
            else
            uwu.add(n+"");
        }
        return uwu;
    }
}