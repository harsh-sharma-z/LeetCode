class Solution {
    class pair{
        int first;
        int sec;
        pair(int f,int s){
            this.first=f;
            this.sec=s;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new pair(roads[i][0],roads[i][2]));
        }
        int[] dist=new int[n];
        int[] ways=new int[n];
       Arrays.fill(dist , Integer.MAX_VALUE);
       Arrays.fill(ways , 0);
        
        PriorityQueue < pair > pq = new PriorityQueue < pair > ((x, y) -> x.first - y.first);
        pq.add(new pair(0,0));
        
        dist[0]=0;
        ways[0]=1;
        int mod=(int) 1e9+7;
        while(!pq.isEmpty())
        {
            int dis = pq.peek().first;
            int node = pq.peek().sec;
            pq.remove();
            
            for (pair it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.sec;
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new pair(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                } 
                else if (dis + edW == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        
        return ways[n - 1] % mod;
    }
}

