class Solution {

    private int[] nums;
    private int total;
    private Random ran;

    public Solution(int[] w) {

        this.ran = new Random();

        for(int i = 1 ; i < w.length  ; i++){
            w[i] +=  w[i-1];
        }

        this.nums = w;
        this.total = w[w.length - 1];
        
    }
    
    public int pickIndex() {


        if(this.total == 0)
            return -1;

        int n = this.ran.nextInt(this.total) + 1;

        int lo = 0 , hi = this.nums.length - 1; 

        while(lo < hi){
            int mid = lo + (hi - lo)/2;

            if (this.nums[mid] == n)
                return mid;
            else if (this.nums[mid] < n)
                lo = mid + 1;
            else 
                hi = mid;
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */