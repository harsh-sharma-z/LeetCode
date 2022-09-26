class Solution {
    public int findPar(int u){
        return par[u] == u ? u : (par[u] = findPar(par[u]));
    }
    int[] par;
    public boolean equationsPossible(String[] equations) {
        par = new int[26];
        
        for(int i = 0 ; i < 26 ; i++){
            par[i] = i;
        }
        
        for(String str : equations){
             if(str.charAt(1) == '='){
                int p1 = findPar(str.charAt(0) - 'a');
                int p2 = findPar(str.charAt(3) - 'a');
                if(p1 != p2){
                    par[p1] = p2;
                } 
             }
        }
        
        for(String str : equations){
            if(str.charAt(1) == '!'){
                int p1 = findPar(str.charAt(0) - 'a');
                int p2 = findPar(str.charAt(3) - 'a');
                if(p1 == p2){
                    return false;
                } 
             }
        }
        return true;
    }
    
}