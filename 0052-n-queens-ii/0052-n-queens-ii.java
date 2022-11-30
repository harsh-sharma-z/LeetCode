class Solution {
    
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        
       
        
        int[] leftrow=new int [n];
        int[] upperDia=new int[2*n-1];
        int[] lowerDia=new int[2*n-1];
        
        return solve(0,board,leftrow,lowerDia,upperDia);
       
    }
    
    public static int solve(int col,char[][] board, int[] leftrow, int[]lowerDia,int[] upperDia)
    {
        
        if(col==board.length)
        {
            //res.add(construct(board));
           return 1;
        }
        int c=0;
        for(int row=0;row<board.length;row++)
        {
            if(leftrow[row]==0 && lowerDia[row+col]==0 && upperDia[board.length-1-row+col]==0)
            {
                board[row][col]='Q';
                leftrow[row]=1;
                upperDia[board.length-1+col-row]=1;
                lowerDia[row+col]=1;
                c+=solve(col+1,board,leftrow,lowerDia,upperDia);
                board[row][col]='.';
                leftrow[row]=0;
                upperDia[board.length-1+col-row]=0;
                lowerDia[row+col]=0;
            }
        }
        return c;
    }
    
}