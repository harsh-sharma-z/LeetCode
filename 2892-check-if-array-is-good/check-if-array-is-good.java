class Solution {

    public boolean isGood(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=1;i<n;i++){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }

        mp.put(n-1,mp.getOrDefault(n-1,0)+1);

        for(int x : nums){
            if(mp.getOrDefault(x,0) > 0){
                mp.put(x,mp.get(x)-1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}