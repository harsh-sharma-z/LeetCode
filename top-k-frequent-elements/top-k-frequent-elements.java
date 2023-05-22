class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        map.put(i,map.getOrDefault(i,0)+1);
        PriorityQueue<Integer> uwu=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(Integer key:map.keySet())
            uwu.add(key);
        int ans[]=new int[k];
        for(int i=0;i<k;i++)
        ans[i]=uwu.poll();
        return ans;
    }
}