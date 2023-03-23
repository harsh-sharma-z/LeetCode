class Solution {
    public boolean canFinish(int n, int[][] pre) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            map.put(i,new ArrayList<>());
        }
        
        for(int[] a:pre)
        {
            int v1=a[0];
            int v2=a[1];
            map.get(v2).add(v1);
        }
        
        return TopoSort(map);
    }
    
    private boolean TopoSort(HashMap<Integer,List<Integer>> map)
    {
        int in[]=indegree(map);
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<in.length;i++)
            if(in[i]==0)
                q.add(i);
        int c=0;
        while(!q.isEmpty())
        {
            int key=q.peek();
            q.remove();
            c++;
            for(int nbrs: map.get(key))
            {
                in[nbrs]--;
                if(in[nbrs]==0)
                    q.add(nbrs);

            }
        }
        
        return c==map.size()?true : false;
    }
    
     private int[] indegree(HashMap<Integer,List<Integer>> map){
        int[] in=new int[map.size()];
        for(int key:map.keySet())
        {
            for(int nbrs:map.get(key))
                in[nbrs]++;
        }
        return in;
    }

    
    
    
}