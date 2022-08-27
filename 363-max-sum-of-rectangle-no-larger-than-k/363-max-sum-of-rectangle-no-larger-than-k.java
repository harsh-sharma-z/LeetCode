class Solution {
    public int maxSumSubmatrix(int[][] matrix, int p) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefixSum = new int[n][m];
        
        for(int i=0;i<n;i++) {
            int sum=0;
            for(int j=0;j<m;j++) {
                sum+=matrix[i][j];
                if(i==0) {
                    prefixSum[i][j]=sum;
                } else {
                    prefixSum[i][j]=prefixSum[i-1][j]+sum;
                }
            }
        }
        
        int ans = Integer.MIN_VALUE;
        
        // for start point
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // for end point
                for(int k=i;k<n;k++) {
                    for(int l=j;l<m;l++) {
                        int sum = prefixSum[k][l];
                        if(i-1>=0 && j-1>=0) {
                            sum+=(prefixSum[i-1][j-1]-prefixSum[i-1][l]-prefixSum[k][j-1]);
                        } else if(i-1>=0) {
                            sum-=(prefixSum[i-1][l]);
                        } else if(j-1>=0) {
                            sum-=(prefixSum[k][j-1]);
                        }
                        
                        if(sum>ans && sum<=p) ans=sum;
                        
                    }
                }
            }
        }
        return ans;
    }
}