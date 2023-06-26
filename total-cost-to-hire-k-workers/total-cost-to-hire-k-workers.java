class Pair{
    int val, index;
    Pair(int val, int index)
    {
        this.val = val;
        this.index = index;
    }   
}
class Solution {
    public long totalCost(int[] costs, int k, int len) 
    {
        PriorityQueue<Pair>pq = new PriorityQueue<Pair>((Pair a, Pair b)->{
            if (a.val != b.val) return (a.val - b.val);
            else return (a.index - b.index);
        });
        int n = costs.length;
        int i, j;
        for (i = 0, j = n - 1; i <= j && i < len; i++, j--)
        {
            pq.add(new Pair(costs[i], i));
            if (i != j) pq.add(new Pair(costs[j], j));
        }
        int low = i, high = j;
        long ans = 0;
        while(!pq.isEmpty() && k > 0)
        {
            Pair minPair = pq.poll();
            int minVal = minPair.val;
            int minIndex = minPair.index;
            
            ans += minPair.val;
            k--;
            
            if (low > high) continue;
            
            int dist1 = Math.abs(low - minIndex);
            int dist2 = Math.abs(high - minIndex);
            if (dist1 < dist2) pq.add(new Pair(costs[low], low++));
            else pq.add(new Pair(costs[high], high--));
        }
        return ans;
    }
}