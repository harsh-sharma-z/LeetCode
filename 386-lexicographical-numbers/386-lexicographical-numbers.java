class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> uwu=new ArrayList<>();
        help(0,n,uwu);
        return uwu;
    }
    
    public void help(int curr,int n,List<Integer> uwu)
    {
        if(curr>n)
            return;
        if(curr!=0)
        uwu.add(curr);
        int i=0;
        if(curr==0)
        {
            i=1;
        }
        
        for(;i<=9;i++)
        {
            int p=(10*curr)+i;
            help(p,n,uwu);
        }
       // help(curr+1,n,uwu);
    }
}