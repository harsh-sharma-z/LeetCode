class Solution {
    public boolean isValid(String s) {
        Stack<Character> uwu=new Stack<>();
        for(char c: s.toCharArray())
        {
            if(c=='{')
                uwu.push('}');
            else if(c=='(')
                uwu.push(')');
            else if(c=='[')
                uwu.push(']');
            else if(uwu.isEmpty() || uwu.pop()!=c)
                return false;
        }
    return uwu.isEmpty();
    }
}