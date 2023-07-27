class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long l = Integer.MAX_VALUE;
        long sum = 0;
        for(int i : batteries){
            sum += i;
            l = Math.min(i , l);
        }
        long r = sum / n;
        long ans = 0;
        while(l <= r){
            long mid = l + (r - l)/2;
            if(possible(batteries , mid , n)){
                ans = mid;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return ans;
    }

    private boolean possible (int[] arr , long t , int n){
        long target = n * t;
        long s = 0;
        for(int i : arr){
            s += Math.min(i , t);
            if(s >= target)
                return true;
        }
        return false;
    }
}