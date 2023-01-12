class Solution {
    private int[] ans;
    private List<List<Integer>> uwu;
    private Set<Integer> visited;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans=new int[n];
        uwu=new ArrayList<>(n);
        
        for(int i=0;i<n;i++)
        {
            uwu.add(new ArrayList<>());
        }
        
        for(int[] e:edges)
        {
            uwu.get(e[0]).add(e[1]);
            uwu.get(e[1]).add(e[0]);
        }
        visited=new HashSet<Integer>(n);
        dfs(0,labels);
        
        return ans;
    }
    private int[] dfs(int node, String labels)
    {
        visited.add(node);
        
        int count[]=new int[26];
        
        for(int adj:uwu.get(node))
        {
            
            if(!visited.contains(adj))
            {
                int[] adjcount=dfs(adj,labels);
                for(int i=0;i<26;i++)
                    count[i]+=adjcount[i];
            }
        }
        
        char ch=labels.charAt(node);
        count[ch-'a']++;
        
        ans[node]=count[ch-'a'];
        
        return count;
    }
}