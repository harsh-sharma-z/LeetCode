class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String str[]=s.split(" ");
        String a="";
        
        for(int i=str.length-1;i>=0;i--)
        {
            a=a+" "+str[i];
            a=a.trim();
        }
        
        return a.trim();
    }
}