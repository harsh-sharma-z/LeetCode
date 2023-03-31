//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    class Tuple{
        int distance;
        int row;
        int col;
        public Tuple(int distance, int row,int col)
        {
            this.distance=distance;
            this.row=row;
            this.col=col;
        }
    }
    int MinimumEffort(int heights[][]) {
        PriorityQueue<Tuple> uwu=new PriorityQueue<>((x,y)-> x.distance-y.distance);
        int n=heights.length;
        int m=heights[0].length;
        
        int dist[][]=new int[n][m];
        
        for(int i[]: dist)
        Arrays.fill(i,(int)(1e9));
        
        dist[0][0]=0;
        
        uwu.add(new Tuple(0,0,0));
        
        
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        
        while(!uwu.isEmpty())
        {
            Tuple temp=uwu.poll();
            int diff=temp.distance;
            int r=temp.row;
            int c=temp.col;
            
            if(r==n-1 && c==m-1 )
            return diff;
            
            
            for(int i=0;i<4;i++)
            {
                int newr=r+dr[i];
                int newc=c+dc[i];
                
                if(newr>=0 && newr<n && newc>=0 && newc<m)
                {
                    int newdiff=Math.max(Math.abs(heights[newr][newc]-heights[r][c]),diff);
                    if(newdiff<dist[newr][newc])
                    {
                        dist[newr][newc]=newdiff;
                        uwu.add(new Tuple(newdiff, newr,newc));
                    }
                }
            }
        }
        
        return 0;
    }
}