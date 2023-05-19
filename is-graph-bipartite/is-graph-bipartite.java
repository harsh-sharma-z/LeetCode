class Solution {
    class BP
    {
        int v;
        int col;
        public BP(int v,int col)
        {
            this.v=v;
            this.col=col;
        }
    }
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer,Integer> vis=new HashMap<>();
        Queue<BP> uwu=new LinkedList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(vis.containsKey(i))
            continue;
            uwu.add(new BP(i,0));
            while(!uwu.isEmpty())
            {
                BP curr=uwu.poll();
                if(vis.containsKey(curr.v))
                {
                    if(vis.get(curr.v)!=curr.col)
                    return false;
                    else
                    continue;
                }
                vis.put(curr.v,curr.col);
                for(int adj:graph[curr.v])
                if(!vis.containsKey(adj))
                uwu.add(new BP(adj,((curr.col*-1)+1)));
            }
        }
        return true;
    }
}