class Solution {
    public boolean detectCapitalUse(String word) {
        if(Character.isUpperCase(word.charAt(0)))
        {
            if(word.length()==1)
                return true;
            boolean a=Character.isUpperCase(word.charAt(1));
            for(int i=2;i<word.length();i++)
            {
                if(a!=(Character.isUpperCase(word.charAt(i))))
                    return false;
            }
        }
        else
        for(int i=1;i<word.length();i++)
            if(Character.isUpperCase(word.charAt(i)))
                return false;
        return true;
            
        
    }
}