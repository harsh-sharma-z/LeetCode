class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0)
            return ans;
        
        help(0,nums,new ArrayList<>());
        return ans;
        
    }
    private void help(int ind,int[] nums,  List<Integer> uwu)
    {
        if(ind>=nums.length)
        {
            ans.add(new ArrayList<>(uwu));
            return;
        }
        
        uwu.add(nums[ind]);
        help(ind+1,nums,uwu);
        uwu.remove(uwu.size()-1);
        help(ind+1,nums,uwu);
        return ;
    }
}