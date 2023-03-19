class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer,Integer> visited=new HashMap<>();
        Queue<BipartitePair> q=new LinkedList<>();
        
        for(int src=0;src<graph.length;src++)
        {
            if(visited.containsKey(src))
            {
                continue;
            }
            
            q.add(new BipartitePair(src,0));
            
            while(!q.isEmpty())
            {
                BipartitePair curr=q.poll();
                
                if(visited.containsKey(curr.vtx)){
                    
                    if(visited.get(curr.vtx)!=curr.lv)
                        return false;
                    else
                        continue;
                }
                visited.put(curr.vtx,curr.lv);
                
                for(int nbrs:graph[curr.vtx])
                {
                    if(!visited.containsKey(nbrs))
                        q.add(new BipartitePair(nbrs,curr.lv+1));
                }
            }
        }
        return true;
    }
    

}

    class BipartitePair
    {
        int vtx;
        int lv;
        
        public BipartitePair(int vtx,int lv)
        {
            
            this.vtx=vtx;
            this.lv=lv;
            
        }
    }