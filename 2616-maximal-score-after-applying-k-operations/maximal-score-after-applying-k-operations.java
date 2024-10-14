class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int n : nums) {
            pq.add(n);
        }

        long score = 0;

        while(k > 0) {
            int max = pq.poll();
            score += max;
            pq.add((int)Math.ceil(max / 3.0));
            k--;
        }
        
        return score;
    }
}