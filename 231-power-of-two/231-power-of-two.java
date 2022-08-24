class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1)
            return false;
        
        String s=Integer.toBinaryString(n);
        
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                return false;
        }
        
        if(s.charAt(0)=='1')
            return true;
        
        return false;
        
        
        
    }
}