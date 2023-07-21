class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] t = new int[n]; // LIS ending at i
        Arrays.fill(t , 1);
        int[] c = new int[n]; // count of LIS ending at i
        Arrays.fill(c , 1);

        for(int i = 0 ; i < n ; i++){
            for(int  j = 0 ; j < i ; j++){
                if(nums[j] < nums[i]){ 
                    if(t[j]+1 == t[i]){ // same size the subsequence firse mil gya
                        c[i] += c[j]; // count ko pichhle subsequence se badha do
                    }
                    else if ( t[j]+1 > t[i]){ // pehli baar is size ka subsequence  mila h
                        t[i] = t[j] + 1; //naye size ka valid subseq
                        c[i] = c[j] ;// count purana jitna hi rhega kyuki ek element add hua h
                    }
                }
            }
        }
        int maxSubSeq = 0; // max subsequence ka size nikalenge
        for(int i : t)
            maxSubSeq = Math.max(maxSubSeq , i);
        
        int maxFreq = 0; // max freq nikalenge max size ke subseq ki
        for(int i = 0 ; i < n ; i++){
            if(t[i] == maxSubSeq)
                maxFreq += c[i];
        }

        return maxFreq;
    }
}