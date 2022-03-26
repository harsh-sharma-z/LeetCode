class Solution {
    public int strStr(String haystack, String needle) {
         if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
         int l = needle.length();
        
         for (int i = 0; i < haystack.length() - l + 1; i++) {
   
            if (haystack.substring(i, i + l).equals(needle)) {
                return i;
            }
        }
        return -1;
        
    }
}
