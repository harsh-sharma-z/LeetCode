class KthLargest {
    PriorityQueue<Integer> uwu;
    int k=0;
    public KthLargest(int k, int[] nums) {
        this.k=k;;
        uwu=new PriorityQueue<>();
        for(int i:nums)
        this.add(i);
    }
    
    public int add(int val) {
        uwu.add(val);
        if(uwu.size()>k)
        uwu.poll();
        return uwu.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */