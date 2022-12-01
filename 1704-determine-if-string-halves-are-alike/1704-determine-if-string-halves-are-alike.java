class Solution {
    public boolean halvesAreAlike(String s) {
        s=s.toLowerCase();
        int a=0,b=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(i<(s.length())/2)
            {
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                    a++;
            }
            else
            {
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                    b++;
            }
        }
        return a==b?true:false;
    }
}