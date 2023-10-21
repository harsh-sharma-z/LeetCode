class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n + 1];

        for(int i = 0 ; i < n ; i++){
            dp[i] = nums[i];
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> b.x - a.x);

        pq.offer(new Pair(dp[0] , 0));

        int res = nums[0];

        for(int i = 1 ; i < n ; i ++){
            while(!pq.isEmpty() && i - pq.peek().y > k){
                pq.poll();
            }

            dp[i] = Math.max(dp[i] , nums[i] + pq.peek().x);
            pq.offer(new Pair(dp[i] , i));

            res = Math.max(dp[i] , res);
        }

        return res;
    }
}