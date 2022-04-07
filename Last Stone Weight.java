class Solution {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int st: stones) pq.add(st);
        while(pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1 > stone2) pq.add(stone1-stone2);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
    
    public static void main(String[] args) {
        int[] a = new int[]{25, 23, 16, 16, 16};
        System.out.println(lastStoneWeight(a));
    }
}
