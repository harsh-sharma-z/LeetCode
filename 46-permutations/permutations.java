class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] freq = new int[nums.length];
        List<Integer> temp = new ArrayList<>();
        solve(nums , ans , freq , temp);
        return ans;
    }

    private void solve(int[] nums , List<List<Integer>> ans , int[] freq , List<Integer> temp){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(freq[i] == 0){
                temp.add(nums[i]);
                freq[i] = 1;
                solve(nums , ans , freq , temp);
                temp.remove(temp.size()-1);
                freq[i] = 0;
            }
        }
    }
}