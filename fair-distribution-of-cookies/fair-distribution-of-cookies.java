class Solution {
    int res=Integer.MAX_VALUE;
    int n;
    public int distributeCookies(int[] cookies, int k) {
        n=cookies.length;
        int child[]=new int[k]; //cookie rakhne ka point

        solve(0,cookies,child,k);
        return res;

    }


    private void solve(int idx, int[] cookies, int [] child, int k)
    {
        if(idx>=n) //out-of bound
        {
            int unf=Integer.MIN_VALUE;
            for(int i: child)  
            unf=Math.max(unf,i);
            res=Math.min(res,unf);
            return;
        }

        int cookie=cookies[idx]; // idx vali cookie uthao
        for(int i=0;i<k;i++) // sare pos vale childs m daalke dekho
        {
            child[i]+=cookie; 
            solve(idx+1,cookies,child,k);
            child[i]-=cookie; // backtrack
        }

    }
}