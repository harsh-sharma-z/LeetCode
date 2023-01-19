class Solution {
    public int subarraysDivByK(int[] nums, int k) {
         HashMap<Integer,Integer> hashMap = new HashMap<>();
        int prefixSum = 0;
        int ans = 0;
        hashMap.put(0,1);
        for(int i = 0;i<nums.length;i++){
            prefixSum = (prefixSum + nums[i])%k;
            if(prefixSum<0) prefixSum +=k;
            if(hashMap.containsKey(prefixSum)){
                
                    ans = ans+hashMap.get(prefixSum);
                
                
                hashMap.put(prefixSum,hashMap.get(prefixSum)+1);
            }else{
                hashMap.put(prefixSum,1);
            }

        }
        return ans;
    }
}