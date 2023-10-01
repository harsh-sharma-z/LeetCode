class Solution {
    public String reverseWords(String s) {
        String ans = "";
        for(String word : s.split(" "))
            ans += new StringBuilder(word).reverse().toString() + " ";
        return ans.trim();
    }
}