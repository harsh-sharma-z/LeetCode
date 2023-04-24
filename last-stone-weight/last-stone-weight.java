class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> uwu=new PriorityQueue<>((a,b)->b-a);
        for(int i:stones)
        uwu.add(i);
        while(uwu.size()>1)
        {
            int a=uwu.remove();
            int b=uwu.remove();
            if(a>b) uwu.add(a-b);
        }
        return uwu.isEmpty()?0:uwu.poll();
    }
}