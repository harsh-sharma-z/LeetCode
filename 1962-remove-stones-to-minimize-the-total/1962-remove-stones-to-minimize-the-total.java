class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> uwu=new PriorityQueue<Integer>((a,b)->b-a);
        for(int i=0;i<piles.length;i++)
            uwu.add(piles[i]);
        while(k-->0)
        {
            int c=uwu.poll();
            int r=Math.floorDiv(c,2);
            uwu.offer(c-r);
        }
        int ans=0;
        while(!uwu.isEmpty())
            ans+=uwu.poll();
        return ans;
    }
}