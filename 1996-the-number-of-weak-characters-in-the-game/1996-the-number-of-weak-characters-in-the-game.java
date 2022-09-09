class Solution {
    public int numberOfWeakCharacters(int[][] p) {
         Arrays.sort(p, (a,b)-> b[0] - a[0] == 0 ? a[1] - b[1] : b[0] -          a[0]);
        int ans = 0;
        int n = 0;
        for(int i=0;i<p.length;++i){
            if(p[i][1] < n)     ++ans;
            n = Math.max(n, p[i][1]);
        }
        return ans;
        
    }
}