class Solution {
    public String removeStars(String s) {
        StringBuilder ans=new StringBuilder("");
        for(char a: s.toCharArray())
        {
            if(a=='*')
                ans.deleteCharAt(ans.length()-1);
            else
                ans.append(a);
        }
        return (ans).toString();
    }
}