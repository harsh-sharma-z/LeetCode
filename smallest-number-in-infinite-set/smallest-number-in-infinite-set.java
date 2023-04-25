class SmallestInfiniteSet {
    private Integer min;
    private PriorityQueue<Integer> heap;
    public SmallestInfiniteSet() {
        min = 1;
        heap = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if(!heap.isEmpty()){
            return heap.poll();
        }
        min++;
        return min-1;
    }
    
    public void addBack(int num) {
        if(min > num && !heap.contains(num)){
            heap.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */