class Solution {
    public int firstUniqChar(String s) {
        int ans=s.length()+1;
        
        int first , last;
        
        for(char c='a'; c<='z'; c++)
        {
            
            first=s.indexOf(c);
            
            if(first!=-1 && first==s.lastIndexOf(c))
                ans=Math.min(ans,first);
            
        }
        
        
        if(ans<s.length()+1)
            return ans;
        return -1;
    }
}
