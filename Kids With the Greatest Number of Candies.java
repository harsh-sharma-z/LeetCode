class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> ans = new ArrayList<Boolean>();
        int max = candies[0];
        
        for(int i = 1; i < candies.length; i++) {
            if(candies[i] > max) {
                max = candies[i];
            }
        }
        
        for(int i = 0; i < candies.length; i++) {
            candies[i] = candies[i] + extraCandies;
            if(candies[i] >= max) {
                ans.add(true);
            }else {
                ans.add(false);
            }
        }
        
        return ans;
        
    }
}
