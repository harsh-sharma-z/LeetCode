class Solution {
    public int majorityElement(int[] nums) {
        // Boyre Moore's Algorithm
        int c = 0, ans = 0; //assumption of the answer
        for(int i : nums){
            if(c == 0) ans = i;
            c = i == ans ? c + 1 : c - 1;
        }
        return ans;
    }
}