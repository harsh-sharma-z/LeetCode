class Solution {
    
    public static void sortDia(int [][]mat,int i,int j,int row,int col)
    {
        ArrayList<Integer> a=new ArrayList<>();
        int p=i;
        int q=j;
        
        while(i<row && j<col)
        {
            a.add(mat[i][j]);
            i++;
            j++;
        }
        Collections.sort(a);
        int h=0;
        while(p<row && q<col)
        {
            mat[p][q]=a.get(h);
            p++;
            q++;
            h++;
        }
    }
    public int[][] diagonalSort(int[][] mat) {
        
        int row=mat.length;
        int col=mat[0].length;
        
        for(int j=0;j<col-1;j++)
        {
            int i=0;
            
            sortDia(mat,i,j,row,col);
        }
        
        for(int i=1;i<row-1;i++)
        {
            int j=0;
            sortDia(mat,i,j,row,col);
            
        }
        return mat;
    }
}