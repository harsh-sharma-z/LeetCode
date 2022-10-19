class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    boolean ans=search(board,i,j,word,0);
                    if(ans==true)
                    {
                        return ans;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean search(char[][] board,int cr,int cc,String word,int idx)
    {
        
        if(idx==word.length())
            return true;
        if(cr<0||cc<0||cr>=board.length||cc>=board[0].length||board[cr][cc]!=word.charAt(idx))
        {
            return false;
        }
        board[cr][cc]='*';
        int r[]={-1,1,0,0};
        int c[]={0,0,-1,1};
        
        for(int i=0;i<4;i++)
        {
            boolean ans=search(board,cr+r[i],cc+c[i],word,idx+1);
            if(ans==true)
            return ans;
        }
        board[cr][cc]=word.charAt(idx);
        
        return false;
    }
}