//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    static class Pair{
        
        int distance;
        int node;
        
        public Pair(int distance, int node){
            this.distance=distance;
            this.node=node;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
       TreeSet<Pair> st=new TreeSet<>(new Comparator<>(){
           public int compare(Pair a, Pair b)
           {
               if(a.distance==b.distance)
               return a.node-b.node;
               return a.distance-b.distance;
           }
       });
       int dist[]=new int[V];
       Arrays.fill(dist,1000000007);
       
       st.add(new Pair(0,S));
       dist[S]=0;
       
       while(st.size()!=0)
       {
           Pair temp=st.iterator().next();
           int node=temp.node;
           int d=temp.distance;
           st.remove(temp);
           for(ArrayList<Integer> i:adj.get(node))
           {
                int edge=i.get(0);
                int w=i.get(1);
                
                if(w+d<dist[edge] || dist[edge]==1000000007)
                {
                    Pair x= new Pair(w+d, edge);
                    if(st.contains(x)) st.remove(x);
                    dist[edge]=w+d;
                    st.add(x);
                }
           }
       }
       return dist;
    }
}

