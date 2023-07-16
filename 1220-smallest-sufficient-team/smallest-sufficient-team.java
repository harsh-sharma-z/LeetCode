class Solution {
     int res[];

    private void smallestSufficientTeamHelp(int ind, int reqOr, int dp[][], List<Integer> ans, int nums[]){
        if( reqOr == 0 ){
            if( res == null || ans.size() < res.length ){
                res = new int[ans.size()];
                for(int i=0; i<ans.size(); i++) res[i] = ans.get(i);
            }
            return;
        }
        if( ind == nums.length ) return;

        if( dp[ind][reqOr] != -1 && dp[ind][reqOr] <= ans.size() ) return;

        smallestSufficientTeamHelp(ind+1, reqOr, dp, ans, nums); // not take
        
        ans.add(ind);
        smallestSufficientTeamHelp(ind+1, reqOr&(~nums[ind]), dp, ans, nums); // take
        ans.remove(ans.size()-1);
        dp[ind][reqOr] = ans.size();
    }


    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> mpp = new HashMap<>();
        int ind = 0, n = people.size();
        for(String x : req_skills ) mpp.put(x, ind++);

        int nums[] = new int[n];
        for(int i=0; i<n; i++){
            int tmp = 0;
            for(int j = 0; j<people.get(i).size(); j++ ) tmp |= (1<<mpp.get(people.get(i).get(j)));
            nums[i] = tmp;
        }

        // find sub sequence of nums with minimum length so that subsequence OR sum will be reqOr
        // dp[i][reqOr] = minimum number of numbers required to get a OR sum of reqOr
        int reqOr = (1<<req_skills.length) - 1;
        int dp[][] = new int[n][reqOr+1];
        List<Integer> ans = new ArrayList<>();
        for(int[] row : dp) Arrays.fill(row, -1);
        smallestSufficientTeamHelp(0, reqOr, dp, ans, nums);
        return res;
    }
}