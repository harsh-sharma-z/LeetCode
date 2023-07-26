class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1 , r = 10000000;
        int res = Integer.MAX_VALUE;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(possible(dist , mid , hour) <= hour){
                res = Math.min(res , mid);
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        if(res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
    private double possible (int[] dist , int mid , double hour){
        double ans = 0.0;
        for(int i = 0 ; i < dist.length - 1 ; i++){
            ans += Math.ceil(((double)dist[i] / mid));
        }
        ans += ((double)dist[dist.length-1] / mid);

        return ans;
    }
}