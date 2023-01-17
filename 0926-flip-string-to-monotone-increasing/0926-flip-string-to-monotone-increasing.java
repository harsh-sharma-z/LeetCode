class Solution {
    public int minFlipsMonoIncr(String s) {
        int c1=0;
        int flip=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                c1++;
            else
                flip=Math.min((flip+1),(c1));
        }
        return flip;
    }
}