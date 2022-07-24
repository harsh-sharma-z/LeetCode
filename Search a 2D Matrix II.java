class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean test=false;
        int m=matrix.length;
        int n=matrix[0].length;
        
        
            for(int i=0;i<m;i++)
        {
            if(target>=matrix[i][0])
            {
                for(int j=0;j<n;j++)
                    if(target==matrix[i][j])
                    {
                        test=true;
                        break;
                    }
            }

                else
                    break;
                
            }
            

        
        return test;
        
    }
}
