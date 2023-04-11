class Solution {
    public String removeStars(String s) {
        StringBuilder ans=new StringBuilder("");
        Stack<Character> uwu=new Stack<>();
        for(char a: s.toCharArray())
        {
            if(a=='*')
                uwu.pop();
            else
                uwu.push(a);
        }
        while(!uwu.isEmpty())
        {
            ans.append(uwu.pop());
        }
        return (ans.reverse()).toString();
    }
}