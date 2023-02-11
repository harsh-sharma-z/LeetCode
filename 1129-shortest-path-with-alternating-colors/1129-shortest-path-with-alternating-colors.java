class Solution {

    class Cell{
        int node,color,pathLen;
        public Cell(int node,int color,int pathLen){
            this.node = node;
            this.color = color;
            this.pathLen = pathLen;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

            List<List<Cell>> adj = new ArrayList<>();

            for(int i=0;i<n;i++)
                adj.add(new ArrayList<>());

            for(int[] edges:redEdges)
                adj.get(edges[0]).add(new Cell(edges[1],0,0));
        
            for(int[] edges:blueEdges)
                adj.get(edges[0]).add(new Cell(edges[1],1,0));
        
            int[] ans = new int[n];
            ans[0] = 0;

            for(int i=1;i<n;i++)
                ans[i] = Integer.MAX_VALUE;

            Queue<Cell> q = new LinkedList<>();
            boolean[][] visited = new boolean[n][2];

            q.add(new Cell(0,-1,0));
            visited[0][0] = true;
            visited[0][1] = true;

            while(!q.isEmpty()){
                
                Cell temp = q.poll();
                int nd = temp.node;
                int col = temp.color;
                int path = temp.pathLen;
                
                ans[nd] = Math.min(ans[nd],path);
              
                for(int i=0;i<adj.get(nd).size();i++){
                    int adj_node = adj.get(nd).get(i).node;
                    int adj_col = adj.get(nd).get(i).color;
                   
                    if(visited[adj_node][adj_col] == false && col != adj_col){
                        
                        visited[adj_node][adj_col] = true;
                        q.add(new Cell(adj_node,adj_col,path+1));
                    }
                }
            }
        

        for(int i=1;i<n;i++){
            if(ans[i] == Integer.MAX_VALUE)
                ans[i] = -1;
        }

        return ans;
    }
}