//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    class Pair{
        int node;
        int dis;
        Pair(int node , int dis){
            this.node = node;
            this.dis = dis;
        }
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i = 0 ; i < N ; i++)
		    adj.add(new ArrayList<Pair>());
		   
		for(int i[] : edges){
		    int u = i[0];
		    int v = i[1];
		    int d = i[2];
		    adj.get(u).add(new Pair(v, d));
		}
		
		Stack<Integer> uwu = new Stack<>();
		boolean vis[] = new boolean[N];
		
		for(int i  = 0 ; i < N ; i++)
		    if(!vis[i])
		        topo(i , adj , uwu , vis);
		        
		 int dis[] = new int[N];
		 
		 Arrays.fill(dis , 1000_000_007);
		 
		 dis[0] = 0;
		 
		 while(!uwu.isEmpty()){
		     int u = uwu.pop();
		     
		     for(Pair i : adj.get(u)){
		         int v = i.node;
		         int d = i.dis;
		         
		         if(dis[u] + d < dis[v])
		            dis[v] = dis[u] + d;
		     }
		 }
		   
	    for(int i = 0 ; i < N ; i++){
	        if(dis[i] == 1000_000_007)
	            dis[i] = -1;
	    }
	    
	    return dis;
		
	}
	
	private void topo(int src , ArrayList<ArrayList<Pair>> adj , Stack<Integer> uwu , boolean[] vis){
	    vis[src] = true;
	    
	    for(Pair v : adj.get(src)){
	        if(!vis[v.node])
	            topo(v.node , adj , uwu , vis);
	    }
	    
	    uwu.add(src);
	}
}