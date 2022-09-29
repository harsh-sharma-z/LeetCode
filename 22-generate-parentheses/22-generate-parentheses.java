class Solution {
    public List<String> generateParenthesis(int n) {
        String s="";
        for(int i=0;i<n;i++)
        {
            s=s+"()";
        }
        List<String> uwu=new ArrayList<>();
        String ans="";
        print(s,ans,uwu);
        return uwu;
    }
    
    public void print(String ques, String ans,List<String> uwu) {
        if (ques.length() == 0) {
            if(isValid(ans))
            uwu.add(ans);
            return;
        }

        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            boolean f = false;
            for (int j = i + 1; j < ques.length(); j++) {
                if (ques.charAt(j) == ch) {
                    f = true;
                    break;
                }
            }
            if (f == false) {
                String s1 = ques.substring(0, i);
                String s2 = ques.substring(i + 1);
                print(s1 + s2, ans + ch,uwu);
            }
        }
    }
    
    public boolean isValid(String s)
    {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
	map.put('(', ')');
	
 
	Stack<Character> stack = new Stack<Character>();
 
	for (int i = 0; i < s.length(); i++) {
		char curr = s.charAt(i);
 
		if (map.keySet().contains(curr)) {
			stack.push(curr);
		} else if (map.values().contains(curr)) {
			if (!stack.empty() && map.get(stack.peek()) == curr) {
				stack.pop();
			} else {
				return false;
			}
		}
	}
 
	return stack.empty();
    }
}