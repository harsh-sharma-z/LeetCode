class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        
        List<List<String>> res=new ArrayList<>();
        
        int[] leftrow=new int [n];
        int[] upperDia=new int[2*n-1];
        int[] lowerDia=new int[2*n-1];
        
        solve(0,board,res,leftrow,lowerDia,upperDia);
        return res;
    }
    
    
    public static void solve(int col,char[][] board,List<List<String>> res, int[] leftrow, int[]lowerDia,int[] upperDia)
    {
        
        if(col==board.length)
        {
            res.add(construct(board));
            return;
        }
        for(int row=0;row<board.length;row++)
        {
            if(leftrow[row]==0 && lowerDia[row+col]==0 && upperDia[board.length-1-row+col]==0)
            {
                board[row][col]='Q';
                leftrow[row]=1;
                upperDia[board.length-1+col-row]=1;
                lowerDia[row+col]=1;
                solve(col+1,board,res,leftrow,lowerDia,upperDia);
                board[row][col]='.';
                leftrow[row]=0;
                upperDia[board.length-1+col-row]=0;
                lowerDia[row+col]=0;
            }
        }
    }
    
    public static List<String> construct(char[][] board)
    {
        List<String> uwu=new ArrayList<>();
        
        for(int i=0;i<board.length;i++)
        {
            String s=new String(board[i]);
            uwu.add(s);
        }
        return uwu;
    }
}