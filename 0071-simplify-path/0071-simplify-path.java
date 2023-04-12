class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        StringBuilder str = new StringBuilder();
        for(String curr : path.split("/")) {
            if(curr.length() != 0) {
                switch(curr) {
                    case ".." :
                        if(stack.size() != 0) stack.pop();
                        break;
                    case "." :
                        break;
                    default :
                        stack.push(curr);
                }
            }
        }
        while(stack.size() != 0) {
            str.append(new StringBuilder(stack.pop()).reverse().toString());
            str.append("/");
        }
        str.reverse();
        return str.length() != 0 ? str.toString() : "/";
    }
}