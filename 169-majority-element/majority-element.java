class Solution {
    public int majorityElement(int[] nums) {
        //boyre moore's' algorithm
        int c = 0 , ans = 0; //count and possible answer
        for(int i : nums){
            if(c==0) ans = i; //if no possible answer make a new answer
            c = i == ans ? c + 1 : c - 1; //count inc or dec according to previous possible answer
        }
        return ans;
    }
}