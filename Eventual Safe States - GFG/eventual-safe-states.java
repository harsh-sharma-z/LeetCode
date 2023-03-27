//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<List<Integer>> rev=new ArrayList<>();
        
        for(int i=0;i<V;i++)
        rev.add(new ArrayList<>());
        
        int[] in=new int[V];
        
        
        for(int i=0;i<V;i++)
        {
            for(int it: adj.get(i))
            {
            rev.get(it).add(i);
            in[i]++;
            }
        }
        
        Queue<Integer> uwu=new LinkedList<>();
        
        List<Integer> safe=new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            if(in[i]==0)
            uwu.add(i);
        }
        
        
        
        while(!uwu.isEmpty())
        {
            int node=uwu.poll();
            
            
            safe.add(node);
            
            for(int it: rev.get(node))
            {
                in[it]--;
                
                if(in[it]==0)
                uwu.add(it);
            }
        }
        
        Collections.sort(safe);
        
        return safe;
    }
}
