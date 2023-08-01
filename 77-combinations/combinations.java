class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        solve(1 , n , k , new ArrayList<>());
        return res;
    }

    private void solve(int s , int n , int k , List<Integer> temp){
        if(k == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(s > n)
            return;

        temp.add(s);
        solve(s+1 , n , k-1 , temp);
        temp.remove(temp.size()-1);
        solve(s+1 , n , k , temp);
    }
}