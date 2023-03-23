class Solution {
    public int[] findOrder(int n, int[][] pre) {
        
        // if(n==1 || n==0)
        //     return new int[0];
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
        
        int[] ans=new int[n];
        return TopoSort(map,ans);
//         int c=0;
//         for(int i:ans)
//             if(i==0)
//                 c++;
        
//         if(n==c)
//             return new int[0];
        // return ans;
    }
    
    private int[] TopoSort(HashMap<Integer,List<Integer>> map,int[] ans)
    {
        int in[]=indegree(map);
        int c=0;
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<in.length;i++)
            if(in[i]==0)
                q.add(i);
        int i=0;
        while(!q.isEmpty())
        {
            int key=q.peek();
            q.remove();
            c++;
            ans[i++]=key;
            for(int nbrs: map.get(key))
            {
                in[nbrs]--;
                if(in[nbrs]==0)
                    q.add(nbrs);

            }
        }
        
return c==map.size()? ans: new int[0];
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