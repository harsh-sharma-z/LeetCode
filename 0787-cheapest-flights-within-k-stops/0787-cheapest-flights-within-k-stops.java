class Solution {
    class Tuple{
        int node;
        int distance;
        int stops;
        public Tuple(int stops, int node, int distance)
        {
            this.stops=stops;
            this.node=node;
            this.distance=distance;
        }
    }
    
    class Pair{
        int first;
        int second;
        public Pair(int first, int second)
        {
            this.first=first;
             this.second=second;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Pair>());
        
        for(int[] i: flights)
            adj.get(i[0]).add(new Pair(i[1],i[2]));
        
        int[] dist=new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[src]=0;
        
        Queue<Tuple> uwu=new LinkedList<>();
        uwu.add(new Tuple(0,src,0));
        
        while(!uwu.isEmpty())
        {
            Tuple temp= uwu.poll();
            int stops=temp.stops;
            int node=temp.node;
            int d=temp.distance;
            
            if(stops>k)
                continue;
            
            for(Pair i: adj.get(node))
            {
                int newnode=i.first;
                int cost=i.second;
                
                if(d+cost<dist[newnode])
                {
                    dist[newnode]=d+cost;
                    uwu.add(new Tuple(stops+1, newnode , d+cost));
                }
            }
        }
        
        if(dist[dst]==(int)(1e9))
            return -1;
        return dist[dst];
    }
}