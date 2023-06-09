class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ans='~';
        for(char a:letters)
        if(a<ans && a>target)
        ans=a;
        if(ans=='~')
        return letters[0];
        return ans;
    }
}