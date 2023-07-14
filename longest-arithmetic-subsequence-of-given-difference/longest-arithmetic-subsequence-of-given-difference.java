class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int n = arr.length;
        HashMap<Integer , Integer> dp = new HashMap<>();

        int ans = 1;

        for(int i = 0 ; i < n ; i++){
            int temp = arr[i];
            if(dp.containsKey(temp - diff))
                dp.put(temp , dp.get(temp - diff) + 1);
            else
                dp.put(temp , 1);
            ans = Math.max(ans , dp.get(temp));
        }
        return ans;
    }
}