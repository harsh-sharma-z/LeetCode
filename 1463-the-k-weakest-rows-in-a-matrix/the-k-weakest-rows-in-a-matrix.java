class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++){
            int j = 0 ;
            for(; j < m ; j++){
                if(mat[i][j] == 0)
                    break;
            }
            ans[i] = j * n + i;
        }

        Arrays.sort(ans);

        for(int i = 0 ; i < mat.length ; i++){
            ans[i] = ans[i] % n;
        }

        return Arrays.copyOfRange(ans , 0 , k);
    }
}