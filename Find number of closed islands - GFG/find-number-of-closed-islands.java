//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
        int ans=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(matrix[i][j]==1)
                    if(dfs(matrix,i,j,N,M))
                        ans++;
            }
        }
        return ans;
    }
    private boolean dfs(int[][] matrix, int i,int j, int N,int M)
    {
        if(i<0 ||i>=N || j<0 || j>=M)
            return false;
        if(matrix[i][j]==0)
        return true;
        matrix[i][j]=0;
        boolean up=dfs(matrix,i-1,j,N,M);
        boolean down=dfs(matrix,i+1,j,N,M);
        boolean left=dfs(matrix,i,j-1,N,M);
        boolean right=dfs(matrix,i,j+1,N,M);
        return up && down && left && right;
    }
}