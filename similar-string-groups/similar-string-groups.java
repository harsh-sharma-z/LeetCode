class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;

        DisjointSet ds = new DisjointSet(n);

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(similar(strs[i],strs[j]))ds.unionBySize(i,j);
            }
        }
        return ds.size();
    }
    public boolean similar(String s,String t){
        int n = 0;
        for(int i=0; i<s.length(); i++){
            //here we are incrementing the n because we can only replace two characters so more than 2 can be considered as not similar
            if(s.charAt(i) != t.charAt(i) && ++n > 2) 
                return false;
        }
        return true;
    }
}
//Union find using size
class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    int n;
    public DisjointSet(int n){
        for(int i=0; i<=n; i++){
            size.add(1);
            parent.add(i);
        }
        this.n = n;
    }

    public int findUpar(int node){
        if(node == parent.get(node))
            return node;

        parent.set(node , findUpar(parent.get(node)));
        return parent.get(node);
    }

    public void unionBySize(int u,int v){
        int ult_u = findUpar(u);
        int ult_v = findUpar(v);

        if(ult_u == ult_v)return;

        if(size.get(ult_u) < size.get(ult_v)){
            parent.set(ult_u,ult_v);
            size.set(ult_v,size.get(ult_u) + size.get(ult_v));
        }else{
            parent.set(ult_v,ult_u);
            size.set(ult_u,size.get(ult_u) + size.get(ult_v));
        }
        n--;
    }
    public int size(){
        return n;
    }
}