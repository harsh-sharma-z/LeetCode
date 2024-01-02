class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int n = nums.length , count[] = new int[n + 1];
        for(int i : nums){
            if(res.size() < ++ count[i])
                res.add(new ArrayList<>());
            res.get(count[i] - 1).add(i);
        }
        return res;
    }
}