class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(); // min heap by default
        //Collections.reverseOrder for max heap
        for(int i=0;i<k;i++)
        {
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++)
        {
            if(arr[i]>pq.peek())
            {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.poll();
    }
}