class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> uwu=new ArrayList<>();
        String ans="";
        help(n,0,0,ans,uwu);
        return uwu;
    }
    
    public void help(int n,int open,int close,String ans,List<String>uwu)
    {
        if(open==n && close == n)
            uwu.add(ans);
        if(open<n)
            help(n,open+1,close,ans+"(",uwu);
        
        if(close<open)
            help(n,open,close+1,ans+")",uwu);
    }
}