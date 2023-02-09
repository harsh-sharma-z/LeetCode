class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> uwu=new ArrayList<>();
        help(0,nums,uwu,new ArrayList<>());
        return uwu;
    }
    public void help(int ind,int[] nums,List<List<Integer>> uwu,List<Integer> ds )
    {
        uwu.add(new ArrayList<>(ds));
        for(int i=ind;i<nums.length;i++)
        {
            if(i!=ind && nums[i]==nums[i-1])
                continue;
            ds.add(nums[i]);
            help(i+1,nums,uwu,ds);
            ds.remove(ds.size()-1);
        }
    }
}