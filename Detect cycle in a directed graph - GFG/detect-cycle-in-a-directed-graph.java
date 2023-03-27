//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int in[]=new int[V];
        
        for(int i=0;i<V;i++)
        {
            for(int j: adj.get(i))
            in[j]++;
        }
        
        Queue<Integer> uwu=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(in[i]==0)
            uwu.add(i);
        }
        
        int ans=0;
        while(!uwu.isEmpty())
        {
            int node=uwu.poll();
            ans++;
            for(int i:adj.get(node))
            {
                in[i]--;
                if(in[i]==0)
                uwu.add(i);
            }
        }
        
        if(ans==V)
        return false;
        return true;
    }
}