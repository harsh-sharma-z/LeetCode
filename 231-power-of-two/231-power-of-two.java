class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1)
            return false;
        String s=Integer.toBinaryString(n);
        
        if(s.charAt(0)!='1')
            return false;
        
        
        
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                return false;
        }
        
        
        
        return true;
        
        
        
    }
}